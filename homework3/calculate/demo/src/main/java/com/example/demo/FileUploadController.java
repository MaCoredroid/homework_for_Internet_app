package com.example.demo;
import com.example.demo.storage.StorageFileNotFoundException;
import com.example.demo.storage.StorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

class circle
{

    public circle(double x , double y, double r )
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public double x;
    public double y;
    public double r;
};

class limit
{
    public limit(double left,double right,double up,double down)
    {
        this.left=left;
        this.right=right;
        this.up=up;
        this.down=down;
    }
    public double left;
    public double right;
    public double up;
    public double down;
}


@Controller
public class FileUploadController {

    private final StorageService storageService;
    public double result =0;
    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) throws IOException {
        String name= file.getOriginalFilename();
        String extension = name.substring(name.lastIndexOf(".") + 1);
        if(!extension.equals("txt"))
        {
            System.out.print(extension);
            return "redirect:/";
        }
        storageService.store(file);
        result = calculate(file);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);
        redirectAttributes.addFlashAttribute("message",
                "Area: "+df.format(result));
        return "redirect:/";
    }
    private static boolean is_in_the_circle(double i, double j, ArrayList<circle> circles)
    {
        for (int p = 0; p < circles.size(); p++)
        {
            if ((i - circles.get(p).x)*(i - circles.get(p).x) + (j - circles.get(p).y)*(j - circles.get(p).y) < circles.get(p).r*circles.get(p).r)
            {
                return true;
            }
        }
        return false;
    }
    private static limit square(limit alimit, ArrayList<circle> circles)
    {
        for (int i = 0; i < circles.size(); i++)
        {
            if (alimit.left > circles.get(i).x - circles.get(i).r)
            {
                alimit.left = circles.get(i).x - circles.get(i).r;
            }
            if (alimit.right < circles.get(i).x + circles.get(i).r)
            {
                alimit.right = circles.get(i).x + circles.get(i).r;
            }
            if (alimit.up < circles.get(i).y + circles.get(i).r)
            {
                alimit.up = circles.get(i).y + circles.get(i).r;
            }
            if (alimit.down > circles.get(i).y - circles.get(i).r)
            {
                alimit.down = circles.get(i).y - circles.get(i).r;
            }
        }
        limit ans=new limit(alimit.left,alimit.right,alimit.up,alimit.down);
        return ans;
    }
    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private double calculate(MultipartFile file) throws IOException {
        File tempfile = convert(file);
        ArrayList<circle> circles = new ArrayList<circle>();
        Scanner in = new Scanner(tempfile);
        while(in.hasNext())
        {
            double x = in.nextDouble();
            double y = in.nextDouble();
            double r= in.nextDouble();
            circle temp= new circle(x, y, r);
            circles.add(temp);
        }
        limit zero=new limit(0,0,0,0);
        limit real=new limit(0,0,0,0);
        real=square(zero,circles);
        int precise = 2;
        double count = 0;
        double temp=Math.pow(10,(-1)*precise);
        for (double i = real.left; i < real.right; i += temp)
        {
            for (double j = real.down; j < real.up; j += temp)
            {
                if (is_in_the_circle(i, j, circles))
                {
                    count++;
                }


            }
        }

        return count*temp*temp;
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}

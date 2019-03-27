import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
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

public class overlapcircles {


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
    public static void main(String[] args) throws IOException {
        ArrayList<circle> circles = new ArrayList<circle>();
        Scanner in = new Scanner(Paths.get("./src/circles.txt"), "UTF-8");
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
        System.out.printf("Please input precision");
        int precision = 0;
        Scanner input = new Scanner(System.in);
        precision=input.nextInt();
        int precise = precision / 2;
        double count = 0;
        double temp=Math.pow(10,(-1)*precise);
        //System.out.print(temp);
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
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(precision);
        System.out.print(df.format(count*temp*temp));
    }
}

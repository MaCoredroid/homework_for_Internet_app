package hello;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
public class Greeting {

    private long x1;
    private long y1;
    private long r1;
    private long x2;
    private long y2;
    private long r2;
    private long x3;
    private long y3;
    private long r3;
    public double area =0;


    public long getx1() {
        return x1;
    }
    public long getx2() {
        return x2;
    }
    public long getx3() {
        return x3;
    }
    public long gety1() {
        return y1;
    }
    public long gety2() {
        return y2;
    }
    public long gety3() {
        return y3;
    }
    public long getr1() {
        return r1;
    }
    public long getr2() {
        return r2;
    }
    public long getr3() {
        return r3;
    }
    public void setx1(long x1) {
        this.x1 = x1;
    }
    public void setx2(long x2) {
        this.x2 = x2;
    }
    public void setx3(long x3) {
        this.x3 = x3;
    }
    public void sety1(long y1) {
        this.y1 = y1;
    }
    public void sety2(long y2) {
        this.y2 =y2;
    }
    public void sety3(long y3) {
        this.y3 =y3;
    }
    public void setr1(long r1) {
        this.r1 =r1;
    }
    public void setr2(long r2) {
        this.r2 = r2;
    }
    public void setr3(long r3) {
        this.r3 =r3;
    }
    ArrayList<circle> circles = new ArrayList<circle>();
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
    public void calculate()
    {
        circle temp1= new circle(x1, y1, r1);
        circles.add(temp1);
        circle temp2= new circle(x2, y2, r2);
        circles.add(temp2);
        circle temp3= new circle(x3, y3, r3);
        circles.add(temp3);
        limit zero=new limit(0,0,0,0);
        limit real=new limit(0,0,0,0);
        real=square(zero,circles);
        System.out.printf("Please input precision");
        int precision = 4;
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

        area=count*temp*temp;
    }




}

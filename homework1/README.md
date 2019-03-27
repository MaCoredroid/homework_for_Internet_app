Compute the total area covered by given circles
=============================================
Input format:
----------
x1 y1 r1<br>
x2 y2 r2<br>
in `txt` file <br>
for example: 0 0 4<br>
Denots a circle whose center is (0,0) with radius as 4<br>
Therefore, the `area` of this circle is `16π` <br>

Implementation:
--------------
```java
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
```
This method can determine whether 'a given point' is in the 'circles'.<br>
The density of the given point is based on the precision you input.<br>

```java
        System.out.printf("Please input precision");
        int precision = 0;
        Scanner input = new Scanner(System.in);
        precision=input.nextInt();
        int precise = precision / 2;
```
If your want maximum fraction digits as 4. <br>
Then the precision of `x` and `y` is 2.<br>
Let's suppose the left `limit` is 1, the right `limit` is 2 <br>
Then the `x` of given point is 1.01 1.02 1.03........ 1.99 2.00<br>
`In this way, the calculation is fast and quite precise.`<br>


Overlapcircle.pdf gives a whole picture of the problem
-----------------------------------------------------
I will see the JUnit and Gradle later.

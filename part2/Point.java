import java.lang.Math;

public class Point {
   private double x;
   private double y;



   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   
   }


   public double getX() {
      return x;
   }

   public double getY() {
      return y;
   }

   public double getRadius() {
      return Math.sqrt((x * x) + (y * y));
   }

   public double getAngle() {
      if (x == 0.0) {
         return (Math.PI / 2);
      } else {
         return (Math.abs(Math.atan(y / x)));
      }
   }

   public Point rotate90() {
      Point newPoint = new Point((-1 * y), x);
      return newPoint;
   }


}

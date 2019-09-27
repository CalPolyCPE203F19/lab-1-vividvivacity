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
      double originalAngle = Math.atan(y / x);
      if (x < 0.0 && y > 0.0) {
         return (Math.PI + originalAngle);
      } else if (x < 0.0 && y < 0.0)  {
         return (originalAngle - Math.PI);         
      } else if (x == 0.0 && y > 0.0) {
         return (Math.PI / 2);
      } else if (x == 0.0 && y < 0.0) {
         return (Math.PI / -2);
      } else if (x < 0.0 && y == 0.0) {
         return (Math.PI);
      } else {
         return Math.atan(y / x);
      }
   }

   public Point rotate90() {
      Point newPoint = new Point((-1 * y), x);
      return newPoint;
   }


}

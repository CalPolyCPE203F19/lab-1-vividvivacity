import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Math;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetX()
   {
      assertEquals(1.0, new Point(1.0, 2.0).getX(), DELTA);
      assertEquals(5.5, new Point(5.5, 0.0).getX(), DELTA);
   }

   @Test
   public void testGetY()
   {
      assertEquals(69.0, new Point(420.0, 69.0).getY(), DELTA);
      assertEquals(4.7, new Point(3.8, 4.7).getY(), DELTA);
   }

   @Test
   public void testGetRadius()
   {
      assertEquals(315.0, new Point(315.0, 0.0).getRadius(), DELTA);
      assertEquals(315.0, new Point(0.0, 315.0).getRadius(), DELTA);
      assertEquals(5.0, new Point(3.0, 4.0).getRadius(), DELTA);
      assertEquals(13.0, new Point(-5.0, 12.0).getRadius(), DELTA);
      assertEquals(Math.sqrt(113.48), new Point(8.2, -6.8).getRadius(), DELTA);
   }

   @Test
   public void testGetAngle()
   {
      assertEquals((Math.PI / 4), new Point(1.0, 1.0).getAngle(), DELTA);
      assertEquals((Math.PI / 2), new Point(0.0, 4.0).getAngle(), DELTA);
      assertEquals((Math.PI / 6), new Point((Math.sqrt(3) / 2), -0.5).getAngle(), DELTA);
      assertEquals(0.0, new Point(-69.42, 0.0).getAngle(), DELTA);
   }

   @Test
   public void testRotate90()
   {
      Point point1 = new Point(1.0, 2.0);
      Point point2 = new Point(-3.0, -4.0);
      Point point3 = point1.rotate90();
      Point point4 = point2.rotate90();

      assertEquals(-2.0, point3.getX(), DELTA);
      assertEquals(1.0, point3.getY(), DELTA);
      assertEquals(4.0, point4.getX(), DELTA);
      assertEquals(-3.0, point4.getY(), DELTA);
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */

   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getX",
         "getY",
         "getRadius",
         "getAngle",
         "rotate90"
         );

      final List<Class> expectedMethodReturns = Arrays.asList(
         double.class,
         double.class,
         double.class,
         double.class,
         Point.class
         );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0],
         new Class[0]
         );

      verifyImplSpecifics(Point.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, Point.class.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue("Unexpected number of public methods",
         expectedMethodNames.size()+1 >= publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}

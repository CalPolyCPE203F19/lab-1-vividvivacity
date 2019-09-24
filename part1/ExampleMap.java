import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ExampleMap
{
   public static List<String> highEnrollmentStudents(
      Map<String, List<Course>> courseListsByStudentName, int unitThreshold)
   {
      List<String> overEnrolledStudents = new LinkedList<>();

      /*
         Build a list of the names of students currently enrolled
         in a number of units strictly greater than the unitThreshold.
      */
      List<Course> courses; 
      String student;
      int totalUnits = 0;
      for (Map.Entry<String, List<Course>> entry : courseListsByStudentName.entrySet()) {
         student = entry.getKey();
         courses = entry.getValue();
         for (Course course : courses) {
            totalUnits += course.getNumUnits();
         }
         if (totalUnits > unitThreshold) { 
            overEnrolledStudents.add(student);
         }
         totalUnits = 0;
      } 
      return overEnrolledStudents;      
   }
}

import java.io.FileNotFoundException;

/**
 * program for managing students and classes from csv files
 */
public class Main {

    /**
     * runs main program
     *
     * @param args                      none
     * @throws FileNotFoundException    when Courses or Students csv files cannot be found
     */
    public static void main(String[] args) throws FileNotFoundException {
        StudentManager studentManager = new StudentManager();
        studentManager.createCoursesAndStudents(
                System.getProperty("user.dir") + "/src/data/Courses.csv",
                System.getProperty("user.dir") + "/src/data/Students.csv"
        );
        System.out.println(studentManager);
    }
}
package test;

import main.StudentManager;
import main.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentManagerTest {
    static private String courseFilePath = System.getProperty("user.dir") + "/src/main/data/Courses.csv";
    static private String studentsFilePath = System.getProperty("user.dir") + "/src/main/data/Students.csv";
    static StudentManager studentManager = new StudentManager();

    @BeforeAll
    static void setup() throws FileNotFoundException {
        studentManager.createCoursesAndStudents(courseFilePath, studentsFilePath);
    }


    @Test
    void getCourseCount() {
        assert(studentManager.getCourseCount() == 15);
    }

    @Test
    void getStudentCount() {
        assert(studentManager.getStudentCount() == 403);
    }

    @Test
    void getStudentCountByCourseIndex() {
        assert(studentManager.getStudentCount(1) == 27);
    }

    @Test
    void getStudentCountByCourseName() {
        assert(studentManager.getStudentCount("CSC142a") == 29);
    }

    @Test
    void getCourseName() {
        assert(studentManager.getCourseName(3).equals("CSC110d"));
    }

    @Test
    void getStudent() {
        assertTrue(studentManager.getStudent(2, 2) instanceof Student);
    }

    @Test
    void getStudents() {
        assertTrue(studentManager.getStudents(1) instanceof Student[]);
    }

    @Test
    void findStudentCourse() {
        assert(studentManager.findStudentCourse("282393") == 4);
    }

    @Test
    void createCoursesAndStudents() {
        StudentManager newStudentManager = new StudentManager();
        String courseFilePath = System.getProperty("user.dir") + "/src/main/data/Courses.csv";
        String studentsFilePath = System.getProperty("user.dir") + "/src/main/data/Students.csv";
        assertThrows(NullPointerException.class, () -> newStudentManager.createCoursesAndStudents(null, null));
        assertThrows(NullPointerException.class, () -> newStudentManager.createCoursesAndStudents(courseFilePath, null));
        assertThrows(NullPointerException.class, () -> newStudentManager.createCoursesAndStudents(null, studentsFilePath));
    }

    @Test
    void testToString() {
        System.out.println(studentManager);
        assert(studentManager.toString().equals("\nStudent Manager Summary\nTotal Classes:  15\nTotal Students: 403\n"));
    }
}
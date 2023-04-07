package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A student manager for tracking classes and associated students
 */
public class StudentManager implements StudentManagerInterface {
    /**
     * a two-dimensional array of main.Student objects
     */
    private Student[][] studentsByCourse;

    /**
     * an array of course name Strings
     */
    private String[] courses;

    /**
     * the total number of courses in the student manager
     */
    private int totalCourseCount;

    /**
     * the total number of students in the student manager
     */
    private int totalStudentCount;

    /**
     * the main.StudentManager constructor
     */
    public StudentManager(){
        this.studentsByCourse = new Student[0][];
        this.courses = new String[0];
        this.totalCourseCount = 0;
        this.totalStudentCount = 0;
    }

    public int getCourseCount() {
        return totalCourseCount;
    }

    public int getStudentCount(int courseIndex){
        return studentsByCourse[courseIndex].length;
    }

    public int getStudentCount(String courseName){
        int courseIndex;
        int studentCount = 0;
        for (courseIndex = 0; courseIndex < totalCourseCount; courseIndex++){
            if (courses[courseIndex].equals(courseName)){
                studentCount = studentsByCourse[courseIndex].length;
                break;
            }
        }
        return studentCount;
    }

    public int getStudentCount() {
        return totalStudentCount;
    }

    public String getCourseName(int courseIndex){
        return courses[courseIndex];
    }

    public Student getStudent(int courseIndex, int studentIndex){
        return studentsByCourse[courseIndex][studentIndex];
    }

    public Student[] getStudents(int courseIndex){
        return studentsByCourse[courseIndex];
    }

    public int findStudentCourse(String id){
        int foundCourseIdx = -1;
        for (int courseIdx = 0; courseIdx < totalCourseCount; courseIdx++){
            for (Student student : studentsByCourse[courseIdx]){
                if (student.id().equals(id)){
                    foundCourseIdx = courseIdx;
                    break;
                }
            }
        }
        return foundCourseIdx;
    }

    /**
     * loads and creates the studentsByCourse array as well as the courses array.  Also tallies course count and student count.
     *
     * @param filePath                  the path to the course csv file
     * @throws FileNotFoundException    throws when the file path isn't found
     */
    private void createCourses(String filePath) throws FileNotFoundException {
        File courseFile = new File(filePath);
        Scanner courseInputScanner = new Scanner(courseFile);
        int numOfCourses = Integer.parseInt(courseInputScanner.next());
        this.courses = new String[numOfCourses];
        this.studentsByCourse = new Student[numOfCourses][];

        courseInputScanner.nextLine();
        courseInputScanner.nextLine();

        for (int courseIdx = 0; courseIdx < numOfCourses; courseIdx++){
            String course = courseInputScanner.next();
            String[] splitCourse = course.split(",");
            String courseName = splitCourse[0];
            int studentCount = Integer.parseInt(splitCourse[1]);

            this.studentsByCourse[courseIdx] = new Student[studentCount];
            this.courses[courseIdx] = courseName;
            this.totalCourseCount++;
            this.totalStudentCount += studentCount;
        }

        courseInputScanner.close();
    }

    /**
     * creates main.Student objects and fills in the students for every course
     *
     * @param filePath                  the path to the students csv file
     * @throws FileNotFoundException    throws when the file path isn't found
     */
    private void createStudents(String filePath) throws FileNotFoundException {
        File studentFile = new File(filePath);
        Scanner studentInputScanner = new Scanner(studentFile);
        studentInputScanner.useDelimiter(",");
        studentInputScanner.nextLine();

        for(int courseIdx = 0; courseIdx < this.studentsByCourse.length; courseIdx++){
            for (int studentIdx = 0; studentIdx < this.studentsByCourse[courseIdx].length; studentIdx++){
                studentInputScanner.next();
                String id = studentInputScanner.next();
                String lastName = studentInputScanner.next();
                String firstName = studentInputScanner.next();
                String email = studentInputScanner.next();
                String phone = studentInputScanner.nextLine();
                this.studentsByCourse[courseIdx][studentIdx] = new Student(id, lastName, firstName, email, phone);
            }
        }

        studentInputScanner.close();
    }

    /**
     * calls createCourses followed by createStudents to load in all main.data from their respective file paths
     *
     * @param courseFilePath            the path to the course csv file
     * @param studentFilePath           the path to the students csv file
     * @throws FileNotFoundException    throws when paths aren't found
     */
    public void createCoursesAndStudents(String courseFilePath, String studentFilePath) throws FileNotFoundException {
        this.createCourses(courseFilePath);
        this.createStudents(studentFilePath);
    }

    public String toString(){
        String smString = "";
        smString += "\n";
        smString += "main.Student Manager Summary\n";
        smString += "Total Classes:  " + this.getCourseCount() + "\n";
        smString += "Total Students: " + this.getStudentCount() + "\n";

        return smString;
    }

}

package test;

import main.Student;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StudentTest {
    Student testStudent = new Student(
            "12345",
            "Potter",
            "Harry",
            "harrypotter@theboywholived.co.wizards",
            "555-WIZ-ARDS"
    );

    @Test
    public void id() {
        assert(testStudent.id().equals("12345"));
    }

    @Test
    public void lastName() {
        assert(testStudent.lastName().equals("Potter"));
    }

    @Test
    public void firstName() {
        assert(testStudent.firstName().equals("Harry"));
    }

    @Test
    public void email() {
        assert(testStudent.email().equals("harrypotter@theboywholived.co.wizards"));
    }

    @Test
    public void phone() {
        assert(testStudent.phone().equals("555-WIZ-ARDS"));
    }

    @Test
    public void equals() {
        Student testStudentIdentical = new Student(
                "12345",
                "Potter",
                "Harry",
                "harrypotter@theboywholived.co.wizards",
                "555-WIZ-ARDS"
        );
        Student testStudentDifferent = new Student(
                "54321",
                "Granger",
                "Hermione",
                "hermione@itsleviooosa.co.notleviosaaa",
                "123-456-7890"
        );
        assert(testStudent.equals(testStudentIdentical));
        assert(testStudentIdentical.equals(testStudent));
        assert(!testStudentDifferent.equals(testStudent));
    }

    @Test
    public void checkNoNullEntries() {

        assertThrows(IllegalArgumentException.class, () -> new Student(
                null,
                "Potter",
                "Harry",
                "harrypotter@theboywholived.co.wizards",
                "555-WIZ-ARDS"
        ));

        assertThrows(IllegalArgumentException.class, () -> new Student(
                "12345",
                null,
                "Harry",
                "harrypotter@theboywholived.co.wizards",
                "555-WIZ-ARDS"
        ));

        assertThrows(IllegalArgumentException.class, () -> new Student(
                "12345",
                "Potter",
                null,
                "harrypotter@theboywholived.co.wizards",
                "555-WIZ-ARDS"
        ));

        assertThrows(IllegalArgumentException.class, () -> new Student(
                "12345",
                "Potter",
                "Harry",
                null,
                "555-WIZ-ARDS"
        ));

        assertThrows(IllegalArgumentException.class, () -> new Student(
                "12345",
                "Potter",
                "Harry",
                "harrypotter@theboywholived.co.wizards",
                null
        ));
    }
}
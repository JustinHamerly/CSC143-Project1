/**
 * creates a Student object
 *
 * @param id            a student id (required)
 * @param lastName      a last name (required)
 * @param firstName     a first name (required)
 * @param email         an email (required)
 * @param phone         a phone number (required)
 */
public record Student(String id, String lastName, String firstName, String email, String phone) {
    /**
     * Student record precondition for any null arguments
     *
     * @throws IllegalArgumentException     when any parameter is null
     */
    public Student{
        if(id == null || lastName == null || firstName == null || email == null || phone == null){
            throw new IllegalArgumentException("all parameters are required");
        }
    }

    /**
     * checks for equality for all values in two Student objects
     *
     * @param studentObj    a Student object to compare to this Student object
     * @return boolean      true if all values match in both objects; otherwise false
     */
    public boolean equals(Student studentObj){
        return (
            this.id == studentObj.id() &&
            this.lastName == studentObj.lastName() &&
            this.firstName == studentObj.firstName() &&
            this.email == studentObj.email() &&
            this.phone == studentObj.phone()
        );
    }
}

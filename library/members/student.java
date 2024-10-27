package library.members;

/**
 * Represents a student member in the library system.
 * The Student class extends the Member class and inherits common member attributes 
 * such as name, address, and phone number.
 */
public class Student extends Member {


    /**
     * Constructor to create a Student object.
     * 
     * @param name The name of the student.
     * @param address The address of the student.
     * @param phoneNumber The phone number of the student.
     */
    public Student(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }
}

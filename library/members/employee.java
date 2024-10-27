package library.members;

/**
 * Represents an employee in the library system.
 * The Employee class extends the Member class and inherits common member attributes 
 * such as name, address, and phone number.
 */
public class Employee extends Member {

    /**
     * Constructor to create an Employee object.
     * 
     * @param name The name of the employee.
     * @param address The address of the employee.
     * @param phoneNumber The phone number of the employee.
     */
    public Employee(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }
    
}


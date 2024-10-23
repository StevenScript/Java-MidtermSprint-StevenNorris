package library.members;

/**
 * Abstract base class representing a library member.
 * This class provides the basic information for a member, such as their name and address.
 * It serves as a foundation for various types of members (e.g., regular members, VIP members, etc.).
 */
public abstract class member {
    // The name of the library member
    protected String name;
    
    // The address of the library member
    protected String address;

    /**
     * Constructor to initialize a Member object with a name and an address.
     * 
     * @param name The name of the member.
     * @param address The address of the member.
     */
    public member(String name, String address) {
        this.name = name;
        this.address = address;
    }

    /**
     * Returns the name of the library member.
     * 
     * @return A String representing the member's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the library member.
     * 
     * @return A String representing the member's address.
     */
    public String getAddress() {
        return address;
    }
}
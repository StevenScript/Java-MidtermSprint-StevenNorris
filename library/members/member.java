package library.members;

import library.items.LibraryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class representing a library member.
 * This class provides the basic information for a member, such as their name and address.
 * It serves as a foundation for various types of members (e.g., regular members, VIP members, etc.).
 */
public abstract class Member {
    // The name and address of the library member
    protected String name;    
    protected String address;

    // A list to track items borrowed by the member
    protected List<LibraryItem> borrowedItems;



    /**
     * Constructor to initialize a Member object with a name and an address.
     * 
     * @param name The name of the member.
     * @param address The address of the member.
     */
    public Member(String name, String address) {
        this.name = name;
        this.address = address;
        this.borrowedItems = new ArrayList<>();
    }

    /**
     * Returns the name of the library member.
     * 
     * @return String - representing the member's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the address of the library member.
     * 
     * @return String - the member's address.
     */
    public String getAddress() {
        return address;
    }


    /**
     * Returns the address of the library member.
     * 
     * @return String - List LibraryItem objects refering to member's borrowed items
     */
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

}

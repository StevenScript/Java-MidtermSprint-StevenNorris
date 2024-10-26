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
    // The Personal Details of the library member
    protected String name;    
    protected String address;
    protected String phoneNumber;
    
    // A list to track items borrowed by the member
    protected List<LibraryItem> borrowedItems;



    /**
     * Constructor to initialize a Member object with a name and an address.
     * 
     * @param name The name of the member.
     * @param address The address of the member.
     */
    public Member(String name, String address, String phoneNumber)  {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
     * Returns the Phone Number of the library member.
     * 
     * @return String - the member's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Returns the address of the library member.
     * 
     * @return String - List LibraryItem objects refering to member's borrowed items
     */
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    /**
     * Searches borrowed items by title.
     * @param title The title to search for.
     * @return A list of matching LibraryItem objects.
     */
    public List<LibraryItem> searchBorrowedItemsByTitle(String title) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : borrowedItems) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                results.add(item);
            }
        }
        return results;
    }

    /**
     * Updates the patron's details.
     * @param name The new name of the patron.
     * @param address The new address.
     * @param phoneNumber The new phone number.
     */
    public void updateDetails(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}

package library.members;

import library.items.LibraryItem;
import java.util.Map;
import java.util.HashMap;
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
    protected Map<LibraryItem, Integer> borrowedItems;
    



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
         this.borrowedItems = new HashMap<>();
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
    public Map<LibraryItem, Integer> getBorrowedItems() {
        return borrowedItems;
    }


    // Methods to manage borrowed items
    public void borrowItem(LibraryItem item, int quantity) {
        borrowedItems.put(item, borrowedItems.getOrDefault(item, 0) + quantity);
    }

    public void returnItem(LibraryItem item, int quantity) {
        if (borrowedItems.containsKey(item)) {
            int currentQuantity = borrowedItems.get(item);
            if (currentQuantity <= quantity) {
                borrowedItems.remove(item);
            } else {
                borrowedItems.put(item, currentQuantity - quantity);
            }
        } else {
            System.out.println(name + " has not borrowed " + item.getTitle());
        }
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



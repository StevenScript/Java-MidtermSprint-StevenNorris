package library.members;

import library.items.LibraryItem;
import java.util.Map;
import java.util.HashMap;
/**
 * Abstract base class representing a library member.
 * This class provides the basic information for a member, such as their name, address, and phone number.
 * It serves as a foundation for various types of members (e.g., students, employees, etc.).
 * Members can borrow and return items from the library, which are tracked in a borrowed items list.
 */
public abstract class Member {
    
    // The Personal Details of the library member
    protected String name;    
    protected String address;
    protected String phoneNumber;
    protected Map<LibraryItem, Integer> borrowedItems; // A map to track borrowed items and their quantities
    



    /**
     * Constructor to initialize a Member object with a name, address, and phone number.
     * 
     * @param name The name of the member.
     * @param address The address of the member.
     * @param phoneNumber The phone number of the member.
     */
    public Member(String name, String address, String phoneNumber)  {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
         this.borrowedItems = new HashMap<>();
    }


//------Getters-------//


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
     * Returns a map of borrowed items and their quantities for the library member.
     * 
     * @return A Map of LibraryItem objects and their corresponding quantities.
     */
    public Map<LibraryItem, Integer> getBorrowedItems() {
        return borrowedItems;
    }


 //-------- Methods to manage borrowed items ---------//


    /**
     * Allows the member to borrow a specified quantity of a library item.
     * 
     * @param item The item to be borrowed.
     * @param quantity The number of copies to borrow.
     */
    public void borrowItem(LibraryItem item, int quantity) {
        borrowedItems.put(item, borrowedItems.getOrDefault(item, 0) + quantity);
    }


    /**
     * Allows the member to return a specified quantity of a borrowed library item.
     * If the quantity being returned is greater than or equal to the quantity borrowed, the item is removed.
     * 
     * @param item The item to return.
     * @param quantity The number of copies to return.
     */
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
     * Updates the member's details, including name, address, and phone number.
     * 
     * @param name The new name of the member.
     * @param address The new address of the member.
     * @param phoneNumber The new phone number of the member.
     */
    public void updateDetails(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}



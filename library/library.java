package library;

import library.items.LibraryItem;
import library.models.Author;
import library.members.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * This manages the collection items, authors, and members.
 * It provides methods to add or/and retrieve them.
 */
public class library {
    // all library items
    private List<LibraryItem> items;

    // authors whose works are in the library
    private List<Author> authors;

    // List of all library members (able to borrow)
    private List<Member> members;

/**
 * Constructor to initialize the library with empty lists for items, authors, and members.
 */
    public library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        members = new ArrayList<>();
    }

    /**
     * Adds a new library item (e.g., a book, DVD) to the collection.
     * 
     * @param item The library item to add.
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Adds a new author to the list of authors.
     * 
     * @param author The author to add.
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * Adds a new library member (i.e., a person who can borrow items).
     * 
     * @param member The library member to add.
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Deletes a library item from the collection.
     * @param item The LibraryItem to delete.
     */
    public void deleteItem(LibraryItem item) {
        items.remove(item);
    }


    /**
     * Deletes an author from the collection.
     * @param author The Author to delete.
     */
    public void deleteAuthor(Author author) {
        authors.remove(author);
    }

    /**
     * Deletes a Member from the collection.
     * @param patron The member to delete.
     */
    public void deleteMember(Member member) {
        members.remove(member);
    }


    /**
     * Returns the list of all library items.
     * 
     * @return A list of LibraryItem objects.
     */
    public List<LibraryItem> getItems() {
        return items;
    }

    /**
     * Returns the list of all authors in the library.
     * 
     * @return A list of Author objects.
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Returns the list of all library members.
     * 
     * @return A list of Member objects.
     */
    public List<Member> getMembers() {
        return members;
    }
    
    
    
// Borrowing and Returning Items

    /**
     * Allows a library member to borrow an item.
     * Checks if the item is available by checking the number of copies.
     * If able, it lowers the number of copies by one and adds the item 
     * to the member's list of borrowed items.
     * 
     * @param member The member borrowing the item.
     * @param item The item to borrow.
     */
    public void borrowItem(Member member, LibraryItem item) {
        if (item.getNumberOfCopies() > 0) {
            item.setNumberOfCopies(item.getNumberOfCopies() - 1);
            member.getBorrowedItems().add(item);
            System.out.println(member.getName() + " borrowed " + item.getTitle());
        } else {
            System.out.println("Item not available.");
        }
    }

    /**
     * Allows a library member to return an item.
     * Checks if the member has borrowed the item. If so, it increases the 
     * number of copies by one and removes the item from the member's borrowed list.
     * 
     * @param member The library member returning the item.
     * @param item The library item being returned.
     */
    public void returnItem(Member member, LibraryItem item) {
        if (member.getBorrowedItems().contains(item)) {
            item.setNumberOfCopies(item.getNumberOfCopies() + 1);
            member.getBorrowedItems().remove(item);
            System.out.println(member.getName() + " returned " + item.getTitle());
        } else {
            System.out.println(member.getName() + " did not borrow " + item.getTitle());
        }
    }
}
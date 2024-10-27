package library;

import library.models.Author;
import library.members.Member;
import library.items.LibraryItem;
import library.items.BookPrinted;
import library.items.PeriodicalPrinted;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * This manages the collection items, authors, and members.
 * It provides methods to add, edit, delete, and retrieve them.
 */
public class Library {
    // All library items
    private List<LibraryItem> items;

    // Authors whose works are in the library
    private List<Author> authors;

    // List of all library members (able to borrow)
    private List<Member> members;

    /**
     * Constructor to initialize the library with empty lists for items, authors, and members.
     */
    public Library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Methods to manage items
    /**
     * Adds a new library item to the collection.
     *
     * @param item The library item to add.
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Deletes a library item from the collection.
     *
     * @param item The LibraryItem to delete.
     */
    public void deleteItem(LibraryItem item) {
        items.remove(item);
    }

    // Methods to manage authors
    /**
     * Adds a new author to the list of authors.
     *
     * @param author The author to add.
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * Deletes an author from the collection.
     *
     * @param author The Author to delete.
     */
    public void deleteAuthor(Author author) {
        authors.remove(author);
    }

    // Methods to manage members
    /**
     * Adds a new library member.
     *
     * @param member The library member to add.
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Deletes a Member from the collection.
     *
     * @param member The member to delete.
     */
    public void deleteMember(Member member) {
        members.remove(member);
    }

    // Getters
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

//------------Editing------------//


    // Methods to edit items
    public void editItem(String itemId, LibraryItem updatedItem) {
        for (LibraryItem item : items) {
            if (item.getId().equals(itemId)) {
                // Update the existing item's details
                item.updateDetailsFrom(updatedItem);
                System.out.println("Item updated successfully.");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Methods to edit authors
    public void editAuthor(Author existingAuthor, Author updatedAuthor) {
        int index = authors.indexOf(existingAuthor);
        if (index != -1) {
            Author author = authors.get(index);
            author.updateDetails(updatedAuthor.getName(), updatedAuthor.getDateOfBirth());
            System.out.println("Author updated successfully.");
        } else {
            System.out.println("Author not found.");
        }
    }

    // Methods to edit Members
    public void editMember(Member existingPatron, Member updatedPatron) {
        int index = members.indexOf(existingPatron);
        if (index != -1) {
            Member patron = members.get(index);
            patron.updateDetails(updatedPatron.getName(), updatedPatron.getAddress(), updatedPatron.getPhoneNumber());
            System.out.println("Patron updated successfully.");
        } else {
            System.out.println("Patron not found.");
        }
    }
    
//------------Borrowing and Returning Items------------//

    // Borrow item method
/**
 * Allows a member to borrow a specific quantity of an item.
 * @param member The member borrowing the item.
 * @param item The item to borrow.
 * @param quantity The number of copies to borrow.
 */
public void borrowItem(Member member, LibraryItem item, int quantity) {
    if (item instanceof BookPrinted) {
        BookPrinted printedBook = (BookPrinted) item;
        int availableCopies = printedBook.getNumberOfCopies();
        if (availableCopies >= quantity) {
            printedBook.setNumberOfCopies(availableCopies - quantity);
            member.borrowItem(item, quantity); // Assuming Member class has a borrowItem method
            System.out.println(member.getName() + " borrowed " + quantity + " copies of '" + item.getTitle() + "'");
        } else {
            System.out.println("Not enough copies of '" + item.getTitle() + "' available.");
        }
    } else if (item instanceof PeriodicalPrinted) {
        PeriodicalPrinted printedPeriodical = (PeriodicalPrinted) item;
        int availableCopies = printedPeriodical.getNumberOfCopies();
        if (availableCopies >= quantity) {
            printedPeriodical.setNumberOfCopies(availableCopies - quantity);
            member.borrowItem(item, quantity);
            System.out.println(member.getName() + " borrowed " + quantity + " copies of '" + item.getTitle() + "'");
        } else {
            System.out.println("Not enough copies of '" + item.getTitle() + "' available.");
        }
    } else {
        // For electronic and audio items, assume unlimited availability
        member.borrowItem(item, quantity);
        System.out.println(member.getName() + " borrowed " + quantity + " copies of '" + item.getTitle() + "'");
    }
}

// Return item method
/**
 * Allows a member to return a specific quantity of an item.
 * @param member The member returning the item.
 * @param item The item to return.
 * @param quantity The number of copies to return.
 */
public void returnItem(Member member, LibraryItem item, int quantity) {
    Map<LibraryItem, Integer> borrowedItems = member.getBorrowedItems(); // Assuming getBorrowedItems returns a Map<LibraryItem, Integer>
    if (borrowedItems.containsKey(item)) {
        int borrowedQuantity = borrowedItems.get(item);
        if (borrowedQuantity >= quantity) {
            member.returnItem(item, quantity); // Assuming Member class has a returnItem method
            // Increase the number of copies if it's a physical item
            if (item instanceof BookPrinted) {
                BookPrinted printedBook = (BookPrinted) item;
                printedBook.setNumberOfCopies(printedBook.getNumberOfCopies() + quantity);
            } else if (item instanceof PeriodicalPrinted) {
                PeriodicalPrinted printedPeriodical = (PeriodicalPrinted) item;
                printedPeriodical.setNumberOfCopies(printedPeriodical.getNumberOfCopies() + quantity);
            }
            System.out.println(member.getName() + " returned " + quantity + " copies of '" + item.getTitle() + "'");
        } else {
            System.out.println(member.getName() + " has only borrowed " + borrowedQuantity + " copies of '" + item.getTitle() + "'");
        }
    } else {
        System.out.println(member.getName() + " has not borrowed '" + item.getTitle() + "'");
    }
}


    /**
 * Searches for library items by title.
 * @param title The title to search for.
 * @return A list of matching LibraryItem objects.
 */
public List<LibraryItem> searchItemsByTitle(String title) {
    List<LibraryItem> results = new ArrayList<>();
    for (LibraryItem item : items) {
        if (item.getTitle().equalsIgnoreCase(title)) {
            results.add(item);
        }
    }
    return results;
}

/**
 * Searches for library items by author name.
 * @param authorName The author's name to search for.
 * @return A list of matching LibraryItem objects.
 */
public List<LibraryItem> searchItemsByAuthor(String authorName) {
    List<LibraryItem> results = new ArrayList<>();
    for (LibraryItem item : items) {
        for (Author author : item.getAuthors()) {
            if (author.getName().equalsIgnoreCase(authorName)) {
                results.add(item);
                break; // Break to avoid adding the same item multiple times if multiple authors match
            }
        }
    }
    return results;
}

/**
 * Searches for a library item by ISBN.
 * @param isbn The ISBN to search for.
 * @return The matching LibraryItem object, or null if not found.
 */
public LibraryItem searchItemByISBN(String isbn) {
    for (LibraryItem item : items) {
        if (item.getIsbn().equalsIgnoreCase(isbn)) {
            return item;
        }
    }
    return null;
}

}


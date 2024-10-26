package library;

import library.models.Author;
import library.members.Member;
import library.items.LibraryItem;
import library.items.BookPrinted;
import library.items.PeriodicalPrinted;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Allows a library member to borrow a specific quantity of an item.
     * If the item is a physical copy (e.g., book or periodical), it checks if there are enough copies
     * available. For each copy borrowed, the number of available copies is reduced. If the item is 
     * electronic or audio, no copies are deducted.
     * 
     * @param member The library member borrowing the item.
     * @param item The library item to borrow.
     * @param quantity The number of copies to borrow.
     */
    public void borrowItem(Member member, LibraryItem item, int quantity) {
        if (item instanceof BookPrinted) {
            BookPrinted printedBook = (BookPrinted) item;
            if (printedBook.getNumberOfCopies() >= quantity) {
                printedBook.setNumberOfCopies(printedBook.getNumberOfCopies() - quantity);
                // Add the item to the member's borrowed items list for each copy borrowed
                for (int i = 0; i < quantity; i++) {
                    member.getBorrowedItems().add(item);
                }
                System.out.println(member.getName() + " borrowed " + quantity + " copies of " + item.getTitle());
            } else {
                System.out.println("Not enough copies of '" + item.getTitle() + "' available.");
            }
        } else if (item instanceof PeriodicalPrinted) {
            PeriodicalPrinted printedPeriodical = (PeriodicalPrinted) item;
            if (printedPeriodical.getNumberOfCopies() >= quantity) {
                printedPeriodical.setNumberOfCopies(printedPeriodical.getNumberOfCopies() - quantity);
                for (int i = 0; i < quantity; i++) {
                    member.getBorrowedItems().add(item);
                }
                System.out.println(member.getName() + " borrowed " + quantity + " copies of " + item.getTitle());
            } else {
                System.out.println("Not enough copies of '" + item.getTitle() + "' available.");
            }
        } else {
            // For electronic or audio items, no copies are deducted
            member.getBorrowedItems().add(item);
            System.out.println(member.getName() + " borrowed " + item.getTitle());
        }
    }

    /**
     * Allows a library member to return a specific quantity of an item they borrowed.
     * It checks the member's borrowed list and removes the specified number of copies.
     * If the item is a physical copy (e.g., book or periodical), the number of available copies is increased.
     * 
     * @param member The library member returning the item.
     * @param item The library item being returned.
     * @param quantity The number of copies to return.
     */
    public void returnItem(Member member, LibraryItem item, int quantity) {
        int count = 0;
        for (int i = 0; i < member.getBorrowedItems().size() && count < quantity; ) {
            if (member.getBorrowedItems().get(i).equals(item)) {
                member.getBorrowedItems().remove(i);
                count++;
            } else {
                i++;
            }
        }

        if (count > 0) {
            if (item instanceof BookPrinted) {
                BookPrinted printedBook = (BookPrinted) item;
                printedBook.setNumberOfCopies(printedBook.getNumberOfCopies() + count);
            } else if (item instanceof PeriodicalPrinted) {
                PeriodicalPrinted printedPeriodical = (PeriodicalPrinted) item;
                printedPeriodical.setNumberOfCopies(printedPeriodical.getNumberOfCopies() + count);
            }
            System.out.println(member.getName() + " returned " + count + " copies of " + item.getTitle());
        } else {
            System.out.println(member.getName() + " did not borrow " + item.getTitle() + " or insufficient copies to return.");
        }
    }
}


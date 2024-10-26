package library.items;

import java.util.List;

import library.models.Author;


/**
 * Represents a printed book.
 */
public class BookPrinted extends BookMaster{
    private int numberOfCopies;
    private int numberOfPages;

    public BookPrinted(String id, String title, List<Author> authors, String isbn, String publisher, int numberOfCopies, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.numberOfCopies = numberOfCopies;
        this.numberOfPages = numberOfPages;
    }


    
    /**
     * Updates the printed book's details.
     * @param title The new title.
     * @param authors The new list of authors.
     * @param isbn The new ISBN.
     * @param publisher The new publisher.
     * @param numberOfCopies The new number of copies.
     * @param numberOfPages The new number of pages.
     */
    public void updateDetails(String title, List<Author> authors, String isbn, String publisher,
                              int numberOfCopies, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.numberOfPages = numberOfPages;
    }


    /**
 * Updates the details of the current book from another LibraryItem instance.
 * This method specifically checks if the updated item is a BookPrinted instance and, if so,
 * copies over its details (title, authors, ISBN, publisher, number of copies, and number of pages).
 * If the provided item is not a BookPrinted, the method prints an error message.
 * 
 * @param updatedItem The LibraryItem containing the new data to update this printed book with.
 */
    @Override
public void updateDetailsFrom(LibraryItem updatedItem) {
    if (updatedItem instanceof BookPrinted) {
        BookPrinted updatedPrintedBook = (BookPrinted) updatedItem;
        this.title = updatedPrintedBook.getTitle();
        this.authors = updatedPrintedBook.getAuthors();
        this.isbn = updatedPrintedBook.getIsbn();
        this.publisher = updatedPrintedBook.getPublisher();
        this.numberOfCopies = updatedPrintedBook.getNumberOfCopies();
        this.numberOfPages = updatedPrintedBook.getNumberOfPages();
    } else {
        System.out.println("Invalid item type for update.");
    }
}


// Getters
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

// Setters
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    
}

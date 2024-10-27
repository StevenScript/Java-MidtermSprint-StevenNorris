package library.items;

import java.util.List;

import library.models.Author;


/**
 * Represents a printed book in the library system.
 * This class extends the BookMaster class and includes additional attributes such as 
 * the number of copies available in the library and the number of pages in the book.
 */
public class BookPrinted extends BookMaster{
    private int numberOfCopies; // The number of copies of the printed book available in the library
    private int numberOfPages; // The number of pages in the printed book


    /**
     * Constructor to create a BookPrinted object.
     * 
     * @param id The unique ID of the printed book.
     * @param title The title of the printed book.
     * @param authors The list of authors associated with the printed book.
     * @param isbn The ISBN of the printed book.
     * @param publisher The publisher of the printed book.
     * @param numberOfCopies The number of copies of the printed book available in the library.
     * @param numberOfPages The number of pages in the printed book.
     */
    public BookPrinted(String id, String title, List<Author> authors, String isbn, String publisher, int numberOfCopies, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.numberOfCopies = numberOfCopies;
        this.numberOfPages = numberOfPages;
    }


    
     /**
     * Updates the details of the printed book, including title, authors, ISBN, publisher,
     * number of copies, and number of pages.
     * 
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
     * Updates the details of the current printed book from another LibraryItem instance.
     * Specifically checks if the provided item is a BookPrinted instance and, if so,
     * copies over its details (title, authors, ISBN, publisher, number of copies, and number of pages).
     * If the provided item is not a BookPrinted, it prints an error message.
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

 //----- Getters -------//

     /**
     * Returns the number of copies of the printed book available in the library.
     * 
     * @return The number of copies of the printed book.
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Returns the number of pages in the printed book.
     * 
     * @return The number of pages in the printed book.
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    // Setters

    /**
     * Sets the number of copies of the printed book available in the library.
     * 
     * @param numberOfCopies The new number of copies of the printed book.
     */
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
    

    
   

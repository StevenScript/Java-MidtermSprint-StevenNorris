package library.items;
import library.models.Author;
import java.util.List;


/**
 * Represents a printed periodical in the library system.
 * This class extends the PeriodicalMaster class and includes additional attributes such as 
 * the number of copies available in the library and the number of pages in the periodical.
 */
public class PeriodicalPrinted extends PeriodicalMaster {
    private int numberOfCopies; // The number of copies of the printed periodical available in the library
    private int numberOfPages; // The number of pages in the printed periodical


    /**
     * Constructor to create a PeriodicalPrinted object.
     * 
     * @param id The unique ID of the printed periodical.
     * @param title The title of the printed periodical.
     * @param authors The list of authors associated with the printed periodical.
     * @param isbn The ISBN of the printed periodical.
     * @param publisher The publisher of the printed periodical.
     * @param numberOfCopies The number of copies of the printed periodical available in the library.
     * @param numberOfPages The number of pages in the printed periodical.
     */
    public PeriodicalPrinted(String id, String title, List<Author> authors, String isbn, String publisher, int numberOfCopies, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.numberOfCopies = numberOfCopies;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Updates the details of the printed periodical, including title, authors, ISBN, publisher,
     * number of copies, and number of pages.
     * 
     * @param title The new title of the printed periodical.
     * @param authors The new list of authors.
     * @param isbn The new ISBN of the printed periodical.
     * @param publisher The new publisher of the printed periodical.
     * @param numberOfCopies The new number of copies of the printed periodical.
     * @param numberOfPages The new number of pages in the printed periodical.
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
     * Method to update details from another LibraryItem instance
     * 
     * Updates the details of the current printed periodical from another LibraryItem instance.
     * Specifically checks if the provided item is a PeriodicalPrinted instance and, if so,
     * copies over its details (title, authors, ISBN, publisher, number of copies, and number of pages).
     * If the provided item is not a PeriodicalPrinted, it prints an error message.
     * 
     * @param updatedItem The LibraryItem containing the new data to update this printed periodical with.
     */
    @Override
    public void updateDetailsFrom(LibraryItem updatedItem) {
        if (updatedItem instanceof PeriodicalPrinted) {
            PeriodicalPrinted updatedPrintedPeriodical = (PeriodicalPrinted) updatedItem;
            this.title = updatedPrintedPeriodical.getTitle();
            this.authors = updatedPrintedPeriodical.getAuthors();
            this.isbn = updatedPrintedPeriodical.getIsbn();
            this.publisher = updatedPrintedPeriodical.getPublisher();
            this.numberOfCopies = updatedPrintedPeriodical.getNumberOfCopies();
            this.numberOfPages = updatedPrintedPeriodical.getNumberOfPages();
        } else {
            System.out.println("Invalid item type for update.");
        }
    }

//------Getters-------//

    /**
     * Returns the number of copies of the printed periodical available in the library.
     * 
     * @return The number of copies of the printed periodical.
     */
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Returns the number of pages in the printed periodical.
     * 
     * @return The number of pages in the printed periodical.
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    // Setters

    /**
     * Sets the number of copies of the printed periodical available in the library.
     * 
     * @param numberOfCopies The new number of copies of the printed periodical.
     */
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
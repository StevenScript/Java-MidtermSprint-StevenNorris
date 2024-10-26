package library.items;
import library.models.Author;
import java.util.List;

public class PeriodicalPrinted extends PeriodicalMaster {
    private int numberOfCopies;
    private int numberOfPages;

    public PeriodicalPrinted(String id, String title, List<Author> authors, String isbn, String publisher, int numberOfCopies, int numberOfPages) {
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


// Getters
    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

//setters
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
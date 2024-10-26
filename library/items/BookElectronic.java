package library.items;
import library.models.Author;
import java.util.List;

public class BookElectronic extends BookMaster {

    private double fileSize; // in MB
    private String fileFormat; // e.g., "PDF", "EPUB"
    private int numberOfPages;

    public BookElectronic(String id, String title, List<Author> authors, String isbn, String publisher, double fileSize, String fileFormat, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.numberOfPages = numberOfPages;
    }

    // New method to update book details
    /**
     * Updates the printed book's details.
     * @param title The new title.
     * @param authors The new list of authors.
     * @param isbn The new ISBN.
     * @param publisher The new publisher.
     * @param fileSize The amount of memory taken up by the file.
     * @param fileFormat The type of file
     * @param numberOfPages The new number of pages.
     */
    public void updateDetails(String title, List<Author> authors, String isbn, String publisher,
                              double fileSize, String fileFormat, int numberOfPages) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
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
    if (updatedItem instanceof BookElectronic) {
        BookElectronic updatedElectronicBook = (BookElectronic) updatedItem;
        this.title = updatedElectronicBook.getTitle();
        this.authors = updatedElectronicBook.getAuthors();
        this.isbn = updatedElectronicBook.getIsbn();
        this.publisher = updatedElectronicBook.getPublisher();
        this.fileSize = updatedElectronicBook.getFileSize();
        this.fileFormat = updatedElectronicBook.getFileFormat();
        this.numberOfPages = updatedElectronicBook.getNumberOfPages();
    } else {
        System.out.println("Invalid item type for update.");
    }
}

    // Getters
    public double getFileSize() {
        return fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
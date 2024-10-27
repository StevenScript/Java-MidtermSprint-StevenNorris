package library.items;
import library.models.Author;
import java.util.List;

/**
 * The BookElectronic class represents an electronic book in the library system.
 * It extends the BookMaster class and includes additional attributes such as 
 * file size, file format, and the number of pages.
 */
public class BookElectronic extends BookMaster {

    private double fileSize; // The file size in MB
    private String fileFormat; // The file format e.g., "PDF", "EPUB"
    private int numberOfPages; // The number of pages


    /**
     * Constructor to create a BookElectronic object.
     * 
     * @param id The unique ID of the electronic book.
     * @param title The title of the electronic book.
     * @param authors The list of authors associated with the book.
     * @param isbn The ISBN of the electronic book.
     * @param publisher The publisher of the electronic book.
     * @param fileSize The size of the electronic book file, in megabytes (MB).
     * @param fileFormat The file format of the electronic book (e.g., "PDF", "EPUB").
     * @param numberOfPages The number of pages in the electronic book.
     */
    public BookElectronic(String id, String title, List<Author> authors, String isbn, String publisher, double fileSize, String fileFormat, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Method to update the details of the electronic book
     * Updates the electronic book's details, including title, authors, ISBN, publisher,
     * file size, file format, and the number of pages.
     * 
     * @param title The new title of the electronic book.
     * @param authors The new list of authors.
     * @param isbn The new ISBN of the electronic book.
     * @param publisher The new publisher of the electronic book.
     * @param fileSize The new file size of the electronic book, in megabytes (MB).
     * @param fileFormat The new file format of the electronic book (e.g., "PDF", "EPUB").
     * @param numberOfPages The new number of pages in the electronic book.
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
     * Method to update details from another LibraryItem instance
     * Updates the details of the current electronic book from another LibraryItem instance.
     * Specifically checks if the provided item is a BookElectronic instance and, if so,
     * copies over its details (title, authors, ISBN, publisher, file size, file format, and number of pages).
     * If the provided item is not a BookElectronic, it prints an error message.
     * 
     * @param updatedItem The LibraryItem containing the new data to update this electronic book with.
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

// ---- Getters for fileSize, fileFormat, and numberOfPages --- //
    
/**
 * Returns the file size of the electronic book.
 * 
 * @return The file size of the electronic book, in megabytes (MB).
 */
public double getFileSize() {
    return fileSize;
}

/**
 * Returns the file format of the electronic book.
 * 
 * @return The file format of the electronic book (e.g., "PDF", "EPUB").
 */
public String getFileFormat() {
    return fileFormat;
}


/**
 * Returns the number of pages in the electronic book.
 * 
 * @return The number of pages in the electronic book.
 */
public int getNumberOfPages() { 
    return numberOfPages;
}
}
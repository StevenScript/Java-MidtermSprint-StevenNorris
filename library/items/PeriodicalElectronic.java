package library.items;
import library.models.Author;
import java.util.List;


/**
 * The PeriodicalElectronic class represents an electronic periodical in the library system.
 * It extends the PeriodicalMaster class and includes additional attributes such as 
 * file size, file format, and the number of pages.
 */
public class PeriodicalElectronic extends PeriodicalMaster {
    private double fileSize; // file size in MB
    private String fileFormat; // file format  e.g., "PDF"
    private int numberOfPages; // The number of pages


    /**
     * Constructor to create a PeriodicalElectronic object.
     * 
     * @param id The unique ID of the electronic periodical.
     * @param title The title of the electronic periodical.
     * @param authors The list of authors associated with the periodical.
     * @param isbn The ISBN of the electronic periodical.
     * @param publisher The publisher of the electronic periodical.
     * @param fileSize The size of the electronic periodical file, in megabytes (MB).
     * @param fileFormat The file format of the electronic periodical (e.g., "PDF").
     * @param numberOfPages The number of pages in the electronic periodical.
     */
    public PeriodicalElectronic(String id, String title, List<Author> authors, String isbn, String publisher, double fileSize, String fileFormat, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.numberOfPages = numberOfPages;
    }

    /**
     * Updates the electronic periodical's details, including title, authors, ISBN, publisher,
     * file size, file format, and the number of pages.
     * 
     * @param title The new title of the electronic periodical.
     * @param authors The new list of authors.
     * @param isbn The new ISBN of the electronic periodical.
     * @param publisher The new publisher of the electronic periodical.
     * @param fileSize The new file size of the electronic periodical, in megabytes (MB).
     * @param fileFormat The new file format of the electronic periodical (e.g., "PDF").
     * @param numberOfPages The new number of pages in the electronic periodical.
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
     * Updates the details of the current electronic periodical from another LibraryItem instance.
     * Specifically checks if the provided item is a PeriodicalElectronic instance and, if so,
     * copies over its details (title, authors, ISBN, publisher, file size, file format, and number of pages).
     * If the provided item is not a PeriodicalElectronic, it prints an error message.
     * 
     * @param updatedItem The LibraryItem containing the new data to update this electronic periodical with.
     */
     @Override
    public void updateDetailsFrom(LibraryItem updatedItem) {
        if (updatedItem instanceof PeriodicalElectronic) {
            PeriodicalElectronic updatedElectronicPeriodical = (PeriodicalElectronic) updatedItem;
            this.title = updatedElectronicPeriodical.getTitle();
            this.authors = updatedElectronicPeriodical.getAuthors();
            this.isbn = updatedElectronicPeriodical.getIsbn();
            this.publisher = updatedElectronicPeriodical.getPublisher();
            this.fileSize = updatedElectronicPeriodical.getFileSize();
            this.fileFormat = updatedElectronicPeriodical.getFileFormat();
            this.numberOfPages = updatedElectronicPeriodical.getNumberOfPages();
        } else {
            System.out.println("Invalid item type for update.");
        }
    }
//---- Getters for fileSize, fileFormat, and numberOfPages

    /**
     * Returns the file size of the electronic periodical.
     * 
     * @return The file size of the periodical, in megabytes (MB).
     */
    public double getFileSize() {
        return fileSize;
    }

    /**
     * Returns the file format of the electronic periodical.
     * 
     * @return The file format of the periodical (e.g., "PDF").
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * Returns the number of pages in the electronic periodical.
     * 
     * @return The number of pages in the periodical.
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }
}

  

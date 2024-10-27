package library.items;
import library.models.Author;
import java.util.List;


/**
 * The BookAudio class represents an audiobook in the library system.
 * It extends the BookMaster class and includes additional attributes 
 * like runtime (in hours) and the narrator of the audiobook.
 */
public class BookAudio extends BookMaster {
    private double runtime; // runtime of the audiobook, in hours
    private String narrator; // The name of the narrator for the audiobook




    /**
     * Constructor to create a BookAudio object.
     * 
     * @param id The unique ID of the audiobook.
     * @param title The title of the audiobook.
     * @param authors The list of authors associated with the audiobook.
     * @param isbn The ISBN of the audiobook.
     * @param publisher The publisher of the audiobook.
     * @param runtime The length of the audiobook in hours.
     * @param narrator The name of the narrator for the audiobook.
     */
    public BookAudio(String id, String title, List<Author> authors, String isbn, String publisher, double runtime, String narrator) {
        super(id, title, authors, isbn, publisher);
        this.runtime = runtime;
        this.narrator = narrator;
    }


   /**
     * Constructor to create a BookAudio object.
     * 
     * @param id The unique ID of the audiobook.
     * @param title The title of the audiobook.
     * @param authors The list of authors associated with the audiobook.
     * @param isbn The ISBN of the audiobook.
     * @param publisher The publisher of the audiobook.
     * @param runtime The length of the audiobook in hours.
     * @param narrator The name of the narrator for the audiobook.
     */
    public void updateDetails(String title, List<Author> authors, String isbn, String publisher,
    double runtime, String narrator) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.runtime = runtime;
        this.narrator = narrator;
    }


    // Method to update details from another LibraryItem instance
    /**
     * Updates the details of the current book from another LibraryItem instance.
     * This method specifically checks if the updated item is a BookAudio instance and, if so,
     * copies over its details (title, authors, ISBN, publisher, number of copies, and number of pages).
     * If the provided item is not a BookAudio, the method prints an error message.
     * 
     * @param updatedItem The LibraryItem containing the new data to update this printed book with.
     */
    @Override
    public void updateDetailsFrom(LibraryItem updatedItem) {
        if (updatedItem instanceof BookAudio) {
            BookAudio updatedElectronicBook = (BookAudio) updatedItem;
            this.title = updatedElectronicBook.getTitle();
            this.authors = updatedElectronicBook.getAuthors();
            this.isbn = updatedElectronicBook.getIsbn();
            this.publisher = updatedElectronicBook.getPublisher();
            this.runtime = updatedElectronicBook.getRuntime();
            this.narrator = updatedElectronicBook.getNarrator();
        } else {
            System.out.println("Invalid item type for update.");
        }
    }

// Getters for runtime and narrator

       /**
        * Returns the runtime of the audiobook.
        * 
        * @return The length of the audiobook in hours.
        */
        public double getRuntime() {
            return runtime;
        }

        /**
         * Returns the name of the narrator of the audiobook.
         * 
         * @return The name of the audiobook's narrator.
         */
        public String getNarrator() {
            return narrator;
        }
    }


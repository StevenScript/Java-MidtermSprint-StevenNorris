package library.items;
import library.models.Author;
import java.util.List;

public class BookAudio extends BookMaster {
    private double runtime; // in hours
    private String narrator;

    public BookAudio(String id, String title, List<Author> authors, String isbn, String publisher, double runtime, String narrator) {
        super(id, title, authors, isbn, publisher);
        this.runtime = runtime;
        this.narrator = narrator;
    }

    // New method to update book details
    /**
     * Updates the printed book's details.
     * @param title The new title.
     * @param authors The new list of authors.
     * @param isbn The new ISBN.
     * @param publisher The new publisher.
     * @param runtime The length of the audio, in hours
     * @param narrator The Narrator's name
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

    // Getters
    public double getRuntime() {
        return runtime;
    }

    public String getNarrator() {
        return narrator;
    }
}

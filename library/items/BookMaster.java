package library.items;

import library.models.Author;
import java.util.List;

/**
 * Abstract base class for all types of books in the library system.
 * BookMaster serves as the foundation for specific book types like 
 * printed books, audiobooks, and electronic books. It extends the 
 * LibraryItem class to inherit common attributes like ID, title, authors, 
 * ISBN, and publisher.
 */
public abstract class BookMaster extends LibraryItem {


    /**
     * Constructor for creating a BookMaster instance. 
     * This constructor is used by subclasses of BookMaster.
     * 
     * @param id The unique ID of the book.
     * @param title The title of the book.
     * @param authors The list of authors associated with the book.
     * @param isbn The ISBN of the book.
     * @param publisher The publisher of the book.
     */
    public BookMaster(String id, String title, List<Author> authors, String isbn, String publisher) {
        super(id, title, authors, isbn, publisher);
    }
}

package library.items;

import library.models.Author;
import java.util.List;

/**
 * Abstract base class for all books.
 */
public abstract class BookMaster extends LibraryItem {

    public BookMaster(String id, String title, List<Author> authors, String isbn, String publisher) {
        super(id, title, authors, isbn, publisher);
    }
}

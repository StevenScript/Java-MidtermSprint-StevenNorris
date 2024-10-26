package library.items;

import library.models.Author;
import java.util.List;

/**
 * Abstract base class for all periodicals.
 */
public abstract class PeriodicalMaster extends LibraryItem {

    public PeriodicalMaster(String id, String title, List<Author> authors, String isbn, String publisher) {
        super(id, title, authors, isbn, publisher);
    }
}

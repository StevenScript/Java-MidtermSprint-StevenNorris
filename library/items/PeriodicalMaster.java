package library.items;

import library.models.Author;
import java.util.List;

/**
 * Abstract base class for all periodicals in the library system.
 * PeriodicalMaster serves as the base file for specific periodical types such as 
 * electronic periodicals, printed periodicals, and more. It extends the LibraryItem class
 * to inherit common attributes like ID, title, authors, ISBN, and publisher.
 */
public abstract class PeriodicalMaster extends LibraryItem {


    /**
     * Constructor for creating a PeriodicalMaster instance.
     * This constructor is used by subclasses of PeriodicalMaster to initialize common 
     * attributes for periodicals, such as ID, title, authors, ISBN, and publisher.
     * 
     * @param id The unique ID of the periodical.
     * @param title The title of the periodical.
     * @param authors The list of authors associated with the periodical.
     * @param isbn The ISBN of the periodical.
     * @param publisher The publisher of the periodical.
     */
    public PeriodicalMaster(String id, String title, List<Author> authors, String isbn, String publisher) {
        super(id, title, authors, isbn, publisher);
    }
}

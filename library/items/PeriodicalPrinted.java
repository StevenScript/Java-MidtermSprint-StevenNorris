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
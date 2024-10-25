package library.items;

import java.util.List;

import library.models.Author;


/**
 * Represents a printed book.
 */
public class BookPrinted extends BookMaster{
    private int numberOfCopies;
    private int numberOfPages;

    public BookPrinted(String id, String title, List<Author> authors, String isbn, String publisher, int numberOfCopies, int numberOfPages) {
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

// Setters
    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
    
}

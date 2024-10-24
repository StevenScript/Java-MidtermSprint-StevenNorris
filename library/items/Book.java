package library.items;

import java.util.List;

import library.models.Author;

/**
 * Represents a book in the library.
 */
public class Book extends LibraryItem {
    private List<Author> authors;

    public Book(String id, String title, List<Author> authors, int numberOfCopies) {
        super(id, title, numberOfCopies);
        this.authors = authors;
    }

    // Getter for authors
    public List<Author> getAuthors() {
        return authors;
    }
}
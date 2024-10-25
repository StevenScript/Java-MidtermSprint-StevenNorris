package library.items;

import java.util.List;

import library.models.Author;

/**
 * Base abstract class for library items.
 * Serves as a foundation for items that can be stored in the library
 * Each item has an ID and a title.
 */
public abstract class LibraryItem {
    protected String id;
    protected String title;
    protected List<Author> authors;
    protected String isbn;
    protected String publisher;

    /**
     * Constructor to initialise a LibraryItem with an ID and title.
     * 
     * @param id The unique ID for the item
     * @param title The title of the item
     */
    public LibraryItem(String id, String title, List<Author> authors, String isbn, String publisher) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
    }


    // Getters

    /**
     * Returns the unique ID of the library item.
     * 
     * @return A String - item's ID.
     */
    public String getId() {
        return id;
    }


    /**
     * Returns the title of library item.
     * 
     * @return A String - item's title.
     */
    public String getTitle() {
        return title;
    }


    /**
     * Returns the Author(s) name.
     * 
     * @return A String - item's title.
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Returns the ISBN of library item.
     * 
     * @return A String - item's ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns the Publisher name of an item.
     * 
     * @return A String - Item's Publisher
     */
    public String getPublisher() {
        return publisher;
    }
}

package library.items;

import java.util.List;
import java.util.Objects;
import library.models.Author;

/**
 * Abstract base class for all library items.
 * This class serves as the foundation for any item that can be stored in the library,
 * such as books, periodicals, or digital media. Each item has a unique ID, title, authors,
 * ISBN, and publisher.
 */
public abstract class LibraryItem {
    protected String id;
    protected String title;
    protected List<Author> authors;
    protected String isbn;
    protected String publisher;

    /**
     * Constructor to initialize a LibraryItem with its ID, title, authors, ISBN, and publisher.
     * 
     * @param id The unique ID for the library item.
     * @param title The title of the library item.
     * @param authors The list of authors who contributed to the library item.
     * @param isbn The ISBN of the library item (if applicable).
     * @param publisher The publisher of the library item.
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

    
     /**
     * Abstract method to update the details of the library item.
     * This method is meant to be implemented by subclasses, allowing them to update
     * their details from another LibraryItem instance.
     * 
     * @param updatedItem The LibraryItem object containing the updated details.
     */
     public abstract void updateDetailsFrom(LibraryItem updatedItem);

     /**
     * Overrides the equals method to compare LibraryItem objects based on their unique ID.
     * 
     * @param o The object to be compared.
     * @return True if the objects are equal, otherwise false.
     */
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
 
         LibraryItem that = (LibraryItem) o;
 
         return id.equals(that.id);
     }
 
     /**
     * Overrides the hashCode method to generate a hash code based on the item's unique ID.
     * 
     * @return The hash code value for the item.
     */
     @Override
     public int hashCode() {
         return Objects.hash(id);
     }
 }


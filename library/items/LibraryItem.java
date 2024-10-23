package library.items;

/**
 * Base abstract class for library items.
 * Serves as a foundation for items that can be stored in the library
 * Each item has an ID and a title.
 */
public abstract class LibraryItem {
      // Unique ID for the library item
    protected String id;
    protected String title;


    /**
     * Constructor to initialise a LibraryItem with an ID and title.
     * 
     * @param id The unique ID for the item
     * @param title The title of the item
     */
    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
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
}


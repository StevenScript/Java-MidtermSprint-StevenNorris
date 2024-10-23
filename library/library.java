package library;

import library.items.LibraryItem;
import library.models.Author;
import library.members.Member;

import java.util.ArrayList;
import java.util.List;

/**
 * This manages the collection items, authors, and members.
 * It provides methods to add or/and retrieve them.
 */
public class library {
    // all library items
    private List<LibraryItem> items;

    // authors whose works are in the library
    private List<Author> authors;

    // List of all library members (able to borrow)
    private List<Member> members;

    /**
     * Constructor to initialize the library with empty lists for items, authors, and members.
     */
    public library() {
        items = new ArrayList<>();
        authors = new ArrayList<>();
        members = new ArrayList<>();
    }

    /**
     * Adds a new library item (e.g., a book, DVD) to the collection.
     * 
     * @param item The library item to add.
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Adds a new author to the list of authors.
     * 
     * @param author The author to add.
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * Adds a new library member (i.e., a person who can borrow items).
     * 
     * @param member The library member to add.
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Returns the list of all library items.
     * 
     * @return A list of LibraryItem objects.
     */
    public List<LibraryItem> getItems() {
        return items;
    }

    /**
     * Returns the list of all authors in the library.
     * 
     * @return A list of Author objects.
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * Returns the list of all library members.
     * 
     * @return A list of Member objects.
     */
    public List<Member> getMembers() {
        return members;
    }
}

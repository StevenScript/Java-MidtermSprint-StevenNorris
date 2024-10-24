package library;

import java.util.ArrayList;
import java.util.List;

import library.items.Book;
import library.models.Author;
import library.members.Student;

/**
 * The main class to demonstrate the functionality of the Library Management System.
 * It creates instances of authors, books, and members, adds them to the library, 
 * and then outputs the current state of the library's collections.
 */
public class Test {
    public static void main(String[] args) {
        // Create a library instance
        library library = new library();

        // Create an author, add it to library
        Author author = new Author("Mark Z. Danielewski", "1775-12-16");
        library.addAuthor(author);

        // Create and add book with its author
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Book book = new Book("1", "House of Leaves", authors);
        library.addItem(book);

        // Create and add a student member
        Student student = new Student("Mia Demoe", "111 Yes Drive");
        library.addMember(student);

        // Output to verify
        System.out.println("Authors in the library:");  // Output the list of authors in the library
        for (Author a : library.getAuthors()) {
            System.out.println("- " + a.getName());
        }

        System.out.println("Items in the library:");   // Output the list of items
        for (var item : library.getItems()) {
            System.out.println("- " + item.getTitle());
        }

        System.out.println("Memembers of this library:"); // Output the list of members
        for (var patron : library.getMembers()) {
            System.out.println("- " + patron.getName());
        }
    }
}

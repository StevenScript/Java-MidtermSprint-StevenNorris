package library;

import library.items.*;
import library.models.Author;
import library.members.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class to run the Library Management System.
 */
public class Demo {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();

        // Create an author
        Author author1 = new Author("George Orwell", "1903-06-25");
        library.addAuthor(author1);

        // Create a list of authors for the book
        List<Author> authors = new ArrayList<>();
        authors.add(author1);

        // Create a printed book using BookPrinted
        BookPrinted printedBook = new BookPrinted("1", "1984", authors,
                "9780451524935", "Secker & Warburg", 10, 328);
        library.addItem(printedBook);

        // Create a student patron
        Student student = new Student("Alice Smith", "123 Main St", "555-1234");
        library.addMember(student);

        // Display initial details
        System.out.println("Initial Book Title: " + printedBook.getTitle());
        System.out.println("Initial Book Publisher: " + printedBook.getPublisher());
        System.out.println("Initial Author Name: " + author1.getName());
        System.out.println("Initial Patron Name: " + student.getName());
        System.out.println("Initial Patron Address: " + student.getAddress());

        // Edit the book's details
        // Create an updated BookPrinted object with new details
        BookPrinted updatedBook = new BookPrinted("1", "Nineteen Eighty-Four", authors,
                "9780451524935", "Penguin Books", 15, 328);
        library.editItem("1", updatedBook);

        // Edit the author's details
        Author updatedAuthor = new Author("Eric Arthur Blair", "1903-06-25");
        library.editAuthor(author1, updatedAuthor);

        // Edit the patron's details
        Student updatedStudent = new Student("Alice Johnson", "456 Elm St", "555-5678");
        library.editMember(student, updatedStudent);

        // Display updated details
        System.out.println("\nUpdated Book Title: " + printedBook.getTitle());
        System.out.println("Updated Book Publisher: " + printedBook.getPublisher());
        System.out.println("Updated Author Name: " + author1.getName());
        System.out.println("Updated Patron Name: " + student.getName());
        System.out.println("Updated Patron Address: " + student.getAddress());
    }
}



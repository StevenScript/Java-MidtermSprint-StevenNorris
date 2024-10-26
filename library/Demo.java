package library;

import java.util.ArrayList;
import java.util.List;

import library.items.*;
import library.models.Author;
import library.members.Student;

/**
 * Main class to demonstrate the functionality of the Library Management System.
 * This combines test cases for creating authors, books, members, borrowing/returning items,
 * and editing the details of library items, authors, and members.
 */
public class Demo {
    public static void main(String[] args) {
        
        // Create a library instance
        Library library = new Library();

        // === First Test Case ===
        // Create an author, add it to the library
        Author author1 = new Author("Mark Z. Danielewski", "1966-03-05");
        library.addAuthor(author1);

        // Create and add a book with its author
        List<Author> authors1 = new ArrayList<>();
        authors1.add(author1);

        // Create a book with authors and number of copies
        BookPrinted book1 = new BookPrinted("1", "House of Leaves", authors1, "9780375703768", "Pantheon Books", 10, 709);

        library.addItem(book1);

        // Create and add a student member
        Student student1 = new Student("Mia Demoe", "111 Yes Drive", "7094278343");
        library.addMember(student1);

        // Show starting book amount
        System.out.println("Total number of copies (House of Leaves): " + book1.getNumberOfCopies());

        // Borrow the book
        library.borrowItem(student1, book1, 1);

        // Check number of copies after borrowing
        System.out.println("Number of copies after borrowing (House of Leaves): " + book1.getNumberOfCopies());

        // Return the book
        library.returnItem(student1, book1, 1);

        // Check number of copies after returning
        System.out.println("Number of copies after returning (House of Leaves): " + book1.getNumberOfCopies());

        System.out.println("Authors in the library:");
        for (Author a : library.getAuthors()) {
            System.out.println("- " + a.getName());
        }

        System.out.println("Items in the library:");
        for (var item : library.getItems()) {
            System.out.println("- " + item.getTitle());
        }

        System.out.println("Members of this library:");
        for (var member : library.getMembers()) {
            System.out.println("- " + member.getName());
        }

        // === Second Test Case ===
        // Create another author, add it to the library
        Author author2 = new Author("George Orwell", "1903-06-25");
        library.addAuthor(author2);

        // Create a list of authors for the second book
        List<Author> authors2 = new ArrayList<>();
        authors2.add(author2);

        // Create a printed book using BookPrinted
        BookPrinted printedBook = new BookPrinted("2", "1984", authors2,
                "9780451524935", "Secker & Warburg", 10, 328);
        library.addItem(printedBook);

        // Create another student member
        Student student2 = new Student("Alice Smith", "123 Main St", "555-1234");
        library.addMember(student2);

        // Display initial details for the second test case
        System.out.println("\nInitial Book Title: " + printedBook.getTitle());
        System.out.println("Initial Book Publisher: " + printedBook.getPublisher());
        System.out.println("Initial Author Name: " + author2.getName());
        System.out.println("Initial Member Name: " + student2.getName());
        System.out.println("Initial Member Address: " + student2.getAddress());

        // Edit the printed book's details
        BookPrinted updatedBook = new BookPrinted("2", "Nineteen Eighty-Four", authors2,
                "9780451524935", "Penguin Books", 15, 328);
        library.editItem("2", updatedBook);

        // Edit the author's details
        Author updatedAuthor = new Author("Eric Arthur Blair", "1903-06-25");
        library.editAuthor(author2, updatedAuthor);

        // Edit the member's details
        Student updatedStudent = new Student("Alice Johnson", "456 Elm St", "555-5678");
        library.editMember(student2, updatedStudent);

        // Display updated details
        System.out.println("\nUpdated Book Title: " + printedBook.getTitle());
        System.out.println("Updated Book Publisher: " + printedBook.getPublisher());
        System.out.println("Updated Author Name: " + author2.getName());
        System.out.println("Updated Member Name: " + student2.getName());
        System.out.println("Updated Member Address: " + student2.getAddress());
    }
}



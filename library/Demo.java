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
        // Create authors, add them to the library
        Author author1 = new Author("Mark Z. Danielewski", "1966-03-05");
        Author author2 = new Author("George Orwell", "1903-06-25");
        Author author3 = new Author("Aldous Huxley", "1894-07-26");
        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);

        // Create and add a book with its author
        List<Author> authors1 = new ArrayList<>();
        authors1.add(author1);
        List<Author> authors2 = new ArrayList<>();
        authors2.add(author2);
        List<Author> authors3 = new ArrayList<>();
        authors3.add(author3);

        // Create a book with authors and number of copies
        BookPrinted book1 = new BookPrinted("1", "House of Leaves", authors1, "9780375703768", "Pantheon Books", 10, 709);
        BookPrinted book2 = new BookPrinted("2", "1984", authors2, "9780451524935", "Secker & Warburg", 10, 328);
        BookPrinted book3 = new BookPrinted("3", "Brave New World", authors3, "9780060850524", "Chatto & Windus", 8, 311);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);

        // Create and add a student member
        Student student1 = new Student("Mia Demoe", "111 Yes Drive", "7094278343");
        Student student2 = new Student("Adam Apple", "123 Main St", "709-466-1234");
        library.addMember(student1);
        library.addMember(student2);

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

        //  Output the current authors in the library
        System.out.println("Authors in the library:");
        for (Author a : library.getAuthors()) {
            System.out.println("- " + a.getName());
        }

        // Output the items in the library
        System.out.println("Items in the library:");
        for (var item : library.getItems()) {
            System.out.println("- " + item.getTitle());
        }

        // Output the members of the library
        System.out.println("Members of this library:");
        for (var member : library.getMembers()) {
            System.out.println("- " + member.getName());
        }

        // === Testing Editing Details ===
        // Edit the printed book's details
        BookPrinted updatedBook2 = new BookPrinted("2", "Nineteen Eighty-Four", authors2,
                "9780451524935", "Penguin Books", 15, 328);
        library.editItem("2", updatedBook2);

        // Edit the author's details
        Author updatedAuthor2 = new Author("Eric Arthur Blair", "1903-06-25");
        library.editAuthor(author2, updatedAuthor2);

        // Edit the member's details
        Student updatedStudent2 = new Student("Alice Johnson", "456 Elm St", "555-5678");
        library.editMember(student2, updatedStudent2);

        // Display updated details
        System.out.println("\nUpdated Book Title: " + book2.getTitle());
        System.out.println("Updated Book Publisher: " + book2.getPublisher());
        System.out.println("Updated Author Name: " + author2.getName());
        System.out.println("Updated Member Name: " + student2.getName());
        System.out.println("Updated Member Address: " + student2.getAddress());

        // === Testing Searching ===
        // Search for items by title
        System.out.println("\nSearch results for title 'House of Leaves':");
        List<LibraryItem> titleResults = library.searchItemsByTitle("House of Leaves");
        for (LibraryItem item : titleResults) {
            System.out.println("- " + item.getTitle() + " by " + item.getAuthors().get(0).getName());
        }

        // Search for items by author
        System.out.println("\nSearch results for author 'Aldous Huxley':");
        List<LibraryItem> authorResults = library.searchItemsByAuthor("Aldous Huxley");
        for (LibraryItem item : authorResults) {
            System.out.println("- " + item.getTitle() + " by " + item.getAuthors().get(0).getName());
        }

        // Search for item by ISBN
        System.out.println("\nSearch result for ISBN '9780451524935':");
        LibraryItem isbnResult = library.searchItemByISBN("9780451524935");
        if (isbnResult != null) {
            System.out.println("- " + isbnResult.getTitle() + " by " + isbnResult.getAuthors().get(0).getName());
        } else {
            System.out.println("No item found with the given ISBN.");
        }
    }
}



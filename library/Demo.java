package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import library.items.*;
import library.models.Author;
import library.members.Student;
import library.members.Member;

/**
 * Main class to demonstrate the functionality of the Library Management System.
 * This combines test cases for creating authors, books, periodicals, members,
 * borrowing/returning items, and editing the details of library items, authors, and members.
 */
public class Demo {
    public static void main(String[] args) {
        
        // Create a library instance
        Library library = new Library();

        // Load data into the library
        loadData(library);

        // Retrieve the items, authors, and members for testing
        List<LibraryItem> items = library.getItems();
        List<Author> authors = library.getAuthors();
        List<Member> members = library.getMembers();

        // For testing, we'll use specific items and members
        BookPrinted printedBook = (BookPrinted) items.get(0); // House of Leaves
        BookElectronic electronicBook = (BookElectronic) items.get(1); // Digital Fortress
        BookAudio audioBook = (BookAudio) items.get(2); // The Hobbit (Audio)
        PeriodicalPrinted printedPeriodical = (PeriodicalPrinted) items.get(3); // National Geographic
        PeriodicalElectronic electronicPeriodical = (PeriodicalElectronic) items.get(4); // Science Daily
        Student student1 = (Student) members.get(0); // Mia Demoe
        Student student2 = (Student) members.get(1); // Adam Apple

        // Show starting book amount for printed items
        System.out.println("Total number of copies (House of Leaves): " + printedBook.getNumberOfCopies());
        System.out.println("Total number of copies (National Geographic): " + printedPeriodical.getNumberOfCopies());

        // === Borrow/Return Test ===
        System.out.println("\n--- Borrow/Return Test ---");
        // Borrow 3 copies of "House of Leaves"
        library.borrowItem(student1, printedBook, 3);

        // Borrow an electronic book (unlimited copies)
        library.borrowItem(student1, electronicBook, 1);

        // Borrow an audio book (unlimited copies)
        library.borrowItem(student2, audioBook, 1);

        // Borrow 2 copies of a printed periodical
        library.borrowItem(student2, printedPeriodical, 2);

        // Borrow an electronic periodical (unlimited copies)
        library.borrowItem(student1, electronicPeriodical, 1);

        // Display borrowed items
        System.out.println("\nBorrowed items by " + student1.getName() + ":");
        for (Map.Entry<LibraryItem, Integer> entry : student1.getBorrowedItems().entrySet()) {
            LibraryItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + item.getTitle() + ": " + quantity + " copies");
        }

        System.out.println("\nBorrowed items by " + student2.getName() + ":");
        for (Map.Entry<LibraryItem, Integer> entry : student2.getBorrowedItems().entrySet()) {
            LibraryItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + item.getTitle() + ": " + quantity + " copies");
        }

        // Try to borrow more copies than available
        System.out.println("\nAttempting to borrow 8 more copies of 'House of Leaves':");
        library.borrowItem(student1, printedBook, 8);

        // Return 2 copies of "House of Leaves"
        System.out.println("\nReturning 2 copies of 'House of Leaves':");
        library.returnItem(student1, printedBook, 2);

        // Display borrowed items after returning
        System.out.println("\nBorrowed items by " + student1.getName() + " after returning:");
        for (Map.Entry<LibraryItem, Integer> entry : student1.getBorrowedItems().entrySet()) {
            LibraryItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + item.getTitle() + ": " + quantity + " copies");
        }

        // Check number of copies after borrowing
        System.out.println("\nNumber of copies after borrowing (House of Leaves): " + printedBook.getNumberOfCopies());
        System.out.println("Number of copies after borrowing (National Geographic): " + printedPeriodical.getNumberOfCopies());

        // Return the remaining copy
        library.returnItem(student1, printedBook, 1);

        // Check number of copies after returning
        System.out.println("Number of copies after returning (House of Leaves): " + printedBook.getNumberOfCopies());

        // === Testing Editing Details ===
        // Edit the electronic book's details
        BookElectronic updatedBookElectronic = new BookElectronic("2", "Digital Fortress (Updated Edition)", electronicBook.getAuthors(),
                "9780312944926", "St. Martin's Press", 5.0, "EPUB", 384);
        library.editItem("2", updatedBookElectronic);

        // Edit the audio book's details
        BookAudio updatedBookAudio = new BookAudio("3", "The Hobbit (Unabridged)", audioBook.getAuthors(),
                "9780618968633", "HarperCollins", 10.5, "Andy Serkis");
        library.editItem("3", updatedBookAudio);

        // Display updated details
        System.out.println("\nUpdated Electronic Book Title: " + electronicBook.getTitle());
        System.out.println("Updated Electronic Book File Size: " + electronicBook.getFileSize() + " MB");
        System.out.println("Updated Audio Book Title: " + audioBook.getTitle());
        System.out.println("Updated Audio Book Narrator: " + audioBook.getNarrator());

        // === Testing Searching ===
        // Search for items by title
        System.out.println("\nSearch results for title 'The Hobbit (Unabridged)':");
        List<LibraryItem> titleResults = library.searchItemsByTitle("The Hobbit (Unabridged)");
        for (LibraryItem item : titleResults) {
            System.out.println("- " + item.getTitle() + " by " + item.getAuthors().get(0).getName());
        }

        // Search for items by author
        System.out.println("\nSearch results for author 'Dan Brown':");
        List<LibraryItem> authorResults = library.searchItemsByAuthor("Dan Brown");
        for (LibraryItem item : authorResults) {
            System.out.println("- " + item.getTitle() + " by " + item.getAuthors().get(0).getName());
        }

        // Search for item by ISBN
        System.out.println("\nSearch result for ISBN '9781426217786':");
        LibraryItem isbnResult = library.searchItemByISBN("9781426217786");
        if (isbnResult != null) {
            System.out.println("- " + isbnResult.getTitle() + " by " + isbnResult.getAuthors().get(0).getName());
        } else {
            System.out.println("No item found with the given ISBN.");
        }
    }

    // Method to load data into the library
    private static void loadData(Library library) {
        // Create authors
        Author author1 = new Author("Mark Z. Danielewski", "1966-03-05");
        Author author2 = new Author("Dan Brown", "1964-06-22");
        Author author3 = new Author("J.R.R. Tolkien", "1892-01-03");
        Author author4 = new Author("National Geographic Society", "1888-01-13");
        Author author5 = new Author("Science Daily", "1995-01-01");

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
        library.addAuthor(author4);
        library.addAuthor(author5);

        // Create books and periodicals
        List<Author> authors1 = new ArrayList<>();
        authors1.add(author1);

        List<Author> authors2 = new ArrayList<>();
        authors2.add(author2);

        List<Author> authors3 = new ArrayList<>();
        authors3.add(author3);

        List<Author> authors4 = new ArrayList<>();
        authors4.add(author4);

        List<Author> authors5 = new ArrayList<>();
        authors5.add(author5);

        // BookPrinted
        BookPrinted bookPrinted = new BookPrinted("1", "House of Leaves", authors1, "9780375703768", "Pantheon Books", 10, 709);

        // BookElectronic
        BookElectronic bookElectronic = new BookElectronic("2", "Digital Fortress", authors2, "9780312944926", "St. Martin's Press", 4.5, "PDF", 384);

        // BookAudio
        BookAudio bookAudio = new BookAudio("3", "The Hobbit", authors3, "9780618968633", "HarperCollins", 10.0, "Rob Inglis");

        // PrintedPeriodical
        PeriodicalPrinted printedPeriodical = new PeriodicalPrinted("4", "National Geographic", authors4, "9781426217786", "National Geographic Partners", 20, 100);

        // ElectronicPeriodical
        PeriodicalElectronic electronicPeriodical = new PeriodicalElectronic("5", "Science Daily", authors5, "N/A", "ScienceDaily LLC", 2.0, "HTML", 0);

        // Adding items to the library
        library.addItem(bookPrinted);
        library.addItem(bookElectronic);
        library.addItem(bookAudio);
        library.addItem(printedPeriodical);
        library.addItem(electronicPeriodical);

        // Create students (members)
        Student student1 = new Student("Mia Demoe", "111 Yes Drive", "709-427-8343");
        Student student2 = new Student("Adam Apple", "123 Main St", "709-466-1234");
        Student student3 = new Student("Jane Doe", "456 Elm St", "709-555-6789");
        Student student4 = new Student("John Smith", "789 Oak St", "709-555-9876");

        library.addMember(student1);
        library.addMember(student2);
        library.addMember(student3);
        library.addMember(student4);
    }
}

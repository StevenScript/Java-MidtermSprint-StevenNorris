package library;

import library.items.*;
import library.models.Author;
import library.members.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class to run the Library Management System.
 */
public class Test {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library();

        // Create authors
        Author author1 = new Author("George Orwell", "1903-06-25");
        library.addAuthor(author1);

        // Create printed book
       BookPrinted printedBook = new BookPrinted("1", "1984", Arrays.asList(author1), "9780451524935", "Secker & Warburg", 10, 328);
        library.addItem(printedBook);

        // Create electronic book
        BookElectronic electronicBook = new BookElectronic("2", "Animal Farm", Arrays.asList(author1), "9780451526342", "Secker & Warburg", 2.5, "EPUB", 112);
        library.addItem(electronicBook);

        // Create audio book
        BookAudio audioBook = new BookAudio("3", "Homage to Catalonia", Arrays.asList(author1), "9780156421171", "Secker & Warburg", 7.5, "John Smith");
        library.addItem(audioBook);

        // Create printed periodical
        PeriodicalPrinted printedPeriodical = new PeriodicalPrinted("4", "Time Magazine", null, "N/A", "Time Inc.", 20, 50);
        library.addItem(printedPeriodical);

        // Create electronic periodical
        PeriodicalElectronic electronicPeriodical = new PeriodicalElectronic("5", "Nature", null, "N/A", "Nature Publishing Group", 15.0, "PDF", 40);
        library.addItem(electronicPeriodical);

        // Create a student member
        Student student = new Student("Mia Demoe", "111 Yes Drive");
        library.addMember(student);

        // Borrow 2 copies of the printed book
        library.borrowItem(student, printedBook, 2);

        // Borrow the electronic book
        library.borrowItem(student, electronicBook, 1);

        // Borrow the audio book
        library.borrowItem(student, audioBook, 1);

        // Display borrowed items
        System.out.println("\nAlice's borrowed items:");
        for (LibraryItem item : student.getBorrowedItems()) {
            System.out.println("- " + item.getTitle());
        }

        // Check number of copies for printed book
        System.out.println("\nNumber of copies of '1984' after borrowing: " + printedBook.getNumberOfCopies());

        // Return 1 copy of the printed book
        library.returnItem(student, printedBook, 1);

        // Return the electronic book
        library.returnItem(student, electronicBook, 1);

        // Check number of copies after returning
        System.out.println("\nNumber of copies of '1984' after returning: " + printedBook.getNumberOfCopies());

        // Display borrowed items after returning
        System.out.println("\nAlice's borrowed items after returning:");
        for (LibraryItem item : student.getBorrowedItems()) {
            System.out.println("- " + item.getTitle());
        }
    }
}

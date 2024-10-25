package library.items;
import library.models.Author;
import java.util.List;

public class BookAudio extends BookMaster {
    private double runtime; // in hours
    private String narrator;

    public BookAudio(String id, String title, List<Author> authors, String isbn, String publisher, double runtime, String narrator) {
        super(id, title, authors, isbn, publisher);
        this.runtime = runtime;
        this.narrator = narrator;
    }

    // Getters
    public double getRuntime() {
        return runtime;
    }

    public String getNarrator() {
        return narrator;
    }
}

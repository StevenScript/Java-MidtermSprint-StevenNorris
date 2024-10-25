package library.items;
import library.models.Author;
import java.util.List;

public class BookElectronic extends BookMaster {

    private double fileSize; // in MB
    private String fileFormat; // e.g., "PDF", "EPUB"
    private int numberOfPages;

    public BookElectronic(String id, String title, List<Author> authors, String isbn, String publisher, double fileSize, String fileFormat, int numberOfPages) {
        super(id, title, authors, isbn, publisher);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
        this.numberOfPages = numberOfPages;
    }

    // Getters
    public double getFileSize() {
        return fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
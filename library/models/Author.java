package library.models;

/**
 * Author data in our database.
 */
public class Author {
    private String name;
    private String dateOfBirth;

    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}

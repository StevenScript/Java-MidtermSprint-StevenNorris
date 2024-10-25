package library.models;


/**
 * This class represents an author in the library system.
 * Each author has a name and a date of birth.
 */
public class Author {
    // The name of the author
    private String name;
    
    // The date of birth of the author, stored as a String
    private String dateOfBirth;

    /**
     * Constructor to initialize the Author object with a name and date of birth
     * 
     * @param name The name of the author.
     * @param dateOfBirth The date of birth of the author (format "YYYY-MM-DD")
     */
    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;         
    }

    /**
     * Returns the name of the author.
     * 
     * @return String - author's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the date of birth of the author.
     * 
     * @return String - author's date of birth in "YYYY-MM-DD"
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
}

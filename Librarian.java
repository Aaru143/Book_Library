/**
 * this class models a librarian
 */
public class Librarian {
  // instance fields

  // librarian's username
  private String username;

  // librarian password to have access to this application
  private String password;



  /**
   * Class constructor for Librarian.java
   * 
   * @param username - the username of the librarian, password - the password of the librarian
   *                 account
   * @return void
   */
  public Librarian(String username, String password) {
    // assigns the username
    this.username = username;
    // assigns the password
    this.password = password;
  }



  /**
   * Checks if the password entered is the correct password
   * 
   * @param password - password entered
   * @return boolean - true if the password is correct, false otherwise
   */
  public boolean checkPassword(String password) {
    // returns true if the password is correct
    return this.password.equals(password);
  }



  /**
   * Returns the username of the librarian
   * 
   * @param
   * @return String username of the librarian
   */
  public String getUsername() {
    // returns the username of the librarian
    return this.username;
  }
}

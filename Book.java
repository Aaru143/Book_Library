/**
 * this class models a book
 */
public class Book {

  // class variable that represents the identifier of the next book
  private static int nextId = 1;

  // unique identifier of this book.
  // Every instance of Book has a unique identifier of type int. These identifiers are incremented
  // with the order of creation of a new Book. For instance, the first created book has 1 as ID, the
  // second created book has 2 as ID, the third created book has 3 as ID, and so on.
  private final int ID;

  // name of the author of this book
  private String author;

  // title of this book
  private String title;

  // card bar code of the borrower of this book
  // When borrowerCardBarCode == null, the book is available
  private Integer borrowerCardBarCode;



  /**
   * Class constructor for Book.java
   * 
   * @param title - title of the book, author - author of the book
   * @return void
   */
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    // assigns the book with its unique ID
    this.ID = nextId;
    // increments the ID for its assignment to the next book
    nextId++;
    // sets the bar code to null initially as the book is available for checkout
    this.borrowerCardBarCode = null;
  }



  /**
   * Returns the author of the book
   * 
   * @param
   * @return String
   */
  public String getAuthor() {
    return this.author;
  }



  /**
   * Returns the unique ID of the book
   * 
   * @param
   * @return int
   */
  public int getID() {
    return this.ID;
  }



  /**
   * Returns the unique bar code of the subscriber who borrowed the book
   * 
   * @param
   * @return Integer
   */
  public Integer getBorrowerCardBarCode() {
    return this.borrowerCardBarCode;
  }



  /**
   * Sets the borrowerCardBarCode to the card bar code of the subscriber
   * 
   * @param borrowerCardBarCode - the card bar code of the subscriber
   * @return void
   */
  public void borrowBook(Integer borrowerCardBarCode) {
    this.borrowerCardBarCode = borrowerCardBarCode;
  }



  /**
   * Sets the borrowerCardBarCode to null
   * 
   * @param
   * @return void
   */
  public void returnBook() {
    // sets the bar code to null as the book is now available for checkout
    this.borrowerCardBarCode = null;
  }



  /**
   * Returns the title of the book
   * 
   * @param
   * @return String
   */
  public String getTitle() {
    return this.title;
  }



  /**
   * Checks if the book is available for checkout
   * 
   * @param
   * @return void
   */
  public boolean isAvailable() {
    // checks if the bar code is null, hence the book is available for checkout
    if (this.borrowerCardBarCode == null) {
      return true;
    }
    // returns false if the book is not available for checkout
    return false;
  }

}


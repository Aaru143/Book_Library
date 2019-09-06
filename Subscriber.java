import java.util.ArrayList;

/**
 * this class models a subscriber. Each subscriber is issued a library card and has a PIN to access
 * the library services. for the library card we define an instance field of type integer called
 * <CAR_BAR_CODE> that represent's the subscriber's library card's bar code the bar code is a ten
 * digit number which is incremented with creation of each subscriber.
 */
public class Subscriber {

  // static fields

  // subscriber cannot check out a book that is not available
  // maximum number of books to be checked out one subscriber, a subscriber cannot check out more
  // books than this
  private final static int MAX_BOOKS_CHECKED_OUT = 10;

  // class variable that represents the card bar code of the next subscriber to be created
  private static int nextCardBarCode = 2019000001;

  // Instance fields

  // 4-digits Personal Identification Number to verify the identity of this subscriber
  private int pin;

  // card bar code of this subscriber
  private final Integer CARD_BAR_CODE;

  // name of this subscriber
  private String name;

  // address of this subscriber
  private String address;

  // phone number of this subscriber
  private String phoneNumber;


  // list of books checked out by this subscriber and not yet returned. A subscriber can have at
  // most 10 checked out books
  private ArrayList<Book> booksCheckedOut;

  // list of the books returned by this subscriber
  private ArrayList<Book> booksReturned;



  /**
   * Class constructor for Subscriber.java
   * 
   * @param name, pin, address, phoneNumber - the specific details of the subscriber
   * @return void
   */
  public Subscriber(String name, int pin, String address, String phoneNumber) {
    this.booksCheckedOut = new ArrayList<Book>();
    this.booksReturned = new ArrayList<Book>();
    this.name = name;
    this.pin = pin;
    this.address = address;
    this.phoneNumber = phoneNumber;
    // assigns the unique bar code to each subscriber
    this.CARD_BAR_CODE = nextCardBarCode;
    // increments the bar code to be assigns to the next subscriber
    nextCardBarCode++;
  }



  /**
   * Checks out an available book. The checkout operation fails if the maximum number of checked out
   * books by this subscriber is already reached
   * 
   * @param book - reference to the book to be checked out by the subscriber
   * @return void
   */
  public void checkoutBook(Book book) {
    // checks if the list storing the books checked out by the subscriber has reached its limit i.e
    // 10
    if ((this.booksCheckedOut.size() == MAX_BOOKS_CHECKED_OUT)) {
      // if the maximum number of books is checked out by the subscriber then prints the error
      // message
      System.out.println(
          "Checkout Failed: You cannot check out more than " + MAX_BOOKS_CHECKED_OUT + " books.");
      // checks if the subscriber has already checked out a book
    } else if (isBookInBooksCheckedOut(book)) {
      // prints out the message saying that book has already been checked out
      System.out.println("You have already checked out " + book.getTitle() + " book.");
      // checks if the book is available for checkout
    } else if (!book.isAvailable()) {
      // if the book is not available prints out the error message
      System.out.println("Sorry, " + book.getTitle() + " is not available.");
    } else {
      // if the book is available, adds the book to the list of checked out books
      this.booksCheckedOut.add(book);
      // calls the borrowBook method to assign the bar code of the subscriber to the book
      book.borrowBook(this.CARD_BAR_CODE);
    }
  }



  /**
   * Returns a library book
   * 
   * @param book - reference to the book to be returned by the subscriber
   * @return void
   */
  public void returnBook(Book book) {
    //a book is returned only if its checked out
    if(booksCheckedOut.contains(book)) {
    // adds the book to the list of books returned by the subscriber
    this.booksReturned.add(book);
    // calls the returnBook method to set the bar code of the book to null, and hence make it
    // available again
    book.returnBook();
    // removes the book from the list of checked out books
    this.booksCheckedOut.remove(book);
    }
    System.out.println("Sorry! This book is not checked out by you.");
  }



  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksCheckedOut(Book book) {
    // checks if the list of checked out books contains the checked out book
    return booksCheckedOut.contains(book);
  }



  /**
   * Checks if this subscriber booksReturned list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksReturned list
   * @return true if booksReturned contains book, false otherwise
   */
  public boolean isBookInBooksReturned(Book book) {
    // checks if the list of returned books contains the returned book
    return booksReturned.contains(book);
  }



  /**
   * Displays the list of the books checked out and not yet returned
   * 
   * @param
   * @return void
   */
  public void displayBooksCheckedOut() {
    if (booksCheckedOut.isEmpty()) // empty list
      // if the list is empty prints the message
      System.out.println("No books checked out by this subscriber");
    else
      // Traverse the list of books checked out by this subscriber and display its content
      for (int i = 0; i < booksCheckedOut.size(); i++) {
        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
      }
  }



  /**
   * Displays the history of the returned books by this subscriber
   * 
   * @param
   * @return void
   */
  public void displayHistoryBooksReturned() {
    if (booksReturned.isEmpty()) // empty list
      System.out.println("No books returned by this subscriber");
    else
      // Traverse the list of borrowed books already returned by this subscriber and display its
      // content
      for (int i = 0; i < booksReturned.size(); i++) {
        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
        System.out.println("Author: " + booksReturned.get(i).getAuthor());
      }
  }



  /**
   * Displays this subscriber's personal information
   * 
   * @param
   * @return void
   */
  public void displayPersonalInfo() {
    // displays the personal info of the subscriber in the specified format
    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
    System.out.println("  Name: " + name);
    System.out.println("  Address: " + address);
    System.out.println("  Phone number: " + phoneNumber);
  }



  /**
   * Returns the address of the subscriber
   * 
   * @param
   * @return String - the address of subscriber
   */
  public String getAddress() {
    return this.address;
  }



  /**
   * Returns the name of the subscriber
   * 
   * @param
   * @return String - the name of subscriber
   */
  public String getName() {
    return this.name;
  }



  /**
   * Returns the card bar code of the subscriber
   * 
   * @param
   * @return Integer - the card bar code of subscriber
   */
  public Integer getCARD_BAR_CODE() {
    return this.CARD_BAR_CODE;
  }



  /**
   * Returns the pin of the subscriber
   * 
   * @param
   * @return int - the pin of subscriber
   */
  public int getPin() {
    return this.pin;
  }



  /**
   * Returns the phone number of the subscriber
   * 
   * @param
   * @return String - the phoneNumber of subscriber
   */
  public String getPhoneNUmber() {
    return this.phoneNumber;
  }



  /**
   * Sets the phone number of the subscriber
   * 
   * @param phoneNumber - phoneNumber of the subscriber
   * @return void
   */
  public void setPhoneNUmber(String phoneNumber) {
    // sets the phone number of the subscriber
    this.phoneNumber = phoneNumber;
  }



  /**
   * Sets the address of the subscriber
   * 
   * @param Address - the address of subscriber
   * @return void
   */
  public void setAddress(String Address) {
    // sets the address of the subscriber
    this.address = Address;
  }
}

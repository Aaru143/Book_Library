import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class models the library
 */
public class Library {
  // instance fields

  // Street address of this library
  private String address;

  // library's librarian. Each library can have one librarian
  private Librarian librarian;

  // list of all the books in the library
  private ArrayList<Book> books;

  // list of this library's subscribers
  private ArrayList<Subscriber> subscribers;



  /**
   * Class constructor for Library.java
   * 
   * @param address - this library's address, librarianUsername - the username for the librarian,
   *                librarianLogin - the password for the librarian's account
   * @return void
   */
  public Library(String address, String librarianUsername, String librarianLogin) {
    // creates a new Array list to store the books available in the library
    this.books = new ArrayList<Book>();
    // creates a new Array List containing all the Subscribers
    this.subscribers = new ArrayList<Subscriber>();
    // creates a new librarian with the username and password
    this.librarian = new Librarian(librarianUsername, librarianLogin);
    // assigns the address of the library
    this.address = address;
  }



  /**
   * Returns the librarian of the library
   * 
   * @param
   * @return Librarian - the librarian of the library
   */
  public Librarian getLibrarian() {
    // returns the librarian
    return this.librarian;
  }



  /**
   * Returns the address of the library
   * 
   * @param
   * @return String address of the library
   */
  public String getAddress() {
    // returns the address of the library
    return this.address;
  }



  /**
   * Returns a Book given the unique Book ID, if found. If not found then returns null and displays
   * the message : "Error: this book identifier didn't match any of // our books identifiers."
   * 
   * @param bookId - ID of the book to be searched
   * @return Book reference to the book corresponding to bookId
   */
  public Book findBook(int bookId) {
    // iterates through the array list containing all the available books in the library
    for (int i = 0; i < this.books.size(); i++) {
      // checks if the ID of the book matches the required book's ID
      if (this.books.get(i).getID() == bookId) {
        // returns the reference to the required book if found
        return this.books.get(i);
      }
    }
    // returns null if book not found and displays the message
    System.out.println("Error: this book identifier didn't match any of our books identifiers");
    return null;
  }



  /**
   * Finds the books by title and returns an array list containing the reference to matched books.
   * It is case insensitive.
   * 
   * @param title - title of the book to be searched
   * @return bookList - list of found books
   */
  public ArrayList<Book> findBookByTitle(String title) {
    // a boolean variable to see if the book is found
    boolean bookFound = false;
    // creates a new list to store the matched books
    ArrayList<Book> bookList = new ArrayList<Book>();
    // iterates through the array list containing all the available books in the library
    for (int i = 0; i < books.size(); i++) {
      // checks if the title of the book matches the required book's title
      if ((this.books.get(i).getTitle().toLowerCase()).equals(title.toLowerCase())) {
        // adds the book to the bookList if the title matches
        bookList.add(this.books.get(i));
        // sets bookFound to true if the book is found
        bookFound = true;
      }
    }
    // returns the list containing the matched books and prints the message
    for (int i = 0; i < bookList.size(); i++) {
      System.out.println("<Book ID>: " + bookList.get(i).getID() + " <Title>: "
          + bookList.get(i).getTitle() + " <Author>: " + bookList.get(i).getAuthor()
          + " <Is Available>: " + bookList.get(i).isAvailable());
    }
    if (bookFound == true)
      return bookList;
    else
      // returns null and prints error message if bookFound is false - book is not found with the
      // given title
      System.out.println("Error: Book with title " + title + " not found.");
    return null;
  }



  /**
   * Finds the books by author and returns an array list containing the reference to matched books.
   * It is case insensitive.
   * 
   * @param auhtor - author of the book to be searched
   * @return bookList - list of found books
   */
  public ArrayList<Book> findBookByAuthor(String author) {
    // a boolean variable to see if the book is found
    boolean bookFound = false;
    // creates a new list to store the matched books
    ArrayList<Book> bookList = new ArrayList<Book>();
    // iterates through the array list containing all the available books in the library
    for (int i = 0; i < books.size(); i++) {
      // checks if the author of the book matches the required book's author
      if ((this.books.get(i).getAuthor().toLowerCase()).equals(author.toLowerCase())) {
        // adds the book to the bookList if the author matches
        bookList.add(this.books.get(i));
        // sets bookFound to true if the book is found
        bookFound = true;
      }
    }
    // returns the list containing the matched books and prints the message
    for (int i = 0; i < bookList.size(); i++) {
      System.out.println("<Book ID>: " + bookList.get(i).getID() + " <Title>: "
          + bookList.get(i).getTitle() + " <Author>: " + bookList.get(i).getAuthor()
          + " <Is Available>: " + bookList.get(i).isAvailable());
    }
    if (bookFound == true)
      return bookList;
    else
      // returns null and prints error message if bookFound is false - book is not found with the
      // given author
      System.out.println("Error: Book with author " + author + " not found.");
    return null;
  }



  /**
   * Adds the book with specified title and author to the library
   * 
   * @param title - title of the book, author - author of the book
   * @return void
   */
  public void addBook(String title, String author) {
    // creates a new book with the specified title and author
    Book bookToBeAdded = new Book(title, author);
    // adds the newly created book to the list of books in the library
    this.books.add(bookToBeAdded);
    if (books.contains(bookToBeAdded)) {
      // prints the message indicating that the book is added
      System.out.println("Book with Title " + title + " is successfully added to the library.");
    }
  }



  /**
   * Removes the book with specified ID from the library
   * 
   * @param bookId- bookId of the book to be removed
   * @return Book - reference to the removed book
   */
  public Book removeBook(int bookId) {
    // iterates through the array list containing all the available books in the library
    for (int i = 0; i < books.size(); i++) {
      // checks if the ID of the book matches the required book's ID
      if (books.get(i).getID() == bookId) {
        Book bookToBeReturned = books.get(i);
        // removes the book from the list
        books.remove(i);
        // returns the reference to the removed book
        return bookToBeReturned;

      }
    }
    // returns null if the book not found
    return null;
  }



  /**
   * Adds the subscriber to the list of Subscribers of the library
   * 
   * @param name-name of the subscriber, pin- pin of the subscriber, address-address of the
   *        subscriber, phoneNumber-phone number of the subscriber
   * @return void
   */
  public void addSubscriber(String name, int pin, String address, String phoneNumber) {
    // creates a new subscriber with the specifies name, pin, address, and phoneNumber
    Subscriber newSub = new Subscriber(name, pin, address, phoneNumber);
    // adds the new subscriber to the list
    subscribers.add(newSub);
    // displays the message to indicate that the new subscriber has been added.
    if (subscribers.contains(newSub)) {
      System.out.println("Library card with bar code " + newSub.getCARD_BAR_CODE()
          + " is successfully issued to the new subscriber " + newSub.getName() + ".");
    }
  }



  /**
   * Displays a list of books
   * 
   * @param books ArrayList of books
   * @return void
   */
  public static void displayBooks(ArrayList<Book> books) {
    // Traverse the list of books and display book id, title, author, and availability of each book
    for (int i = 0; i < books.size(); i++) {
      System.out.print("<Book ID>: " + books.get(i).getID() + " ");
      System.out.print("<Title>: " + books.get(i).getTitle() + " ");
      System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
      System.out.println("<Is Available>: " + books.get(i).isAvailable());
    }
  }



  /**
   * Finds and returns the reference to a subscriber having the specified cardBarCode
   * 
   * @param cardBarCode- unique card bar code of the subscriber to be searched
   * @return Subscriber - the subscriber having the specified bar code
   */
  public Subscriber findSubscriber(int cardBarCode) {
    // iterates through the list containing the subscribers of the library
    for (int i = 0; i < subscribers.size(); i++) {
      // checks if the bar code of the subscriber matches the specified bar code
      if (subscribers.get(i).getCARD_BAR_CODE() == cardBarCode) {
        // returns the subscriber of the bar code matches
        return subscribers.get(i);
      }
    }
    // returns null and prints the error message if the subscriber not found
    System.out.println("Error: this card bar code didn't match any of our records");
    return null;
  }



  /**
   * Reads and processes the user commands with respect to the menu of this application
   * 
   * @param scanner Scanner object used to read the user command lines
   * @return void
   */
  public void readProcessUserCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    // display the library management system main menu
    displayMainMenu();
    System.out.print(promptCommandLine);
    // read user command line
    String command = scanner.nextLine();
    // split user command
    String[] commands = command.trim().split(" ");
    // '3': Exit the application
    while (commands[0].trim().charAt(0) != '3') {
      // performs different functions for different cases
      switch (commands[0].trim().charAt(0)) {
        // login as librarian commands[1]: password
        case '1':
          if (this.librarian.checkPassword(commands[1])) {
            // read and process librarian commands
            readProcessLibrarianCommand(scanner);
          } else {
            // error password
            System.out.println("Error: Password incorrect!");
          }
          break;
        // login as subscriber commands[1]: card bar code
        case '2':
          Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
          if (subscriber != null) {
            // correct PIN
            if (subscriber.getPin() == Integer.parseInt(commands[2]))
              // read and process subscriber commands
              readProcessSubscriberCommand(subscriber, scanner);
            else
              System.out.println("Error: Incorrect PIN.");
          }
          break;
      }
      // read and split next user command line
      // display the library management system main menu
      displayMainMenu();
      System.out.print(promptCommandLine);
      // read user command line
      command = scanner.nextLine();
      // split user command line
      commands = command.trim().split(" ");
    }
  }



  /**
   * Reads and processes the subscriber commands according to the subscriber menu
   * 
   * @param subscriber, scanner
   * @return void
   */
  public void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    // displays the subscriber's main menu
    displaySubscriberMenu();
    // read user command line
    System.out.print(promptCommandLine);
    String command = scanner.nextLine();
    // split user command
    String[] commands = command.trim().split(" ");
    // '9' : Exit Subscriber menu
    while (commands[0].trim().charAt(0) != '9') {
      // performs different functions for different cases
      switch (commands[0].trim().charAt(0)) {

        // "[1 <book ID>] Check out a book"
        case '1':
          subscriber.checkoutBook(findBook(Integer.parseInt(commands[1].trim())));
          break;

        // "[2 <book ID>] Return a book"
        case '2':
          subscriber.returnBook(findBook(Integer.parseInt(commands[1].trim())));
          break;

        // "[3 <title>] Search a Book by title"
        case '3':
          findBookByTitle(commands[1].trim());
          break;

        // "[4 <author>] Search a Book by author"
        case '4':
          findBookByAuthor(commands[1].trim());
          break;

        // "[5] Print list of books checked out"
        case '5':
          subscriber.displayBooksCheckedOut();
          break;

        // "[6] Print history of returned books"
        case '6':
          subscriber.displayHistoryBooksReturned();
          break;

        // "[7 <address>] Update address"
        case '7':
          subscriber.setAddress(commands[1].trim());
          break;

        // "[8 <phone number>] Update phone number"
        case '8':
          subscriber.setPhoneNUmber(commands[1].trim());
          break;
      }
      // displays the subscriber menu for the next command
      displaySubscriberMenu();
      System.out.print(promptCommandLine);
      // read user command line
      command = scanner.nextLine();
      // split user command line
      commands = command.trim().split(" ");
    }
  }



  /**
   * Reads and processes the librarian commands according to the librarian menu
   * 
   * @param scanner
   * @return void
   */
  public void readProcessLibrarianCommand(Scanner scanner) {
    final String promptCommandLine = "ENTER COMMAND: ";
    // displays the subscriber's main menu
    displayLibrarianMenu();
    // reads the user command line
    System.out.print(promptCommandLine);
    String command = scanner.nextLine();
    // splits the user command line
    String[] commands = command.trim().split(" ");
    // '9': for exiting the librarian menu
    while (commands[0].trim().charAt(0) != '9') {
      //// performs different functions for different cases
      switch (commands[0].trim().charAt(0)) {

        // "[1 <title> <author>] Add new Book"
        case '1':
          addBook(commands[1].trim(), commands[2].trim());
          break;

        // "[2 <name> <pin> <address> <phone number>] Add new subscriber"
        case '2':
          addSubscriber(commands[1].trim(), Integer.parseInt(commands[2].trim()),
              commands[3].trim(), commands[4].trim());
          break;

        // "[3 <card bar code> <book ID>] Check out a Book"
        case '3':
          Subscriber newSub1 = findSubscriber(Integer.parseInt(commands[1].trim()));
          newSub1.checkoutBook(findBook(Integer.parseInt(commands[2].trim())));
          break;

        // "[4 <card bar code> <book ID>] Return a Book for a subscriber"
        case '4':
          Subscriber newSub2 = findSubscriber(Integer.parseInt(commands[1].trim()));
          newSub2.returnBook(findBook(Integer.parseInt(commands[2].trim())));
          break;

        // "[5 <card bar code>] Display Personal Info of a Subscriber"
        case '5':
          Subscriber newSub3 = findSubscriber(Integer.parseInt(commands[1].trim()));
          newSub3.displayPersonalInfo();
          break;

        // "[6 <card bar code>] Display Books Checked out by a Subscriber"
        case '6':
          Subscriber newSub4 = findSubscriber(Integer.parseInt(commands[1].trim()));
          newSub4.displayBooksCheckedOut();
          break;

        // "[7] Display All Books"
        case '7':
          displayBooks(this.books);
          break;

        // "[8 <book ID>] Remove a Book"
        case '8':
          removeBook(Integer.parseInt(commands[1].trim()));
          break;
      }
      // displays the librarian's menu for the next command
      displayLibrarianMenu();
      System.out.print(promptCommandLine);
      // read user command line
      command = scanner.nextLine();
      // split user command line
      commands = command.trim().split(" ");
    }
  }



  /**
   * Displays the main menu for this book library application
   * 
   * @param
   * @return void
   */
  private static void displayMainMenu() {
    // displays the menu
    System.out.println("\n--------------------------------------------------------");
    System.out.println("     Welcome to our Book Library Management System");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <password>] Login as a librarian");
    System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
    System.out.println("[3] Exit"); // Exit the application
    System.out.println("--------------------------------------------------------");
  }



  /**
   * Displays the menu for a Subscriber
   * 
   * @param
   * @return void
   */
  private static void displaySubscriberMenu() {
    // prints the menu
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Subscriber's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <book ID>] Check out a book");
    System.out.println("[2 <book ID>] Return a book");
    System.out.println("[3 <title>] Search a Book by title");
    System.out.println("[4 <author>] Search a Book by author");
    System.out.println("[5] Print list of books checked out");
    System.out.println("[6] Print history of returned books");
    System.out.println("[7 <address>] Update address");
    System.out.println("[8 <phone number>] Update phone number");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }



  /**
   * Displays the menu for the Librarian
   * 
   * @param
   * @return void
   */
  private static void displayLibrarianMenu() {
    // displays the menu
    System.out.println("\n--------------------------------------------------------");
    System.out.println("    Welcome to Librarian's Space");
    System.out.println("--------------------------------------------------------");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <title> <author>] Add new Book");
    System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
    System.out.println("[3 <card bar code> <book ID>] Check out a Book");
    System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
    System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
    System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
    System.out.println("[7] Display All Books");
    System.out.println("[8 <book ID>] Remove a Book");
    System.out.println("[9] Logout");
    System.out.println("--------------------------------------------------------");
  }



  /**
   * Display the Application GoodBye and logout message.
   * 
   * @param
   * @return void
   */
  private static void displayGoodByeLogoutMessage() {
    // displays the logout message
    System.out.println("\n--------------------------------------------------------");
    System.out.println("       Thanks for Using our Book Library App!!!!");
    System.out.println("--------------------------------------------------------");
  }



  /**
   * Main method that represents the driver for this application
   * 
   * @param args
   * @return void
   */
  public static void main(String[] args) {
    // create a scanner object to read user inputs
    Scanner scanner = new Scanner(System.in);
    // create a new library object
    Library madisonLibrary = new Library("Madison, WI", "april", "abc");
    // read and process user command lines
    madisonLibrary.readProcessUserCommand(scanner);
    // display good bye message
    displayGoodByeLogoutMessage();
    // close this scanner
    scanner.close();
  }
}

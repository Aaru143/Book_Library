
public class BookLibraryTests {

  /*
  // testBookConstructorGetters() method checks whether the constructor of your Book class
  // initializes correctly the new Book instance fields: title, author, borrowerCardBarCode, ID, and
  // increments nextID static field. In particular, make sure that the different identifiers (ID
  // fields) of at least two created books are set correctly and that the book is initially
  // available. It checks also checks whether all your implemented getter methods defined within
  // your Book class work correctly.
  public static boolean testBookConstructorGetters() {
    Book Book1 = new Book("How to be strong", "Aarushi Gupta");
    Book Book2 = new Book("On My Block", "Netflix");

    String Book1Details = Book1.getTitle() + " " + Book1.getAuthor() + " " + Book1.getID() + " "
        + Book1.getBorrowerCardBarCode();

    String Book2Details = Book2.getTitle() + " " + Book2.getAuthor() + " " + Book2.getID() + " "
        + Book2.getBorrowerCardBarCode();

    Book1.borrowBook(2019000001);
    String Book1DetailsAfter = Book1.getTitle() + " " + Book1.getAuthor() + " " + Book1.getID()
        + " " + Book1.getBorrowerCardBarCode();
    System.out.println(Book1Details);
    System.out.println(Book2Details);
    System.out.println(Book1DetailsAfter);
    if (Book1Details.equals("How to be strong Aarushi Gupta 1 null")
        && Book2Details.equals("On My Block Netflix 2 null")
        && Book1DetailsAfter.equals("How to be strong Aarushi Gupta 1 2019000001")) {
      return true;
    }
      return false;
  }

  // testBookReturnBook() checks whether returnBook() method defined within your Book class sets
  // correctly the instance field borrowerCardBarCode. A Book must be available after this instance
  // method is called.
  public static boolean testBookReturnBook() {
    Book Book1 = new Book("How to be strong", "Aarushi Gupta");
    Book1.borrowBook(2019000001);
    Book1.returnBook();
    if(Book1.isAvailable()) {
      return true;
    }
    return false;
  }

  
  public static boolean testSubscriberCheckoutBook() {
    Book Book1 = new Book("How to be strong", "Aarushi Gupta");
    Book Book2 = new Book("On My Block", "Netflix");
    Book Book3 = new Book("Looney Tunes", "Cartoons");
    Book Book4 = new Book("Hello", "Aarushi Gupta");
    Book Book5 = new Book("Block", "Netflix");
    
    //creating a new subscriber and displaying its info to see if the constructor works correctly
    Subscriber newSub = new Subscriber("Aarushi",1234,"New Delhi","6088863078");
    newSub.displayPersonalInfo();
    
    //adds a new book to the checked out list
    newSub.checkoutBook(Book1); //adds the book to the checked out list
    System.out.println(Book1.getBorrowerCardBarCode()); //sets the barcode to the subscriber's barcode and hence not null
    System.out.println(newSub.isBookInBooksCheckedOut(Book1));//checks if the book is there in list hence return true
    newSub.displayBooksCheckedOut();
    
    //checks the details  after returning the book
   newSub.returnBook(Book1);
    System.out.println(Book1.getBorrowerCardBarCode());
   System.out.println(newSub.isBookInBooksReturned(Book1));
    newSub.displayHistoryBooksReturned();
    newSub.displayBooksCheckedOut();
    return false;
  } */
  
  
  public static boolean testLibraryclass() {
    //checks the constructor of the library class
    Library Madison_Library = new Library("Madison","Aarushi","password");
    
    //checks the addBook() method of the library class
    Madison_Library.addBook("Story Of My Life","Helen Keller");
    Madison_Library.addBook("Adventures Of Tin-Tin","Roald Dahl");
    Madison_Library.addBook("Mussorie","Ruskin Bond");
    Madison_Library.addBook("Stories for Children","Ruskin Bond");
    Madison_Library.addBook("Pride And Prejudice","Jane Austen");
    
    //add two books with same title
    Madison_Library.addBook("Introduction to CS","Steve Jobs"); 
    Madison_Library.addBook("Introduction to cs","Sundar Pichai");
    
    //add two different books with same author
    Madison_Library.addBook("Half Girlfriend","chetan Bhagat");
    Madison_Library.addBook("Two States","Chetan Bhagat");
   
    
    //finds the book with a specific ID
    Madison_Library.findBook(4);
    //find a book with the ID that doesn't exist
    Madison_Library.findBook(50);
    
    
    //displays the list of books by the same author and is case insensitive
    Madison_Library.findBookByAuthor("Chetan Bhagat");
    //finds a book with author that doesn't exist
    Madison_Library.findBookByAuthor("Kamla Devi");
    
    
    //displays the list of books having the same title and is case-insensitive
    Madison_Library.findBookByTitle("Introduction to cs");
    //finds a book with a title that doesn't exist
    Madison_Library.findBookByTitle("Three Men In A Boat");
    
    //remove an existing book
    Madison_Library.removeBook(4);
    //remove a non existent book. It returns null
    Madison_Library.removeBook(50);
    
    //adding a Subscriber
    Madison_Library.addSubscriber("Aarushi", 1234, "Madison", "6088863078");
    
    //finding an existing subscriber
    Madison_Library.findSubscriber(2019000001);
    //finding a non-existing subscriber
    Madison_Library.findSubscriber(2019000045);

  return false;  
  }
  
  public static void main(String agrs[]) {
    //System.out.println(testBookConstructorGetters());
    //System.out.println(testBookReturnBook()); 
    //System.out.println(testSubscriberCheckoutBook());
    testLibraryclass();
  }

}
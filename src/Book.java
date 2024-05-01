
 class Book {

    // Populating arrays with book data to be used later
     static String[] titles = {
             "American Prometheus","The Guns of August","Orientalism","1776","An Army at Dawn",
             "The Book Thief","A Tale of Two Cities","Shōgun","All Quiet on the Western Front","War and Peace",
             "The Three-Body Problem","Ender's Game","Dune","Foundation","I, Robot",
             "The Body","Murder on the Orient Express","A Study in Scarlet","Where the Crawdads Sing","And Then There Were None",
             "Harry Potter and the Sorcerer's Stone","The Lightning Thief","The Fellowship of the Ring","A Game of Thrones","The lion, the Witch, and the Wardrobe",
     };
     static String[] authors = {
             "Kai Bird, Martin J. Sherwin","Barbara W. Tuchman","Edward Said","David McCullough","Rick Atkinson",
             "Markus Zusak","Charles Dickens","James Clavell","Erich Maria Remarque","Leo Tolstoy",
             "Cixin Liu","Orson Scott Card","Frank Herbert","Isaac Asimov","Isaac Asimov",
             "Stephen King","Agatha Christie","Arthur Conan Doyle","Delia Owens","Agatha Christie",
             "J.K. Rowling","Rick Riordan","J.R.R. Tolkien","George R.R. Martin","C.S. Lewis"
     };
     static String[] pubDates = {
             "04/05/2005","1962","1978","05/24/2005","08/2002",
             "2005","11/26/1859","1975","1928","1867",
             "2008","01/1985","08/1965","1951","12/02/1950",
             "1982","01/01/1934","1887","08/14/2018","11/06/1939",
             "06/26/1997","06/01/2005","06/29/1954","08/01/1996","10/16/1950"
     };
     static double[] prices = {
             15.15, 8.99, 12.99, 11.51, 14.69,
             7.83, 5.49, 22.49, 6.99, 12.49,
             19.59, 15.15, 20.99, 18.80, 13.56,
             10.48, 8.99, 8.88, 10.94, 16.55,
             8.64, 5.99, 21.00, 11.00, 7.64
     };
     static int[] pageNums = {
             721, 551, 368, 386, 704,
             584, 408, 1299, 160, 1225,
             302, 324, 896, 255, 253,
             192, 256, 192, 368, 272,
             223, 377, 423, 694, 172
     };
     static int[] genreIndices = {
             0,0,0,0,0,
             1,1,1,1,1,
             2,2,2,2,2,
             3,3,3,3,3,
             4,4,4,4,4,
     };
     static String[] genres = {
             "History (Nonfiction)",
             "Historical Fiction",
             "Science Fiction",
             "Mystery",
             "Fantasy",
     };
     static boolean[] outStatus = new boolean[titles.length];

    // Initializing variables for all important characteristics of a book
    String title;
    String author;
    String pubDate;
    double price;
    int pageNum;
    int genreIndex;
    boolean checkedOut;

    // Creating a book object to hold all relevant info in one spot
    public Book(String title, String author, String pubDate, double price, int pageNum, int genreIndex, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.price = price;
        this.pageNum = pageNum;
        this.genreIndex = genreIndex;
        this.checkedOut = checkedOut;
    }
    // Function that prints all book info. Prevents huge chunks of code being repeated each time we want to show book info
  public double printBook(){
      System.out.println("Title: " + title);
      System.out.println("Author: " + author);
      System.out.println("Date Published: " + pubDate);
      System.out.println("Price: $" + price);
      System.out.println("Page Count: " + pageNum);
      if (!checkedOut){System.out.println("Currently Available");}
      if (checkedOut){System.out.println("Currently Checked Out");}
      System.out.println("----------------------------------------");

    // Math Class Method. Used for calculating late fees.
      public double calculateLateFee;(LocalDate currentDate) {
          if (currentDate.isAfter(dueDate)) {
              long daysLate = dueDate.until(currentDate).getDays();
              // Utilize the calculateLateFee method from the LibraryMath class
              return LibraryMath.calculateLateFee((int) daysLate);
          }
          return 0; // No late fee if not late
      }

  }

}


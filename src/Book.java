
 class Book {
    // Initializing variables for all important characteristics of a book
     String title;
    String author;
    String pubDate;
    double price;
    int pageNum;
    int genreIndex;

    // Creating a book object to hold all relevant info in one spot
    public Book(String title, String author, String pubDate, double price, int pageNum, int genreIndex) {
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.price = price;
        this.pageNum = pageNum;
        this.genreIndex = genreIndex;
    }
    // Function that prints all book info. Prevents huge chunks of code being repeated each time we want to show book info
  public void printBook(){
      System.out.println("Title: " + title);
      System.out.println("Author: " + author);
      System.out.println("Date Published: " + pubDate);
      System.out.println("Price: $" + price);
      System.out.println("Page Count: " + pageNum);
      System.out.println();

  }

}


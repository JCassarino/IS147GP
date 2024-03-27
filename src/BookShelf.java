public class BookShelf {
private static class Book{
    String title;
    String author;
    String pubDate;
    double price;
    int pageNum;
    int genreIndex;
    public Book(String title, String author, String pubDate, double price, int pageNum, int genreIndex){
        this.title = title;
        this.author = author;
        this.pubDate = pubDate;
        this.price = price;
        this.pageNum = pageNum;
        this.genreIndex = genreIndex;
        }
    }

}

public class BookShelf {
    /*
    1. History (Nonfiction) - American Prometheus, The Guns of August, Orientalism, 1776, An Army At Dawn
    2. Historical Fiction - The Book Thief, A Tale of Two Cities, Shogun, All Quiet On The Western Front, War and Peace
    3. Science Fiction - The Three-Body Problem, Ender's Game, Dune, Foundation, I Robot
    4. Mystery - The Body, Murder on the Orient Express, A Study in Scarlet, Where the Crawdads Sing, And Then There Were None
    5. Fantasy - Harry Potter, Percy Jackson, Lord of the Rings, Game of Thrones, The Chronicles of Narnia
     */
private static class Book{
    String title;
    String author;
    String pubDate;
    double price;
    int genreIndex;
    public Book(String title, String author, String pubDate, double price, int genreIndex){
        this.title = title;
        this.author = author;
        this.price = price;
        this.pubDate = pubDate;
        this.genreIndex = genreIndex;
        }
    }

}
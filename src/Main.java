import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

// Populating arrays with book data to be used later
    String[] titles = {
            "American Prometheus","The Guns of August","Orientalism","1776","An Army at Dawn",
            "The Book Thief","A Tale of Two Cities","Shōgun","All Quiet on the Western Front","War and Peace",
            "The Three-Body Problem","Ender's Game","Dune","Foundation","I, Robot",
            "The Body","Murder on the Orient Express","A Study in Scarlet","Where the Crawdads Sing","And Then There Were None",
            "Harry Potter and the Sorcerer's Stone","The Lightning Thief","The Fellowship of the Ring","A Game of Thrones","The lion, the Witch, and the Wardrobe",
    };

    String[] authors = {
            "Kai Bird, Martin J. Sherwin","Barbara W. Tuchman","Edward Said","David McCullough","Rick Atkinson",
            "Markus Zusak","Charles Dickens","James Clavell","Erich Maria Remarque","Leo Tolstoy",
            "Cixin Liu","Orson Scott Card","Frank Herbert","Isaac Asimov","Isaac Asimov",
            "Stephen King","Agatha Christie","Arthur Conan Doyle","Delia Owens","Agatha Christie",
            "J.K. Rowling","Rick Riordan","J.R.R. Tolkien","George R.R. Martin","C.S. Lewis"
    };

    String[] pubDates = {
            "04/05/2005","1962","1978","05/24/2005","08/2002",
            "2005","11/26/1859","1975","1928","1867",
            "2008","01/1985","08/1965","1951","12/02/1950",
            "1982","01/01/1934","1887","08/14/2018","11/06/1939",
            "06/26/1997","06/01/2005","06/29/1954","08/01/1996","10/16/1950"
    };

    double[] prices = {
            15.15, 8.99, 12.99, 11.51, 14.69,
            7.83, 5.49, 22.49, 6.99, 12.49,
            19.59, 15.15, 20.99, 18.80, 13.56,
            10.48, 8.99, 8.88, 10.94, 16.55,
            8.64, 5.99, 21.00, 11.00, 7.64


    };

    int[] pageNums = {
            721, 551, 368, 386, 704,
            584, 408, 1299, 160, 1225,
            302, 324, 896, 255, 253,
            192, 256, 192, 368, 272,
            223, 377, 423, 694, 172

    };

    int[] genreIndices = {
            1,1,1,1,1,
            2,2,2,2,2,
            3,3,3,3,3,
            4,4,4,4,4,
            5,5,5,5,5
    };

    String[] genres = {
            "History (Nonfiction)",
            "Historical Fiction",
            "Science Fiction",
            "Mystery",
            "Fantasy",
    };

    // Creating an array of "book" objects and populating it with the data listed above
Book[] books = new Book[titles.length];
for (int i = 0; i < books.length; i++){
books[i] = new Book(
        titles[i],
        authors[i],
        pubDates[i],
        prices[i],
        pageNums[i],
        genreIndices[i]);
}
    // Declaring scanner, allows us to prompt user to choose their genre
        Scanner in = new Scanner(System.in);

    // Variable to store the selected genre, initialized as null to allow for declaration inside loop, which would then break the loop
        String selectedGenre = null;

    // Printing welcome text
        System.out.println("Welcome to the IS147 Library Directory!");
        System.out.println();

while (selectedGenre == null) {
    System.out.println("Please select the genre of book you would like to look at:");
    for (int i = 0; i < genres.length; i++){
        System.out.println("["+ (i+1) +"] - " + genres[i]);
    }
    int genreChoice = in.nextInt();


    if (genreChoice >= 1 && genreChoice <= genres.length){
        selectedGenre = genres[genreChoice-1];} // Valid choice, declares selectedGenre as a valid int, breaking the loop to continue the program

    else {System.out.println("Invalid choice. Please try again.");} // Invalid choice, runs loop again
}

            System.out.println("Books in the " +selectedGenre+ " genre: ");
            for(Book book : books){
                if(genres[book.genreIndex].equals(selectedGenre)){
                    System.out.println("Title: " + book.title);
                    System.out.println("Author: " + book.author);
                    System.out.println("Date Published: " + book.pubDate);
                    System.out.println("Price: " + book.price);
                    System.out.println("Page Count: " + book.pageNum);
                    System.out.println();

                }
            }

    }
}
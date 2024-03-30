import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

    // Calling arrays that were populated in the book class - Arrays were populated there to prevent visual bloat in the Main
        String[] titles = Book.titles;
        String[] authors = Book.authors;
        String[] pubDates = Book.pubDates;
        double[] prices = Book.prices;
        int[] pageNums = Book.pageNums;
        int[] genreIndices = Book.genreIndices;
        String[] genres = Book.genres;

    // Creating an array of "book" objects and populating it with the data listed above
Book[] bookShelf = new Book[titles.length];
for (int i = 0; i < bookShelf.length; i++){
bookShelf[i] = new Book(
        titles[i],
        authors[i],
        pubDates[i],
        prices[i],
        pageNums[i],
        genreIndices[i]);
}
    // Declaring scanner, allows us to prompt user when input is needed
        Scanner in = new Scanner(System.in);

    // Variable to store the selected genre, initialized as null to allow for declaration inside loop, which would then break the loop
        String selectedGenre = null;

    // Printing welcome text
        System.out.println("Welcome to the IS147 Library Directory!");
        System.out.println();

    // Prompting user to choose a genre of book to browse. Uses a loop to allow for repeating message if user chooses invalid options
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
    // Shows books in the genre selected by the user. Utilises the printBook function present in the book class
            System.out.println("Books in the " +selectedGenre+ " genre: ");
            System.out.println();
            for( Book book : bookShelf){
                if(genres[book.genreIndex].equals(selectedGenre)){book.printBook();}
            }

    }
}
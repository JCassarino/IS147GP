import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // Declaring scanner, allows us to prompt user when input is needed
        Scanner in = new Scanner(System.in);

        // Printing welcome text
        System.out.println("----------------------------------------");
        System.out.println("Welcome to the IS147 Library Directory!");
        System.out.println("----------------------------------------");

        // Calling arrays that were populated in the book class - Arrays were populated there to prevent visual bloat in the Main
        String[] titles = Book.titles;
        String[] authors = Book.authors;
        String[] pubDates = Book.pubDates;
        double[] prices = Book.prices;
        int[] pageNums = Book.pageNums;
        int[] genreIndices = Book.genreIndices;
        String[] genres = Book.genres;
        boolean[] outStatus = Book.outStatus;
        int[] bookId = Book.bookIds;

        // Creating an array of "book" objects (named "bookShelf" and populating it with the data listed above
        Book[] bookShelf = new Book[titles.length];
        for (int i = 0; i < bookShelf.length; i++) {
            bookShelf[i] = new Book(
                    titles[i],
                    authors[i],
                    pubDates[i],
                    prices[i],
                    pageNums[i],
                    genreIndices[i],
                    outStatus[i],
                    bookId[i]
            );
        }

        // Displays main menu on startup, and after the user completes any action (such as checking out a book or browsing a genre)
        // Utilizes switch statements to provide multiple menu options along with an error message if an invalid option is chosen
        while (true) {
            System.out.println("[1] - Browse Currently Available Books");
            System.out.println("[2] - Checkout / Return A Book");
            System.out.println("[3] - Exit");
            System.out.println("Please Enter Your Choice: ");

            int mainMenuChoice = in.nextInt();

            switch (mainMenuChoice) {

                case 1:
                    int booksFound = browseBooks(in, Book.genres, bookShelf);
                    System.out.println("Total books found: " + booksFound);
                    break;
                case 2:
                    checkoutMenu(in, Book.bookIds, bookShelf, Book.outStatus, Book.titles, Book.authors);
                    break;
                case 3:
                    System.out.println("Thank you for visiting the IS147 Library.");
                    System.out.println("Come again soon!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    


    // browseBooks function allows for the user to search for books by genre. This is used in the browse feature.
    private static int browseBooks(Scanner in, String[] genres, Book[] bookShelf){

        // Variable to store the selected genre, initialized as null to allow for declaration inside loop, which would then break the loop
        String selectedGenre = null;

        // Prompting user to choose a genre of book to browse. Uses a loop to allow for repeating message if user chooses invalid options
        while (selectedGenre == null) {
            System.out.println("Please select the genre of book you would like to look at:");
            for (int i = 0; i < genres.length; i++) {
                System.out.println("[" + (i + 1) + "] - " + genres[i]);
            }
            int genreChoice = in.nextInt();

            if (genreChoice >= 1 && genreChoice <= genres.length) {
                selectedGenre = genres[genreChoice - 1];
            } // Valid choice, declares selectedGenre as a valid int, breaking the loop to continue the program

            else {
                System.out.println("Invalid choice. Please try again.");
            } // Invalid choice, runs loop again
        }

        int booksFound = 0; // Variable to store the number of books found

        // Shows books in the genre selected by the user. Utilises the printBook function present in the book class
        System.out.println("Books in the " + selectedGenre + " genre: ");
        System.out.println("----------------------------------------");

        // Iterates through the bookShelf array - Checks each book for its genre
        // If the genre of a book matches the user's chosen genre, the printBook function will be called to display that book's info
        for (Book book : bookShelf) {
            if (genres[book.genreIndex].equals(selectedGenre)) {
                booksFound++; // Increment the counter for each book found
                System.out.println("["+booksFound+"]");
                book.printBook();
            }
        }

        return booksFound; // Return the number of books found
    }
    /*
    -  Provides the user a menu they can navigate to check out or return a book.
    -  After using the browseBooks feature, a user can identify the unique ID number of a book they'd like to check out
    -  Once prompted, the user can enter that ID number to flip the checkedOut status of the chosen book object
    -  This will display a "checked out" or a "returned" message based the user's action
     */

    private static void checkoutMenu(Scanner in, int[] bookId, Book[] bookShelf, boolean[] outStatus, String[] titles, String[] authors){
        System.out.println("-------------------------------------------------");
        System.out.println("Welcome to the IS147 Library Checkout Interface!");
        System.out.println("Please enter the Book ID number of the title you want to check out / return:");
         int checkoutChoice = in.nextInt(); // Prompts the user to enter the ID of a book
        for (int i = 0; i < bookShelf.length; i++)
            // Uses a for loop to iterate through the bookshelf array and identify the book with an ID matching the user's input
            if (checkoutChoice == bookId[i]) {
                outStatus[i] = !outStatus[i];
                bookShelf[i].setCheckedOut(outStatus[i]);
                System.out.println("-------------------------------------------------");
                if(outStatus[i]){System.out.println("Successfully Checked Out: ");}
                if(!outStatus[i]){System.out.println("Successfully Returned: ");}
                System.out.println(titles[i]+ ", by "+ authors[i]);
                System.out.println("-------------------------------------------------");
            }
            }

    }



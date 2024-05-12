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
        // Creating an array of "book" objects and populating it with the data listed above
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
        for (Book book : bookShelf) {
            if (genres[book.genreIndex].equals(selectedGenre)) {
                booksFound++; // Increment the counter for each book found
                System.out.println("["+booksFound+"]");
                book.printBook();
            }
        }

        return booksFound; // Return the number of books found
    }

    private static void checkoutMenu(Scanner in, int[] bookId, Book[] bookShelf, boolean[] outStatus, String[] titles, String[] authors){
        System.out.println("-------------------------------------------------");
        System.out.println("Welcome to the IS147 Library Checkout Interface!");
        System.out.println("Please enter the Book ID number of the title you want to check out / return:");
         int checkoutChoice = in.nextInt();
        for (int i = 0; i < bookShelf.length; i++)
            if (checkoutChoice == bookId[i]) {
                outStatus[i] = !outStatus[i];
                System.out.println("-------------------------------------------------");
                if(outStatus[i]){System.out.println("Successfully Checked Out: ");}
                if(!outStatus[i]){System.out.println("Successfully Returned: ");}
                System.out.println(titles[i]+ ", by "+ authors[i]);
                System.out.println("-------------------------------------------------");
            }
            }

    }



import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // Declaring scanner, allows us to prompt user when input is needed
        Scanner in = new Scanner(System.in);

        // Printing welcome text
        System.out.println("----------------------------------------");
        System.out.println("Welcome to the IS147 Library Directory!");
        System.out.println("----------------------------------------");
        ;

        // Calling arrays that were populated in the book class - Arrays were populated there to prevent visual bloat in the Main
        String[] titles = Book.titles;
        String[] authors = Book.authors;
        String[] pubDates = Book.pubDates;
        double[] prices = Book.prices;
        int[] pageNums = Book.pageNums;
        int[] genreIndices = Book.genreIndices;
        String[] genres = Book.genres;
        boolean[] outStatus = Book.outStatus;

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
                    outStatus[i]
            );

        }


        while (true) {
            System.out.println("[1] - Browse / Checkout Books");
            System.out.println("[2] - Return A Book");
            System.out.println("[3] - Exit");
            System.out.println("Please Enter Your Choice: ");

            int mainMenuChoice = in.nextInt();

            switch (mainMenuChoice) {

                case 1:
                    browseBooks(in, Book.genres, bookShelf);
                    break;
                case 2:
                    System.out.println("Return Menu");
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


    // browseBooks function allows for the user to search for books by genre. This is used in the browse feature as well as the checkout feature.
        private static void browseBooks(Scanner in, String[] genres, Book[] bookShelf){

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
        // Shows books in the genre selected by the user. Utilises the printBook function present in the book class
        System.out.println("Books in the " + selectedGenre + " genre: ");
            System.out.println("----------------------------------------");
        for (Book book : bookShelf) {
            if (genres[book.genreIndex].equals(selectedGenre)) {
                book.printBook();
            }
        }

    }
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Display all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You chose to add a book.");
                    // Call a method to add a book
                    break;
                case 2:
                    System.out.println("You chose to remove a book.");
                    // Call a method to remove a book
                    break;
                case 3:
                    System.out.println("You chose to search for a book.");
                    // Call a method to search for a book
                    break;
                case 4:
                    System.out.println("You chose to display all books.");
                    // Call a method to display all books
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}



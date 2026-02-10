import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library(10);

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add book");
            System.out.println("2. Add e-book");
            System.out.println("3. Display all books");
            System.out.println("4. Search book by title");
            System.out.println("5. Borrow book");
            System.out.println("6. Return book");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.println("enter title");
                    String title=scanner.nextLine();

                    System.out.println("enter author");
                    String author=scanner.nextLine();

                    System.out.println("enter year");
                    int year= scanner.nextInt(); scanner.nextLine();

                    Book book= new Book(title,author,year);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.println("enter title");
                    String etitle=scanner.nextLine();

                    System.out.println("enter author");
                    String eauthor=scanner.nextLine();

                    System.out.println("enter year");
                    int eyear=scanner.nextInt(); scanner.nextLine();

                    System.out.println("enter file size");
                    double fileSize=scanner.nextDouble(); scanner.nextLine();

                    Book ebook= new EBook(etitle,eauthor,eyear,fileSize);
                    library.addBook(ebook);
                    break;

                case 3:
                    library.displayBooks();
                    break;

                case 4:
                    System.out.println("enter title to search");
                    String titleFound=scanner.nextLine();

                    Book found=library.searchByTitle(titleFound);
                    if (found == null){
                        System.out.println("book not found");
                    }else {
                        System.out.println(found + "founded");
                    }
                    break;

                case 5:
                    System.out.println("enter title to borrow");
                    String titleBorrow =scanner.nextLine();
                    library.borrowBook(titleBorrow);
                    break;

                case 6:
                    System.out.println("enter title to return");
                    String titleReturn=scanner.nextLine();
                    library.returnBook(titleReturn);
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 7);

        scanner.close();
    }
}

public class Library {

    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    // TODO: Add book to array
    public void addBook(Book book) {
        if(count>= books.length){
            System.out.println("you cant");
            return;
        }
        books[count]=book;
        count++;
        System.out.println("successfully added");

    }

    // TODO: Display all books
    public void displayBooks() {
        if (count==0){
            System.out.println("no books");
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " ) " + books[i]);
        }
    }

    // TODO: Search book by title
    public Book searchByTitle(String title) {
        if (title==null) return null;
        for (int i=0;i<count;i++){
            if (books[i].getTitle().equalsIgnoreCase(title.trim())) {
                return books[i];
            }
        }
        return null;
    }

    // TODO: Borrow book by title
    public void borrowBook(String title) {
        Book book=searchByTitle(title);
        if ( book==null) {
            System.out.println("book not found");
            return;
        }
        if (!book.isAvailable()){
            System.out.println("this book borrowed");
            return;
        }
        book.borrowBook();
        System.out.println("you borrowed: " + book.getTitle());
    }

    // TODO: Return book by title
    public void returnBook(String title) {
        Book book=searchByTitle(title);
        if ( book==null) {
            System.out.println("book not found");
        }
        if (book.isAvailable()){
            System.out.println("this book is already marked as available");
            return;
        }
        book.returnBook();
        System.out.println("you returned: " + book.getTitle());
    }
}

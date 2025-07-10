import java.util.ArrayList;
import java.util.Scanner;

public class BookRecommenderV1 {
    static ArrayList<Book> userBooks = new ArrayList<>();
    static ArrayList<Book> recs = new ArrayList<>();
    public static void main(String[] args) {

    }

    public void Setup(ArrayList<Book> booksToAdd) {
        for (Book book : booksToAdd) {
            userBooks.add(book);
        }
    }

    public void Run() {
        ArrayList<Book> archivedBooks = new ArrayList<>();
        Book archived1 = new Book();
        archived1.title = "Title11";
        archived1.genre = "Fantasy";
        Book archived2 = new Book();
        archived2.title = "Title12";
        archived2.genre = "Action";
        Book archived3 = new Book();
        archived3.title = "Title13";
        archived3.genre = "Adventure";
        Book archived4 = new Book();
        archived4.title = "Title14";
        archived4.genre = "Comedy";
        Book archived5 = new Book();
        archived5.title = "Title15";
        archived5.genre = "Horror";
        Book archived6 = new Book();
        archived6.title = "Title16";
        archived6.genre = "Crafts/Hobbies";
        Book archived7 = new Book();
        archived7.title = "Title17";
        archived7.genre = "Young Adult Fiction";
        Book archived8 = new Book();
        archived8.title = "Title18";
        archived8.genre = "Fiction";
        Book archived9 = new Book();
        archived9.title = "Title19";
        archived9.genre = "Non-Fiction";
        Book archived10 = new Book();
        archived10.title = "Title20";
        archived10.genre = "Travel";
        Book archived11 = new Book();
        archived11.title = "Title21";
        archived11.genre = "Education";
        archivedBooks.add(archived1);
        archivedBooks.add(archived2);
        archivedBooks.add(archived3);
        archivedBooks.add(archived4);
        archivedBooks.add(archived5);
        archivedBooks.add(archived6);
        archivedBooks.add(archived7);
        archivedBooks.add(archived8);
        archivedBooks.add(archived9);
        archivedBooks.add(archived10);
        archivedBooks.add(archived11);
        for (Book book1 : archivedBooks) {
            for (Book book2 : userBooks) {
                if ((book1.genre.equals(book2.genre)) && !(book1.title.equals(book2.title))) {
                    recs.add(book1);
                }
            }
        }
        for (Book book : recs) {
            System.out.println(book.title);
        }
    }
}

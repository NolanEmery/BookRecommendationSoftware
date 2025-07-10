import java.util.ArrayList;

public class AddBooks {
    private static ArrayList<Book> archs;
    private static ArrayList<Book> users;
    private static ArrayList<Book> rec;

    public static void addBooks() {
        archs = new ArrayList<>();
        users = new ArrayList<>();
        rec = new ArrayList<>();
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
        Book archived12 = new Book();
        archived12.title = "Title22";
        archived12.genre = "Science Fiction";
        archs.add(archived1);
        archs.add(archived2);
        archs.add(archived3);
        archs.add(archived4);
        archs.add(archived5);
        archs.add(archived6);
        archs.add(archived7);
        archs.add(archived8);
        archs.add(archived9);
        archs.add(archived10);
        archs.add(archived11);
        archs.add(archived12);
    }

    public static ArrayList<Book> getArchs() {
        return archs;
    }

    public static ArrayList<Book> getUsers() {
        return users;
    }

    public static ArrayList<Book> getRec() {
        return rec;
    }
}

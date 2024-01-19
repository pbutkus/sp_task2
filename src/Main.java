import logic.BookFinder;
import logic.FileReader;
import model.Book;
import ui.UserInterface;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = new FileReader("books.json");
        List<Book> books = fr.read();

        BookFinder bookFinder = new BookFinder(books);

        UserInterface ui = new UserInterface(bookFinder);
        ui.start();
    }
}
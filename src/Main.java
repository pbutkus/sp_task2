import logic.FileReader;
import model.Book;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fr = new FileReader("books.json");
        List<Book> books = fr.read();
    }
}
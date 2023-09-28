package logic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import model.Book;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class FileReader {

    private final String file;

    public FileReader(String file) {
        this.file = file;
    }

    public List<Book> read() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new java.io.FileReader(file));
        Book[] books = gson.fromJson(reader, Book[].class);

        return Arrays.asList(books);
    }

}

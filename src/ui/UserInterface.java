package ui;

import logic.BookFinder;
import model.Book;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private final BookFinder bookFinder;

    public UserInterface(BookFinder bookFinder) {
        this.scanner = new Scanner(System.in);
        this.bookFinder = bookFinder;
    }

    public void start() {
        System.out.println("1. Search by title");
        System.out.println("2. Search by author");
        System.out.println("3. Search by language");
        System.out.println("4. Search by year");
        System.out.println("0. Exit");

        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                searchByTitle();
                break;
            case "2":
                searchByAuthor();
                break;
            case "3":
                searchByLanguage();
                break;
            case "4":
                searchByYear();
                break;
            case "0":
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid input");
                start();
        }
    }

    private void searchByTitle() {
        System.out.println();
        System.out.println("Enter title:");
        String title = scanner.nextLine();
        System.out.println("Searching for '" + title + "'");

        List<Book> books = bookFinder.search("title", title);

        printList(books);
        start();
    }

    private void searchByAuthor() {
        System.out.println();
        System.out.println("Enter author:");
        String author = scanner.nextLine();
        System.out.println("Searching for " + author);

        List<Book> books = bookFinder.search("author", author);

        if (books == null) {
            System.out.println("The book has not been found...");
        } else {
            System.out.println(books);
        }

        System.out.println();
        start();
    }

    private void searchByLanguage() {
        System.out.println();
        System.out.println("Enter Language:");
        String language = scanner.nextLine();
        System.out.println("Searching for " + language);

        List<Book> books = bookFinder.search("language", language);

        if (books == null) {
            System.out.println("The book has not been found...");
        } else {
            System.out.println(books);
        }

        System.out.println();
        start();
    }

    private void searchByYear() {
        System.out.println("Enter year:");
        int year = scanner.nextInt();
    }

    private void printList(List<Book> books) {
        if (books == null) {
            System.out.println("No books were found...");
        } else {
            books.forEach(System.out::println);
        }
        System.out.println();
    }

}

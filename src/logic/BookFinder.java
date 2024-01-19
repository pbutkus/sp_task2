package logic;

import model.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class BookFinder {

    private final List<Book> books;

    public BookFinder(List<Book> books) {
        this.books = books;
    }

    private <T extends Comparable<T>> int binarySearch(List<Book> list, T target, Function<Book, T> fieldExtractor, int left, int right) {
        if (left <= right) {
            int middle = left + (right - left) / 2;

            T middleValue = fieldExtractor.apply(list.get(middle));

            int comparison = middleValue.compareTo(target);

            boolean contains = middleValue.toString()
                    .toUpperCase()
                    .contains(target.toString().toUpperCase());

            if (comparison == 0 || contains) {
                return middle;
            } else if (comparison < 0) {
                return binarySearch(books, target, fieldExtractor, middle + 1, right);
            } else {
                return binarySearch(books, target, fieldExtractor, left, middle - 1);
            }
        }

        return -1;
    }

    private <T> List<Book> linearSearch(int targetIndex, Function<Book, T> fieldExtractor, String searchFor) {
        List<Book> bookList = new ArrayList<>();

        bookList.add(books.get(targetIndex));

        for (int i = targetIndex - 1; i >= 0; i--) {
            T currentBook = fieldExtractor.apply(books.get(i));

            boolean contains = currentBook.toString()
                    .toUpperCase()
                    .contains(searchFor.toUpperCase());

            if (contains) {
                bookList.add(books.get(i));
            } else {
                break;
            }
        }

        for (int i = targetIndex + 1; i < books.size(); i++) {
            T currentBook = fieldExtractor.apply(books.get(i));

            boolean contains = currentBook.toString()
                    .toUpperCase()
                    .contains(searchFor.toUpperCase());

            if (contains) {
                bookList.add(books.get(i));
            } else {
                break;
            }
        }

        return bookList;
    }

    public int findBookByTitle(String title) {
        books.sort(Comparator.comparing(Book::getTitle));

        return binarySearch(books, title, Book::getTitle, 0, books.size() - 1);
    }

    public int findBookByAuthor(String author) {
        books.sort(Comparator.comparing(Book::getAuthor));

        return binarySearch(books, author, Book::getAuthor, 0, books.size() - 1);
    }

    public int findBookByLanguage(String language) {
        books.sort(Comparator.comparing(Book::getLanguage));

        return binarySearch(books, language, Book::getLanguage, 0, books.size() - 1);
    }

    public int findBookByYear(String year) {
        books.sort(Comparator.comparing(Book::getYear));

        int yearInt = Integer.parseInt(year);

        return binarySearch(books, yearInt, Book::getYear, 0, books.size() - 1);
    }

    public List<Book> search(String searchBy, String searchFor) {
        int bookIndex = switch (searchBy) {
            case "title" -> findBookByTitle(searchFor);
            case "author" -> findBookByAuthor(searchFor);
            case "language" -> findBookByLanguage(searchFor);
            case "year" -> findBookByYear(searchFor);
            default -> -1;
        };

        if (bookIndex == -1) {
            return null;
        }

        return switch (searchBy) {
            case "title" -> linearSearch(bookIndex, Book::getTitle, searchFor);
            case "author"-> linearSearch(bookIndex, Book::getAuthor, searchFor);
            case "language" -> linearSearch(bookIndex, Book::getLanguage, searchFor);
            case "year" -> linearSearch(bookIndex, Book::getYear, searchFor);
            default -> null;
        };
    }

}

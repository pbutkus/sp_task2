package model;

public class Book {

    private String title;
    private String author;
    private String language;
    private int pages;
    private int year;
    private String country;
    private String imageLink;
    private String link;

    public Book(String title, String author, String language, int pages, int year, String country, String imageLink, String link) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.pages = pages;
        this.year = year;
        this.country = country;
        this.imageLink = imageLink;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

package model;

public class Book {

    private final String title;
    private final String author;
    private final String language;
    private final int pages;
    private final int year;
    private final String country;
    private final String imageLink;
    private final String link;

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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", pages=" + pages +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", link='" + link;
    }
}

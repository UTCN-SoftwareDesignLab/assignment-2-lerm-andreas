package bookstore.business.dto;

import org.springframework.beans.factory.annotation.Required;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookDto {

    @Size(min = 2, message = "The author must be of at least 2 characters!")
    @NotNull(message = "You must specify the author of the book!")
    private String author;
    @Size(min = 2, message = "The title must be of at least 2 characters!")
    @NotNull(message = "You must specify the title of the book!")
    private String title;
    @Pattern(regexp = "^[1-9]+$")
    @Size(min = 5, max = 5, message = "ISBN is the wrong size")
    @NotNull(message = "You must specify the ISBN of the book!")
    private String isbn;
    @NotNull(message = "You must specify the genre of the book!")
    @Size(min = 2, message = "The genre must be of at least 2 characters!")
    private String genre;

    @Positive(message = "The quantity must be greater than 0!")
    private int quantity;
    @NotNull(message = "You must specify the price of the book!")
    @Positive(message = "The price must be greater than 0!")
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
}

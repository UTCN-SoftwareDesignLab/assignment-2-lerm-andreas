package bookstore.business.service;

import bookstore.business.dto.BookDto;
import bookstore.data.entity.Book;
import bookstore.report.Strategy;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

public interface BookService {
    @Transactional
    List<Book> getAll();
    @Transactional
    Book createBook(BookDto bookDto);

    @Transactional
    void deleteBook(BookDto bookDto);
    @Transactional
    Book getBook(BookDto bookDto);

    //search books by genre, title, author

    List<Book> getBooksByGenreContaining(String genre);

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    @Transactional
    void updateBook(BookDto bookDto);

    @Transactional
    void sell(int quantity,String title);

    void generateReport(List<Book>books,String fileName) throws IOException;

    void chooseStrategy(Strategy strategy);
}

package bookstore.business.service;

import bookstore.business.dto.BookDto;
import bookstore.data.entity.Book;
import bookstore.report.Strategy;

import java.io.IOException;
import java.util.List;

public class CachingBookService implements BookService {

    private BookService origin;

    public CachingBookService(BookService origin) {
        this.origin = origin;
    }

    @Override
    public List<Book> getAll() {
        return origin.getAll();
    }

    @Override
    public Book createBook(BookDto bookDto){
        return origin.createBook(bookDto);
    }

    @Override
    public void deleteBook(BookDto bookDto){
         origin.deleteBook(bookDto);
    }

    @Override
    public Book getBook(BookDto bookDto){
        return origin.getBook(bookDto);
    }

    @Override
    public List<Book> getBooksByGenreContaining(String genre ){
        return origin.getBooksByGenreContaining(genre);
    }

    @Override
    public Book getBookByTitle(String title ){
        return origin.getBookByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author ){
        return origin.getBooksByAuthor(author);
    }

    @Override
    public void updateBook(BookDto bookDto){
        origin.updateBook(bookDto);
    }

    @Override
    public void sell(int quantity, String title){
         origin.sell(quantity,title);
    }

    @Override
    public void generateReport(List<Book> books,String fileName) throws IOException {
        origin.generateReport( books,fileName);
    }

    @Override
    public void chooseStrategy(Strategy strategy) {
        origin.chooseStrategy(strategy);
    }
}

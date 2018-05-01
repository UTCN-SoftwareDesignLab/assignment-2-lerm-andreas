package bookstore.business.service;

import bookstore.business.dto.BookDto;
import bookstore.data.entity.Book;
import bookstore.data.repository.BookRepository;
import bookstore.report.CSVReport;
import bookstore.report.PDFReport;
import bookstore.report.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private Strategy strategy;


    @Autowired
    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void chooseStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(BookDto bookDto){
        Book book  = new Book(bookDto.getTitle(),bookDto.getIsbn(),bookDto.getGenre(),bookDto.getAuthor(),bookDto.getQuantity(),bookDto.getPrice());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(BookDto bookDto){
       Book book = bookRepository.findByIsbn(bookDto.getIsbn());

       bookRepository.delete(book);
    }

    @Override
    public Book getBook(BookDto bookDto){
        return bookRepository.findByIsbn(bookDto.getIsbn());
    }

    @Override
    public List<Book> getBooksByGenreContaining(String genre){
        return bookRepository.findAllByGenreContaining(genre);
    }

    @Override
    public List<Book> getBooksByAuthor(String author){
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public Book getBookByTitle(String title){
        return bookRepository.getByTitle(title);
    }


    @Override
    public void sell(int quantity,String title) {
        Book book = bookRepository.getByTitle(title);
        if(book.getQuantity()-quantity > 0)
        book.setQuantity(book.getQuantity()-quantity);
        else
            book.setQuantity(0);
        bookRepository.updateBook(book.getQuantity(),book.getTitle(),book.getPrice(),book.getIsbn());
    }


    @Override
    public void updateBook(BookDto book)
    {
        bookRepository.updateBook(book.getQuantity(),book.getTitle(),book.getPrice(),book.getIsbn());
    }

    @Override
    public void generateReport(List<Book> books,String fileName) throws IOException {
        strategy.generateReport(fileName,books);
    }

}
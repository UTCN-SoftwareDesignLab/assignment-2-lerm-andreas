package bookstore.report;

import bookstore.data.entity.Book;

import java.io.IOException;
import java.util.List;

public interface Strategy {

    void generateReport(String fileName, List<Book> books) throws IOException;

}

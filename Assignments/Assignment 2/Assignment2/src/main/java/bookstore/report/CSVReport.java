package bookstore.report;

import bookstore.business.service.BookService;
import bookstore.business.service.BookServiceImpl;
import bookstore.data.entity.Book;
import bookstore.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReport implements Strategy {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "title,author,isbn";

    @Override
    public void generateReport(String fileName,List<Book> books) {

        //Create new students objects

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (Book book : books) {
                fileWriter.append(book.getTitle());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getAuthor());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getIsbn());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }

}
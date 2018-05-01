
package bookstore;
import bookstore.business.service.*;
import bookstore.data.repository.BookRepository;
import bookstore.data.repository.UserRepository1;
import bookstore.report.PDFReport;
import bookstore.report.Strategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = "BookService")
    public BookService bookService(BookRepository repository) {
        return new CachingBookService(new BookServiceImpl(repository));
    }


   @Bean(name = "UserService1")
    public UserService1 userService(UserRepository1 repository) {
        return new CachingUserService1(new UserServiceImpl1(repository));
    }

}

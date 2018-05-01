package bookstore.presentation;

import bookstore.business.dto.BookDto;
import bookstore.business.service.BookService;
import bookstore.data.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    BookService bookService;

    @Autowired
    public  UserController(final BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping("/user")
    public String getAdministratorPage(Model model){
        return "userPage";
    }

    @PostMapping("/user")
    public String showAdministratorPage(Model model){
        return "userPage";
    }


    @GetMapping("/getBooksByGenreForm")
    public String getByGenreFormGet(Model model) {
        model.addAttribute("book", new BookDto());

        return "getBooksByGenreForm";
    }

    @PostMapping("/getBooksByGenreForm")
    public String getByGenreForm(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "getBooksByGenreForm";
        }

        return "getBooksByGenreContaining";
    }

    @PostMapping("/getBooksByGenreContaining")
    public ModelAndView getBooksByGenre(@ModelAttribute("genre") String genre) {

        List<Book> bookList = new ArrayList<>();

        bookList = bookService.getBooksByGenreContaining(genre);

        ModelAndView modelAndView = new ModelAndView("searchbooks_list");

        modelAndView.addObject("bookDtoList", bookList);

        return modelAndView;
    }

    @GetMapping("/getBooksByTitleForm")
    public String getByTitleFormGet(Model model) {
        model.addAttribute("book", new BookDto());

        return "getBooksByTitleForm";
    }

    @PostMapping("/getBooksByTitleForm")
    public String getByTitleForm(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "getBooksByTitleForm";
        }

        return "getBooksByTitle";
    }

    @PostMapping("/getBooksByTitle")
    public ModelAndView getBooksByTitle(@ModelAttribute("title") String title) {

        List<Book> bookList = new ArrayList<>();

        Book book = new Book();

        book = bookService.getBookByTitle(title);

        bookList.add(book);

        ModelAndView modelAndView = new ModelAndView("searchbooks_list");

        modelAndView.addObject("bookDtoList", bookList);

        return modelAndView;
    }


    @GetMapping("/getBooksByAuthorForm")
    public String getByAuthorFormGet(Model model) {
        model.addAttribute("book", new BookDto());

        return "getBooksByAuthorForm";
    }

    @PostMapping("/getBooksByAuthorForm")
    public String getByAuthorBookForm(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "getBooksByAuthorForm";
        }

        return "getBookByAuthor";
    }

    @PostMapping("/getBooksByAuthor")
    public ModelAndView getBooksByAuthor(@ModelAttribute("author") String author) {

        List<Book> bookList;

        bookList = bookService.getBooksByAuthor(author);

        ModelAndView modelAndView = new ModelAndView("searchbooks_list");

        modelAndView.addObject("bookDtoList", bookList);

        return modelAndView;
    }

    @PostMapping("/sellBooksForm")
    public String sellForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "sellBookForm";
    }

    @PostMapping("/sellBooks")
    public ModelAndView sellBooks(@ModelAttribute("quantity") int quantity, @ModelAttribute("title") String title) {

        bookService.sell(quantity,title);

        List<Book> bookList;

        bookList = bookService.getAll();

        ModelAndView modelAndView = new ModelAndView("searchbooks_list");

        modelAndView.addObject("bookDtoList", bookList);

        return modelAndView;
    }


}

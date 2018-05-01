package bookstore.presentation;

import bookstore.business.dto.BookDto;
import bookstore.business.dto.UserDto1;
import bookstore.business.service.BookService;
import bookstore.business.service.UserService1;
import bookstore.data.entity.Book;
import bookstore.data.entity.User1;
import bookstore.report.CSVReport;
import bookstore.report.PDFReport;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Controller
public class AdministratorController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService1 userService;

    @Autowired
    public  AdministratorController(final BookService bookService, final UserService1 userService){
        this.bookService = bookService;
        this.userService=userService;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    List<Book> getAllBooks() {
        // This returns a JSON or XML with the users
        return bookService.getAll();
    }

    @PostMapping("/allBooks")
    public ModelAndView getAllBooks(@ModelAttribute BookDto bookDto) {
        List<Book> bookDtoList = bookService.getAll();
        ModelAndView mav = new ModelAndView("books_list");
        mav.addObject("bookDtoList", bookDtoList);
        return mav;
    }

    @GetMapping("/administrator")
    public String getAdministratorPage(Model model){
        return "adminPage";
    }

    @PostMapping("/administrator")
    public String showAdministratorPage(Model model){
        return "adminPage";
    }


    //GET BOOK BY ISBN

    @GetMapping("/getBookForm")
    public String getBookGetMethod(Model model) {
        model.addAttribute("book", new BookDto());

        return "getBookForm";
    }

    @PostMapping("/getBookForm")
    public String getForm(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
        // model.addAttribute("book", new BookDto());
        if (bindingResult.hasErrors()) {
            return "getBookForm";
        }
        return "getBook";
    }


    @PostMapping("/getBook")
    public ModelAndView getBook(@ModelAttribute BookDto bookDto) {

        List<Book> bookList = new ArrayList<>();

        Book book = bookService.getBook(bookDto);

        bookList.add(book);

        ModelAndView modelAndView = new ModelAndView("books_list");

        modelAndView.addObject("bookDtoList", bookList);

        return modelAndView;
    }

    @GetMapping("/createBookForm")
    public String checkPersonInfoForm(Model model) {
        model.addAttribute("book", new BookDto());

        return "addBookForm";
    }
    /*@PostMapping("/createBookForm")
    public String checkPersonInfo(Model model) {
        model.addAttribute("book", new BookDto());

        return "addBookForm";
    }

    @PostMapping("/createBook")
    public ModelAndView createBook(@ModelAttribute BookDto bookDto) {

        bookService.createBook(bookDto);
        List<Book> bookDtoList = bookService.getAll();

        ModelAndView mav = new ModelAndView("books_list");

        mav.addObject("bookDtoList", bookDtoList);

        return mav;
    }
    */
    @PostMapping("/createBookForm")
    public String checkPersonInfo(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
       // model.addAttribute("book", new BookDto());
        if (bindingResult.hasErrors()) {
            return "addBookForm";
        }
        return "addBookForm";
    }

    @PostMapping("/createBook")
    public ModelAndView createBook(@ModelAttribute BookDto bookDto) {

        bookService.createBook(bookDto);
        List<Book> bookDtoList = bookService.getAll();

        ModelAndView mav = new ModelAndView("books_list");

        mav.addObject("bookDtoList", bookDtoList);

        return mav;
    }


    @GetMapping("/deleteBookForm")
    public String deleteBookForm(Model model) {
        model.addAttribute("book", new BookDto());

        return "deleteBookForm";
    }


    @PostMapping("deleteForm")
    public String deleteForm(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "deleteBookForm";
        }
        return "deleteBook";
    }

    @PostMapping("/deleteBook")
    public ModelAndView deleteBook(@ModelAttribute BookDto bookDto) {
        bookService.deleteBook(bookDto);
        List<Book> bookList = bookService.getAll();

        ModelAndView modelAndView = new ModelAndView("books_list");

        modelAndView.addObject("bookDtoList", bookList);

        return modelAndView;
    }


    @GetMapping("/createUserForm")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserDto1());
        return "addUserForm";
    }

    @PostMapping("/createUserForm")
    public String createUserFormGet(@ModelAttribute("user") @Valid UserDto1 userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUserForm";
        }

        return "createUser";
    }



    @PostMapping("/createUser")
    public ModelAndView createUser(@ModelAttribute UserDto1 userDto1) {
        userService.createUser(userDto1);
        List<User1> userDtoList = userService.getAll();

        ModelAndView mav = new ModelAndView("users1_list");

        mav.addObject("userDtoList1", userDtoList);

        return mav;
    }

    @GetMapping("/deleteUserForm")
    public String deleteUserFormGet(Model model) {
        model.addAttribute("user", new UserDto1());
        return "deleteUserForm";
    }

    @PostMapping("deleteUserForm")
    public String deleteUserForm(@ModelAttribute("user") @Valid UserDto1 userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "deleteUserForm";
        }
        return "deleteUser";
    }

    @PostMapping("/deleteUser")
    public ModelAndView deleteUser(@ModelAttribute UserDto1 userDto) {
        userService.deleteUser(userDto);
        List<User1> userDtoList = userService.getAll();

        ModelAndView modelAndView = new ModelAndView("users1_list");

        modelAndView.addObject("userDtoList1", userDtoList);
        return modelAndView;
    }


    @GetMapping("/updateBookForm")
    public String updateBookFormGet(Model model) {
        model.addAttribute("book", new BookDto());

        return "updateBookForm";
    }


    @PostMapping("/updateBookForm")
    public String updateBookForm(@ModelAttribute("book") @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateBookForm";
        }
      // return "deleteBook";
        return "updateBook";
    }


    @PostMapping("/updateBook")
    public ModelAndView updateBook(@ModelAttribute BookDto bookDto) {
        bookService.updateBook(bookDto);
        List<Book> bookDtoList = bookService.getAll();

        ModelAndView mav = new ModelAndView("books_list");

        mav.addObject("bookDtoList", bookDtoList);

        return mav;
    }

    @PostMapping("/generatePDFReport")
    public String generatePDFReport() throws IOException {

        bookService.chooseStrategy(new PDFReport());
        bookService.generateReport(getAllBooks(), "C:/Projects/NewHope5/NewHope3/my_doc.pdf");

        return "generateReport";

    }


    @PostMapping("/generateCSVReport")
    public String generateCSVeport() throws IOException {
        bookService.chooseStrategy(new CSVReport());
        bookService.generateReport(getAllBooks(),"report.csv");

        return "generateReport";
    }


    /*@RequestMapping(value = "/login", method = RequestMethod.GET)
    @Order(value = 1)
    public String index() {
        return "login";
    }
    */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(Model model,HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        if(session.getAttribute("errorMessage")!=null)
        {
            model.addAttribute("incorrect",(String)session.getAttribute("errorMessage"));
        }
        return "login";
    }

}


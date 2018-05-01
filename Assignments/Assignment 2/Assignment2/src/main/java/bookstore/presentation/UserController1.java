package bookstore.presentation;

import bookstore.business.service.UserService1;
import bookstore.data.entity.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserController1 {
    //@Autowired
    UserService1 userService1;

    /*  @RequestMapping(value = "/{ff}", method = RequestMethod.GET)
      public ModelAndView getStudentsByFirstName(@PathVariable("ff") String firstName, Principal principal)
      {
          List<UserDto> studentDtoList = studentService.getStudentHavingFirstName(firstName);

          ModelAndView mav = new ModelAndView("student_list");
          mav.addObject("studentDtoList", studentDtoList);

          return mav;
      }

  */
    @Autowired
    public UserController1(final UserService1 userService1){
        this.userService1 = userService1;
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<User1> getAllUsers1() {
    //     This returns a JSON or XML with the users
      return userService1.getAll();
    }

   @GetMapping(path="/all1")
    public String getAllStudents1() {
        // This returns a JSON or XML with the users
        return "users1_list";
    }


    @GetMapping("/todos")
    public String findAll(Model model)
    {
        final List<User1> items=userService1.getAll();
        model.addAttribute("itemsCount",items.size());

        return "todos";
    }

    @RequestMapping(value = "/all2", method = RequestMethod.GET)
    public ModelAndView getAllStudents2()
    {
        List<User1> userDtoList = userService1.getAll();

        ModelAndView mav = new ModelAndView("users1_list");

        mav.addObject("userDtoList1", userDtoList);
        return mav;
    }
}

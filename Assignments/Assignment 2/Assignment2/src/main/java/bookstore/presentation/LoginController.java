package bookstore.presentation;

import bookstore.business.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {


    private AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService)
    {
        this.authenticationService=authenticationService;
    }

    @GetMapping("/login")
    @Order(value = 1)
    public String displayLogin()
    {
        return "login";
    }

}

package bookstore.business.service;

import bookstore.data.entity.User1;

import java.util.List;

public interface AuthenticationService {
    List<User1> findByUserNameAndPassword(String username, String password);
}

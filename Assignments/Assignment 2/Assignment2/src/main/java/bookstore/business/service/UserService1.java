package bookstore.business.service;

import bookstore.business.dto.UserDto1;
import bookstore.data.entity.User1;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService1 {
    List<User1> getAll();
    @Transactional
    User1 createUser(UserDto1 userDto1);
    @Transactional
    void deleteUser(UserDto1 userDto1);

    User1 getUser(UserDto1 userDto1);
}

package bookstore.business.service;

import bookstore.business.dto.UserDto1;
import bookstore.data.entity.User1;

import java.util.List;

public class CachingUserService1 implements UserService1 {

    private UserService1 origin;

    public CachingUserService1(UserService1 origin) {
        this.origin = origin;
    }

    @Override
    public List<User1> getAll() {
        //TODO: Add caching
        return origin.getAll();
    }

    @Override
    public User1 createUser(UserDto1 userDto1){
        return origin.createUser(userDto1);
    }

    @Override
    public void deleteUser(UserDto1 userDto1){
        origin.deleteUser(userDto1);
    }

    @Override
    public User1 getUser(UserDto1 userDto1){
        return origin.getUser(userDto1);
    }
}

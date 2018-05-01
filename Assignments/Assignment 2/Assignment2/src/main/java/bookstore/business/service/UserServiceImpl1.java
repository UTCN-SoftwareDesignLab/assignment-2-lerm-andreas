package bookstore.business.service;

import bookstore.business.dto.UserDto1;
import bookstore.data.entity.Book;
import bookstore.data.entity.User1;
import bookstore.data.repository.UserRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImpl1 implements UserService1 {

    private UserRepository1 userRepository;

    @Autowired
    public UserServiceImpl1(final UserRepository1 userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User1> getAll() {
        return userRepository.findAll();
    }



   @Override
    public User1 createUser(UserDto1 userDto1){
       BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        User1 user1 = new User1(userDto1.getUserName(),passwordEncoder.encode(userDto1.getPassword()),userDto1.getRole());
        return userRepository.save(user1);
   }

   public void deleteUser(UserDto1 userDto1){
        User1 user1 = userRepository.findByUserName(userDto1.getUserName());
        userRepository.delete(user1);
   }

   @Override
    public User1 getUser(UserDto1 userDto1){
       BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
       User1 user1 = new User1(userDto1.getUserName(),passwordEncoder.encode(userDto1.getPassword()),userDto1.getRole());
       return userRepository.findByUserName(user1.getUserName());
   }
}
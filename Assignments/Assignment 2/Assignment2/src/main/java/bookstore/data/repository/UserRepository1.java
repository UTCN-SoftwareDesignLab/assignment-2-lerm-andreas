package bookstore.data.repository;

import bookstore.data.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository1 extends JpaRepository<User1, Integer>
{
  // List<User1> findAllByUserName (String userName);
    User1 findByUserName(String userName);

     List<User1> findByUserNameAndPassword(String username,String password);
}

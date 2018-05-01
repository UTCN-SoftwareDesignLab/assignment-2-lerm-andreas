package bookstore.business.service;

import bookstore.data.entity.User1;
import bookstore.data.repository.UserRepository1;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.MessageDigest;
import java.util.List;

public class AuthenticationServiceImpl implements AuthenticationService{

    private UserRepository1 userRepository;


    @Autowired
    public AuthenticationServiceImpl(UserRepository1 userRepository)
    {
        this.userRepository=userRepository;
    }

    public List<User1> findByUserNameAndPassword(String username, String password)
    {
        return userRepository.findByUserNameAndPassword(username,encodePassword(password));
    }

    private String encodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            return null;
        }
    }
}

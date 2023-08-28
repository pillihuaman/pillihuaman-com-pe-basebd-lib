package pillihuaman.com.segurity.basebd.token.dao.implement;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import pillihuaman.com.segurity.basebd.user.User;

import java.util.Collections;

@Service
public class CustomUserDetailsServiceImpl {

    public UserDetails convertUserToUserDetailsService(User user) {
        // Create a UserDetails object based on your 'User' object
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                // Add your authorities/roles here as needed (e.g., user.getRoles())
                Collections.emptyList()
        );

        return userDetails;
    }
}
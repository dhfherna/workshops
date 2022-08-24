package co.com.bancolombia.usermanagment.service;

import co.com.bancolombia.usermanagment.dto.AuthDTO;
import co.com.bancolombia.usermanagment.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private List<UserDTO> listUsers;

    public UserDTO consultUserByCredentials(AuthDTO request) {
        return listUsers.stream()
                .filter(user -> request.getUser().equals(user.getUser())
                        && request.getPass().equals(user.getPass()))
                .findFirst().orElse(null);
    }
}

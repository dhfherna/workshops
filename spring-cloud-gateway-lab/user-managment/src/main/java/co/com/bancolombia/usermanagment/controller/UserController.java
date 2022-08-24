package co.com.bancolombia.usermanagment.controller;

import co.com.bancolombia.usermanagment.dto.AuthDTO;
import co.com.bancolombia.usermanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Object> consultUserByCredentials(@RequestBody AuthDTO request) {
        return ResponseEntity.ok(userService.consultUserByCredentials(request));
    }
}

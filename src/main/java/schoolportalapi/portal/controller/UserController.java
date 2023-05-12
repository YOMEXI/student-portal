package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolportalapi.portal.payload.auth.AuthenticationRequest;
import schoolportalapi.portal.payload.auth.AuthenticationResponse;
import schoolportalapi.portal.payload.auth.RegisterRequest;
import schoolportalapi.portal.service.UserService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterRequest registerRequest){
        return userService.register(registerRequest);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody AuthenticationRequest request){
        return userService.login(request);
    }
}

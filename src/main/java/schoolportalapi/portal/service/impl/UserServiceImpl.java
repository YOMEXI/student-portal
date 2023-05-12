package schoolportalapi.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import schoolportalapi.portal.config.JwtFullService;
import schoolportalapi.portal.entities.User;
import schoolportalapi.portal.exception.CustomApiException;
import schoolportalapi.portal.payload.auth.AuthenticationRequest;
import schoolportalapi.portal.payload.auth.AuthenticationResponse;
import schoolportalapi.portal.payload.auth.RegisterRequest;
import schoolportalapi.portal.repository.RoleRepository;
import schoolportalapi.portal.repository.UserRepository;
import schoolportalapi.portal.service.UserService;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtFullService jwtFullService;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<?> register(RegisterRequest registerRequest) {

        var ifUserExist = userRepository.findByEmail(registerRequest.getEmail());

                if(ifUserExist.isPresent())
                   throw  new CustomApiException(HttpStatus.BAD_REQUEST,
                            "User Already Exists");


        var userRole = roleRepository.findById(registerRequest.getRoleId())
                .orElseThrow(()->new CustomApiException(HttpStatus.BAD_REQUEST,
                        "Role does not exist"));

        var newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());
        newUser.setRoles(Collections.singleton(userRole));

        var jwtToken = jwtFullService.generateToken(newUser);
        var refreshToken = jwtFullService.generateRefreshToken(newUser);

        userRepository.save(newUser);
        return new ResponseEntity<>("User Registered SucessFully",HttpStatus.CREATED);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        return null;
    }
}

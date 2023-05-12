package schoolportalapi.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import schoolportalapi.portal.config.JwtFullService;
import schoolportalapi.portal.entities.User;
import schoolportalapi.portal.exception.CustomApiException;
import schoolportalapi.portal.payload.auth.AuthenticationRequest;
import schoolportalapi.portal.payload.auth.AuthenticationResponse;
import schoolportalapi.portal.payload.auth.LoginResponse;
import schoolportalapi.portal.payload.auth.RegisterRequest;
import schoolportalapi.portal.repository.RoleRepository;
import schoolportalapi.portal.repository.UserRepository;
import schoolportalapi.portal.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtFullService jwtFullService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
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



        userRepository.save(newUser);
        return new ResponseEntity<>("User Registered SuccessFully",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> login(AuthenticationRequest request) {

        var ifUserExist = userRepository.findByEmail(request.getEmail());

        if(ifUserExist.isEmpty())
            throw new CustomApiException(HttpStatus.BAD_REQUEST,"User does not Exist");

        boolean comparePassword =bCryptPasswordEncoder.matches(request.getPassword()
                ,ifUserExist.get().getPassword());

        if(!comparePassword)
            throw new CustomApiException(HttpStatus.BAD_REQUEST,"Bad credentials inputed");


      var authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        List<String> roles = authentication.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());


        String jwtToken = jwtFullService.generateToken(ifUserExist.get());



        return ResponseEntity.ok(new LoginResponse(
                ifUserExist.get().getId(),
                ifUserExist.get().getFirstName(),
                ifUserExist.get().getLastName(),
                ifUserExist.get().getEmail(),
                roles,
                jwtToken
        ));
    }
}

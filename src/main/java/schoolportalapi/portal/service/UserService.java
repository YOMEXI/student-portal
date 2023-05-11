package schoolportalapi.portal.service;

import org.springframework.http.ResponseEntity;
import schoolportalapi.portal.payload.auth.AuthenticationRequest;
import schoolportalapi.portal.payload.auth.AuthenticationResponse;
import schoolportalapi.portal.payload.auth.RegisterRequest;

public interface UserService {
    ResponseEntity<?> register(RegisterRequest registerRequest);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}

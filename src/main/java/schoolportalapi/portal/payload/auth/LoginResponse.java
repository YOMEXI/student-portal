package schoolportalapi.portal.payload.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import schoolportalapi.portal.entities.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;
    private String accessToken;


}

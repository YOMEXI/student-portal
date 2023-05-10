package schoolportalapi.portal.entities;

import jakarta.persistence.*;
import lombok.*;
import schoolportalapi.portal.utils.enums.RolesEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(unique = true,nullable = false)
    private String name;
}

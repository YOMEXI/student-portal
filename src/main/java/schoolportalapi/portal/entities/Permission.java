package schoolportalapi.portal.entities;


import jakarta.persistence.*;
import lombok.*;
import schoolportalapi.portal.utils.enums.PermissionsEnum;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<PermissionsEnum> permissions;
}

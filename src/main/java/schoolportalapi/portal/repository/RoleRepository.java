package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}

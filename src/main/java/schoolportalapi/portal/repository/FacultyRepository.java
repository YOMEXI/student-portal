package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Faculty;

public interface FacultyRepository extends JpaRepository <Faculty,Long> {
}

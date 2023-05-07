package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Faculty;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository <Faculty,Long> {


    Optional<Faculty> findByFacultyName(String facultyName);

    Optional<Faculty> findByFacultyCode(String facultyCode);
}

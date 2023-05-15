package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional findByRegistrationNumber(String registrationNumber);
    Optional findByEmail(String email);
}

package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Student;

public interface StudentRepostory extends JpaRepository<Student,Long> {
}

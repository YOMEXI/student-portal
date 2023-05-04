package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}

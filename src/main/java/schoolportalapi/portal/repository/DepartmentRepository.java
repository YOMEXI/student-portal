package schoolportalapi.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Faculty;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Optional<Department> findByDepartmentName(String departmentName);

    Optional<Department> findByDepartmentCode(String departmentCode);
}

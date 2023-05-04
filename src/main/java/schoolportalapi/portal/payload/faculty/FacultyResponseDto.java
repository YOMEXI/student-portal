package schoolportalapi.portal.payload.faculty;

import lombok.*;
import schoolportalapi.portal.entities.Department;

import java.util.List;


@Data
public class FacultyResponseDto {
    private Long Id;
    private String facultyName;
    private String facultyCode;
    private List<Department> departments;


}

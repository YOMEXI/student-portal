package schoolportalapi.portal.payload.department;

import lombok.*;
import schoolportalapi.portal.entities.Faculty;

@Data
public class DepartmentResponseDto {

    private Long Id;
    private String departmentName;
    private String departmentCode;
    private Faculty faculty;
}

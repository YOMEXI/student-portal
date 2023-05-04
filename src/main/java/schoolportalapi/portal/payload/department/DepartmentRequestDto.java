package schoolportalapi.portal.payload.department;

import lombok.*;

@Data
public class DepartmentRequestDto {
    private String departmentName;

    private String departmentCode;

    private Long facultyId;
}

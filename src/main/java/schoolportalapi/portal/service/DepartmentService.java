package schoolportalapi.portal.service;

import org.springframework.stereotype.Service;
import schoolportalapi.portal.payload.department.DepartmentRequestDto;
import schoolportalapi.portal.payload.department.DepartmentResponseDto;
import schoolportalapi.portal.payload.faculty.FacultyRequestDto;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

    List<DepartmentResponseDto> AllDepartments();
}

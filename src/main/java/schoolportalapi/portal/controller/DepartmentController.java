package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schoolportalapi.portal.payload.department.DepartmentRequestDto;
import schoolportalapi.portal.payload.department.DepartmentResponseDto;
import schoolportalapi.portal.payload.faculty.FacultyRequestDto;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;
import schoolportalapi.portal.service.DepartmentService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/create")
    public DepartmentResponseDto createDepartment(@Validated @RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.createDepartment(departmentRequestDto);
    }

    @GetMapping()
    public List<DepartmentResponseDto> getAllDepartments(){
        return departmentService.AllDepartments();
    }
}

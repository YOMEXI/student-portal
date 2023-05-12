package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schoolportalapi.portal.payload.department.DepartmentRequestDto;
import schoolportalapi.portal.payload.department.DepartmentResponseDto;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;
import schoolportalapi.portal.repository.StudentRepostory;
import schoolportalapi.portal.service.StudentService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public StudentResponseDto createStudent(@Validated @RequestBody StudentRequestDto studentRequestDto){
        return studentService.createStudent(studentRequestDto);
    }
}

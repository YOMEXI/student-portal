package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;
import schoolportalapi.portal.payload.student.StudentUpdateDto;
import schoolportalapi.portal.service.StudentService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/student")
@PreAuthorize("hasAnyRole('ADMIN')")
public class StudentController {
    @Autowired
    StudentService studentService;


    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@Validated @RequestBody StudentRequestDto studentRequestDto){
        return studentService.createStudent(studentRequestDto);
    }

    @GetMapping()
    public ResponseEntity<?> allStudent(){
        return studentService.allStudents();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody StudentUpdateDto updateInfo){
        return studentService.updateStudent(id,updateInfo);
    }


    @PreAuthorize("hasAnyRole('SUPERUSER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}

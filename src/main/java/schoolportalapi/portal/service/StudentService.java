package schoolportalapi.portal.service;


import org.springframework.http.ResponseEntity;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;
import schoolportalapi.portal.payload.student.StudentUpdateDto;

public interface StudentService {
    ResponseEntity<?> createStudent(StudentRequestDto studentRequestDto);

    ResponseEntity<?> allStudents();

    ResponseEntity<?> deleteStudent(Long id);
    ResponseEntity<?> updateStudent(Long id, StudentUpdateDto studentInfo);


}

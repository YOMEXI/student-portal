package schoolportalapi.portal.service;


import org.springframework.http.ResponseEntity;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;

public interface StudentService {
    ResponseEntity<?> createStudent(StudentRequestDto studentRequestDto);

    ResponseEntity<?> allStudents();

    ResponseEntity<?> deleteStudent(Long id);


}

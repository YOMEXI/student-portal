package schoolportalapi.portal.service;


import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;

public interface StudentService {
    StudentResponseDto createStudent(StudentRequestDto studentRequestDto);
}

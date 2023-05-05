package schoolportalapi.portal.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Faculty;
import schoolportalapi.portal.entities.Student;
import schoolportalapi.portal.exception.CustomApiException;
import schoolportalapi.portal.helperMethods.studentHelperMethods;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;
import schoolportalapi.portal.repository.DepartmentRepository;
import schoolportalapi.portal.repository.FacultyRepository;
import schoolportalapi.portal.repository.StudentRepostory;
import schoolportalapi.portal.service.StudentService;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepostory studentRepostory;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private studentHelperMethods studentHelperMethods;


    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {

        Student newStudent = new Student();
        newStudent.setFirstName(studentRequestDto.getFirstName());
        newStudent.setLastName(studentRequestDto.getLastName());
        newStudent.setGender(studentRequestDto.getGender());
        newStudent.setEmail(studentRequestDto.getEmail());
        newStudent.setCourse(studentRequestDto.getCourse());
        newStudent.setPhoneNo(studentRequestDto.getPhoneNo());
        newStudent.setEmergencyContact(studentRequestDto.getEmergencyContact());
       newStudent.setState(studentRequestDto.getState());
       newStudent.setYearOfRegistration(studentRequestDto.getYearOfRegistration());

       Optional<Department> studentsDepartment = departmentRepository
               .findById(studentRequestDto.getDepartmentId());

       if(studentsDepartment.isEmpty())
           throw new CustomApiException(HttpStatus.BAD_REQUEST,"Department does not exist");



       newStudent.setDepartment(studentsDepartment.get());

       newStudent.setRegistrationNumber(studentHelperMethods
               .createStudentRegistrationNo(studentsDepartment
                       .get().getFaculty().getFacultyCode(),studentsDepartment.get()
                       .getDepartmentCode(),studentRequestDto.getYearOfRegistration()));



       studentRepostory.save(newStudent);


        return modelMapper.map(newStudent, StudentResponseDto.class);
    }
}

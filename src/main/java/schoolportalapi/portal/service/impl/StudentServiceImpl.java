package schoolportalapi.portal.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Student;
import schoolportalapi.portal.exception.CustomApiException;
import schoolportalapi.portal.helperMethods.ResponseHandler;
import schoolportalapi.portal.helperMethods.studentHelperMethods;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;
import schoolportalapi.portal.repository.DepartmentRepository;
import schoolportalapi.portal.repository.FacultyRepository;
import schoolportalapi.portal.repository.StudentRepository;
import schoolportalapi.portal.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepostory;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private studentHelperMethods studentHelperMethods;


    @Override
    public ResponseEntity<?> createStudent(StudentRequestDto studentRequestDto) {
        var emailAlreadyUsed = studentRepostory
                .findByEmail(studentRequestDto.getEmail());

        if(emailAlreadyUsed.isPresent())
            throw new CustomApiException(HttpStatus.BAD_REQUEST,
                    "Student already Registered with this email Email");


        Student newStudent = new Student();
        newStudent.setFirstName(studentRequestDto.getFirstName());
        newStudent.setLastName(studentRequestDto.getLastName());
        newStudent.setGender(studentRequestDto.getGender());
        newStudent.setEmail(studentRequestDto.getEmail());
        newStudent.setCourse(studentRequestDto.getCourse());
        newStudent.setPhoneNo(studentRequestDto.getPhoneNo());
        newStudent.setEmergencyContact(studentRequestDto.getEmergencyContact());
       newStudent.setState(studentRequestDto.getState());
        newStudent.setDateOfBirth(studentRequestDto.getDateOfBirth());
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



      var savedStudent= studentRepostory.save(newStudent);


        return ResponseHandler.generateResponse("Student created successfully",
                HttpStatus.CREATED,savedStudent);
    }

    @Override
    public ResponseEntity<?> allStudents() {


        List<Student> findAllStudents = studentRepostory.findAll();

        var allStudents=findAllStudents.stream()
                .map(student -> modelMapper.map(student, StudentResponseDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(allStudents);
    }

    @Override
    public ResponseEntity<?> deleteStudent(Long id) {

        Student student = studentRepostory.findById(id)
                .orElseThrow(()->new CustomApiException(HttpStatus.BAD_REQUEST,
                        "Student doesnt exist"));

        studentRepostory.deleteById(student.getId());

        return ResponseEntity.ok("Student deleted Successfully");
    }


}

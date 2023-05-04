package schoolportalapi.portal.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Faculty;
import schoolportalapi.portal.entities.Student;
import schoolportalapi.portal.helperMethods.studentHelperMethods;
import schoolportalapi.portal.payload.student.StudentRequestDto;
import schoolportalapi.portal.payload.student.StudentResponseDto;
import schoolportalapi.portal.repository.DepartmentRepository;
import schoolportalapi.portal.repository.FacultyRepository;
import schoolportalapi.portal.repository.StudentRepostory;
import schoolportalapi.portal.service.StudentService;

import java.util.Optional;

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
        newStudent.setLastName(studentRequestDto.getFirstName());
        newStudent.setGender(studentRequestDto.getGender());
        newStudent.setEmail(studentRequestDto.getEmail());
        newStudent.setCourse(studentRequestDto.getCourse());
        newStudent.setPhone(studentRequestDto.getPhone());
        newStudent.setEmergencyContact(studentRequestDto.getEmergencyContact());
        newStudent.setLga(studentRequestDto.getLga());

       Optional<Department> studentsDepartment = departmentRepository
               .findById(studentRequestDto.getDepartmentId());

       Optional <Faculty> StudentsFaculty = facultyRepository
               .findById(studentsDepartment
                       .get()
                       .getFaculty().getId());

       newStudent.setDepartment(studentsDepartment.get());

       newStudent.setRegistrationNumber(studentHelperMethods
               .createStudentRegistrationNo(StudentsFaculty.get().getFacultyCode(),studentsDepartment.get().getDepartmentCode()));


       newStudent.setDepartment(studentsDepartment.get());


        return null;
    }
}

package schoolportalapi.portal.repository;



import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Faculty;
import schoolportalapi.portal.entities.Student;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    FacultyRepository facultyRepository;


    private Faculty newFac;

    private Department studentDept ;

    private Student student1;
    private Student student2;

   @BeforeEach
    public void setup(){
        newFac = new Faculty();
       newFac.setFacultyCode("sci");
       newFac.setFacultyName("sciences");

        studentDept = new Department();
       studentDept.setDepartmentCode("csc");
       studentDept.setDepartmentName("Computer science");

         student1 = new Student();
        student1.setEmail("abayomexy@gmail.com");
        student1.setFirstName("Akin");
        student1.setLastName("Lanre");
        student1.setGender("male");
        student1.setPhoneNo("08099999999");
        student1.setState("Ondo");
        student1.setDateOfBirth("11/2/2023");
        student1.setEmergencyContact("00");
        student1.setRegistrationNumber("sci/csc/23/2829");
        student1.setCourse("Information Technology");
        student1.setYearOfRegistration("2023");
        student1.setDepartment(studentDept);

         student2 = new Student();
        student2.setEmail("mike@gmail.com");
        student2.setFirstName("mike");
        student2.setLastName("mila");
        student2.setGender("male");
        student2.setPhoneNo("08099999499");
        student2.setState("Ondo");
        student2.setDateOfBirth("11/2/2023");
        student2.setEmergencyContact("000");
        student2.setRegistrationNumber("sci/chm/23/2829");
        student2.setCourse("Chemistry");
        student2.setYearOfRegistration("2023");
        student2.setDepartment(studentDept);



    }


    @Test
    @DisplayName("It should save the student to the database")
    void createStudent(){

        var fac = newFac;
        var studentFaculty = facultyRepository.save(fac);

        var dept = studentDept;
        dept.setFaculty(studentFaculty);

        var studentDepartment = departmentRepository.save(studentDept);


        Student newStudent = student1;
        newStudent.setDepartment(studentDepartment);

        Student saveStudent = studentRepository.save(newStudent);

        assertThat(saveStudent).isNotNull();
    }

    @Test
    @DisplayName("It should return all Users")
    void getAllStudents(){

        var fac = newFac;
        var studentFaculty = facultyRepository.save(fac);

        var dept = studentDept;
        dept.setFaculty(studentFaculty);

        var studentDepartment = departmentRepository.save(studentDept);


        Student firstStudent = student1;
        firstStudent.setDepartment(studentDepartment);

        studentRepository.save(firstStudent);


        Student secondStudent = student2;
        secondStudent.setDepartment(studentDepartment);

         studentRepository.save(secondStudent);

        List<Student> list = studentRepository.findAll();


        assertEquals(2,list.size());
    }

    @Test
    @DisplayName("it should return a single user")
    void getStudentById(){

        var fac = newFac;
        var studentFaculty = facultyRepository.save(fac);

        var dept = studentDept;
        dept.setFaculty(studentFaculty);

        var studentDepartment = departmentRepository.save(studentDept);


        Student newStudent = student1;
        newStudent.setDepartment(studentDepartment);

        Student saveStudent = studentRepository.save(newStudent);


        Student existingStudent = studentRepository.findById(saveStudent.getId()).get();

        assertNotNull(existingStudent);
        assertThat("abayomexy@gmail.com").isEqualTo(existingStudent.getEmail());
    }
}

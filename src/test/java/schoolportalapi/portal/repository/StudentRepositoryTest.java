package schoolportalapi.portal.repository;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Student;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @DisplayName("It should save the student to the database")
    void createStudent(){

        Department studentDept = new Department();
        studentDept.setId(1L);
        studentDept.setDepartmentCode("sci");
        studentDept.setDepartmentName("Computer-sci");


        Student newStudent = new Student();
        newStudent.setEmail("abayomexy@gmail.com");
        newStudent.setFirstName("Akin");
        newStudent.setLastName("Lanre");
        newStudent.setGender("male");
        newStudent.setPhoneNo("08099999999");
        newStudent.setState("Ondo");
        newStudent.setDateOfBirth("11/2/2023");
        newStudent.setEmergencyContact(0);
        newStudent.setRegistrationNumber("fcs/sci/23/2829");
        newStudent.setCourse("Information Technology");
        newStudent.setYearOfRegistration("2023");
        newStudent.setDepartment(studentDept);

        Student saveStudent = studentRepository.save(newStudent);

        assertThat(saveStudent).isNotNull();
    }

    @Test
    @DisplayName("It should return all Users")
    void getAllStudents(){
        Department studentDept = new Department();
        studentDept.setId(1L);
        studentDept.setDepartmentCode("sci");
        studentDept.setDepartmentName("Computer-sci");


        Student student1 = new Student();
        student1.setEmail("abayomexy@gmail.com");
        student1.setFirstName("Akin");
        student1.setLastName("Lanre");
        student1.setGender("male");
        student1.setPhoneNo("08099999999");
        student1.setState("Ondo");
        student1.setDateOfBirth("11/2/2023");
        student1.setEmergencyContact(0);
        student1.setRegistrationNumber("fcs/sci/23/2829");
        student1.setCourse("Information Technology");
        student1.setYearOfRegistration("2023");
        student1.setDepartment(studentDept);

        studentRepository.save(student1);




        Student student2 = new Student();
        student2.setEmail("mike@gmail.com");
        student2.setFirstName("mike");
        student2.setLastName("mila");
        student2.setGender("male");
        student2.setPhoneNo("08099999499");
        student2.setState("Ondo");
        student2.setDateOfBirth("11/2/2023");
        student2.setEmergencyContact(0);
        student2.setRegistrationNumber("fcs/sci/23/2829");
        student2.setCourse("Information Technology");
        student2.setYearOfRegistration("2023");
        student2.setDepartment(studentDept);


        studentRepository.save(student2);

        List<Student> list = studentRepository.findAll();


        assertEquals(2,list.size());
    }

    @Test
    @DisplayName("it should return a single user")
    void getStudentById(){
        Department studentDept = new Department();
        studentDept.setId(1L);
        studentDept.setDepartmentCode("sci");
        studentDept.setDepartmentName("Computer-sci");

        Student student1 = new Student();
        student1.setEmail("abayomexy@gmail.com");
        student1.setFirstName("Akin");
        student1.setLastName("Lanre");
        student1.setGender("male");
        student1.setPhoneNo("08099999999");
        student1.setState("Ondo");
        student1.setDateOfBirth("11/2/2023");
        student1.setEmergencyContact(0);
        student1.setRegistrationNumber("fcs/sci/23/2829");
        student1.setCourse("Information Technology");
        student1.setYearOfRegistration("2023");
        student1.setDepartment(studentDept);

        studentRepository.save(student1);
        Student existingStudent = studentRepository.findById(student1.getId()).get();

        assertNotNull(existingStudent);
        assertThat("abayomexy@gmail.com").isEqualTo(existingStudent.getEmail());
    }
}

package schoolportalapi.portal.payload.student;

import lombok.Data;
import schoolportalapi.portal.entities.Department;
@Data
public class StudentResponseDto {

    private Long id;

    private String firstName;

    private String lastName;


    private String middleName;

    private String phoneNo;

    private String registrationNumber;

    private String matricNo;

    private String state;

    private String dateOfBirth;
    private String course;

    private String gender;


    private String email;

    private Integer emergencyContact;

     private Department department;
}

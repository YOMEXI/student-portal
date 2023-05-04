package schoolportalapi.portal.payload.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import schoolportalapi.portal.entities.Department;

@Data
public class StudentRequestDto {

    private String firstName;

    private String lastName;

    private String middleName;


    private Integer phone;

    private String registrationNumber;

    private String matricNo;

    private String state;

    private String lga;

    private String course;

    private String gender;


    private String email;

    private Integer emergencyContact;

     private Long departmentId;
}

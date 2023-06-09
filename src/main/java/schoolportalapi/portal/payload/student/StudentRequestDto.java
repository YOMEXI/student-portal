package schoolportalapi.portal.payload.student;


import lombok.Data;


@Data
public class StudentRequestDto {

    private String firstName;

    private String lastName;

    private String middleName;

    private String phoneNo;

    private String registrationNumber;

    private String matricNo;

    private String state;

    private String course;
    private String dateOfBirth;

    private String yearOfRegistration;
    private String gender;

    private String email;

    private String emergencyContact;

     private Long departmentId;
}

package schoolportalapi.portal.payload.student;


import lombok.Data;


@Data
public class StudentUpdateDto {

    private String firstName;

    private String lastName;

    private String middleName;

    private String phoneNo;


    private String state;


    private String gender;


}

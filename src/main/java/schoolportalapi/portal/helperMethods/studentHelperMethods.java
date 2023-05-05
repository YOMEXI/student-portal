package schoolportalapi.portal.helperMethods;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import schoolportalapi.portal.exception.CustomApiException;
import schoolportalapi.portal.repository.StudentRepostory;

import java.util.Random;

@Component
public class studentHelperMethods {

    @Autowired
    StudentRepostory studentRepostory;

    public String createStudentRegistrationNo(String facultyCode, String departmentCode,String yearOfRegistration){

        Long randomNo = 100 + new Random().nextLong(900);

            String regNo=
                    String.valueOf(facultyCode + "/"
                            + departmentCode
                            + "/" + yearOfRegistration.substring(2) + "/"
                            + randomNo);


            var ifRegNoExist = studentRepostory.findByRegistrationNumber(regNo);

            if(ifRegNoExist.isPresent())
                throw new CustomApiException(HttpStatus.BAD_REQUEST,"Reg No already exists");

            return regNo;
    }
}

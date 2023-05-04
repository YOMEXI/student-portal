package schoolportalapi.portal.service;


import schoolportalapi.portal.payload.faculty.FacultyRequestDto;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;

import java.util.List;

public interface FacultyService {
        FacultyResponseDto createFaculty(FacultyRequestDto facultyRequestDto);

      List <FacultyResponseDto> AllFaculties();
}

package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import schoolportalapi.portal.payload.faculty.FacultyRequestDto;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;
import schoolportalapi.portal.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculty")
public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @PostMapping("/create")
    public FacultyResponseDto createFaculty(@Validated @RequestBody FacultyRequestDto facultyRequestDto){
        return facultyService.createFaculty(facultyRequestDto);
    }

    @GetMapping()
    public List<FacultyResponseDto> getAllFaculties(){
        return facultyService.AllFaculties();
    }
}

package schoolportalapi.portal.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolportalapi.portal.entities.Faculty;
import schoolportalapi.portal.payload.faculty.FacultyRequestDto;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;
import schoolportalapi.portal.repository.FacultyRepository;
import schoolportalapi.portal.service.FacultyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public FacultyResponseDto createFaculty(FacultyRequestDto facultyRequestDto) {


        Faculty newFaculty = new Faculty();
        newFaculty.setFacultyName(facultyRequestDto.getFacultyName());
        newFaculty.setFacultyCode(facultyRequestDto.getFacultyCode());

        List departmentList =new ArrayList();

        newFaculty.setDepartments(departmentList);

        facultyRepository.save(newFaculty);


        return modelMapper.map(newFaculty, FacultyResponseDto.class);
    }

    @Override
    public List<FacultyResponseDto> AllFaculties() {

       List <Faculty> allFaculties = facultyRepository.findAll();
        var mappedFaculties=allFaculties.stream()
                .map(faculty -> modelMapper.map(faculty, FacultyResponseDto.class))
                .collect(Collectors.toList());

        return  mappedFaculties;
    }
}

package schoolportalapi.portal.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import schoolportalapi.portal.entities.Department;
import schoolportalapi.portal.entities.Faculty;
import schoolportalapi.portal.exception.CustomApiException;
import schoolportalapi.portal.payload.department.DepartmentRequestDto;
import schoolportalapi.portal.payload.department.DepartmentResponseDto;
import schoolportalapi.portal.payload.faculty.FacultyRequestDto;
import schoolportalapi.portal.payload.faculty.FacultyResponseDto;
import schoolportalapi.portal.repository.DepartmentRepository;
import schoolportalapi.portal.repository.FacultyRepository;
import schoolportalapi.portal.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    FacultyRepository facultyRepository;
    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {
        Department newDepartment = new Department();
        newDepartment.setDepartmentName(departmentRequestDto.getDepartmentName());
        newDepartment.setDepartmentCode(departmentRequestDto.getDepartmentCode());


       Optional<Faculty> departmentFaculty = facultyRepository.findById(departmentRequestDto.getFacultyId());
        newDepartment.setFaculty(departmentFaculty.get());


        if (departmentFaculty.isEmpty())
                throw new CustomApiException(HttpStatus.BAD_REQUEST,"Faculty does not exist");

        departmentRepository.save(newDepartment);


        return modelMapper.map(newDepartment, DepartmentResponseDto.class);
    }

    @Override
    public List<DepartmentResponseDto> AllDepartments() {

        List<Department> allDepartments =departmentRepository.findAll();

        var mappedDepartments= allDepartments.stream()
                .map(department -> modelMapper.map(department, DepartmentResponseDto.class))
                .collect(Collectors.toList());

        return mappedDepartments ;
    }
}

package schoolportalapi.portal.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import schoolportalapi.portal.entities.Role;
import schoolportalapi.portal.payload.auth.RoleRequestDto;
import schoolportalapi.portal.payload.auth.RoleResponseDto;
import schoolportalapi.portal.repository.RoleRepository;
import schoolportalapi.portal.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public RoleResponseDto createRole( RoleRequestDto roleRequestDto) {

        Role newRole=new Role();
        newRole.setName(roleRequestDto.getName());
        System.out.println(roleRequestDto);
        roleRepository.save(newRole);

        return modelMapper.map(newRole, RoleResponseDto.class);
    }
}

package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolportalapi.portal.payload.auth.RoleRequestDto;
import schoolportalapi.portal.payload.auth.RoleResponseDto;
import schoolportalapi.portal.service.RoleService;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    private RoleResponseDto createRole(RoleRequestDto roleRequestDto){
        return roleService.createRole(roleRequestDto);
    }
}

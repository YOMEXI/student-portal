package schoolportalapi.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import schoolportalapi.portal.payload.auth.RoleRequestDto;
import schoolportalapi.portal.payload.auth.RoleResponseDto;
import schoolportalapi.portal.service.RoleService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/role")
@PreAuthorize("hasAnyRole('SUPERUSER')")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/create")
    private RoleResponseDto createRole(@RequestBody RoleRequestDto roleRequestDto){

        return roleService.createRole(roleRequestDto);
    }
}

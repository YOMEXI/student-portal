package schoolportalapi.portal.service;

import schoolportalapi.portal.payload.auth.RoleRequestDto;
import schoolportalapi.portal.payload.auth.RoleResponseDto;

public interface RoleService {
    RoleResponseDto createRole(RoleRequestDto roleRequestDto);
}

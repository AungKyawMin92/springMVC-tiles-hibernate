package mm.com.proj1.service;

import java.util.List;
import java.util.Map;

import mm.com.proj1.dto.ProcessResponse;
import mm.com.proj1.dto.UserDTO;
import mm.com.proj1.dto.UserRoleDTO;


public interface UserService {

	List<UserDTO> checkAuth(UserDTO loginDto);

	List<UserRoleDTO> getAllRole();

	ProcessResponse manageUser(UserDTO userDto);

	List<UserDTO> userSearch(UserDTO userDto);

	Map<Long, String> getAllRoleMap();

	UserDTO getById(long parseLong);

}

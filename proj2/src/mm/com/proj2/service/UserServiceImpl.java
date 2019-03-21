package mm.com.proj2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.com.proj2.dto.ProcessResponse;
import mm.com.proj2.dto.ProcessResponse.ReturnType;
import mm.com.proj2.dto.UserDTO;
import mm.com.proj2.dto.UserRoleDTO;
import mm.com.proj2.entity.User;
import mm.com.proj2.entity.UserRole;
import mm.com.proj2.reposity.UserDao;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	private final Logger log = LogManager.getLogger(this.getClass());
	@Autowired UserDao userDao;

	@Override
	public List<UserDTO> checkAuth(UserDTO loginDto) {
	
		List<User> userList = userDao.checkAuth(loginDto);
		List<UserDTO> userDtoList = new ArrayList<>();
		for(User user : userList){
			userDtoList.add(new UserDTO(user));
		}
		return userDtoList;
	}

	@Override
	public List<UserRoleDTO> getAllRole() {
		List<UserRole> roleList = userDao.getAllRole();
		List<UserRoleDTO> roleDtoList = new ArrayList<>();
		for(UserRole role : roleList){
			roleDtoList.add(new UserRoleDTO(role));
		}
		return roleDtoList;
	}

	@Override
	public ProcessResponse manageUser(UserDTO userDto) {
		try{
			UserRole userRole = new UserRole();
			userRole.setId(Integer.parseInt(userDto.getUserRoleId()+""));
			User user = new User(Integer.parseInt(userDto.getUserId()+""),userDto.getUserName(), userDto.getUserPassword(),userRole, userDto.getLoginName());
			userDto.setUserId(Long.parseLong(userDao.manageUser(user)+""));
			return null;
		}catch(Exception e){
			log.error(ExceptionUtils.getStackTrace(e));
			return new ProcessResponse(ReturnType.SAVE_FAIL);
		}
	}

	@Override
	public List<UserDTO> userSearch(UserDTO userDto) {
		List<User> userList = userDao.searchUser(userDto);
		List<UserDTO> userDtoList = new ArrayList<>();
		for(User user : userList){
			userDtoList.add(new UserDTO(user));
		}
		return userDtoList;
	}

	@Override
	public Map<Long, String> getAllRoleMap() {
		List<UserRole> roleList = userDao.getAllRole();
		Map<Long, String> roleMap = new HashMap<Long, String>();
		for(UserRole role : roleList){
			roleMap.put(Long.parseLong(role.getId()+""), role.getName());
		}
		return roleMap;
	}

	@Override
	public UserDTO getById(long id) {
		User u = userDao.getById(id);
		return new UserDTO(u);
	}

}

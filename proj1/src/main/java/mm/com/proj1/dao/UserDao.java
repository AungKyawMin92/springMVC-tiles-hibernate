package mm.com.proj1.dao;

import java.util.List;

import mm.com.proj1.dto.UserDTO;
import mm.com.proj1.entity.User;
import mm.com.proj1.entity.UserRole;


public interface UserDao {

	List<User> checkAuth(UserDTO loginDto);

	List<UserRole> getAllRole();

	Long manageUser(User user);

	List<User> searchUser(UserDTO userDto);

	User getById(long id);

}

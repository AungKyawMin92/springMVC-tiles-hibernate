package mm.com.proj2.reposity;

import java.util.List;

import mm.com.proj2.dto.UserDTO;
import mm.com.proj2.entity.User;
import mm.com.proj2.entity.UserRole;

public interface UserDao {

	List<User> checkAuth(UserDTO loginDto);

	List<UserRole> getAllRole();

	Integer manageUser(User user);

	List<User> searchUser(UserDTO userDto);

	User getById(long id);

}

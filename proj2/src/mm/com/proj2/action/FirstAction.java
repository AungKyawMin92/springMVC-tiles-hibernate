package mm.com.proj2.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mm.com.proj2.dto.UserDTO;
import mm.com.proj2.service.UserService;

public class FirstAction extends ActionSupport{

	@Autowired
	private UserService userService;
	
	private UserDTO userDto;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session=request.getSession();
	
	public String insertagency()
	{
		userDto = new UserDTO();
			
		return SUCCESS;
	}
	public String chkLogin()
	{		
		List<UserDTO> userAuthList = userService.checkAuth(userDto);
		if(userAuthList.size() > 0){
			session.setAttribute("uid", userAuthList.get(0).getUserId());
			session.setAttribute("logInUserName", userAuthList.get(0).getLoginName());
			return SUCCESS;
		}
		else{
			return "login";
		}
	}
	public UserDTO getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDTO userDto) {
		this.userDto = userDto;
	}
	
	
	
}

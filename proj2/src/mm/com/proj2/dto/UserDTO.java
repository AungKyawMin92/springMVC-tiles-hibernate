package mm.com.proj2.dto;

import java.io.Serializable;

import mm.com.proj2.entity.User;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 2660216976010244505L;
	
	private Long userId;
	private String userName;
	private String userPassword;
	private String loginName;
	private Long userRoleId;
	private String userRoleDesc;
	
		
	public UserDTO() {
		
	}
		
	public UserDTO(User user) {	
		userId = Long.parseLong(user.getId()+"");
		userName = user.getName();
		userPassword = user.getPassword();
		loginName = user.getLoginName();
		userRoleId = user.getRole() == null ? 0L : Long.parseLong(user.getRole().getId()+"");
		userRoleDesc = "";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleDesc() {
		return userRoleDesc;
	}

	public void setUserRoleDesc(String userRoleDesc) {
		this.userRoleDesc = userRoleDesc;
	}




}

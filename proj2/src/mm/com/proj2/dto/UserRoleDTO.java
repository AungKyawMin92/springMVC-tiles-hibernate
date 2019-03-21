package mm.com.proj2.dto;

import java.io.Serializable;

import mm.com.proj2.entity.UserRole;

public class UserRoleDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2178715141215274186L;
	private Long userRoleId;
	private String userRoleName;
	public UserRoleDTO() {
		super();
	}
	public UserRoleDTO(Long userRoleId, String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}
	public UserRoleDTO(UserRole userRole) {
		userRoleId = Long.parseLong(userRole.getId()+"");
		userRoleName = userRole.getName();
	}
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
}

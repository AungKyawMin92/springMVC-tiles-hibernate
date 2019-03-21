package mm.com.proj2.entity;

import java.io.Serializable;


public class User implements Serializable{


	private static final long serialVersionUID = -7263929073553702421L;
	
	private Integer id;
	
	private String name;
	
	
	private String loginName;
	
	private String password;
	
	private UserRole role;

	public User() {
	}	

	public User(Integer id, String name, String password, UserRole role, String loginName) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.loginName = loginName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}



}

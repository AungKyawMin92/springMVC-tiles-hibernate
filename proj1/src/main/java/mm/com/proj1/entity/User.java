package mm.com.proj1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User implements Serializable{


	private static final long serialVersionUID = -7263929073553702421L;
	
	@Id
    @GeneratedValue
	@Column(name="Id")
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	
	@Column(name="LoginName")
	private String loginName;
	
	@Column(name="Password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="User_Role_Id", nullable= false)
	private UserRole role;

	public User() {
	}	

	public User(Long id, String name, String password, UserRole role, String loginName) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.loginName = loginName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

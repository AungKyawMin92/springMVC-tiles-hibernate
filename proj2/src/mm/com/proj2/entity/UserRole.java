package mm.com.proj2.entity;

import java.io.Serializable;

public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8082424172599527058L;
	
	private Integer id;
	private String name;

	public UserRole() {
	}
	public UserRole(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}

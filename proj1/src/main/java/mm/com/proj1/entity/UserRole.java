package mm.com.proj1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Role")
public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8082424172599527058L;
	
	@Id
    @GeneratedValue
	@Column(name="Id")
	private Long id;
	
	@Column(name="Name")
	private String name;

	public UserRole() {
	}
	public UserRole(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}

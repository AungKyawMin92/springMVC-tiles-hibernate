package mm.com.proj2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerType")
public class CustomerType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7928443963158697656L;
	
	@Id
    @GeneratedValue
	@Column(name="Id")
	private Long id;
	
	@Column(name="Name")
	private String name;

	public CustomerType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerType(Long id, String name) {
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

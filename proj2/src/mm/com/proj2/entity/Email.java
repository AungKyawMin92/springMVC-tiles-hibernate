package mm.com.proj2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="email")
public class Email implements Serializable{


	private static final long serialVersionUID = -7263929073553702421L;
	
	@Id
    @GeneratedValue
	@Column(name="Id")
	private Long id;
	
	@Column(name="To_Email")
	private String toEmail;
	
	
	@Column(name="Description")
	private String description;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getToEmail() {
		return toEmail;
	}


	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}

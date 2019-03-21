package mm.com.proj1.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3181556908860139538L;
	private Long id;
	private String toEmail;
	private String description;
	public EmailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailDTO(Long id, String toEmail, String description) {
		super();
		this.id = id;
		this.toEmail = toEmail;
		this.description = description;
	}
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

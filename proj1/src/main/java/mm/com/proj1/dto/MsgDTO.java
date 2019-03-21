package mm.com.proj1.dto;

import java.io.Serializable;

public class MsgDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6193797398756621027L;

	private String receiver;
	private String message;
	
	public MsgDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MsgDTO(String receiver, String message) {
		super();
		this.receiver = receiver;
		this.message = message;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

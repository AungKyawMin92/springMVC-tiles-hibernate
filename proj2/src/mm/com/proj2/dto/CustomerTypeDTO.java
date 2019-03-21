package mm.com.proj2.dto;

import java.io.Serializable;

import mm.com.proj2.entity.CustomerType;

public class CustomerTypeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4693190419676611399L;
	private Long customerTypeId;
	private String customerTypeName;
	public CustomerTypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerTypeDTO(Long customerTypeId, String customerTypeName) {
		super();
		this.customerTypeId = customerTypeId;
		this.customerTypeName = customerTypeName;
	}
	public CustomerTypeDTO(CustomerType customerType) {
		super();
		customerTypeId = customerType.getId();
		customerTypeName = customerType.getName();
	}
	public Long getCustomerTypeId() {
		return customerTypeId;
	}
	public void setCustomerTypeId(Long customerTypeId) {
		this.customerTypeId = customerTypeId;
	}
	public String getCustomerTypeName() {
		return customerTypeName;
	}
	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}
}

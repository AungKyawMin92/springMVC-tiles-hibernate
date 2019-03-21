package mm.com.proj2.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mm.com.proj2.entity.Customer;

public class CustomerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4246774743057946633L;
	
	private Long customerId;
	private String customerName;
	private String customerPhNo;
	private String customerAddress;
	
	private List<CustomerTypeDTO> customerTypeList = new ArrayList<>();
	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(Long customerId, String customerName, String customerPhNo, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhNo = customerPhNo;
		this.customerAddress = customerAddress;
	}
	public CustomerDTO(Customer customer) {
		super();
		customerId = customer.getId();
		customerName = customer.getName();
		customerPhNo = customer.getPhNo();
		customerAddress = customer.getAddress();
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhNo() {
		return customerPhNo;
	}
	public void setCustomerPhNo(String customerPhNo) {
		this.customerPhNo = customerPhNo;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public List<CustomerTypeDTO> getCustomerTypeList() {
		return customerTypeList;
	}
	public void setCustomerTypeList(List<CustomerTypeDTO> customerTypeList) {
		this.customerTypeList = customerTypeList;
	}
	
}

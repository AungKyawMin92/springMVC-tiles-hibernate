package mm.com.proj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mm.com.proj1.dto.CustomerDTO;
import mm.com.proj1.dto.CustomerTypeDTO;
import mm.com.proj1.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customerManage",method = RequestMethod.GET)
	public String userManageForm(Model model){
		List<CustomerTypeDTO> customerTypeList = customerService.getAllCustomerType();
		model.addAttribute("customerForm", new CustomerDTO());
		model.addAttribute("customerTypelist", customerTypeList);
		return "admin/customerManage";
	}
	@RequestMapping(value="/customerManage",method = RequestMethod.POST)
	public String userManage(@ModelAttribute("CustomerForm") CustomerDTO customerDto, Model model){
		
		
		
		List<CustomerTypeDTO> customerTypeList = customerService.getAllCustomerType();
		model.addAttribute("customerForm", new CustomerDTO());
		model.addAttribute("customerTypelist", customerTypeList);
		return "admin/customerManage";
	}

}

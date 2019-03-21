package mm.com.proj1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mm.com.proj1.dao.CustomerDao;
import mm.com.proj1.dto.CustomerTypeDTO;
import mm.com.proj1.entity.CustomerType;

@Transactional
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<CustomerTypeDTO> getAllCustomerType() {
		List<CustomerType> customerTypeList = customerDao.getCustomerTypeAll();
		List<CustomerTypeDTO> customerTypeDtoList = new ArrayList<>();
		for(CustomerType c : customerTypeList){
			customerTypeDtoList.add(new CustomerTypeDTO(c));
		}
		return customerTypeDtoList;
	}

	
}

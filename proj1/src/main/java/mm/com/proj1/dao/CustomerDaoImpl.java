package mm.com.proj1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mm.com.proj1.entity.CustomerType;

@Transactional
@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerType> getCustomerTypeAll() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(CustomerType.class);
		return c.list();
	}

}

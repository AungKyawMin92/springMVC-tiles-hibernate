package mm.com.proj2.reposity;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mm.com.proj2.entity.CustomerType;

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

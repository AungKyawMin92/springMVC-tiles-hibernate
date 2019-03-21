package mm.com.proj2.reposity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mm.com.proj2.dto.UserDTO;
import mm.com.proj2.entity.User;
import mm.com.proj2.entity.UserRole;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> checkAuth(UserDTO loginDto) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(User.class);		
		c.add(Restrictions.eq("loginName", loginDto.getLoginName()));	
		c.add(Restrictions.eq("password", loginDto.getUserPassword()));
		return c.list();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRole> getAllRole() {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(UserRole.class);		
		return c.list();	
	}

	@Override
	public Integer manageUser(User user) {
		 this.sessionFactory.getCurrentSession().saveOrUpdate(user);
		 return user.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchUser(UserDTO userDto) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		c.createAlias("role", "role");
		if(StringUtils.isNotBlank(userDto.getUserName()))
			c.add(Restrictions.like("name", userDto.getUserName()));
		if(userDto.getUserRoleId() > 0)
			c.add(Restrictions.like("role.id", userDto.getUserRoleId()));
		return c.list();
	}

	@Override
	public User getById(long id) {
		Criteria c = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		c.createAlias("role", "role");
		c.add(Restrictions.eq("id", id));
		return (User) c.uniqueResult();
	}

}

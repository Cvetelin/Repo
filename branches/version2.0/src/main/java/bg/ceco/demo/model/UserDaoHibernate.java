package bg.ceco.demo.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoHibernate implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.UserDao#load(long)
	 */

	@Override
	public User load(long id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	@Override
	public User get(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.UserDao#save(bg.ceco.demo.model.User)
	 */

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.UserDao#update(bg.ceco.demo.model.User)
	 */

	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.UserDao#delete(bg.ceco.demo.model.User)
	 */

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.UserDao#list()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> user = crit.list();
		return user;
	}

}

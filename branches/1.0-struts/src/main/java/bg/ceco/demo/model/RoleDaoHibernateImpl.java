package bg.ceco.demo.model;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class RoleDaoHibernateImpl extends HibernateDaoSupport implements
	RoleDao {

    public void delete(Role role) {
	getHibernateTemplate().delete(role);
    }

    public Role load(long id) {
	return (Role) getHibernateTemplate().load(Role.class, id);
    }

    public void save(Role role) {
	getHibernateTemplate().save(role);
    }

    public void update(Role role) {
	getHibernateTemplate().update(role);
    }

    public Collection list() {
	return (Collection) getHibernateTemplate().execute(
		new HibernateCallback() {
		    public Object doInHibernate(Session session)
			    throws HibernateException, SQLException {
			return session.createCriteria(Role.class).list();
		    }
		});
    }
}

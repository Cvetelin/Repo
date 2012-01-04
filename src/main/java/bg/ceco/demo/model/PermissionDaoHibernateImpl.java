package bg.ceco.demo.model;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class PermissionDaoHibernateImpl extends HibernateDaoSupport implements
		PermissionDao {

	public void delete(Permission permission) {
		getHibernateTemplate().delete(permission);
	}

	public Collection list() {
		return (Collection) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createCriteria(Permission.class).list();
					}
				});
		// return Permission.ALL_PERMISSION_TYPES ;
	}

	public Permission load(long id) {
		return (Permission) getHibernateTemplate().load(Permission.class, id);
	}

	public void save(Permission permission) {
		getHibernateTemplate().save(permission);
	}

	public void update(Permission permission) {
		getHibernateTemplate().update(permission);
	}

}

package bg.ceco.demo.model;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class OrganisationDaoHibernate extends HibernateDaoSupport implements
	OrganisationDao {

    public void delete(Organisation person) {
	getHibernateTemplate().delete(person);
    }

    public <T extends Organisation> T load(long id, Class<T> clazz) {
	return (T) getHibernateTemplate().load(clazz, id);
    }

    public void save(Organisation person) {
	getHibernateTemplate().save(person);
    }

    public void update(Organisation person) {
	getHibernateTemplate().update(person);
    }

    public <T extends Organisation> Collection<T> list(final Class<T> clazz) {
	return (Collection<T>) getHibernateTemplate().execute(
		new HibernateCallback() {
		    public Object doInHibernate(Session session)
			    throws HibernateException, SQLException {
			return session.createCriteria(clazz).list();
		    }
		});
    }
    
    public Collection<Departement> listDepsWithInactiveServices() {
	return getSession().createCriteria(Departement.class).createAlias("services", "service").add(Restrictions.eq("service.actif", true)).list();
    }
}


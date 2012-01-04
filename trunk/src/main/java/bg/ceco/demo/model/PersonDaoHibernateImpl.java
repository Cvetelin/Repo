package bg.ceco.demo.model;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class PersonDaoHibernateImpl extends HibernateDaoSupport implements
	PersonDao {

    public void delete(Person person) {
	getHibernateTemplate().delete(person);
    }

    public Person load(long id) {
	return (Person) getHibernateTemplate().load(Person.class, id);
    }

    public void save(Person person) {
	getHibernateTemplate().save(person);
    }

    public void update(Person person) {
	getHibernateTemplate().update(person);
    }

    public Collection list() {
	return (Collection) getHibernateTemplate().execute(
		new HibernateCallback() {
		    public Object doInHibernate(Session session)
			    throws HibernateException, SQLException {
			return session.createCriteria(Person.class).list();
		    }
		});
    }
}

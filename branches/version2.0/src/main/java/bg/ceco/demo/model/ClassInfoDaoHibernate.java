package bg.ceco.demo.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassInfoDaoHibernate   implements ClassInfoDao{
	
@Autowired
private SessionFactory sessionFactory;
		
	public ClassInfo load(long id) {
		return (ClassInfo) sessionFactory.getCurrentSession().load(ClassInfo.class, id);
	
	}

	
	public void save(ClassInfo testClassDirInfo) {
		sessionFactory.getCurrentSession().save(testClassDirInfo);
		
	}

	
	public void update(ClassInfo testClassDirInfo) {
		sessionFactory.getCurrentSession().update(testClassDirInfo);
		
	}

	
	public void delete(ClassInfo testClassDirInfo) {
		sessionFactory.getCurrentSession().delete(testClassDirInfo);
		
	}

	
	public List<ClassInfo> list() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassInfo.class);
		List<ClassInfo> clients = crit.list();
		return clients;
	}
	
}

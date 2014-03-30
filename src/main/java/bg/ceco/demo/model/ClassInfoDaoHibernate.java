package bg.ceco.demo.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
public class ClassInfoDaoHibernate   implements ClassInfoDao{
	
@Autowired
private SessionFactory sessionFactory;
		
	public ClassInfo load(long id) {
		return (ClassInfo) sessionFactory.getCurrentSession().load(ClassInfo.class, id);
	
	}

	
	public void save(ClassInfo classInfo) {
		sessionFactory.getCurrentSession().save(classInfo);
		
	}

	
	public void update(ClassInfo classInfo) {
		sessionFactory.getCurrentSession().update(classInfo);
		
	}

	
	public void delete(ClassInfo classInfo) {
		sessionFactory.getCurrentSession().delete(classInfo);
		
	}

	@SuppressWarnings("unchecked")
	public List<ClassInfo> list() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassInfo.class);
		List<ClassInfo> classInfo = crit.list();
		return classInfo;
	}
	
	@SuppressWarnings("unchecked")
	public List<ClassInfo> listBy(long projectId) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassInfo.class)
				.add(Restrictions.eq("projectId", projectId));		
		List<ClassInfo> classInfo = crit.list();
		return classInfo;
	}
	
	@Override
	public ClassInfo loadBy(String qualifiedName) {
		return (ClassInfo) sessionFactory.getCurrentSession().createCriteria(ClassInfo.class)
			.add(Restrictions.eq("qualifiedName", qualifiedName)).uniqueResult();
	}
	
	@Override
	public void saveAll(List<ClassInfo> element) throws Exception {
        for (int i = 0; i < element.size(); i++) {
	        	sessionFactory.getCurrentSession().save(element.get(i));
	            sessionFactory.getCurrentSession().flush();
	            sessionFactory.getCurrentSession().clear();
	      }
	}
	
}

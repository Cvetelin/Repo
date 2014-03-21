package bg.ceco.demo.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public ClassInfo loadBy(String qualifiedName) {
		return (ClassInfo) sessionFactory.getCurrentSession().createCriteria(ClassInfo.class)
			.add(Restrictions.eq("qualifiedName", qualifiedName)).uniqueResult();
	}
	
}

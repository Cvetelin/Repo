package bg.ceco.demo.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassInfoDaoHibernate implements ClassInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ClassInfo load(long id) {
		return (ClassInfo) sessionFactory.getCurrentSession().load(ClassInfo.class, id);
	}

	@Override
	public ClassInfo get(long id) {
		return (ClassInfo) sessionFactory.getCurrentSession().get(ClassInfo.class, id);
	}

	@Override
	public void save(ClassInfo classInfo) {
		sessionFactory.getCurrentSession().save(classInfo);
	}

	@Override
	public void update(ClassInfo classInfo) {
		sessionFactory.getCurrentSession().update(classInfo);
	}

	@Override
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
	@Override
	public List<ClassInfo> listBy(Project project) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassInfo.class).add(Restrictions.eq("project", project));
		List<ClassInfo> classInfo = crit.list();
		return classInfo;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ClassInfo> loadBy(String qualifiedName) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassInfo.class)
				.add(Restrictions.eq("qualifiedName", qualifiedName));
		List<ClassInfo> classInfo = crit.list();
		return classInfo;
	}

	@Override
	public ClassInfo loadBy(Project project, String qualifiedName) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassInfo.class).add(Restrictions.eq("project", project))
				.add(Restrictions.eqOrIsNull("qualifiedName", qualifiedName));
		ClassInfo classInfo = (ClassInfo) crit.uniqueResult();
		return classInfo;
	}

	@Override
	public void saveAll(List<ClassInfo> element) throws Exception {
		for (int i = 0; i < element.size(); i++) {
			sessionFactory.getCurrentSession().save(element.get(i));
		}
	}
}

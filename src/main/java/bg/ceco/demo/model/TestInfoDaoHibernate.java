package bg.ceco.demo.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestInfoDaoHibernate implements TestInfoDao {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.TestInfoDao#load(long)
	 */
	@Override
	public TestInfo load(long id) {
		return (TestInfo) sessionFactory.getCurrentSession().load(TestInfo.class, id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.TestInfoDao#save(bg.ceco.demo.model.TestInfo)
	 */
	@Override
	public void save(TestInfo testInfo) {
		sessionFactory.getCurrentSession().save(testInfo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.TestInfoDao#update(bg.ceco.demo.model.TestInfo)
	 */
	@Override
	public void update(TestInfo testInfo) {
		sessionFactory.getCurrentSession().update(testInfo);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.TestInfoDao#delete(bg.ceco.demo.model.TestInfo)
	 */
	@Override
	public void delete(TestInfo testInfo) {
		sessionFactory.getCurrentSession().delete(testInfo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.TestInfoDao#list()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TestInfo> list() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(TestInfo.class);
		List<TestInfo> testinfo = crit.list();
		return testinfo;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TestInfo> listBy(ClassInfo classInfo) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(TestInfo.class).add(Restrictions.eq("classInfo", classInfo));
		List<TestInfo> testInfo = crit.list();
		return testInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.model.TestInfoDao#listBy(long)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TestInfo> listBy(long classId) {
		return (List<TestInfo>) sessionFactory.getCurrentSession().createCriteria(TestInfo.class).add(Restrictions.eq("classId", classId))
				.list();
	}

	@Override
	public void saveAll(List<TestInfo> element) {
		for (int i = 0; i < element.size(); i++) {
			sessionFactory.getCurrentSession().save(element.get(i));
		}
	}

	@Override
	public TestInfo loadBy(ClassInfo classInfo, String methodName) {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(TestInfo.class).add(Restrictions.eq("classInfo", classInfo))
				.add(Restrictions.eqOrIsNull("name", methodName));
		TestInfo testInfo = (TestInfo) crit.uniqueResult();
		return testInfo;
	}
}

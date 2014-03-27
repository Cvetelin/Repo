package bg.ceco.demo.model;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PojectDaoHibernate implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#load(long)
	 */
	@Override
	public Project load(long id) {
		return (Project) sessionFactory.getCurrentSession().load(Project.class, id);
	
	}
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#load(long)
	 */
	@Override
	public Project get(long id) {
		return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
	
	}

	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#save(bg.ceco.demo.model.Project)
	 */
	@Override
	public void save(Project project) {
		sessionFactory.getCurrentSession().save(project);
		
	}

	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#update(bg.ceco.demo.model.Project)
	 */
	@Override
	public void update(Project project) {
		sessionFactory.getCurrentSession().update(project);
		
	}

	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#delete(bg.ceco.demo.model.Project)
	 */
	@Override
	public void delete(Project project) {
		sessionFactory.getCurrentSession().delete(project);
		
	}
		
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#removeBy(long)
	 */
	@Override
	public void removeBy(long id) {
	Session session = sessionFactory.getCurrentSession();

	Project jar = (Project) session.get(Project.class, id);

	session.delete(jar);
	}

	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#list()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Project> list() {
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(Project.class);
		List<Project> project = crit.list();
		return project;
	}
	
		
	/* (non-Javadoc)
	 * @see bg.ceco.demo.model.ProjectDao#loadBy(java.lang.String)
	 */
	@Override
	public Project loadBy(String name) {
		return (Project) sessionFactory.getCurrentSession().createCriteria(Project.class)
			.add(Restrictions.eq("name", name)).uniqueResult();
	}
	
}

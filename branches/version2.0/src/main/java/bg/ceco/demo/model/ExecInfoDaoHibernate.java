package bg.ceco.demo.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ExecInfoDaoHibernate implements ExecInfoDao {

	@Autowired
	private SessionFactory sessionFactory;
			
	
		/* (non-Javadoc)
		 * @see bg.ceco.demo.model.ExecInfoDao#load(long)
		 */
		@Override
		public ExecInfo load(long id) {
			return (ExecInfo) sessionFactory.getCurrentSession().load(ExecInfo.class, id);
		
		}		
	
		/* (non-Javadoc)
		 * @see bg.ceco.demo.model.ExecInfoDao#save(bg.ceco.demo.model.ExecInfo)
		 */
		@Override	
		public void save(ExecInfo execInfo) {
			sessionFactory.getCurrentSession().save(execInfo);			
		}
	
		/* (non-Javadoc)
		 * @see bg.ceco.demo.model.ExecInfoDao#update(bg.ceco.demo.model.ExecInfo)
		 */
		@Override		
		public void update(ExecInfo execInfo) {
			sessionFactory.getCurrentSession().update(execInfo);			
		}

		
		/* (non-Javadoc)
		 * @see bg.ceco.demo.model.ExecInfoDao#delete(bg.ceco.demo.model.ExecInfo)
		 */
		@Override	
		public void delete(ExecInfo execInfo) {
			sessionFactory.getCurrentSession().delete(execInfo);			
		}

	
		/* (non-Javadoc)
		 * @see bg.ceco.demo.model.ExecInfoDao#list()
		 */
		@Override		
		@SuppressWarnings("unchecked")
		public List<ExecInfo> list() {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(ExecInfo.class);
			List<ExecInfo> execInfo = crit.list();
			return execInfo;
		}
		
		
		/* (non-Javadoc)
		 * @see bg.ceco.demo.model.ExecInfoDao#listBy(long)
		 */
		@Override
		@SuppressWarnings("unchecked")
		public List<ExecInfo> listBy(TestInfo testInfo) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(ExecInfo.class)
					.add(Restrictions.eq("testInfo", testInfo));		
			List<ExecInfo> execInfo = crit.list();
			return execInfo;
		}
		

		@Override
		@SuppressWarnings("unchecked")
		public List<ExecInfo> listByExecDateDesc(TestInfo testInfo) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(ExecInfo.class)
					.add(Restrictions.eq("testInfo", testInfo)).addOrder(Order.desc("executionDate"));		
			List<ExecInfo> execInfo = crit.list();
			return execInfo;
		}


}

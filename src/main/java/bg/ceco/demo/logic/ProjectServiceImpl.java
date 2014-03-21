package bg.ceco.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bg.ceco.demo.model.Project;
import bg.ceco.demo.model.ProjectDao;

@Component
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ProjectService#list()
	 */
	
	@Override
	public List<Project> list() {
		return projectDao.list();
	}
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ProjectService#load(long)
	 */
	@Override
	public Project load(long id) {
		return projectDao.load(id);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ProjectService#save(bg.ceco.demo.model.Project)
	 */

	@Override
	public void save(Project project) {
		projectDao.save(project);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ProjectService#update(bg.ceco.demo.model.Project)
	 */

	@Override
	public void update(Project project) {
		projectDao.update(project);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ProjectService#delete(bg.ceco.demo.model.Project)
	 */

	@Override
	public void delete(Project project) {
		projectDao.delete(project);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ProjectService#loadBy(java.lang.String)
	 */

	@Override
	public Project loadBy(String jarName) {
		return projectDao.loadBy(jarName);
	}
}

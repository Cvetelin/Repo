package bg.ceco.demo.logic;

import java.util.List;
import bg.ceco.demo.model.Project;

public interface ProjectService {

	public abstract List<Project> list();

	public abstract Project load(long id);

	public abstract void save(Project project);

	public abstract void update(Project project);

	public abstract void delete(Project project);

	public abstract Project loadBy(String jarName);

	public abstract Project get(long id);

}
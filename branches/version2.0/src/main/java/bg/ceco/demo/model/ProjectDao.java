package bg.ceco.demo.model;

import java.util.List;

public interface ProjectDao {

	public abstract Project load(long id);

	public abstract void save(Project project);

	public abstract void update(Project project);

	public abstract void delete(Project project);

	public abstract void removeBy(long id);

	@SuppressWarnings("unchecked")
	public abstract List<Project> list();

	public abstract Project loadBy(String name);

}
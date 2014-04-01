package bg.ceco.demo.logic;

import java.util.List;

import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.Project;

public interface ClassInfoService {

	public abstract List<ClassInfo> list();

	public abstract List<ClassInfo> listBy(Project project);

	public abstract ClassInfo load(long id);

	public abstract void save(ClassInfo classInfo);

	public abstract void update(ClassInfo classInfo);

	public abstract void delete(ClassInfo classInfo);

	public abstract List<ClassInfo> loadBy(String qualifiedName);

	public abstract void saveAll(List<ClassInfo> classInfo) throws Exception;

	public abstract ClassInfo loadBy(Project project, String qualifiedName);

}
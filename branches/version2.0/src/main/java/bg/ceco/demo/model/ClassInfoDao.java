package bg.ceco.demo.model;

import java.util.List;

public interface ClassInfoDao {

	public ClassInfo load(long id);

	public void save(ClassInfo testClassDirInfo);

	public void update(ClassInfo testClassDirInfo);

	public void delete(ClassInfo testClassDirInfo);

	public List<ClassInfo> list();

	public List<ClassInfo> listBy(Project project);

	public List<ClassInfo> loadBy(String qualifiedName);

	void saveAll(List<ClassInfo> element) throws Exception;

	public ClassInfo loadBy(Project project, String qualifiedName);
}

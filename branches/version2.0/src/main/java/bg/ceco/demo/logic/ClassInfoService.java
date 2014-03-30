package bg.ceco.demo.logic;

import java.util.List;

import bg.ceco.demo.model.ClassInfo;

public interface ClassInfoService {

	public abstract List<ClassInfo> list();
	
	public abstract List<ClassInfo> listBy(long projectId);

	public abstract ClassInfo load(long id);

	public abstract void save(ClassInfo classInfo);

	public abstract void update(ClassInfo classInfo);

	public abstract void delete(ClassInfo classInfo);
	
	public abstract ClassInfo loadBy(String qualifiedName);

	public abstract void saveAll(List<ClassInfo> classInfo) throws Exception;

}
package bg.ceco.demo.model;

import java.util.List;

public interface TestInfoDao {

	public abstract TestInfo load(long id);

	public abstract void save(TestInfo testInfo);

	public abstract void update(TestInfo testInfo);

	public abstract void delete(TestInfo testInfo);

	public abstract List<TestInfo> list();

	public abstract List<TestInfo> listBy(long classId);

	public void saveAll(List<TestInfo> element);

	public abstract List<TestInfo> listBy(ClassInfo classInfo);

	public abstract TestInfo loadBy(ClassInfo classInfo, String methodName);

}
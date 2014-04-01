package bg.ceco.demo.logic;

import java.util.List;

import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.TestInfo;

public interface TestInfoService {

	public abstract List<TestInfo> list();

	public abstract TestInfo load(long id);

	public abstract void save(TestInfo testInfo);

	public abstract void update(TestInfo testInfo);

	public abstract void delete(TestInfo testInfo);

	public abstract void saveAll(List<TestInfo> testInfo);

	public abstract List<TestInfo> listBy(ClassInfo classInfo);

}
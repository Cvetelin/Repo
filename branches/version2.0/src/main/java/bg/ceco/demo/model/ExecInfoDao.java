package bg.ceco.demo.model;

import java.util.List;

public interface ExecInfoDao {

	public abstract ExecInfo load(long id);

	public abstract void save(ExecInfo execInfo);

	public abstract void update(ExecInfo execInfo);

	public abstract void delete(ExecInfo execInfo);
	
	public abstract List<ExecInfo> list();

	public abstract List<ExecInfo> listBy(TestInfo testInfo);

	public abstract List<ExecInfo> listByExecDateDesc(TestInfo testInfo);

}
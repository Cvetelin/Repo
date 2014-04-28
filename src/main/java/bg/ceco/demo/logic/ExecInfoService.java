package bg.ceco.demo.logic;

import java.util.List;
import bg.ceco.demo.model.ExecInfo;
import bg.ceco.demo.model.TestInfo;

public interface ExecInfoService {

	public abstract List<ExecInfo> list();

	public abstract ExecInfo load(long id);

	public abstract void save(ExecInfo execInfoDao);

	public abstract void update(ExecInfo execInfo);

	public abstract void delete(ExecInfo execInfo);

	public abstract List<ExecInfo> listBy(TestInfo testInfo);

	public abstract List<ExecInfo> listByExecDatedesc(TestInfo testInfo);

}
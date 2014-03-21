package bg.ceco.demo.logic;

import java.util.List;
import bg.ceco.demo.model.ExecInfo;

public interface ExecInfoService {

	public abstract List<ExecInfo> list();

	public abstract ExecInfo load(long id);

	public abstract void save(ExecInfo execInfoDao);

	public abstract void update(ExecInfo execInfo);

	public abstract void delete(ExecInfo execInfo);

}
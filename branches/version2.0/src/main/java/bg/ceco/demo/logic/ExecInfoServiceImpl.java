package bg.ceco.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bg.ceco.demo.model.ExecInfo;
import bg.ceco.demo.model.ExecInfoDao;
import bg.ceco.demo.model.TestInfo;

@Component
public class ExecInfoServiceImpl implements ExecInfoService {
	@Autowired
	private ExecInfoDao execInfoDao;

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ExecInfoService#list()
	 */
	
	@Override
	public List<ExecInfo> list() {
		return execInfoDao.list();
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ExecInfoService#load(long)
	 */
	
	@Override
	public ExecInfo load(long id) {
		return execInfoDao.load(id);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ExecInfoService#save(bg.ceco.demo.model.ExecInfoDao)
	 */
	
	@Override
	public void save(ExecInfo execInfo) {
		execInfoDao.save(execInfo);
	}

	
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ExecInfoService#update(bg.ceco.demo.model.ExecInfoDao)
	 */
	
	@Override
	public void update(ExecInfo execInfo) {
		execInfoDao.update(execInfo);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ExecInfoService#delete(bg.ceco.demo.model.ExecInfoDao)
	 */
	
	@Override
	public void delete(ExecInfo execInfo) {
		execInfoDao.delete(execInfo);
	}
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ExecInfoService#list()
	 */
	
	@Override
	public List<ExecInfo> listBy(TestInfo testInfo) {
		return execInfoDao.listBy(testInfo);
	}
}

package bg.ceco.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.model.TestInfo;
import bg.ceco.demo.model.TestInfoDao;
@Component
public class TestInfoServiceImpl implements TestInfoService {

	@Autowired
	private TestInfoDao testInfoDao;


	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.TestInfoService#list()
	 */
	
	@Override
	public List<TestInfo> list() {
		return testInfoDao.list();
	}
	

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.TestInfoService#load(long)
	 */
	
	@Override
	public TestInfo load(long id) {
		return testInfoDao.load(id);
	}

	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.TestInfoService#save(bg.ceco.demo.model.TestInfo)
	 */
	
	@Override
	public void save(TestInfo testInfo) {
		testInfoDao.save(testInfo);
	}

	
	
	@Override
	public void update(TestInfo testInfo) {
		testInfoDao.update(testInfo);
	}


	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.TestInfoService#delete(bg.ceco.demo.model.TestInfo)
	 */

	@Override
	public void delete(TestInfo testInfo) {
		testInfoDao.delete(testInfo);
	}
}
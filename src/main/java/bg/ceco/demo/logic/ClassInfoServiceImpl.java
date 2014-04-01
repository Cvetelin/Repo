package bg.ceco.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.model.ClassInfo;
import bg.ceco.demo.model.ClassInfoDao;
import bg.ceco.demo.model.Project;

@Component
public class ClassInfoServiceImpl implements ClassInfoService {

	@Autowired
	private ClassInfoDao classInfoDao;


	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ClassInfoService#list()
	 */
	@Override
	public List<ClassInfo> list() {
		return classInfoDao.list();
	}
	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ClassInfoService#load(long)
	 */
	@Override
	public ClassInfo load(long id) {
		return classInfoDao.load(id);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ClassInfoService#save(bg.ceco.demo.model.ClassInfo)
	 */
	@Override
	public void save(ClassInfo classInfo) {
		classInfoDao.save(classInfo);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ClassInfoService#update(bg.ceco.demo.model.ClassInfo)
	 */
	@Override
	public void update(ClassInfo classInfo) {
		classInfoDao.update(classInfo);
	}

	
	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ClassInfoService#delete(bg.ceco.demo.model.ClassInfo)
	 */
	@Override
	public void delete(ClassInfo classInfo) {
		classInfoDao.delete(classInfo);
	}

	/* (non-Javadoc)
	 * @see bg.ceco.demo.logic.ClassInfoService#load(long)
	 */
	@Override
	public ClassInfo loadBy(String qualifiedName) {
		return classInfoDao.loadBy(qualifiedName);
	}
	
	
	@Override
	public void saveAll(List<ClassInfo> classInfo) throws Exception {
		classInfoDao.saveAll(classInfo);
	}
	
	@Override
	public List<ClassInfo> listBy(Project project) {
		return classInfoDao.listBy(project);
	}
}

package bg.ceco.demo.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.model.User;
import bg.ceco.demo.model.UserDao;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.logic.UserService#list()
	 */
	@Override
	public List<User> list() {
		return userDao.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.logic.UserService#load(long)
	 */
	@Override
	public User load(long id) {
		return userDao.load(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.logic.UserService#get(long)
	 */
	@Override
	public User get(long id) {
		return userDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.logic.UserService#save(bg.ceco.demo.model.User)
	 */
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.logic.UserService#update(bg.ceco.demo.model.User)
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bg.ceco.demo.logic.UserService#delete(bg.ceco.demo.model.User)
	 */
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
}

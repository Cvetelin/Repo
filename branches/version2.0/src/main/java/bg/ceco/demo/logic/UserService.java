package bg.ceco.demo.logic;

import java.util.List;

import bg.ceco.demo.model.User;

public interface UserService {

	public abstract List<User> list();

	public abstract User load(long id);

	public abstract User get(long id);

	public abstract void save(User user);

	public abstract void update(User user);

	public abstract void delete(User user);

}
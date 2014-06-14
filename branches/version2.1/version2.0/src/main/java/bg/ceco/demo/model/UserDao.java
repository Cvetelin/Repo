package bg.ceco.demo.model;

import java.util.List;

public interface UserDao {

	public abstract User load(long id);

	public abstract User get(long id);

	public abstract void save(User user);

	public abstract void update(User user);

	public abstract void delete(User user);

	public abstract List<User> list();

}
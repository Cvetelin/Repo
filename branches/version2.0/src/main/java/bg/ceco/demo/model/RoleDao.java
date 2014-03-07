package bg.ceco.demo.model;

import java.util.Collection;

public interface RoleDao {
	
	public Role load(long id);
	
	public void save(Role role);
	
	public void update(Role role);
	
	public void delete(Role role);
	
	public Collection list();
}

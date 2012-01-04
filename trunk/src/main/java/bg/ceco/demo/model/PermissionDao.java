package bg.ceco.demo.model;

import java.util.Collection;

public interface PermissionDao {
	
	public Permission load(long id);
	
	public void save(Permission permission);
	
	public void update(Permission permission);
	
	public void delete(Permission permission);
	
	public Collection list();
	
}

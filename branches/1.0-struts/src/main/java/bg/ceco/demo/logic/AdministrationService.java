package bg.ceco.demo.logic;

import java.util.Collection;

import bg.ceco.demo.model.Permission;
import bg.ceco.demo.model.Person;
import bg.ceco.demo.model.Role;

public interface AdministrationService {
	
	public void initRoles();
	
	public void initPermissions();
	
	public Collection<Role> listRoles();
	
	public Person loadPerson(long id);
	
	public void savePerson(Person person);
	
	public Collection<Person> listMembers();

	public Role loadRole(long id);
	
	public Permission loadPermission(long id);
	
	public Collection<Permission> listPermissions();
}

package bg.ceco.demo.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.model.Permission;
import bg.ceco.demo.model.PermissionDao;
import bg.ceco.demo.model.Person;
import bg.ceco.demo.model.PersonDao;
import bg.ceco.demo.model.Role;
import bg.ceco.demo.model.RoleDao;

@Component
public class AdministrationServiceImpl implements AdministrationService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private PermissionDao permissionDao;

	public void initRoles() {
		roleDao.save(new Role(0, "Developer", ""/*, Permission.GUEST*/));
		roleDao.save(new Role(0, "Team leader", ""/*, Permission.GUEST*/));
		roleDao.save(new Role(0, "Quality manager", ""/*, Permission.GUEST*/));
		roleDao.save(new Role(0, "Project manager", ""/*, Permission.GUEST*/));
		roleDao.save(new Role(0, "Architect", ""/*, Permission.GUEST*/));
	}

	public void initPermissions(){
		permissionDao.save(new Permission(Permission.GUEST));
		permissionDao.save(new Permission(Permission.POWER_USER));
		permissionDao.save(new Permission(Permission.ROOT));
	}
	
	public Role loadRole(long id) {
		return roleDao.load(id);
	}
	
	public Permission loadPermission(long id){
		return permissionDao.load(id);
	}

	public Collection<Role> listRoles() {
		return roleDao.list();
	}

	public Person loadPerson(long id) {
		return personDao.load(id);
	}

	public void savePerson(Person person) {
		personDao.save(person);
	}

	public Collection<Person> listMembers() {
		return personDao.list();
	}

	// get all avaialble permissions
	public Collection<Permission> listPermissions() {
		return permissionDao.list();
	}
}

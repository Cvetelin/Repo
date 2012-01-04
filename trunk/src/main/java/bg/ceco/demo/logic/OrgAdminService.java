package bg.ceco.demo.logic;

import java.util.Collection;

import bg.ceco.demo.model.Departement;
import bg.ceco.demo.model.Organisation;

public interface OrgAdminService {
	public void initDepartements();
	
	public Collection<Organisation> listOrganisations();
	
	public <T extends Organisation> T loadOrganisation(long id, Class<T> clazz);
	
	public void saveOrganisation(Organisation org);
	
	public Collection<Departement> listDepsWithInactiveServices();
}

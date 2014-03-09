package bg.ceco.demo.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.model.Departement;
import bg.ceco.demo.model.DepartementImpl;
import bg.ceco.demo.model.Organisation;
import bg.ceco.demo.model.OrganisationDao;
import bg.ceco.demo.model.Service;
import bg.ceco.demo.model.ServiceImpl;

//@Component
public class OrgAdminServiceImpl implements OrgAdminService {
    
 //   @Autowired
    private OrganisationDao orgDao;

    public void initDepartements() {
	Departement dep = new DepartementImpl();
	dep.setActif(true);
	dep.setNom("Marketing");
	orgDao.save(dep);
	
	Service srv = new ServiceImpl();
	srv.setActif(true);
	srv.setNom("Plovdiv");
	srv.setDepartement(dep);
	orgDao.save(srv);
	
	srv = new ServiceImpl();
	srv.setActif(true);
	srv.setNom("4irpan");
	srv.setDepartement(dep);
	orgDao.save(srv);
	
	srv = new ServiceImpl();
	srv.setActif(false);
	srv.setNom("Sevlievo");
	srv.setDepartement(dep);
	orgDao.save(srv);
	
	dep = new DepartementImpl();
	dep.setActif(true);
	dep.setNom("IT");
	orgDao.save(dep);
	
	srv = new ServiceImpl();
	srv.setActif(true);
	srv.setNom("2nd floor");
	srv.setDepartement(dep);
	orgDao.save(srv);
	
	srv = new ServiceImpl();
	srv.setActif(true);
	srv.setNom("4th floor");
	srv.setDepartement(dep);
	orgDao.save(srv);
	
	srv = new ServiceImpl();
	srv.setActif(true);
	srv.setNom("1st floor");
	srv.setDepartement(dep);
	orgDao.save(srv);
    }

	public Collection<Organisation> listOrganisations() {
	    return orgDao.list(Organisation.class);
	}
	
	public <T extends Organisation> T loadOrganisation(long id, Class<T> clazz) {
	    return orgDao.load(id, clazz);
	}
	
	public void saveOrganisation(Organisation org) {
	    orgDao.save(org);
	}
	
	public Collection<Departement> listDepsWithInactiveServices() {
	    return orgDao.listDepsWithInactiveServices();
	}
}

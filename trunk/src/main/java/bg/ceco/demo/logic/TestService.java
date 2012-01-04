package bg.ceco.demo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.ceco.demo.model.Departement;
import bg.ceco.demo.model.DepartementImpl;
import bg.ceco.demo.model.OrganisationDao;
import bg.ceco.demo.model.RoleDao;
import bg.ceco.demo.model.Service;
import bg.ceco.demo.model.ServiceImpl;

@Component
public class TestService {

    @Autowired
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
}

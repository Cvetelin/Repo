//
package bg.ceco.demo.model;

import java.io.Serializable;

/**
 * Abstract entity implementation for ${@link fr.boursorama.crm.domain.base.organisation.Service}
 * 
 * @author andromda
 * @generated canonical
 */
public abstract class AbstractService extends OrganisationImpl implements
	Service, Serializable {

    private static final long serialVersionUID = -6274752934046242686L;

    private Departement departement;

    public Departement getDepartement() {
	return this.departement;
    }

    public void setDepartement(Departement departement) {
	this.departement = departement;
    }
}

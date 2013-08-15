//
package bg.ceco.demo.model;

import java.io.Serializable;

/**
 * Abstract entity implementation for ${@link fr.boursorama.crm.domain.base.organisation.Departement}
 * 
 * @author andromda
 * @generated canonical
 */
public abstract class AbstractDepartement extends OrganisationImpl implements
	Departement, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1171524759168824534L;

    /*
     * Attributes fields
     */

    /*
     * Associations ends fields
     */


    /**
     * 
     * @author andromda
     */
    private java.util.Set services;

    /*
     * Constructor
     */

    /**
     * @author andromda
     */
    public AbstractDepartement() {
	this.services = new java.util.HashSet();
    }

    /*
     * Attributes getters and setters
     */

    /*
     * Associations ends getters and setters
     */

    public java.util.Set getServices() {
	return this.services;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Departement#setServices(${typeName})
     * @author andromda
     */
    public void setServices(java.util.Set services) {
	this.services = services;
    }

}

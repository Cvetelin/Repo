//
package bg.ceco.demo.model;

import java.io.Serializable;

/**
 * Abstract entity implementation for ${@link fr.boursorama.crm.domain.base.organisation.Organisation}
 * 
 * @author andromda
 * @generated canonical
 */
public abstract class AbstractOrganisation implements Organisation,
	Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5894002607463921900L;

    /*
     * Attributes fields
     */

    /**
     * 
     * @author andromda
     */
    private java.lang.Boolean actif;

    /**
     * 
     * @author andromda
     */
    private java.lang.String idReprise;

    /**
     * 
     * @author andromda
     */
    private java.lang.String nom;

    /**
     * 
     * @author andromda
     */
    private java.lang.Long id;

    private String type;

    /**
     * @author andromda
     */
    public AbstractOrganisation() {
    }

    /*
     * Attributes getters and setters
     */

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#getActif()
     * @author andromda
     */
    public java.lang.Boolean getActif() {
	return this.actif;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#setActif(java.lang.Boolean)
     * @author andromda
     */
    public void setActif(java.lang.Boolean actif) {
	this.actif = actif;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#getIdReprise()
     * @author andromda
     */
    public java.lang.String getIdReprise() {
	return this.idReprise;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#setIdReprise(java.lang.String)
     * @author andromda
     */
    public void setIdReprise(java.lang.String idReprise) {
	this.idReprise = idReprise;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#getNom()
     * @author andromda
     */
    public java.lang.String getNom() {
	return this.nom;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#setNom(java.lang.String)
     * @author andromda
     */
    public void setNom(java.lang.String nom) {
	this.nom = nom;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#getId()
     * @author andromda
     */
    public java.lang.Long getId() {
	return this.id;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Organisation#setId(java.lang.Long)
     * @author andromda
     */
    public void setId(java.lang.Long id) {
	this.id = id;
    }

    public String getType() {
	return type;
    }
    
    public void setType(String type) {
	this.type = type;
    }
}

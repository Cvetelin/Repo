//
package bg.ceco.demo.model;

import java.io.Serializable;

/**
 * Abstract entity implementation for ${@link fr.boursorama.crm.domain.base.organisation.Agence}
 * 
 * @author andromda
 * @generated canonical
 */
public abstract class AbstractAgence extends OrganisationImpl implements
	Agence, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1071052366267831766L;

    /*
     * Attributes fields
     */

    /**
     * 
     * @author andromda
     */
    private java.lang.String email;

    /**
     * <p>
     * physique ou virtuelle
     * </p>
     * 
     * @author andromda
     */
    private java.lang.Boolean estAgencePhysique;

    /**
     * 
     * @author andromda
     */
    private java.lang.Integer numero;

    /**
     * 
     * @author andromda
     */
    private java.lang.String telephone;

    /**
     * 
     * @author andromda
     */
    private java.lang.String fax;

    /**
     * 
     * @author andromda
     */
    private java.lang.String codeCIS;

    /*
     * Associations ends fields
     */

    /*
     * Constructor
     */

    /*
     * Attributes getters and setters
     */

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#getEmail()
     * @author andromda
     */
    public java.lang.String getEmail() {
	return this.email;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#setEmail(java.lang.String)
     * @author andromda
     */
    public void setEmail(java.lang.String email) {
	this.email = email;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#getEstAgencePhysique()
     * @author andromda
     */
    public java.lang.Boolean getEstAgencePhysique() {
	return this.estAgencePhysique;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#setEstAgencePhysique(java.lang.Boolean)
     * @author andromda
     */
    public void setEstAgencePhysique(java.lang.Boolean estAgencePhysique) {
	this.estAgencePhysique = estAgencePhysique;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#getNumero()
     * @author andromda
     */
    public java.lang.Integer getNumero() {
	return this.numero;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#setNumero(java.lang.Integer)
     * @author andromda
     */
    public void setNumero(java.lang.Integer numero) {
	this.numero = numero;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#getTelephone()
     * @author andromda
     */
    public java.lang.String getTelephone() {
	return this.telephone;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#setTelephone(java.lang.String)
     * @author andromda
     */
    public void setTelephone(java.lang.String telephone) {
	this.telephone = telephone;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#getFax()
     * @author andromda
     */
    public java.lang.String getFax() {
	return this.fax;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#setFax(java.lang.String)
     * @author andromda
     */
    public void setFax(java.lang.String fax) {
	this.fax = fax;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#getCodeCIS()
     * @author andromda
     */
    public java.lang.String getCodeCIS() {
	return this.codeCIS;
    }

    /**
     * @see fr.boursorama.crm.domain.base.organisation.Agence#setCodeCIS(java.lang.String)
     * @author andromda
     */
    public void setCodeCIS(java.lang.String codeCIS) {
	this.codeCIS = codeCIS;
    }

    /*
     * Associations ends getters and setters
     */

}

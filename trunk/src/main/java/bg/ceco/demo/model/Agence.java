//
package bg.ceco.demo.model;

/**
 * Interface for entity
 * 
 * @author andromda
 * @generated canonical
 */
public interface Agence
	extends Organisation
{

	/*
	 * Attributes
	 */


	/**
	 * Get the email of the Agence
	 * 
	 * @return The email of the Agence
	 * @author andromda
	 */
	java.lang.String getEmail();

	/**
	 * Set the email of the Agence
	 * 
	 * @param email The email of the Agence
	 * @author andromda
	 */
	void setEmail(java.lang.String email);


	/**
	 * Get the estAgencePhysique of the Agence
	 * <p>
	 * physique ou virtuelle
	 * </p>
	 * @return The estAgencePhysique of the Agence
	 * @author andromda
	 */
	java.lang.Boolean getEstAgencePhysique();

	/**
	 * Set the estAgencePhysique of the Agence
	 * <p>
	 * physique ou virtuelle
	 * </p>
	 * @param estAgencePhysique The estAgencePhysique of the Agence
	 * @author andromda
	 */
	void setEstAgencePhysique(java.lang.Boolean estAgencePhysique);


	/**
	 * Get the numero of the Agence
	 * 
	 * @return The numero of the Agence
	 * @author andromda
	 */
	java.lang.Integer getNumero();

	/**
	 * Set the numero of the Agence
	 * 
	 * @param numero The numero of the Agence
	 * @author andromda
	 */
	void setNumero(java.lang.Integer numero);


	/**
	 * Get the telephone of the Agence
	 * 
	 * @return The telephone of the Agence
	 * @author andromda
	 */
	java.lang.String getTelephone();

	/**
	 * Set the telephone of the Agence
	 * 
	 * @param telephone The telephone of the Agence
	 * @author andromda
	 */
	void setTelephone(java.lang.String telephone);


	/**
	 * Get the fax of the Agence
	 * 
	 * @return The fax of the Agence
	 * @author andromda
	 */
	java.lang.String getFax();

	/**
	 * Set the fax of the Agence
	 * 
	 * @param fax The fax of the Agence
	 * @author andromda
	 */
	void setFax(java.lang.String fax);


	/**
	 * Get the codeCIS of the Agence
	 * 
	 * @return The codeCIS of the Agence
	 * @author andromda
	 */
	java.lang.String getCodeCIS();

	/**
	 * Set the codeCIS of the Agence
	 * 
	 * @param codeCIS The codeCIS of the Agence
	 * @author andromda
	 */
	void setCodeCIS(java.lang.String codeCIS);


	/*
	 * Associations ends
	 */


	/*
	 * Custom methods
	 */

}

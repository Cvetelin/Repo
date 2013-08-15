//
package bg.ceco.demo.model;

/**
 * Interface for entity
 * 
 * @author andromda
 * @generated canonical
 */
public interface Organisation
{

	/*
	 * Attributes
	 */


	/**
	 * Get the actif of the Organisation
	 * 
	 * @return The actif of the Organisation
	 * @author andromda
	 */
	java.lang.Boolean getActif();

	/**
	 * Set the actif of the Organisation
	 * 
	 * @param actif The actif of the Organisation
	 * @author andromda
	 */
	void setActif(java.lang.Boolean actif);


	/**
	 * Get the idReprise of the Organisation
	 * 
	 * @return The idReprise of the Organisation
	 * @author andromda
	 */
	java.lang.String getIdReprise();

	/**
	 * Set the idReprise of the Organisation
	 * 
	 * @param idReprise The idReprise of the Organisation
	 * @author andromda
	 */
	void setIdReprise(java.lang.String idReprise);


	/**
	 * Get the nom of the Organisation
	 * 
	 * @return The nom of the Organisation
	 * @author andromda
	 */
	java.lang.String getNom();

	/**
	 * Set the nom of the Organisation
	 * 
	 * @param nom The nom of the Organisation
	 * @author andromda
	 */
	void setNom(java.lang.String nom);


	/**
	 * Get the id of the Organisation
	 * 
	 * @return The id of the Organisation
	 * @author andromda
	 */
	java.lang.Long getId();

	/**
	 * Set the id of the Organisation
	 * 
	 * @param id The id of the Organisation
	 * @author andromda
	 */
	void setId(java.lang.Long id);

	String getType();
	
	void setType(String type);
}

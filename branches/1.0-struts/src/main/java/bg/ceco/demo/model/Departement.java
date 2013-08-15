//
package bg.ceco.demo.model;

/**
 * Interface for entity
 * 
 * @author andromda
 * @generated canonical
 */
public interface Departement
	extends Organisation
{

	/*
	 * Attributes
	 */


	/*
	 * Associations ends
	 */

	/**
	 * Get the services of the Departement
	 * 
	 * @return The services of the Departement
	 * @author andromda
	 */
	java.util.Set getServices();

	/**
	 * Set the services of the Departement
	 * 
	 * @param services The services of the Departement
	 * @author andromda
	 */
	void setServices(java.util.Set services);


	/*
	 * Custom methods
	 */

}

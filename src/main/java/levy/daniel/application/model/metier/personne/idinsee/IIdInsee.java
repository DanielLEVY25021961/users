package levy.daniel.application.model.metier.personne.idinsee;

import java.io.Serializable;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * INTERFACE IIdInsee :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 26 déc. 2017
 *
 */
public interface IIdInsee 
	extends IExportateurCsv, IExportateurJTable
		, Comparable<IIdInsee>, Cloneable, Serializable {

	
	/**
	 * method compareTo(
	 * IIdInsee pObject) :<br/>
	 * <ol>
	 * Comparaison de 2 IIdInsee par rapport : <br/>
	 * <li>au numeroInsee.</li>
	 * </ol>
	 *
	 * @param pObject : IIdInsee.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pObject.<br/>
	 */
	@Override
	int compareTo(IIdInsee pObject);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un IIdInsee.<br/>
	 * <br/>
	 *
	 * @return IIdInsee : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IIdInsee clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un IIdInsee</b> :<br/>
	 * "id;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un IIdInsee</b> :<br/>
	 * "id;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un IIdInsee</b> :<br/>
	 * "id;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un IIdInsee</b> :<br/>
	 * "id;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	Object getValeurColonne(int pI);
	
	

	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();

	
	
	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);
	

	
	/**
	 * method getNumeroInsee() :<br/>
	 * getter du numeroInsee.<br/>
	 * <br/>
	 *
	 * @return : String : numeroInsee.<br/>
	 */
	String getNumeroInsee();
	

	
	/**
	 * method setNumeroInsee(
	 * String pNumeroInsee) :<br/>
	 * Setter du numeroInsee.<br/>
	 * <br/>
	 *
	 * @param pNumeroInsee : String : 
	 * valeur à passer à this.numeroInsee.<br/>
	 */
	void setNumeroInsee(String pNumeroInsee);

	
	
} // FIN DE L'INTERFACE IIdInsee.--------------------------------------------

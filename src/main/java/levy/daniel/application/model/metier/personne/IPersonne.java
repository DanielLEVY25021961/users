package levy.daniel.application.model.metier.personne;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;


/**
 * INTERFACE IPersonne :<br/>
 * <p>
 * Modélise un <b>Personne</b>, c'est à dire un 
 * <b>humain</b> qui possède un <b>nom</b> <i>et</i> un <b>prénom</b>.
 * </p>
 * <p>
 * Un IPersonne peut également <i>éventuellement</i> 
 * posséder une date de naissance 
 * <b>dateNaissance</b> et un <b>numeroInsee</b>.
 * </p>
 * 
 * 
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
 * @author dan Lévy
 * @version 1.0
 * @since 24 déc. 2017
 *
 */
public interface IPersonne 
		extends IExportateurJTable, IExportateurCsv
			, Comparable<IPersonne>, Cloneable {

	
	
	/**
	 * method compareTo(
	 * IPersonne pPersonne) :<br/>
	 * <ol>
	 * Comparaison de 2 IPersonne par rapport : <br/>
	 * <li>au nom.</li>
	 * <li>au prenom.</li>
	 * <li>à la date de naissance.</li>
	 * <li>au numeroInsee.</li>
	 * </ol>
	 *
	 * @param pPersonne : IUser.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pPersonne.<br/>
	 */
	@Override
	int compareTo(IPersonne pPersonne);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un IPersonne.<br/>
	 * <br/>
	 *
	 * @return IPersonne : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IPersonne clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un IPersonne</b> :<br/>
	 * "id;nom;prénom;dateNaissance;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un IPersonne</b> :<br/>
	 * "id;nom;prénom;dateNaissance;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un IPersonne</b> :<br/>
	 * "id;nom;prénom;dateNaissance;numeroInsee;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un IPersonne</b> :<br/>
	 * "id;nom;prénom;dateNaissance;numeroInsee;".<br/>
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
	



} // FIN DE L'INTERFACE IPersonne.-------------------------------------------

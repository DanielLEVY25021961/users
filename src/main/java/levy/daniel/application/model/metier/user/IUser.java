package levy.daniel.application.model.metier.user;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;


/**
 * INTERFACE IUser :<br/>
 * <p>
 * Modélise un <b>User</b>, c'est à dire un 
 * <b>utilisateur de l'application</b> qui doit se connecter 
 * à l'application via un <b>login</b> <i>et</i> un mot de passe <b>mdp</b>.
 * </p>
 * 
 * <ul>
 * <p><span style="text-decoration: underline;">HERITE de :</span></p>
 * <li><b>IExportateurCsv</b> pour l'export d'un Objet 
 * métier en csv.</li>
 * <li><b>IExportateurJTable</b> pour l'affichage dans 
 * une JTable (Swing).</li>
 * <li><b>Comparable</b> pour l'affichage des Collections 
 * sous forme triée.</li>
 * <li><b>Cloneable</b> pour garantir que tout objet métier 
 * implémentant cette interface saura se cloner.</li>
 * </ul>
 * 
 * <ul>
 * </ul>
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
public interface IUser 
		extends IExportateurCsv, IExportateurJTable
			, Comparable<IUser>, Cloneable {
	
	
	
	/**
	 * method compareTo(
	 * IUser pUser) :<br/>
	 * <ol>
	 * Comparaison de 2 IUser par rapport : <br/>
	 * <li>au login.</li>
	 * <li>au mot de passe.</li>
	 * </ol>
	 *
	 * @param pUser : IUser.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pUser.<br/>
	 */
	@Override
	int compareTo(IUser pUser);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un IUser.<br/>
	 * <br/>
	 *
	 * @return IUser : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IUser clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
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
	

	
	

} // FIN DE L'INTERFACE IUser.---------------------------------------------

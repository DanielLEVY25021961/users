package levy.daniel.application.model.metier.personne.nommage;

import java.io.Serializable;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;


/**
 * INTERFACE INommage :<br/>
 * <p>
 * Modélise un <b>INommage</b>, c'est à dire un couple
 * <b>[nom - prenom]</b> qui identifie <i>une ou plusieurs</i> 
 * <b>Personne</b>.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE de :
 * </span>
 * </p>
 * <li><b>IExportateurCsv</b> pour l'export d'un Objet 
 * métier en csv.</li>
 * <li><b>IExportateurJTable</b> pour l'affichage dans 
 * une JTable (Swing).</li>
 * <li><b>Comparable</b> pour l'affichage des Collections 
 * sous forme triée.</li>
 * <li><b>Cloneable</b> pour garantir que tout objet métier 
 * implémentant cette interface saura se cloner.</li>
 * <li><b>Serializable</b> pour garantir que tout objet métier 
 * implémentant cette interface pourra être serialisé.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout IIndInsee sait :
 * </span>
 * </p>
 * <li>se <b>comparer</b> à un autre IIndInsee.</li>
 * <li>se <b>cloner</b>.</li>
 * <li>s'exporter sous forme <b>csv</b>.</li>
 * <li>s'exporter sous forme <b>JTable</b>.</li>
 * </ul>
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
 * @since 27 déc. 2017
 *
 */
public interface INommage 
		extends IExportateurCsv, IExportateurJTable
			, Comparable<INommage>, Cloneable, Serializable {
	
	
	/**
	 * method compareTo(
	 * INommage pObject) :<br/>
	 * <ol>
	 * Comparaison de 2 INommage par rapport : <br/>
	 * <li>au nom.</li>
	 * <li>au prenom.</li>
	 * </ol>
	 *
	 * @param pObject : INommage.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pObject.<br/>
	 */
	@Override
	int compareTo(INommage pObject);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un INommage.<br/>
	 * <br/>
	 *
	 * @return INommage : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	INommage clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un INommage</b> :<br/>
	 * "id;nom;prenom;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un INommage</b> :<br/>
	 * "id;nom;prenom;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un INommage</b> :<br/>
	 * "id;nom;prenom;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un INommage</b> :<br/>
	 * "id;nom;prenom;".<br/>
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
	 * method getPrenom() :<br/>
	 * Getter du Prénom du User.<br/>
	 * <ul>
	 * <li>"RG_NOMMAGE_PRENOM_RENSEIGNE_01 : 
	 * le prénom du Nommage doit être renseigné (obligatoire)".</li>
	 * <li>"RG_NOMMAGE_PRENOM_LITTERAL_02 : 
	 * le prénom du Nommage 
	 * ne doit contenir que des lettres ou des 
	 * caractères spéciaux '-', '_', ... (aucun chiffre)".</li>
	 * <li>"RG_NOMMAGE_PRENOM_LONGUEUR_03 : 
	 * le prénom du Nommage doit contenir 
	 * entre [1] et [30] lettres".</li>
	 * </ul>
	 *
	 * @return prenom : String.<br/>
	 */
	String getPrenom();
	
	

	/**
	* method setPrenom(
	* String pPrenom) :<br/>
	* Setter du Prénom du User.<br/>
	* <br/>
	*
	* @param pPrenom : String : valeur à passer à prenom.<br/>
	*/
	void setPrenom(String pPrenom);
	
	

	/**
	 * method getNom() :<br/>
	 * Getter du Nom du User.<br/>
	 * <ul>
	 * <li>"RG_NOMMAGE_NOM_RENSEIGNE_04
	 *  : le nom du Nommage doit être renseigné (obligatoire)".<br/></li>
	 *  <li>"RG_NOMMAGE_NOM_LITTERAL_05
	 *  : le nom du Nommage 
	 *  ne doit contenir que des lettres ou des caractères spéciaux 
	 *  '-', '_', ... (aucun chiffre)".</li>
	 *  <li>
	 *  "RG_NOMMAGE_NOM_LONGUEUR_06
	 *  : le nom du Nommage doit contenir entre 
	 *  [1] et [50] lettres".
	 *  </li>
	 * </ul>
	 *
	 * @return nom : String.<br/>
	 */
	String getNom();
	
	

	/**
	* method setNom(
	* String pNom) :<br/>
	* Setter du Nom du User.<br/>
	* <br/>
	*
	* @param pNom : String : valeur à passer à nom.<br/>
	*/
	void setNom(String pNom);
	
	


} // FIN DE L'INTERFACE INommage.--------------------------------------------

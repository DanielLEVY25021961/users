package levy.daniel.application.model.metier.personne.idinsee;

import java.io.Serializable;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * INTERFACE <b>IIdInsee</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>IIdInsee</b> modélise un <i>concept</i> d' <b>identifiant personnel</b>, c'est à dire un 
 * <b>identifiant unique d'une Personne</b>.
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
 * Garantit que tout IIdInsee sait :
 * </span>
 * </p>
 * <li>se <b>comparer</b> à un autre IIdInsee.</li>
 * <li>se <b>cloner</b>.</li>
 * <li>s'exporter sous forme <b>csv</b>.</li>
 * <li>s'exporter sous forme <b>JTable</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout IIdInsee possède à minima :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>numeroInsee</b>.</li>
 * </ul>
 *
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un IIdInsee est vérifiée sur :</li>
  * <ul>
 * <li><b>numeroInsee</b></li>
 * </ul>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_idInsee.png" 
 * alt="classes d'implémentation des IdInsee" border="1" align="center" />
 * </li>
 * </ul>
 *
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">REGLES DE GESTION</span>
 * </p>
 * <ul>
 * <li>
 * Les <b>Règles de Gestion (RG)</b> applicables aux attributs 
 * d'un IIdInsee sont les suivantes :
 * </li>
 * <br/>
 * 
 * <table border="1">
 * 
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * numeroInsee
 * </td>
 * <td>
 * "RG_IDINSEE_NUMEROINSEE_RENSEIGNE_01 : le numeroInsee 
 * du IdInsee doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_IDINSEE_NUMEROINSEE_LONGUEUR_02 : le numeroInsee du IdInsee
 *  doit contenir entre [5] et [30] caractères"
 *  </td>
 * </tr>
 * 
 * </table>
 * </ul>
 * <br/>
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
 * @author daniel Lévy
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
	 * <ul>
	 * <li>"RG_IDINSEE_NUMEROINSEE_RENSEIGNE_01 : le numeroInsee 
	 * du IdInsee doit être renseigné (obligatoire)".</li>
	 * <li>"RG_IDINSEE_NUMEROINSEE_LONGUEUR_02 : le numeroInsee du IdInsee
	 *  doit contenir entre [5] et [30] caractères".</li>
	 * </ul>
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

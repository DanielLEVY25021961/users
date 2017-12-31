package levy.daniel.application.model.metier.personne.civilite;

import java.io.Serializable;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;


/**
 * INTERFACE <b>ICivilite</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>ICivilite</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * (MONSIEUR ou M., MADAME ou Mme, Mlle ...) 
 * associé de manière unique à une <b>Personne</b>.
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
 * Garantit que tout ICivilite sait :
 * </span>
 * </p>
 * <li>se <b>comparer</b> à un autre ICivilite.</li>
 * <li>se <b>cloner</b>.</li>
 * <li>s'exporter sous forme <b>csv</b>.</li>
 * <li>s'exporter sous forme <b>JTable</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout ICivilite possède à minima :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>civiliteString</b>.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un ICivilite est vérifiée sur :</li>
  * <ul>
 * <li><b>civiliteString</b></li>
 * </ul>
 * </ul>
 * 
 *  <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_civilite.png" 
 * alt="classes d'implémentation des ICivilite" border="1" align="center" />
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
 * d'un ICivilite sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 * <tr>
 * <td rowspan="1">
 * civiliteString
 * </td>
 * <td>
 * "RG_CIVILITE_CIVILITESTRING_NOMENCLATURE_01 : 
 * la civilite (MONSIEUR ou M., MADAME ou Mme, ...) 
 * du Personne doit respecter 
 * un ensemble fini de valeurs (nomenclature)"
 * </td>
 * </tr>
 * 
 * </table>
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
 * @since 29 déc. 2017
 *
 */
public interface ICivilite 
	extends IExportateurJTable, IExportateurCsv
			, Cloneable, Comparable<ICivilite>
					, Serializable {
	
	
	/**
	 * method compareTo(
	 * ICivilite pObject) :<br/>
	 * <ol>
	 * Comparaison de 2 ICivilite par rapport : <br/>
	 * <li>au civiliteString.</li>
	 * </ol>
	 *
	 * @param pObject : ICivilite.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pObject.<br/>
	 */
	@Override
	int compareTo(ICivilite pObject);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un ICivilite.<br/>
	 * <br/>
	 *
	 * @return ICivilite : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	ICivilite clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un ICivilite</b> :<br/>
	 * "id;civiliteString;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un ICivilite</b> :<br/>
	 * "id;civiliteString;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un ICivilite</b> :<br/>
	 * "id;civiliteString;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un ICivilite</b> :<br/>
	 * "id;civiliteString;".<br/>
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
	 * method getCiviliteString() :<br/>
	 * <ul>
	 * <li>Getter de civiliteString 
	 * (MONSIEUR ou M., MADAME ou Mme, ...).</li>
	 * <li>civiliteString ne peut prendre 
	 * <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
	 * </ul>
	 * <ul>
	 * <li>"RG_CIVILITE_CIVILITESTRING_NOMENCLATURE_01 : 
	 * la civilite (MONSIEUR ou M., MADAME ou Mme, ...) 
	 * doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 *
	 * @return civiliteString : String.<br/>
	 */
	String getCiviliteString();
	

	
	/**
	 * method setCiviliteString(
	 * String pCivilite) :<br/>
	 * <ul>
	 * <li>Setter de civiliteString 
	 * (MONSIEUR ou M., MADAME ou Mme, ...).</li>
	 * <li>civiliteString ne peut prendre 
	 * <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
	 * </ul>
	 * <ul>
	 * <li>"RG_CIVILITE_CIVILITESTRING_NOMENCLATURE_01 : 
	 * la civilite (M., Mme, ...) du Personne doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 *
	 * @param pCivilite : String : valeur à passer à civiliteString.<br/>
	 */
	void setCiviliteString(String pCivilite);
	


} // FIN DE L'INTERFACE ICivilite.-------------------------------------------

package levy.daniel.application.model.metier.personne.idinsee.impl;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.idinsee.AbstractIdInsee;

/**
 * class IdInsee :<br/>
 * <p>
 * <b>CLASSE CONCRETE</b> qui modélise un <b>IdInsee</b>, c'est à dire un 
 * <b>identifiant INSEE</b> qui identifie de manière 
 * unique une Personne.
 * </p>
 * 
 * <ul>
 * <li>Implémentation <b>CONCRETE</b> de IdInsee.</li>
 * <li>HERITE de AbstractIdInsee.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">ATTRIBUTS</span>
 * </p>
 * <ul>
 * <li>Les <b>attributs</b> d'un IdInsee sont : </li>
 * <ul>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>numeroInsee</b>.</li>
 * </ul>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/classes_implementation_idInsee.png" 
 * alt="implémentation du IdInsee" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>
 * L'<b>égalité metier</b> d'un IdInsee est vérifiée sur :
 * <ul>
 * <li><b>numeroInsee</b></li>
 * </ul>
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * ENTITIES JPA
 * </span>
 * </p>
 * <ul>
 * <li>la classe abstraite AbstractIdInsee 
 * est transformée en <b>Entity JPA</b> au moyen de 
 * <b>javax.persistence annotations</b>.</li>
 * <li>La <b>stratégie de jointuredes tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_idinsee_entities.png" 
 * alt="implémentation du UserSimple" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * TABLES
 * </span>
 * </p>
 * <ul>
 * <li>Les <b>tables en base</b> résultantes des entities JPA sont :</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/tables-abstract_ids_insee-ids_insee.png" 
 * alt="implémentation du UserSimple" border="1" align="center" />
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
 * d'un UserSimple sont les suivantes :
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 26 déc. 2017
 *
 */
@Entity(name="IdInsee")
@Table(name = "IDS_INSEE", schema = "PUBLIC")
@PrimaryKeyJoinColumn(name = "ID_ABSTRACT_IDINSEE"
, foreignKey=@ForeignKey(name="FK_IDINSEE_ABSTRACTIDINSEE"))
public class IdInsee extends AbstractIdInsee {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(IdInsee.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR IdInsee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public IdInsee() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR IdInsee(
	 * String pNumeroInsee) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS id en BASE</li>
	 * </ul>
	 *
	 * @param pNumeroInsee : String : 
	 * Identifiant INSEE d'une Personne.<br/>
	 */
	public IdInsee(
			final String pNumeroInsee) {
		this(null, pNumeroInsee);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR IdInsee(
	 * Long pId
	 * , String pNumeroInsee) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC id en BASE</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pNumeroInsee : String : 
	 * Identifiant INSEE d'une Personne.<br/>
	 */
	public IdInsee(
			final Long pId
				, final String pNumeroInsee) {
		
		super(pId, pNumeroInsee);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
} // FIN DE LA CLASSE IdInsee.-----------------------------------------------

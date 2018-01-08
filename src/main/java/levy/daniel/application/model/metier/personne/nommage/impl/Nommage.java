package levy.daniel.application.model.metier.personne.nommage.impl;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.nommage.AbstractNommage;


/**
 * CLASSE CONCRETE <b>Nommage</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>Nommage</b> modélise un un <i>concept</i> 
 * de <b>Nommage</b> avec nom et un seul prenom, c'est à dire un couple
 * <b>[nom - prenom]</b>  qui identifie <i>une ou plusieurs</i> <b>Personne</b>.<br/>
 * </p>
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
 * @since 28 déc. 2017
 *
 */
@Entity(name="Nommage")
@Table(name = "NOMMAGES", schema = "PUBLIC")
@PrimaryKeyJoinColumn(name = "ID_ABSTRACT_NOMMAGE"
, foreignKey=@ForeignKey(name="FK_NOMMAGE_ABSTRACTNOMMAGE"))
public class Nommage extends AbstractNommage {

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
	private static final Log LOG = LogFactory.getLog(Nommage.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR Nommage() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Nommage() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Nommage(
	 * String pPrenom
	 * , String pNom) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 *  @param pPrenom : String : Prénom du Nommage.<br/>
	 * @param pNom : String : Nom du Nommage.<br/>
	 */
	public Nommage(
			final String pPrenom
					, final String pNom) {
		
		this(null, pPrenom, pNom);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Nommage(
	 * Long pId
	 * , String pPrenom
	 * , String pNom) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pPrenom : String : Prénom du Nommage.<br/>
	 * @param pNom : String : Nom du Nommage.<br/>
	 */
	public Nommage(
			final Long pId
				, final String pPrenom
					, final String pNom) {
		
		super(pId, pPrenom, pNom);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
} // FIN DE LA CLASSE Nommage.-----------------------------------------------

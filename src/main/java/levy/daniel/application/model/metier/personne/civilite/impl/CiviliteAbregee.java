package levy.daniel.application.model.metier.personne.civilite.impl;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.AbstractCivilite;

/**
 * class CiviliteAbregee :<br/>
 * <ul>
 * <li>Classe modélisant une <b>CiviliteAbregee</b> (M., Mme, ...) 
 * d'un UserSimple.</li>
 * <li>La civilité ne peut prendre <i>que les valeurs</i> définies dans 
 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
 * <li>"RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
 * la civilite (M., Mme, ...) du UserSimple doit respecter 
 * un ensemble fini de valeurs (nomenclature)".</li>
 * </ul>
 * 
 *
 * - Exemple d'utilisation :<br/>
 * <code>//Instanciation d'un CiviliteAbregee en lui passant la String 
 * associée à l'instance M de l'énumération.</code><br/>
 * <code>CiviliteAbregee CIVILITE_M = new 
 * CiviliteAbregee(CivilitesEnum.MONSIEUR.toString());</code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enumération, utilisation d'une énumeration dans classe,<br/>
 * enumeration, utilisation enum, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 déc. 2017
 *
 */
@Entity(name="CiviliteAbregee")
@Table(name="CIVILITES_ABREGEES", schema="PUBLIC")
@PrimaryKeyJoinColumn(name = "ID_CIVILITE"
, foreignKey=@ForeignKey(name="FK_CIVILITEABREGEE_ABSTRACTCIVILITE"))
public class CiviliteAbregee extends AbstractCivilite {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * M : CiviliteAbregee :<br/>
	 * "M.".<br/>
	 */
	public static final CiviliteAbregee M 
		= new CiviliteAbregee(CivilitesEnum.MONSIEUR.getAbreviationEnum());

	
	/**
	 * MME : CiviliteAbregee :<br/>
	 * "Mme".<br/>
	 */
	public static final CiviliteAbregee MME 
		= new CiviliteAbregee(CivilitesEnum.MADAME.getAbreviationEnum());

	
	/**
	 * MLLE : CiviliteAbregee :<br/>
	 * "Mlle".<br/>
	 */
	public static final CiviliteAbregee MLLE 
		= new CiviliteAbregee(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(CiviliteAbregee.class);



	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CiviliteAbregee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CiviliteAbregee() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR CiviliteAbregee(
	 * String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pCiviliteString : String : 
	 * Civilité abrégée (M., Mme, ...).<br/>
	 */
	public CiviliteAbregee(
			final String pCiviliteString) {
		
		this(null, pCiviliteString);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR CiviliteAbregee(
	 * Long pId
	 * , String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCiviliteString : String : 
	 * Civilité abrégée (M., Mme, ...).<br/>
	 */
	public CiviliteAbregee(
			final Long pId
				, final String pCiviliteString) {
		
		super(pId, pCiviliteString);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("CiviliteAbregee [");
		
		builder.append("id=");
		if (this.id != null) {
			builder.append(this.id);
		} else {
			builder.append(NULL);			
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("civilité=");
		if (this.civiliteString != null) {
			builder.append(this.civiliteString);
		} else {
			builder.append(NULL);			
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________


	
} // FIN DE LA CLASSE CiviliteAbregee.---------------------------------------

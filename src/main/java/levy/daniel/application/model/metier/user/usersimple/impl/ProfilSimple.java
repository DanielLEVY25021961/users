package levy.daniel.application.model.metier.user.usersimple.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;


/**
 * class ProfilSimple :<br/>
 * <ul>
 * <li>Classe modélisant un <b>ProfilSimple</b>
 * (ADMINISTRATEUR, UTILISATEUR, ...) typant l'attribut 
 * <b>profil</b> d'un <b>UserSimple</b>.</li>
 * <li>Le ProfilSimple ne peut prendre <i>que les valeurs</i> 
 * définies dans l'ENUMERATION <b>ProfilsSimplesEnum</b>.</li>
 * 
 * <br/>
 * 
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/Implementation_ProfilSimple.png" 
 * alt="Enumération ProfilsSimplesEnum" border="1" align="center" />
 * </li>
 * <br/>
 * </ul>
 * 
 *
 * - Exemple d'utilisation :<br/>
 * <code>//Instanciation d'un ProfilSimple en lui passant la String 
 * associée à l'instance ADMINISTRATEUR de l'énumération.</code><br/>
 * <code>ProfilSimple PROFIL_ADMIN = new 
 * ProfilSimple(ProfilsSimplesEnum.ADMINISTRATEUR.toString());</code><br/>
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
 * @since 10 déc. 2017
 *
 */
@Entity(name="ProfilSimple")
@Table(name="PROFILSSIMPLES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_PROFIL"
, columnNames={"PROFIL"}))
public class ProfilSimple implements Serializable
					, Comparable<ProfilSimple>, Cloneable
								, IExportateurCsv, IExportateurJTable {

	// ************************ATTRIBUTS************************************/


	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	

	/**
	 * ADMINISTRATEUR : ProfilSimple :<br/>
	 * ADMINISTRATEUR.<br/>
	 */
	public static final ProfilSimple ADMINISTRATEUR 
		= new ProfilSimple(
				ProfilsSimplesEnum.ADMINISTRATEUR.toString());
	
	/**
	 * GESTIONNAIRE_DONNEES : ProfilSimple :<br/>
	 * GESTIONNAIRE_DONNEES.<br/>
	 */
	public static final ProfilSimple GESTIONNAIRE_DONNEES 
		= new ProfilSimple(
				ProfilsSimplesEnum.GESTIONNAIRE_DONNEES.toString());

	/**
	 * UTILISATEUR : ProfilSimple :<br/>
	 * UTILISATEUR.<br/>
	 */
	public static final ProfilSimple UTILISATEUR 
		= new ProfilSimple(
				ProfilsSimplesEnum.UTILISATEUR.toString());	

	
	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	private Long id;
	
	
	/**
	 * profilString : String :<br/>
	 * profil d'un UserSimple (ADMINISTRATEUR, UTILISATEUR, ...).<br/>
	 */
	private String profilString;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ProfilSimple.class);


	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR ProfilSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ProfilSimple() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR ProfilSimple(
	 * Long pId
	 * , String pProfilString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pProfilString : String : Profil d'un 
	 * UserSimple (ADMINISTRATEUR, UTILISATEUR, ...).<br/>
	 */
	public ProfilSimple(
			final String pProfilString) {
		
		this(null, pProfilString);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR ProfilSimple(
	 * Long pId
	 * , String pProfilString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pProfilString : String : Profil d'un 
	 * UserSimple (ADMINISTRATEUR, UTILISATEUR, ...).<br/>
	 */
	public ProfilSimple(
			final Long pId
				, final String pProfilString) {
		
		super();
		
		this.id = pId;
		this.profilString = pProfilString;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;		
		int result = 1;		
		result = prime * result 
				+ ((this.profilString == null) ? 0 
						: this.profilString.hashCode());		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un ProfilSimple</b> sur :
	 * <li>"profilString".</li>
	 *</ul>
	 * <br/>
	 */
	@Override
	public final boolean equals(
			final Object pObjet) {

		if (this == pObjet) {
			return true;
		}
		
		if (pObjet == null) {
			return false;
		}
		
		if (!(pObjet instanceof ProfilSimple)) {
			return false;
		}
		
		final ProfilSimple other = (ProfilSimple) pObjet;
		
		if (this.profilString == null) {
			if (other.profilString != null) {
				return false;
			}
		}
		else if (!this.profilString.equals(other.profilString)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final ProfilSimple pObjet) {
		
		if (this == pObjet) {
			return 0;
		}

		if (pObjet == null) {
			return -1;
		}

		int compareProfilString = 0;
		
		if (this.profilString == null) {
			if (pObjet.getProfilString() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObjet.getProfilString() == null) {
			return -1;
		}
				
		compareProfilString 
			= this.profilString
			.compareToIgnoreCase(pObjet.getProfilString());
		
		return compareProfilString;

	} // Fin de compareTo(...).____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ProfilSimple clone() throws CloneNotSupportedException {
		
		final ProfilSimple clone = (ProfilSimple) super.clone();
		
		clone.setId(this.id);
		clone.setProfilString(this.profilString);
		
		return clone;
		
	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("ProfilSimple [");
		
		builder.append("id=");
		if (this.id != null) {
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("profil=");
		if (this.profilString != null) {			
			builder.append(this.profilString);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un ProfilSimple</b> :<br/>
	 * "id;profil;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String getEnTeteCsv() {
		return "id;profil;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un ProfilSimple</b> :<br/>
	 * "id;profil;".<br/>
	 * <br/>
	 */
	@Override
	public final String toStringCsv() {

		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		
		/* profil. */
		stb.append(this.getProfilString());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un ProfilSimple</b> :<br/>
	 * "id;profil;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;
			
		case 1:
			entete = "profil";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un ProfilSimple</b> :<br/>
	 * "id;profil;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			
			break;

		case 1:
			valeur = this.getProfilString();
			break;
			
		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;
		
	} // Fin de getValeurColonne(...)._____________________________________


	
	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROFILSIMPLE")
	public Long getId() {	
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	public void setId(
			final Long pId) {	
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * method getProfilString() :<br/>
	 * Getter du profil d'un UserSimple 
	 * (ADMINISTRATEUR, UTILISATEUR, ...).<br/>
	 * <br/>
	 *
	 * @return profilString : String.<br/>
	 */
	@Column(name = "PROFIL"
			, unique = true, nullable = false
			, updatable = true, insertable = true)
			@Size(min = 1, max = 30)
	public String getProfilString() {	
		return this.profilString;
	} // Fin de getProfilString()._________________________________________


	
	/**
	* method setProfilString(
	* String pProfilString) :<br/>
	* Setter du profil d'un UserSimple 
	* (ADMINISTRATEUR, UTILISATEUR, ...).<br/>
	* <br/>
	*
	* @param pProfilString : String : 
	* valeur à passer à profilString.<br/>
	*/
	public void setProfilString(
			final String pProfilString) {	
		this.profilString = pProfilString;
	} // Fin de setProfilString(...).______________________________________

	
	
} // FIN DE LA CLASSE ProfilSimple.------------------------------------------

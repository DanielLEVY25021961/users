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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * class Civilite :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <ul>
 * <li>Classe modélisant une <b>Civilite</b> (M., Mme, ...) 
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
 * <code>//Instanciation d'un Civilite en lui passant la String 
 * associée à l'instance MONSIEUR de l'énumération.</code><br/>
 * <code>Civilite CIVILITE_M = new 
 * Civilite(CivilitesEnum.MONSIEUR.toString());</code><br/>
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
@Entity(name="Civilite")
@Table(name="CIVILITES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_CIVILITE"
, columnNames={"CIVILITE"}))
public class Civilite implements Serializable
					, Comparable<Civilite>, Cloneable
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
	 * MONSIEUR : Civilite :<br/>
	 * "M.".<br/>
	 */
	public static final Civilite MONSIEUR 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());

	
	/**
	 * MADAME : Civilite :<br/>
	 * "Mme".<br/>
	 */
	public static final Civilite MADAME 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());

	
	/**
	 * MADEMOISELLE : Civilite :<br/>
	 * "Mlle".<br/>
	 */
	public static final Civilite MADEMOISELLE 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());

	
	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	private Long id;
	
	
	/**
	 * civiliteString : String :<br/>
	 * civilité d'un UserSimple (M., Mme, ...).<br/>
	 */
	private String civiliteString;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Civilite.class);



	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR Civilite() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Civilite() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR Civilite(
	 * Long pId
	 * , String pCivilite) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pCivilite : String : Civilité d'un 
	 * UserSimple (M., Mme, ...).<br/>
	 */
	public Civilite(
			final String pCivilite) {
		
		this(null, pCivilite);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Civilite(
	 * Long pId
	 * , String pCivilite) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCivilite : String : Civilité d'un 
	 * UserSimple (M., Mme, ...).<br/>
	 */
	public Civilite(
			final Long pId
				, final String pCivilite) {
		
		super();
		
		this.id = pId;
		this.civiliteString = pCivilite;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((this.civiliteString == null) ? 0 
						: this.civiliteString.hashCode());
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un Civilite</b> sur :
	 * <li>"civiliteString".</li>
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
		
		if (!(pObjet instanceof Civilite)) {
			return false;
		}
		
		final Civilite other = (Civilite) pObjet;
		
		if (this.civiliteString == null) {
			if (other.civiliteString != null) {
				return false;
			}
		}
		else if (!this.civiliteString
				.equalsIgnoreCase(other.civiliteString)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final Civilite pObjet) {

		if (this == pObjet) {
			return 0;
		}

		if (pObjet == null) {
			return -1;
		}

		int compareCivilite = 0;
		
		if (this.civiliteString == null) {
			if (pObjet.getCiviliteString() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObjet.getCiviliteString() == null) {
			return -1;
		}
				
		compareCivilite 
			= this.civiliteString
			.compareToIgnoreCase(pObjet.getCiviliteString());
		
		return compareCivilite;

	} // Fin de compareTo(...).____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Civilite clone() throws CloneNotSupportedException {
		
		final Civilite clone = (Civilite) super.clone();
		
		clone.setId(this.id);
		clone.setCiviliteString(this.civiliteString);
		
		return clone;
		
	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("Civilite [");
		
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



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un Civilite</b> :<br/>
	 * "id;civilité;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String getEnTeteCsv() {
		return "id;civilité;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un Civilite</b> :<br/>
	 * "id;civilité;".<br/>
	 * <br/>
	 */
	@Override
	public final String toStringCsv() {

		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		
		/* civilite. */
		stb.append(this.getCiviliteString());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un Civilite</b> :<br/>
	 * "id;civilité;".<br/>
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
			entete = "civilité";
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
	 * <b>ligne Jtable pour un Civilite</b> :<br/>
	 * "id;civilité;".<br/>
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
			valeur = this.getCiviliteString();
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
	@Column(name="ID_CIVILITE")
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
	 * method getCiviliteString() :<br/>
	 * Getter de la civilité d'un UserSimple (M., Mme, ...).<br/>
	 * <br/>
	 *
	 * @return civiliteString : String.<br/>
	 */
	@Column(name = "CIVILITE"
	, unique = true, nullable = false
	, updatable = true, insertable = true)
	public String getCiviliteString() {	
		return this.civiliteString;
	} // Fin de getCiviliteString()._______________________________________


	
	/**
	* method setCiviliteString(
	* String pCivilite) :<br/>
	* Setter de la civilité d'un UserSimple (M., Mme, ...).<br/>
	* <br/>
	*
	* @param pCivilite : String : valeur à passer à civiliteString.<br/>
	*/
	public void setCiviliteString(
			final String pCivilite) {	
		this.civiliteString = pCivilite;
	} // Fin de setCiviliteString(...).____________________________________

		
	
} // FIN DE LA CLASSE Civilite.----------------------------------------------

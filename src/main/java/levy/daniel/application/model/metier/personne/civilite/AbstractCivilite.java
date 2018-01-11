package levy.daniel.application.model.metier.personne.civilite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE ABSTRAITE <b>AbstractCivilite</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>AbstractCivilite</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * (MONSIEUR ou M., MADAME ou Mme, Mlle ...) 
 * associé de manière unique à une <b>Personne</b>.<br/>
 * <b>FACTORISE</b> les attributs et comportements 
 * des <i>descendants concrets</i>.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * IMPLEMENTE :
 * </span>
 * </p>
 * <li><b>ICivilite</b>.</li>
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
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_civilite.png" 
 * alt="classes d'implémentation des AbstractCivilite" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * ENTITIES JPA
 * </span>
 * </p>
 * <ul>
 * <li>la classe abstraite AbstractCivilite 
 * est transformée en <b>Entity JPA</b> au moyen de 
 * <b>javax.persistence annotations</b>.</li>
 * <li>La <b>stratégie de jointure des tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_civilite_entities.png" 
 * alt="implémentation des entities de AbstractCivilite" border="1" align="center" />
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
 * <img src="../../../../../../../../../../javadoc/images/tables-abstract_civilites_civilites.png" 
 * alt="implémentation des tables de AbstractCivilite" border="1" align="center" />
 * </li>
 * </ul>
 * 
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
 * la civilite (MONSIEUR ou M., MADAME ou Mme, ...) du Personne doit respecter 
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
@Entity(name="AbstractCivilite")
@Table(name="ABSTRACT_CIVILITES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_CIVILITE"
, columnNames={"CIVILITE"}))
@Inheritance(strategy=InheritanceType.JOINED)
public class AbstractCivilite implements ICivilite {

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
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long id;
	
	
	/**
	 * civiliteString : String :<br/>
	 * civilité (MONSIEUR ou M., MADAME ou Mme, ...).<br/>
	 * <ul>
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
	 */
	protected String civiliteString;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractCivilite.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractCivilite() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractCivilite() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR AbstractCivilite(
	 * String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pCiviliteString : String : 
	 * civilité (MONSIEUR ou M., MADAME ou Mme, ...).<br/>
	 */
	public AbstractCivilite(
			final String pCiviliteString) {
		
		this(null, pCiviliteString);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractCivilite(
	 * Long pId
	 * , String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCiviliteString : String : 
	 * civilité (MONSIEUR ou M., MADAME ou Mme, ...).<br/>
	 */
	public AbstractCivilite(
			final Long pId
				, final String pCiviliteString) {
		
		super();
		
		this.id = pId;
		this.civiliteString = pCiviliteString;
		
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
	 * <b>equals(...) pour un AbstractCivilite</b> sur :
	 * <li>civiliteString.</li>
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
		
		if (!(pObjet instanceof AbstractCivilite)) {
			return false;
		}
		
		final AbstractCivilite other = (AbstractCivilite) pObjet;
		
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
			final ICivilite pObject) {
		
		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareCivilite = 0;
		
		if (this.civiliteString == null) {
			if (pObject.getCiviliteString() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObject.getCiviliteString() == null) {
			return -1;
		}
				
		compareCivilite 
			= this.civiliteString
			.compareToIgnoreCase(pObject.getCiviliteString());
		
		return compareCivilite;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AbstractCivilite clone() throws CloneNotSupportedException {

		final AbstractCivilite clone = (AbstractCivilite) super.clone();
		
		clone.setId(this.id);
		clone.setCiviliteString(this.civiliteString);
		
		return clone;
		
	} // Fin de clone().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("AbstractCivilite [");
		
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
	 * <b>en-tête csv pour un AbstractCivilite</b> :<br/>
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
	 * <b>ligne csv pour un AbstractCivilite</b> :<br/>
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
	 * <b>en-tête Jtable pour un AbstractCivilite</b> :<br/>
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
	 * <b>ligne Jtable pour un AbstractCivilite</b> :<br/>
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
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CIVILITE")
	@Override
	public Long getId() {	
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {	
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "CIVILITE"
	, unique = false, nullable = false
	, updatable = true, insertable = true)
	@Override
	public String getCiviliteString() {	
		return this.civiliteString;
	} // Fin de getCiviliteString()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCiviliteString(
			final String pCivilite) {	
		this.civiliteString = pCivilite;
	} // Fin de setCiviliteString(...).____________________________________

		
	
} // FIN DE LA CLASSE AbstractCivilite.--------------------------------------

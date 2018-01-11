package levy.daniel.application.model.metier.personne.idinsee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE ABSTRAITE <b>AbstractIdInsee</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>AbstractIdInsee</b> modélise un <b>IdInsee</b>, c'est à dire un 
 * <b>identifiant INSEE</b> qui identifie de manière 
 * unique une Personne.<br/>
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
 * <li><b>IIdInsee</b>.</li>
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
 * <span style="text-decoration: underline;">
 * INTERFACES ET HERITAGE
 * </span>
 * </p>
 * <ul>
 * <li>l'objet IdInsee hérite de la classe abstraite AbstractIdInsee 
 * qui implémente l'INTERFACE IIdInsee : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_idInsee.png" 
 * alt="implémentation du IdInsee" border="1" align="center" />
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
 * <li>La <b>stratégie de jointure des tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_idinsee_entities.png" 
 * alt="implémentation des entities de AbstractIdInsee" border="1" align="center" />
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
 * <img src="../../../../../../../../../../javadoc/images/tables-abstract_ids_insee-ids_insee.png" 
 * alt="implémentation des tables de AbstractIdInsee" border="1" align="center" />
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
 * d'un AbstractIdInsee sont les suivantes :
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
@Entity(name="AbstractIdInsee")
@Table(name = "ABSTRACT_IDS_INSEE", schema = "PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_NUMEROINSEE"
, columnNames={"NUMEROINSEE"})
, indexes={@Index(name = "INDEX_NUMEROINSEE", columnList="NUMEROINSEE")})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractIdInsee implements IIdInsee {

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
	private Long id;


	/**
	 * numeroInsee : String :<br/>
	 * Identifiant INSEE d'une Personne.<br/>
	 * <ul>
	 * <li>"RG_IDINSEE_NUMEROINSEE_RENSEIGNE_01 : le numeroInsee 
	 * du IdInsee doit être renseigné (obligatoire)".</li>
	 * <li>"RG_IDINSEE_NUMEROINSEE_LONGUEUR_02 : le numeroInsee du IdInsee
	 *  doit contenir entre [5] et [30] caractères".</li>
	 * </ul>
	 */
	private String numeroInsee;
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractIdInsee.class);

	
	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractIdInsee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractIdInsee() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractIdInsee(
	 * String pNumeroInsee) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS id en BASE</li>
	 * </ul>
	 *
	 * @param pNumeroInsee : String : 
	 * Identifiant INSEE d'une Personne.<br/>
	 */
	public AbstractIdInsee(
			final String pNumeroInsee) {
		this(null, pNumeroInsee);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractIdInsee(
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
	public AbstractIdInsee(
			final Long pId
				, final String pNumeroInsee) {
		
		super();
		
		this.id = pId;
		this.numeroInsee = pNumeroInsee;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result 
				+ ((this.numeroInsee == null) ? 0 
						: this.numeroInsee.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un AbstractIdInsee</b> sur :
	 * <li>numeroInsee.</li>
	 *</ul>
	 * <br/>
	 */
	@Override
	public final boolean equals(
			final Object pObject) {
		
		if (this == pObject) {
			return true;
		}
		
		if (pObject == null) {
			return false;
		}
		
		if (!(pObject instanceof AbstractIdInsee)) {
			return false;
		}
		
		final AbstractIdInsee other = (AbstractIdInsee) pObject;
		
		if (this.numeroInsee == null) {
			if (other.numeroInsee != null) {
				return false;
			}
		} else if (!this.numeroInsee
				.equalsIgnoreCase(other.numeroInsee)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IIdInsee pObject) {
		
		if (this == pObject) {
			return 0;
		}
		
		if (pObject == null) {
			return -1;
		}
		
		int compareNumeroInsee = 0;
		
		/* numeroInsee. */
		if (this.getNumeroInsee() == null) {
			if (pObject.getNumeroInsee() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObject.getNumeroInsee() == null) {
			return -1;
		}
		
		compareNumeroInsee 
		= this.getNumeroInsee()
			.compareToIgnoreCase(pObject.getNumeroInsee());
		
		return compareNumeroInsee;

	} // Fin de compareTo(...).____________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final AbstractIdInsee clone() throws CloneNotSupportedException {
		
		final AbstractIdInsee clone = (AbstractIdInsee) super.clone();
		
		clone.setId(this.id);
		clone.setNumeroInsee(this.numeroInsee);
		
		return clone;
		
	} // Fin de clone().___________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("AbstractIdInsee [");
		
		/* id. */
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);			
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* numeroInsee. */
		builder.append("numeroInsee=");
		if (this.numeroInsee != null) {			
			builder.append(this.numeroInsee);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Transient
	@Override
	public final String getEnTeteCsv() {
		return "id;numeroInsee;";
	} // Fin de getEnTeteCsv().____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toStringCsv() {
		
		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		
		/* numeroInsee. */
		stb.append(this.getNumeroInsee());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________
	
	

	/**
	 * {@inheritDoc}
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
			entete = "numeroInsee";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________
	
	

	/**
	 * {@inheritDoc}
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
			valeur = this.getNumeroInsee();			
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
	@Column(name="ID_ABSTRACT_IDINSEE")
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
	@Column(name = "NUMEROINSEE"
			, unique = false, nullable = false
			, updatable = true, insertable = true)
	@Size(min = 5, max = 30)
	@Override
	public String getNumeroInsee() {
		return this.numeroInsee;
	} // Fin de getNumeroInsee().__________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNumeroInsee(
			final String pNumeroInsee) {
		this.numeroInsee = pNumeroInsee;
	} // Fin de setNumeroInsee(...)._______________________________________
	


} // FIN DE LA CLASSE AbstractIdInsee.---------------------------------------

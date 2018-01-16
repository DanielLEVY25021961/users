package levy.daniel.application.model.metier.personne.nommage;

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
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE ABSTRAITE <b>AbstractNommage</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>AbstractNommage</b> modélise un un <i>concept</i> 
 * de <b>Nommage</b>, c'est à dire un couple
 * <b>[nom - prenom]</b> ou un triplet <b>[nom - prenom - prenom2]</b> 
 * qui identifie <i>une ou plusieurs</i> <b>Personne</b>.<br/>
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
 * <li><b>INommage</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout INommage possède à minima :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>nom</b>.</li>
 * <li><b>prenom</b>.</li>
 * </ul>
 * 
 *  <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un INommage est vérifiée sur :</li>
  * <ul>
 * <li><b>nom</b></li>
 * <li><b>prenom</b></li>
 * </ul>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_nommage.png" 
 * alt="classes d'implémentation des AbstractNommage" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * ENTITIES JPA
 * </span>
 * </p>
 * <ul>
 * <li>la classe abstraite AbstractNommage 
 * est transformée en <b>Entity JPA</b> au moyen de 
 * <b>javax.persistence annotations</b>.</li>
 * <li>La <b>stratégie de jointure des tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_nommage_entities.png" 
 * alt="implémentation des entities de AbstractNommage" border="1" align="center" />
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
 * <img src="../../../../../../../../../../javadoc/images/tables-abstract_nommages_nommages.png" 
 * alt="implémentation des tables de AbstractNommage" border="1" align="center" />
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
 * d'un INommage sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">
 * prenom
 * </td>
 * <td>
 * "RG_NOMMAGE_PRENOM_RENSEIGNE_01 : 
 * le prénom du Nommage doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_PRENOM_LITTERAL_02 : 
 * le prénom du Nommage 
 * ne doit contenir que des lettres ou des 
 * caractères spéciaux '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_PRENOM_LONGUEUR_03 : 
 * le prénom du Nommage doit contenir 
 * entre [1] et [30] lettres"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">
 * nom
 * </td>
 * <td>
 * "RG_NOMMAGE_NOM_RENSEIGNE_04
 *  : le nom du Nommage doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_NOM_LITTERAL_05
 *  : le nom du Nommage 
 *  ne doit contenir que des lettres ou des caractères spéciaux 
 *  '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_NOMMAGE_NOM_LONGUEUR_06
 *  : le nom du Nommage doit contenir entre 
 *  [1] et [50] lettres"
 * </td>
 * </tr>
 * 
 * </table>
 * </ul>
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
@Entity(name="AbstractNommage")
@Table(name = "ABSTRACT_NOMMAGES", schema = "PUBLIC"
, indexes={@Index(name = "INDEX_NOM_PRENOM", columnList="NOM, PRENOM")})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractNommage implements INommage {

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
	 * prenom : String :<br/>
	 * Prénom du Nommage.<br/>
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
	 */
	protected String prenom;
	
	
	/**
	 * nom : String :<br/>
	 * Nom du Nommage.<br/>
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
	 */
	protected String nom;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractNommage.class);


	// *************************METHODES************************************/


	
	 /**
	 * method CONSTRUCTEUR AbstractNommage() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractNommage() {
		this(null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractNommage(
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
	public AbstractNommage(
			final String pPrenom
					, final String pNom) {
		
		this(null, pPrenom, pNom);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractNommage(
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
	public AbstractNommage(
			final Long pId
				, final String pPrenom
					, final String pNom) {
		
		super();
		
		this.id = pId;
		this.prenom = pPrenom;
		this.nom = pNom;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		
		int result = 1;
		
		result = prime * result 
				+ ((this.nom == null) ? 0 : this.nom.hashCode());
		result = prime * result 
				+ ((this.prenom == null) ? 0 : this.prenom.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un AbstractNommage</b> sur :
	 * <li>nom.</li>
	 * <li>prenom.</li>
	 * </ul>
	 * <br/>
	 */
	@Override
	public boolean equals(
			final Object pObject) {

		if (this == pObject) {
			return true;
		}
		
		if (pObject == null) {
			return false;
		}
		
		if (!(pObject instanceof AbstractNommage)) {
			return false;
		}
		
		final AbstractNommage other = (AbstractNommage) pObject;
		
		/* nom. */
		if (this.nom == null) {
			if (other.nom != null) {
				return false;
			}
		}
		else if (!this.nom.equals(other.nom)) {
			return false;
		}
		
		/* prenom. */
		if (this.prenom == null) {
			if (other.prenom != null) {
				return false;
			}
		}
		else if (!this.prenom.equals(other.prenom)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final INommage pObject) {

		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}
		
		int compareNom = 0;
		int comparePrenom = 0;
		
		/* Nom. */
		if (this.getNom() == null) {
			if (pObject.getNom() != null) {
				return +1;
			}
		} else {
			if (pObject.getNom() == null) {
				return -1;
			}
			
			compareNom 
			= this.getNom().compareToIgnoreCase(pObject.getNom());
		
			if (compareNom != 0) {
				return compareNom;
			}
		}
		
		/* Prenom. */
		if (this.getPrenom() == null) {
			if (pObject.getPrenom() != null) {
				return +1;
			}
			return 0;
		} 
		
		if (pObject.getPrenom() == null) {
			return -1;
		}
		
		comparePrenom 
			= this.getPrenom().compareToIgnoreCase(pObject.getPrenom());
		
		return comparePrenom;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractNommage clone() throws CloneNotSupportedException {

		final AbstractNommage clone = (AbstractNommage) super.clone();
		
		clone.setId(this.id);
		clone.setNom(this.nom);
		clone.setPrenom(this.prenom);
		
		return clone;
		
	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("AbstractNommage [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);			
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nom=");
		if (this.nom != null) {			
			builder.append(this.nom);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("prenom=");
		if (this.prenom != null) {			
			builder.append(this.prenom);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */	
	@Override
	@Transient
	public String getEnTeteCsv() {
		return "id;nom;prenom;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {
		
		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		
		/* nom. */
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		
		/* prenom. */
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public String getEnTeteColonne(
			final int pI) {
		
		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;
			
		case 1:
			entete = "nom";
			break;
			
		case 2:
			entete = "prenom";
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
	@Override
	@Transient
	public Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			break;

		case 1:
			valeur = this.getNom();		
			break;
			
		case 2:
			valeur = this.getPrenom();
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
	@Column(name="ID_ABSTRACT_NOMMAGE")
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
	@Column(name = "PRENOM"
	, unique = false, nullable = false
	, updatable = true, insertable = true)
	@Size(min = 1, max = 30)
	@Override
	public String getPrenom() {
		return this.prenom;
	} // Fin de getPrenom()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(
			final String pPrenom) {
		this.prenom = pPrenom;
	} // Fin de setPrenom(...).____________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "NOM"
	, unique = false, nullable = false
	, updatable = true, insertable = true)
	@Size(min = 1, max = 50)
	@Override
	public String getNom() {
		return this.nom;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	} // Fin de setNom(...)._______________________________________________



} // FIN DE LA CLASSE AbstractNommage.---------------------------------------

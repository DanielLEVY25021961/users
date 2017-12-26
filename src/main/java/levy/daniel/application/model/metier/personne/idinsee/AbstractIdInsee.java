package levy.daniel.application.model.metier.personne.idinsee;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractIdInsee :<br/>
 * .<br/>
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
	@Column(name="ID_IDINSEE")
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

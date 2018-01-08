package levy.daniel.application.model.metier.personne.nommage.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.nommage.AbstractNommage;
import levy.daniel.application.model.metier.personne.nommage.INommage;


/**
 * CLASSE CONCRETE <b>Nommage2</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>Nommage2</b> modélise un un <i>concept</i> 
 * de <b>Nommage</b> avec nom, un prenom et un deuxième prenom, 
 * c'est à dire un triplet <b>[nom - prenom - prenom2]</b>  
 * qui identifie <i>une ou plusieurs</i> <b>Personne</b>.<br/>
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
@Entity(name="Nommage2")
@Table(name = "NOMMAGES2", schema = "PUBLIC")
@PrimaryKeyJoinColumn(name = "ID_ABSTRACT_NOMMAGE"
, foreignKey=@ForeignKey(name="FK_NOMMAGE2_ABSTRACTNOMMAGE"))
public class Nommage2 extends AbstractNommage {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * prenom2 : String :<br/>
	 * Deuxième Prénom du Nommage.<br/>
	 * <ul>
	 * <li>"RG_NOMMAGE_PRENOM2_RENSEIGNE_01 : 
	 * le prénom2 du Nommage doit être renseigné (obligatoire)".</li>
	 * <li>"RG_NOMMAGE_PRENOM2_LITTERAL_02 : 
	 * le prénom2 du Nommage 
	 * ne doit contenir que des lettres ou des 
	 * caractères spéciaux '-', '_', ... (aucun chiffre)".</li>
	 * <li>"RG_NOMMAGE_PRENOM2_LONGUEUR_03 : 
	 * le prénom2 du Nommage doit contenir 
	 * entre [1] et [30] lettres".</li>
	 * </ul>
	 */
	private String prenom2;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Nommage2.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR Nommage2() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public Nommage2() {
		this(null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Nommage2(
	 * String pPrenom
	 * , String pPrenom2
	 * , String pNom) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pPrenom : String : Prénom du Nommage.<br/>
	 * @param pPrenom2 : String : Deuxième Prénom du Nommage.<br/>
	 * @param pNom : String : Nom du Nommage.<br/>
	 */
	public Nommage2(
			final String pPrenom
				, final String pPrenom2
					, final String pNom) {
		
		this(null, pPrenom, pPrenom2, pNom);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR Nommage2(
	 * Long pId
	 * , String pPrenom
	 * , String pPrenom2
	 * , String pNom) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pPrenom : String : Prénom du Nommage.<br/>
	 * @param pPrenom2 : String : Deuxième Prénom du Nommage.<br/>
	 * @param pNom : String : Nom du Nommage.<br/>
	 */
	public Nommage2(
			final Long pId
				, final String pPrenom
					, final String pPrenom2
						, final String pNom) {
		
		super(pId, pPrenom, pNom);
		
		this.prenom2 = pPrenom2;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		
		int result = super.hashCode();
		
		result = prime * result 
				+ ((this.prenom2 == null) ? 0 : this.prenom2.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
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
		
		if (!super.equals(pObject)) {
			return false;
		}
		
		if (!(pObject instanceof Nommage2)) {
			return false;
		}
		
		
		final Nommage2 other = (Nommage2) pObject;
		
		if (this.prenom2 == null) {
			if (other.prenom2 != null) {
				return false;
			}
		}
		else if (!this.prenom2.equalsIgnoreCase(other.prenom2)) {
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
		
		if (!(pObject instanceof Nommage2)) {
			return -1;
		}
				
		int compareNom = 0;
		int comparePrenom = 0;
		int comparePrenom2 = 0;
		
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
		} else {
			
			if (pObject.getPrenom() == null) {
				return -1;
			}
			
			comparePrenom 
				= this.getPrenom()
					.compareToIgnoreCase(pObject.getPrenom());
			
			if (comparePrenom != 0) {
				return comparePrenom;
			}
		}
		
		final Nommage2 other = (Nommage2) pObject;
		
		/* Prenom2. */
		if (this.getPrenom2() == null) {
			if (other.getPrenom2() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (other.getPrenom2() == null) {
			return -1;
		}
		
		comparePrenom2 
			= this.getPrenom2()
				.compareToIgnoreCase(other.getPrenom2());
		
		return comparePrenom2;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nommage2 clone() throws CloneNotSupportedException {

		final Nommage2 clone = (Nommage2) super.clone();
		
		clone.setId(this.getId());
		clone.setNom(this.getNom());
		clone.setPrenom(this.getPrenom());
		clone.setPrenom2(this.getPrenom2());
		
		return clone;
		
	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("Nommage2 [");
		
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
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("prenom2=");
		if (this.prenom2 != null) {			
			builder.append(this.prenom2);
		} else {
			builder.append(NULL);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un Nommage2</b> :<br/>
	 * "id;nom;prenom;prenom2;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public String getEnTeteCsv() {
		return "id;nom;prenom;prenom2;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un Nommage2</b> :<br/>
	 * "id;nom;prenom;prenom2;".<br/>
	 * <br/>
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
		
		/* prenom2. */
		stb.append(this.getPrenom2());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête JTable pour un Nommage2</b> :<br/>
	 * "id;nom;prenom;prenom2;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
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
			
		case 3:
			entete = "prenom2";
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
	 * <b>ligne Jtable pour un INommage</b> :<br/>
	 * "id;nom;prenom;prenom2;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
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
			
		case 3:
			valeur = this.getPrenom2();
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;
			
	} // Fin de getValeurColonne(...)._____________________________________


	
	/**
	 * method getPrenom2() :<br/>
	 * <ul>
	 * <li>Getter du deuxième prénom.</li>
	 * </ul>
	 *
	 * @return : String : this.prenom2.<br/>
	 */
	@Column(name = "PRENOM2"
	, unique = false, nullable = false
	, updatable = true, insertable = true)
	@Size(min = 1, max = 30)
	public String getPrenom2() {
		return this.prenom2;
	} // Fin de getPrenom2().______________________________________________


	

	/**
	 * method setPrenom2(
	 * String pPrenom2) :<br/>
	 * <ul>
	 * <li>Setter du deuxième prénom.</li>
	 * </ul>
	 *
	 * @param pPrenom2 : String : valeur à passer à this.prenom2.<br/>
	 */
	public void setPrenom2(
			final String pPrenom2) {
		this.prenom2 = pPrenom2;
	} // Fin de setPrenom2(...).___________________________________________


	
} // FIN DE LA CLASSE Nommage2.----------------------------------------------

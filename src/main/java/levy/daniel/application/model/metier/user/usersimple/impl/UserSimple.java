package levy.daniel.application.model.metier.user.usersimple.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.user.usersimple.IUserSimple;


/**
 * class UserSimple :<br/>
 * 
 * <ul>
 * <li><b>UserSimple</b> modélise un User (Internaute) qui se logge 
 * à l'application et qui n'a pas plusieurs <i>profils</i> 
 * ou <i>Rôles</i>.</li>
 * <li>Implémentation <b>CONCRETE</b> de IUserSimple.</li>
 * <li>IMPLEMENTE Serializable.</li>
 * <li>IMPLEMENTE IUserSimple.</li>
 * <li>Objet <b>composite</b> avec les <b>composants</b> 
 * "Civilite" et "ProfilSimple".</li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">ATTRIBUTS</span>
 * </p>
 * <li>Les <b>attributs</b> d'un UserSimple sont : </li>
 * <ul>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>civilite</b> (M., Mme, ...).</li>
 * <li><b>prenom</b>.</li>
 * <li><b>nom</b>.</li>
 * <li><b>email</b>.</li>
 * <li><b>login</b>.</li>
 * <li><b>mot de passe (mdp)</b>.</li>
 * <li><b>profil</b> (Adminstrateur, Utilisateur, ...).</li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <li>
 * L'<b>égalité metier</b> d'un UserSimple est vérifiée sur :
 * <ul>
 * <li><b>login</b></li>
 * <li><b>mdp</b></li>
 * </ul>
 * </li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">RELATIONS</span>
 * </p>
 * <li>
 * La civilité (M., Mme, Mlle, ...) d'un UserSimple est un 
 * Objet <b>Civilite</b> qui ne peut prendre que certaines valeurs 
 * définies dans une énumération CivilitesEnum.<br/>
 * <b>Un</b> UserSimple a <b>au plus un</b> Civilite (M., Mlle, ...).<br/> 
 * <b>Un</b> Civilite peut correspondre à 0 ou <b>plusieurs</b> UserSimple.<br/>
 * La relation UserSimple-Civilite est de type <b>MANY-TO-ONE</b>.
 * </li>
 * <br/>
 * <li>
 * Le profil (ADMINISTRATEUR, UTILISATEUR, ...) d'un UserSimple est un 
 * Objet <b>ProfilSimple</b> qui ne peut prendre que certaines valeurs 
 * définies dans une énumération ProfilsSimplesEnum.<br/>
 * <b>Un</b> UserSimple a <b>un et un seul</b> ProfilSimple (ADMINISTRATEUR, ...).<br/> 
 * <b>Un</b> ProfilSimple peut correspondre à 0 ou <b>plusieurs</b> UserSimple.<br/>
 * La relation UserSimple-ProfilSimple est de type <b>MANY-TO-ONE</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_UserSimple_detaille.png" 
 * alt="implémentation du UserSimple détaillée avec Objets composants" border="1" align="center" />
 * </li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">INTERFACES ET HERITAGE</span>
 * </p>
 * <li>l'objet UserSimple implémente l'INTERFACE IUserSimple : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_UserSimple.png" 
 * alt="implémentation du UserSimple" border="1" align="center" />
 * </li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">ENTITIES JPA</span>
 * </p>
 * <li>L'<b>Entity JPA</b> est définie avec les 
 * <b>javax.persistence annotations</b> suivantes : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/UserSimple_Entity.png" 
 * alt="implémentation de l'Entity UserSimple" border="1" align="center" />
 * </li>
 * 
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
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * <tr>
 * <td>civilite</td>
 * <td>"RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : la civilite (M., Mme, ...) 
 * du UserSimple doit respecter un ensemble fini de valeurs (nomenclature)"</td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">
 * prenom
 * </td>
 * <td>
 * "RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : le prénom du UserSimple 
 * doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_PRENOM_LITTERAL_03 : le prénom du UserSimple ne 
 * doit contenir que des lettres ou des caractères spéciaux 
 * '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_PRENOM_LONGUEUR_04 : le prénom du UserSimple 
 * doit contenir entre [1] et [30] lettres"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">nom</td>
 * <td>"RG_USERSIMPLE_NOM_RENSEIGNE_05 : le nom du UserSimple 
 * doit être renseigné (obligatoire)"</td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_NOM_LITTERAL_06 : le nom du UserSimple 
 * ne doit contenir que des lettres ou des caractères spéciaux 
 * '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_NOM_LONGUEUR_07 : le nom du UserSimple 
 * doit contenir entre [1] et [50] lettres"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td>email</td>
 * <td>"RG_USERSIMPLE_EMAIL_MOTIF_08 : l'email du UserSimple 
 * doit respecter un motif (Regex) d'un email 
 * (du type albacor.trust@google.fr)"</td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * login
 * </td>
 * <td>
 * "RG_USERSIMPLE_LOGIN_RENSEIGNE_09 : le login 
 * du UserSimple doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_LOGIN_LONGUEUR_10 : le login du UserSimple
 *  doit contenir entre [1] et [100] caractères"
 *  </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">
 * mdp
 * </td>
 * <td>
 * "RG_USERSIMPLE_MDP_RENSEIGNE_11 : le mdp du UserSimple
 *  doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_MDP_LONGUEUR_12 : le mdp du UserSimple
 *  doit contenir entre [3] et [20] caractères"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_MDP_MOTIF_13 : le mdp du UserSimple
 *  doit respecter un motif (Regex)"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * profil
 * </td>
 * <td>
 * "RG_USERSIMPLE_PROFIL_RENSEIGNE_14 : le profil du UserSimple
 *  doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 : le profil du UserSimple
 *  doit respecter un ensemble fini de valeurs (nomenclature)"
 * </td>
 * </tr>
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
 * @author dan Lévy
 * @version 1.0
 * @since 25 sept. 2017
 *
 */
@Entity(name="UserSimple")
@Table(name="USERSIMPLES", schema="PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_LOGIN_MDP"
, columnNames={"LOGIN", "MDP"})
, indexes={@Index(name = "INDEX_NOM_PRENOM", columnList="NOM, PRENOM")
, @Index(name = "INDEX_LOGIN_MDP", columnList="LOGIN, MDP")})
public class UserSimple 
	implements Serializable, IUserSimple {

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
	 * civilite : Civilite :<br/>
	 * Civilité du UserSimple (M., Mme, Mlle, ...).<br/>
	 * <ul>
	 * <li>La civilité ne peut prendre <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
	 * <li>"RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
	 * la civilite (M., Mme, ...) du UserSimple doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 */
	private Civilite civilite;
	
	
	/**
	 * prenom : String :<br/>
	 * Prénom du User.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : 
	 * le prénom du UserSimple doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_PRENOM_LITTERAL_03 : 
	 * le prénom du UserSimple 
	 * ne doit contenir que des lettres ou des 
	 * caractères spéciaux '-', '_', ... (aucun chiffre)".</li>
	 * <li>"RG_USERSIMPLE_PRENOM_LONGUEUR_04 : 
	 * le prénom du UserSimple doit contenir 
	 * entre [1] et [30] lettres".</li>
	 * </ul>
	 */
	private String prenom;
	
	
	/**
	 * nom : String :<br/>
	 * Nom du User.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_NOM_RENSEIGNE_05
	 *  : le nom du UserSimple doit être renseigné (obligatoire)".<br/></li>
	 *  <li>"RG_USERSIMPLE_NOM_LITTERAL_06
	 *  : le nom du UserSimple 
	 *  ne doit contenir que des lettres ou des caractères spéciaux 
	 *  '-', '_', ... (aucun chiffre)".</li>
	 *  <li>"RG_USERSIMPLE_NOM_LONGUEUR_07
	 *  : le nom du UserSimple doit contenir entre 
	 *  [1] et [50] lettres".</li>
	 * </ul>
	 */
	private String nom;
	

	/**
	 * email : String :<br/>
	 * E-mail du UserSimple.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_EMAIL_MOTIF_08
	 *  : l'email du UserSimple doit respecter un motif (Regex) 
	 *  d'un email (du type albacor.trust@google.fr)".<br/></li>
	 * </ul>
	 */
	private String email;
	
	
	/**
	 * login : String :<br/>
	 * login.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_LOGIN_RENSEIGNE_09
	 *  : le login du UserSimple
	 *   doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_LOGIN_LONGUEUR_10
	 *  : le login du UserSimple 
	 *  doit contenir entre [1] et [100] caractères".</li>
	 * </ul>
	 */
	private String login;

	
	/**
	 * mdp : String :<br/>
	 * Mot de passe.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_MDP_RENSEIGNE_11
	 *  : le mdp du UserSimple
	 *   doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_MDP_LONGUEUR_12
	 *  : le mdp du UserSimple
	 *   doit contenir entre [3] et [20] caractères".</li>
	 * <li>"RG_USERSIMPLE_MDP_MOTIF_13
	 *  : le mdp du UserSimple
	 *   doit respecter un motif (Regex)".</li>
	 * </ul>
	 */
	private String mdp;

	
	/**
	 * profil : ProfilSimple :<br/>
	 * Profil du UserSimple (administrateur, modérateur, ...).<br/>
	 */
	private ProfilSimple profil;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(UserSimple.class);


	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR UserSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public UserSimple() {
		this(null, null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR UserSimple() :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en Base.</li>
	 * </ul>>
	 *
	 * @param pCivilite : Civilite : Civilité du UserSimple 
	 * (M., Mme, Mlle, ...).<br/>
	 * @param pPrenom : String : Prénom du User.<br/>
	 * @param pNom : String : Nom du User.<br/>
	 * @param pEmail : String : E-mail du UserSimple.<br/>
	 * @param pLogin : String : Login.<br/>
	 * @param pMdp : String : Mot de passe.<br/>
	 * @param pProfil : ProfilSimple : Profil du UserSimple 
	 * (administrateur, modérateur, ...).<br/>
	 */
	public UserSimple(
			final Civilite pCivilite
			, final String pPrenom, final String pNom
			, final String pEmail
			, final String pLogin, final String pMdp
				, final ProfilSimple pProfil) {
		
		this(null
				, pCivilite
				, pPrenom, pNom
				, pEmail
				, pLogin, pMdp
				, pProfil);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR UserSimple(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID EN BASE.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCivilite : Civilite : Civilité du UserSimple 
	 * (M., Mme, Mlle, ...).<br/>
	 * @param pPrenom : String : Prénom du User.<br/>
	 * @param pNom : String : Nom du User.<br/>
	 * @param pEmail : String : E-mail du UserSimple.<br/>
	 * @param pLogin : String : Login.<br/>
	 * @param pMdp : String : Mot de passe.<br/>
	 * @param pProfil : ProfilSimple : Profil du UserSimple 
	 * (administrateur, modérateur, ...).<br/>
	 */
	public UserSimple(
			final Long pId
			, final Civilite pCivilite
			, final String pPrenom, final String pNom
			, final String pEmail
			, final String pLogin, final String pMdp
				, final ProfilSimple pProfil) {
		
		super();
		
		this.id = pId;
		this.civilite = pCivilite;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.email = pEmail;
		this.login = pLogin;
		this.mdp = pMdp;
		this.profil = pProfil;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		
		int result = 1;
		
		result = prime * result 
				+ ((this.login == null) ? 0 : this.login.hashCode());
		result = prime * result 
				+ ((this.mdp == null) ? 0 : this.mdp.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ol>
	 * equals sur
	 * <li><b>login</b>.</li>
	 * <li><b>mot de passe</b>.</li>
	 * </ol>
	 */
	@Override
	public final boolean equals(
			final Object pObj) {

		if (this == pObj) {
			return true;
		}
		
		if (pObj == null) {
			return false;
		}
		
		if (!(pObj instanceof UserSimple)) {
			return false;
		}
		
		final UserSimple other = (UserSimple) pObj;
		
		/* login. */
		if (this.login == null) {
			if (other.login != null) {
				return false;
			}
		}
		else if (!this.login.equals(other.login)) {
			return false;
		}
		
		/* mdp. */
		if (this.mdp == null) {
			if (other.mdp != null) {
				return false;
			}
		}
		else if (!this.mdp.equals(other.mdp)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IUserSimple pObject) {

		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareLogin = 0;
		int compareMdp = 0;
		
		/* login. */
		if (this.getLogin() == null) {
			if (pObject.getLogin() != null) {
				return +1;
			}
		} else {
			if (pObject.getLogin() == null) {
				return -1;
			}
			
			compareLogin 
			= this.getLogin().compareToIgnoreCase(pObject.getLogin());
		
			if (compareLogin != 0) {
				return compareLogin;
			}
		}
		
		
		/* Mdp. */
		if (this.getMdp() == null) {
			if (pObject.getMdp() != null) {
				return +1;
			}
			return 0;
		} 
		
		if (pObject.getMdp() == null) {
			return -1;
		}
		
		compareMdp 
			= this.getMdp().compareToIgnoreCase(pObject.getMdp());
		
		return compareMdp;
		
	} // Fin de compareTo(...).____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final UserSimple clone() throws CloneNotSupportedException {
		
		final UserSimple clone = (UserSimple) super.clone();
		
		clone.setId(this.getId());
		clone.setCivilite(this.getCivilite());
		clone.setPrenom(this.getPrenom());
		clone.setNom(this.getNom());
		clone.setEmail(this.getEmail());
		clone.setLogin(this.getLogin());
		clone.setMdp(this.getMdp());
		clone.setProfil(this.getProfil());
		
		return clone;
		
	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("UserSimple [");
		
		/* id. */
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* civilite. */
		builder.append("civilité=");
		if (this.civilite != null) {
			builder.append(this.civilite.getCiviliteString());
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* prenom. */
		builder.append("prénom=");
		if (this.prenom != null) {
			builder.append(this.prenom);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* nom. */
		builder.append("nom=");
		if (this.nom != null) {
			builder.append(this.nom);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);

		/* email. */
		builder.append("e-mail=");
		if (this.email != null) {
			builder.append(this.email);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* login. */
		builder.append("login=");
		if (this.login != null) {			
			builder.append(this.login);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* mdp. */
		builder.append("mdp=");
		if (this.mdp != null) {			
			builder.append(this.mdp);
		} else {
			builder.append(NULL);
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* profil. */
		builder.append("profil=");
		if (this.profil != null) {			
			builder.append(this.profil.getProfilString());
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
		return "id;civilité;prénom;nom;e-mail;login;mdp;profil;";
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
		/* civilite. */
		if (this.getCivilite() != null) {
			stb.append(this.getCivilite().getCiviliteString());
		} else {
			stb.append(NULL);
		}		
		stb.append(POINT_VIRGULE);
		/* prenom. */
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);
		/* nom. */
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		/* email. */
		stb.append(this.getEmail());
		stb.append(POINT_VIRGULE);
		/* login. */
		stb.append(this.getLogin());
		stb.append(POINT_VIRGULE);
		/* mdp. */
		stb.append(this.getMdp());
		stb.append(POINT_VIRGULE);
		/* profil. */
		if (this.getProfil() != null) {
			stb.append(this.getProfil().getProfilString());
		} else {
			stb.append(NULL);
		}		
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
			entete = "civilité";
			break;
			
		case 2:
			entete = "prénom";
			break;
			
		case 3:
			entete = "nom";
			break;
			
		case 4:
			entete = "e-mail";
			break;

		case 5:
			entete = "login";
			break;

		case 6:
			entete = "mdp";
			break;

		case 7:
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
	 */
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
			if (this.getCivilite() != null) {
				valeur = this.getCivilite().getCiviliteString();
			}
			
			break;
			
		case 2:
			valeur = this.getPrenom();
			break;
			
		case 3:
			valeur = this.getNom();
			break;
			
		case 4:
			valeur = this.getEmail();
			break;
			
		case 5:
			valeur = this.getLogin();
			break;

		case 6:
			valeur = this.getMdp();
			break;

		case 7:
			if (this.getProfil() != null) {
				valeur = this.getProfil().getProfilString();
			}
			
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
	@Column(name="ID_USERSIMPLE")
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
	@ManyToOne(targetEntity = Civilite.class
			, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CIVILITE"
	, unique = false, nullable = true
	, insertable = true, updatable = true
	, foreignKey = @ForeignKey(name = "FK_USERSIMPLE_CIVILITE"))
	@Override
	public Civilite getCivilite() {
		return this.civilite;
	} // Fin de getCivilite()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCivilite(
			final Civilite pCivilite) {
		this.civilite = pCivilite;
	} // Fin de setCivilite(...).__________________________________________



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


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "EMAIL"
	, unique = false, nullable = true
	, updatable = true, insertable = true)
	@Override
	public String getEmail() {
		return this.email;
	} // Fin de getEmail().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEmail(
			final String pEmail) {
		this.email = pEmail;
	} // Fin de setEmail(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Column(name = "LOGIN"
	, unique = false, nullable = false
	, updatable = true, insertable = true)
	@Size(min = 1, max = 100)
	@Override
	public String getLogin() {	
		return this.login;
	} // Fin de getLogin().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLogin(
			final String pLogin) {	
		this.login = pLogin;
	} // Fin de setLogin(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Column(name = "MDP"
	, unique = false, nullable = false
	, updatable = true, insertable = true)
	@Size(min = 3, max = 20)
	@Override
	public String getMdp() {	
		return this.mdp;
	} // Fin de getMdp().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMdp(
			final String pMdp) {	
		this.mdp = pMdp;
	} // Fin de setMdp(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@ManyToOne(targetEntity = ProfilSimple.class
			, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROFIL"
	, unique = false, nullable = false
	, insertable = true, updatable = true
	, foreignKey = @ForeignKey(name = "FK_USERSIMPLE_PROFILSIMPLE"))
	@Override
	public ProfilSimple getProfil() {	
		return this.profil;
	} // Fin de getProfil()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfil(
			final ProfilSimple pProfil) {	
		this.profil = pProfil;
	} // Fin de setProfil(...).____________________________________________

	
	
} // FIN DE LA CLASSE UserSimple.--------------------------------------------------

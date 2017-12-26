package levy.daniel.application;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.usersimple.IDaoCivilite;
import levy.daniel.application.model.dao.metier.usersimple.IDaoProfilSimple;
import levy.daniel.application.model.dao.metier.usersimple.IDaoUserSimple;
import levy.daniel.application.model.metier.user.usersimple.IUserSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.UserSimple;
import levy.daniel.application.model.services.metier.usersimple.impl.ServiceUserSimple;

/**
 * class AppSpring :<br/>
 * Tests des DAO et SERVICES sous SPRING sans avoir besoin 
 * de lancer l'application WEB sous TOMCAT.<br/>
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
 * @since 21 déc. 2017
 *
 */
public final class AppSpring {

	// ************************ATTRIBUTS************************************/

	/**
	 * APPLICATIONCONTEXT_PATH : String :<br/>
	 * "classpath*:applicationContext.xml".<br/>
	 */
	private static final String APPLICATIONCONTEXT_PATH 
		= "classpath*:applicationContext.xml";

	
	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";

	
	/**
	 * serviceUserSimple : ServiceUserSimple :<br/>
	 * SERVICE pour les UserSimple.<br/>
	 */
	public static ServiceUserSimple serviceUserSimple;
	
	
	/**
	 * daoUserSimple : IDaoUserSimple :<br/>
	 * DAO pour les UserSimple.<br/>
	 */
	public static IDaoUserSimple daoUserSimple;
	
	
	/**
	 * daoCivilite : IDaoCivilite :<br/>
	 * DAO pour les Civilite des UserSimple.<br/>
	 */
	public static IDaoCivilite daoCivilite;
	
	
	/**
	 * daoProfilSimple : IDaoProfilSimple :<br/>
	 * DAO pour les ProfilSimple des UserSimple.<br/>
	 */
	public static IDaoProfilSimple daoProfilSimple;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AppSpring.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AppSpring() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	private AppSpring() {
		super();
	}
	
	
	
	/**
	 * method main() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param args : void :  .<br/>
	 * @throws AbstractDaoException 
	 */
	public static void main(
			final String[] args) throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		// ******************************************
		// Création de l'applicationCONTEXT SPRING 
		// avec lecture du fichier de configuration
		// applicationContext.xml.
		// ******************************************
		final AbstractApplicationContext context 
			= new ClassPathXmlApplicationContext(APPLICATIONCONTEXT_PATH);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			/* Affichage des Beans SPRING instanciés dans le Contexte. */
			final String affichageBeans = beansToString(context);
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("BEANS INSTANCIES DANS LE CONTENEUR SPRING : ");
			System.out.println(TIRETS);
			System.out.println(affichageBeans);
			System.out.println(TIRETS);
			System.out.println();
			
		}

		
		/* Obtention du bean serviceUserSimple 
		 * auprès du contexte SPRING. */
		serviceUserSimple 
			= (ServiceUserSimple) 
				context.getBean("ServiceUserSimple");
		
		/* Obtention du bean daoUserSimple 
		 * auprès du contexte SPRING. */
		daoUserSimple 
			= (IDaoUserSimple) 
				context.getBean("DaoUserSimple");
		
		/* Obtention du bean daoCivilite 
		 * auprès du contexte SPRING. */
		daoCivilite 
			= (IDaoCivilite) 
				context.getBean("DaoCivilite");
		
		/* Obtention du bean daoProfilSimple
		 * auprès du contexte SPRING. */
		daoProfilSimple 
			= (IDaoProfilSimple) 
				context.getBean("DaoProfilSimple");
		
		
		final IUserSimple objet1 
		= new UserSimple(
				Civilite.MADAME
				, "Prénom1", "Nom1"
				, "prenom1.nom1@free.fr"
				, "prenom1.nom1", "mdp1"
				, ProfilSimple.ADMINISTRATEUR);
		
		final IUserSimple objet2 
		= new UserSimple(
				Civilite.MONSIEUR
				, "Prénom2", "Nom2"
				, "prenom2.nom2@free.fr"
				, "prenom2.nom2", "mdp2"
				, ProfilSimple.UTILISATEUR);

		final IUserSimple objet3 
		= new UserSimple(
				null
				, "Prénom3", "Nom3"
				, "prenom3.nom3@free.fr"
				, "prenom3.nom3", "mdp3"
				, ProfilSimple.UTILISATEUR);

		final IUserSimple objet4 
		= new UserSimple(
				Civilite.MADEMOISELLE
				, "Prénom4", "Nom4"
				, "prenom4.nom4@free.fr"
				, "prenom4.nom4", "mdp4"
				, ProfilSimple.GESTIONNAIRE_DONNEES);
		
		final IUserSimple objet5 
		= new UserSimple(
				null
				, "Roland", "Bartez"
				, "roland.bartez@free.fr"
				, "roland.bartez", "12345"
				, ProfilSimple.UTILISATEUR);
		
		
		serviceUserSimple.creer(objet1);
		serviceUserSimple.creer(objet2);
		serviceUserSimple.creer(objet3);
		serviceUserSimple.creer(objet4);
		serviceUserSimple.creer(objet5);
		
//		creerUserSimple(objet1);
//		creerUserSimple(objet2);
//		creerUserSimple(objet3);
//		creerUserSimple(objet4);
//		creerUserSimple(objet5);
		
		
		/* Clôture du contexte, sinon, fuite de mémoire. */
		context.close();

	} // Fin de main(...)._________________________________________________


	
	/**
	 * method creerUserSimple(
	 * IUserSimple pObject) :<br/>
	 * <ul>
	 * </ul>
	 * retourne null si pObject est null.<br/>
	 * <br/>
	 *
	 * @param pObject
	 * @return : UserSimple :  .<br/>
	 * @throws AbstractDaoException 
	 */
	@Transactional(
			propagation = Propagation.REQUIRED
			, readOnly = false)
	public static IUserSimple creerUserSimple(
			final IUserSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject est null. */
		if (pObject == null) {
			return null;
		}
		
		IUserSimple objetPersistant = null;
		
		Civilite civilitePersistante = null;
		final Civilite civilite = pObject.getCivilite();
		
		ProfilSimple profilSimplePersistant = null;
		final ProfilSimple profilSimple = pObject.getProfil();
		
		if (civilite != null) {
			if (!daoCivilite.exists(civilite)) {
				civilitePersistante = daoCivilite.create(civilite);
			}
			else {
				civilitePersistante = daoCivilite.retrieve(civilite);
			}
		}
		
		if (profilSimple != null) {
			if (!daoProfilSimple.exists(profilSimple)) {
				profilSimplePersistant = daoProfilSimple.create(profilSimple);
			}
			else {
				profilSimplePersistant = daoProfilSimple.retrieve(profilSimple);
			}
		}
		
		
		pObject.setCivilite(civilitePersistante);
		pObject.setProfil(profilSimplePersistant);
		
		objetPersistant = daoUserSimple.create(pObject);
		
		return objetPersistant;
		
	} // Fin de creerUserSimple(...).______________________________________


	
	/**
	 * method fournirCivilitePersistante(
	 * Civilite pCivilite) :<br/>
	 * <ul>
	 * retourne pObject <b>persistant et attachable à la session</b>.
	 * <li>retourne pObject existant en base si il existe déjà.</li>
	 * <li>crée pObject en base si il n'existe pas 
	 * et le retourne persisté.</li>
	 * </ul>
	 * retourne null si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : Civilite.<br/>
	 * 
	 * @return Civilite : Civilite persistante.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	public static Civilite fournirCivilitePersistante(
			final Civilite pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		Civilite civilitePersistante = null;
		
		if (daoCivilite.exists(pObject)) {
			civilitePersistante = daoCivilite.retrieve(pObject);
		} else {
			civilitePersistante = daoCivilite.create(pObject);
		}
		
		return civilitePersistante;
		
	} // Fin de fournirCivilitePersistante(...).___________________________
	

		
	/**
	 * method fournirProfilSimplePersistant(
	 * ProfilSimple pObject) :<br/>
	 * <ul>
	 * retourne pObject <b>persistant et attachable à la session</b>.
	 * <li>retourne pObject existant en base si il existe déjà.</li>
	 * <li>crée pObject en base si il n'existe pas 
	 * et le retourne persisté.</li>
	 * </ul>
	 * retourne null si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : ProfilSimple.<br/>
	 * 
	 * @return ProfilSimple : ProfilSimple persistant.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	public static ProfilSimple fournirProfilSimplePersistant(
			final ProfilSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		ProfilSimple profilSimplePersistant = null;
		
		if (daoProfilSimple.exists(pObject)) {
			profilSimplePersistant 
				= daoProfilSimple.retrieve(pObject);
		} else {
			profilSimplePersistant 
				= daoProfilSimple.create(pObject);
		}
		
		return profilSimplePersistant;
		
	} // Fin de fournirProfilSimplePersistant(...).________________________
	
	
	
	/**
	 * method beansToString(
	 * AbstractApplicationContext pContext) :<br/>
	 * <ul>
	 * <b>Crée et retourne une String</b> pour l'<i>affichage</i> 
	 * de la <b>liste des Beans SPRING</b> instanciés contenus dans le 
	 * contexte SPRING pContext.<br/>
	 * <li>retourne null si pContext == null.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pContext : AbstractApplicationContext : Context Spring.<br/>
	 * 
	 * @return : String : Liste des Beans instanciés contenus 
	 * dans le Context SPRING avec saut de ligne.<br/>
	 */
	public static String beansToString(
			final AbstractApplicationContext pContext) {
		
		/* retourne null si pContext == null. */
		if (pContext == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		/* Récupération du tableau de Beans 
		 * instanciés dans le conteneur SPRING. */
		final String[] tableauBeans = pContext.getBeanDefinitionNames();
		
		for (int i = 0; i < tableauBeans.length; i ++) {
			stb.append(tableauBeans[i]);
			stb.append(SAUT_LIGNE);
		}
		
		return stb.toString();
		
	} // Fin de beansToString(...).________________________________________

	
	
	
	
}

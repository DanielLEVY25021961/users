package levy.daniel.application.model.services.metier.usersimple.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.usersimple.IDaoCivilite;
import levy.daniel.application.model.dao.metier.usersimple.IDaoProfilSimple;
import levy.daniel.application.model.dao.metier.usersimple.IDaoUserSimple;
import levy.daniel.application.model.metier.user.usersimple.IUserSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilSimple;

/**
 * class ServiceUserSimple :<br/>
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
 * @since 21 déc. 2017
 *
 */
@Service(value="ServiceUserSimple")
public class ServiceUserSimple {

	// ************************ATTRIBUTS************************************/
	
	
	/**
	 * daoUserSimple : IDaoUserSimple :<br/>
	 * DAO pour les UserSimple.<br/>
	 */
	@Autowired
	public transient IDaoUserSimple daoUserSimple;
	
	
	/**
	 * daoCivilite : IDaoCivilite :<br/>
	 * DAO pour les Civilite des UserSimple.<br/>
	 */
	@Autowired
	public transient IDaoCivilite daoCivilite;
	
	
	/**
	 * daoProfilSimple : IDaoProfilSimple :<br/>
	 * DAO pour les ProfilSimple des UserSimple.<br/>
	 */
	@Autowired
	public transient IDaoProfilSimple daoProfilSimple;
	


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ServiceUserSimple.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ServiceUserSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ServiceUserSimple() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method creer(
	 * IUserSimple pObject) :<br/>
	 * <ul>
	 * </ul>
	 * return null si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : IUserSimple
	 * @return : IUserSimple :  .<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public IUserSimple creer(
			final IUserSimple pObject) throws AbstractDaoException {
		
		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
			
		IUserSimple objetPersistant = null;
		
		/* Récupération des objets composants. */
		final Civilite civilite = pObject.getCivilite();
		final ProfilSimple profilSimple = pObject.getProfil();
		
		/* Rend persistants les objets composants. */
		this.fournirCivilitePersistante(civilite);
		this.fournirProfilSimplePersistant(profilSimple);
		
		/* Mise en base de l'objet avec tous ses composants persistants*/
		objetPersistant = this.daoUserSimple.create(pObject);
		
		return objetPersistant;
		
	} // Fin de creer(...).________________________________________________
	
	
	
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
	public Civilite fournirCivilitePersistante(
			final Civilite pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		Civilite civilitePersistante = null;
		
		if (this.daoCivilite.exists(pObject)) {
			civilitePersistante = this.daoCivilite.retrieve(pObject);
		} else {
			civilitePersistante = this.daoCivilite.create(pObject);
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
	public ProfilSimple fournirProfilSimplePersistant(
			final ProfilSimple pObject) throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		ProfilSimple profilSimplePersistant = null;
		
		if (this.daoProfilSimple.exists(pObject)) {
			profilSimplePersistant 
				= this.daoProfilSimple.retrieve(pObject);
		} else {
			profilSimplePersistant 
				= this.daoProfilSimple.create(pObject);
		}
		
		return profilSimplePersistant;
		
	} // Fin de fournirProfilSimplePersistant(...).________________________
	
	
	
} // FIN DE LA CLASSE ServiceUserSimple.-------------------------------------

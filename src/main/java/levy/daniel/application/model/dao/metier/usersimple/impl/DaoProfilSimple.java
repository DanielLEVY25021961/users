package levy.daniel.application.model.dao.metier.usersimple.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.usersimple.IDaoProfilSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilSimple;


/**
 * class DaoProfilSimple :<br/>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>ProfilSimple</b>.</li>
 * <li>
 * Implémente l'interface IDaoProfilSimple.
 * </li>
 * <li>
 * Hérite de la classe abstraite 
 * AbstractDaoGenericJPASpring&lt;ProfilSimple, Long&gt;.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * <li>
 * Annoté (SPRING) <b>Repository(value="DaoProfilSimple")</b> 
 * pour l'<b>injection</b> (Autowiring) dans les SERVICES par SPRING.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DaoProfilSimple.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
 * </li>
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
 * @since 10 déc. 2017
 *
 */
@Repository(value="DaoProfilSimple")
public class DaoProfilSimple 
		extends AbstractDaoGenericJPASpring<ProfilSimple, Long> 
												implements IDaoProfilSimple {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_PROFILSIMPLE : String :<br/>
	 * "Classe DaoProfilSimple".<br/>
	 */
	public static final String CLASSE_DAO_PROFILSIMPLE 
		= "Classe DaoProfilSimple";

	
	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select profilsimple from 
	 * ProfilSimple as profilsimple ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select profilsimple from "
				+ "ProfilSimple as profilsimple ";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoProfilSimple.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR DaoProfilSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoProfilSimple() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
			final ProfilSimple pObject) 
				throws AbstractDaoException {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		/* Crée l'Objet en base ou jette une AbstractDaoException. */
		final ProfilSimple objetPersistant = this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objetPersistant == null) {
			return null;
		}

		/* retourne l'ID de l'objet persistant. */
		return objetPersistant.getId();

	} // Fin de createReturnId(...)._______________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ProfilSimple retrieve(
			final ProfilSimple pObject) 
						throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		ProfilSimple objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where profilsimple.profilString = :pProfilString";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pProfilString", pObject.getProfilString());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (ProfilSimple) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_PROFILSIMPLE
						, "Méthode retrieve(ProfilSimple pObject)", e);
		}
				
		return objetResultat;
		
	} // Fin de retrieve(...)._____________________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ProfilSimple retrieveByIdMetier(
			final ProfilSimple pObjet) throws AbstractDaoException {
		return this.retrieve(pObjet);
	} // Fin de retrieveByIdMetier(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ProfilSimple retrieveByProfil(
			final String pProfilString) throws AbstractDaoException {

		/* return null si pProfilString est blank. */
		if (StringUtils.isBlank(pProfilString)) {
			return null;
		}
		
		ProfilSimple objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where profilsimple.profilString = :pProfilString";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pProfilString", pProfilString);
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (ProfilSimple) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_PROFILSIMPLE
						, "Méthode retrieveByProfil("
								+ "String pProfilString)", e);
		}
				
		return objetResultat;
				
	} // Fin de retrieveByProfilSimple(...)._______________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<ProfilSimple> findAllSousClasse() 
								throws AbstractDaoException {
		return this.findAll();
	} // Fin de findAllSousClasse()._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<ProfilSimple> findAllMaxSousClasse(
			final Long pMax) throws AbstractDaoException {
		return this.findAllMax(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteById(
			final Long pId) throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		ProfilSimple objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where profilsimple.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (ProfilSimple) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
		}

		
		try {
			
			if (objetPersistant != null) {
				
				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);
				
				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);
				
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_DAO_PROFILSIMPLE
						, "Méthode deleteById(Long pId)", e);
		}
		
	} // Fin de deleteById(...).___________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		boolean resultat = false;
		
		ProfilSimple objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where profilsimple.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (ProfilSimple) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
			resultat = false;
		}
		
		try {
			
			if (objetPersistant != null) {
				
				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);
				
				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);
				
				resultat = true;
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_DAO_PROFILSIMPLE
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAllSousClasse() 
			throws AbstractDaoException {
		this.deleteAll();
	} // Fin de deleteAllSousClasse()._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBooleanSousClasse() 
				throws AbstractDaoException {
		return this.deleteAllBoolean();
	} // Fin de deleteAllBooleanSousClasse().______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final ProfilSimple pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		ProfilSimple objetResultat = null;
		
		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where profilsimple.profilString = :pProfilString";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pProfilString", pObject.getProfilString());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (ProfilSimple) requete.getSingleResult();
			
			/* retourne true si l'objet existe en base. */
			if (objetResultat != null) {
				resultat = true;
			}
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_DAO_PROFILSIMPLE
						, "Méthode exists(ProfilSimple pObject)", e);
		}
				
		return resultat;
		
	} // Fin de exists(...)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}
		
		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}
		
		return false;
		
	} // Fin de exists(...)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long countSousClasse() 
			throws AbstractDaoException {
		return this.count();
	} // Fin de countSousClasse()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListe(
			final List<ProfilSimple> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final ProfilSimple objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();
			
	} // Fin de afficherListe(...).________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * this.<b>classObjetMetier</b> dans DaoProfilSimple : 
	 * <b>ProfilSimple.class</b><br/>
	 * <br/>
	 */
	@Override
	protected final void renseignerClassObjetMetier() {
		this.setClassObjetMetier(ProfilSimple.class);		
	} // Fin de renseignerClassObjetMetier().______________________________




	
	
} // FIN DE LA CLASSE DaoProfilSimple.---------------------------------------

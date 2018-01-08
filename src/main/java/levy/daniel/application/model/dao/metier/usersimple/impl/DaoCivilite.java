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
import levy.daniel.application.model.dao.metier.usersimple.IDaoCivilite;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;


/**
 * class DaoCivilite :<br/>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>Civilite</b>.</li>
 * <li>
 * Implémente l'interface IDaoCivilite.
 * </li>
 * <li>
 * Hérite de la classe abstraite 
 * AbstractDaoGenericJPASpring&lt;Civilite, Long&gt;.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * <li>
 * Annoté (SPRING) <b>Repository(value="DaoCivilite")</b> 
 * pour l'<b>injection</b> (Autowiring) dans les SERVICES par SPRING.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DaoCivilite.png" 
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
@Repository(value="DaoCivilite")
public class DaoCivilite 
		extends AbstractDaoGenericJPASpring<Civilite, Long> 
												implements IDaoCivilite {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_CIVILITE : String :<br/>
	 * "Classe DaoCivilite".<br/>
	 */
	public static final String CLASSE_DAO_CIVILITE 
		= "Classe DaoCivilite";

	
	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select civilite from 
	 * Civilite as civilite ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select civilite from "
				+ "Civilite as civilite ";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoCivilite.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR DaoCivilite() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoCivilite() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
			final Civilite pObject) 
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
		final Civilite objetPersistant = this.create(pObject);

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
	public final Civilite retrieve(
			final Civilite pObject) 
						throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		Civilite objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where civilite.civiliteString = :pCiviliteString";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pCiviliteString", pObject.getCiviliteString());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (Civilite) requete.getSingleResult();
			
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
						CLASSE_DAO_CIVILITE
						, "Méthode retrieve(Civilite pObject)", e);
		}
				
		return objetResultat;
		
	} // Fin de retrieve(...)._____________________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Civilite retrieveByIdMetier(
			final Civilite pObjet) throws AbstractDaoException {
		return this.retrieve(pObjet);
	} // Fin de retrieveByIdMetier(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Civilite retrieveByCivilite(
			final String pCiviliteString) throws AbstractDaoException {

		/* return null si pCiviliteString est blank. */
		if (StringUtils.isBlank(pCiviliteString)) {
			return null;
		}
		
		Civilite objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where civilite.civiliteString = :pCiviliteString";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pCiviliteString", pCiviliteString);
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (Civilite) requete.getSingleResult();
			
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
						CLASSE_DAO_CIVILITE
						, "Méthode retrieveByCivilite("
								+ "String pCiviliteString)", e);
		}
				
		return objetResultat;
				
	} // Fin de retrieveByCivilite(...).___________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Civilite> findAllSousClasse() 
							throws AbstractDaoException {
		return this.findAll();
	} // Fin de findAllSousClasse() .______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Civilite> findAllMaxSousClasse(
			final Long pMax) 
								throws AbstractDaoException {
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

		Civilite objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where civilite.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (Civilite) requete.getSingleResult();
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
				.gererException(CLASSE_DAO_CIVILITE
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
		
		Civilite objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where civilite.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (Civilite) requete.getSingleResult();
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
				.gererException(CLASSE_DAO_CIVILITE
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
			final Civilite pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		Civilite objetResultat = null;
		
		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where civilite.civiliteString = :pCiviliteString";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pCiviliteString", pObject.getCiviliteString());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (Civilite) requete.getSingleResult();
			
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
				.gererException(CLASSE_DAO_CIVILITE
						, "Méthode exists(Civilite pObject)", e);
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
	public final Long countSousClasse() throws AbstractDaoException {
		return this.count();
	} // Fin de countSousClasse()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherListe(
			final List<Civilite> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final Civilite objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();
			
	} // Fin de afficherListe(...).________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * this.<b>classObjetMetier</b> dans DaoCivilite : 
	 * <b>Civilite.class</b><br/>
	 * <br/>
	 */
	@Override
	protected final void renseignerClassObjetMetier() {
		this.setClassObjetMetier(Civilite.class);		
	} // Fin de renseignerClassObjetMetier().______________________________

	
	
} // FIN DE LA CLASSE DaoCivilite.-------------------------------------------

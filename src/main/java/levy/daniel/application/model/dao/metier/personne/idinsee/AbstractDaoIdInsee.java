package levy.daniel.application.model.dao.metier.personne.idinsee;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.personne.idinsee.IIdInsee;

/**
 * class AbstractDaoIdInsee :<br/>
 * <ul>
 * <li>
 * DAO ABSTRAIT SPRING pour les 
 * <b>IIdInsee</b>.
 * </li>
 * <li>
 * Comporte l'implémentation des méthodes <b>spécifiques</b> aux 
 * IIdInsee.
 * </li>
 * <li>IMPLEMENTE L'INTERFACE IDaoIdInsee.</li>
 * <li>
 * HERITE DE LA CLASSE ABSTRAITE 
 * AbstractDaoGenericJPASpring&lt;IIdInsee, Long&gt;.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAO_IdInsee.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
 * </li>
 * </ul>
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
public abstract class AbstractDaoIdInsee 
		extends AbstractDaoGenericJPASpring<IIdInsee, Long>
				implements IDaoIdInsee {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_ABSTRACTDAO_IDINSEE : String :<br/>
	 * "Classe AbstractDaoIdInsee".<br/>
	 */
	public static final String CLASSE_ABSTRACTDAO_IDINSEE 
		= "Classe AbstractDaoIdInsee";

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select idInsee from 
	 * AbstractIdInsee as idInsee ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select idInsee from "
				+ "AbstractIdInsee as idInsee ";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDaoIdInsee.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractDaoIdInsee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoIdInsee() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
			final IIdInsee pObject) 
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
		final IIdInsee objetPersistant 
			= this.create(pObject);
		
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
	public final IIdInsee retrieve(
			final IIdInsee pObject) 
						throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		IIdInsee objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where idInsee.numeroInsee = :pNumeroInsee";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNumeroInsee", pObject.getNumeroInsee());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (IIdInsee) requete.getSingleResult();
			
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
						CLASSE_ABSTRACTDAO_IDINSEE
						, "Méthode retrieve(IIdInsee pObject)", e);
		}
				
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IIdInsee retrieveByIdMetier(
			final IIdInsee pObjet) 
								throws AbstractDaoException {
		return this.retrieve(pObjet);
	} // Fin de retrieveByIdMetier(...).___________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IIdInsee retrieveByNumeroInsee(
			final String pNumeroInsee) 
									throws AbstractDaoException {
		
		/* Retourne null si pNumeroInsee est blank. */
		if (StringUtils.isBlank(pNumeroInsee)) {
			return null;
		}
				
		IIdInsee objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where idInsee.numeroInsee = :pNumeroInsee";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNumeroInsee", pNumeroInsee);
		
		try {
			
			/* Execution de la requete HQL. */
			/* Execution de la requete HQL. */
			objetResultat 
			= (IIdInsee) requete.getSingleResult();
			
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
						CLASSE_ABSTRACTDAO_IDINSEE
						, "Méthode retrieveByNumeroInsee(...)", e);
		}

		return objetResultat;
		
	} // Fin de retrieveByNomPrenom(...).__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteById(
			final Long pId) 
					throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		IIdInsee objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where idInsee.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IIdInsee) requete.getSingleResult();
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
				.gererException(CLASSE_ABSTRACTDAO_IDINSEE
						, "Méthode deleteById(Long pId)", e);
		}
		
	} // Fin de deleteById(...).___________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteByIdBoolean(
			final Long pId) 
						throws AbstractDaoException {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		boolean resultat = false;
		
		IIdInsee objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where idInsee.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IIdInsee) requete.getSingleResult();
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
				.gererException(CLASSE_ABSTRACTDAO_IDINSEE
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final IIdInsee pObject) 
					throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		IIdInsee objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where idInsee.numeroInsee = :pNumeroInsee";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNumeroInsee", pObject.getNumeroInsee());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (IIdInsee) requete.getSingleResult();
			
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
				.gererException(CLASSE_ABSTRACTDAO_IDINSEE
						, "Méthode exists(IIdInsee pObject)", e);
		}
				
		return resultat;
		
	} // Fin de exists(...)._______________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final Long pId) 
					throws AbstractDaoException {
		
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
	public final String afficherListe(
			final List<IIdInsee> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final IIdInsee objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________


	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * this.<b>classObjetMetier</b> dans AbstractDaoIdInsee : 
	 * <b>IIdInsee.class</b><br/>
	 * <br/>
	 */
	@Override
	protected final void renseignerClassObjetMetier() {

		this.setClassObjetMetier(IIdInsee.class);

	} // Fin de renseignerClassObjetMetier().______________________________


	
} // FIN DE LA CLASSE AbstractDaoIdInsee.------------------------------------

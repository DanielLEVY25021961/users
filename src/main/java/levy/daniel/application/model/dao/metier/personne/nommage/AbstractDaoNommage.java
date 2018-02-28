package levy.daniel.application.model.dao.metier.personne.nommage;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.personne.nommage.INommage;


/**
 * CLASSE ABSTRAITE <b>AbstractDaoNommage</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>INommage</b> modélise un un <i>concept</i> de <b>Nommage</b> avec un seul prenom
 * , c'est à dire un couple <b>[nom - prenom]</b> qui identifie 
 * <i>une ou plusieurs</i> <b>Personne</b>.
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * AbstractDaoNommage</span>
 * </p>
 * <ul>
 * <li>
 * DAO ABSTRAIT SPRING pour les 
 * <b>INommage</b>.
 * </li>
 * <li>
 * Comporte l'implémentation des méthodes <b>spécifiques</b> aux 
 * INommage.
 * </li>
 * <li>IMPLEMENTE L'INTERFACE IDaoNommage.</li>
 * <li>
 * HERITE DE LA CLASSE ABSTRAITE 
 * AbstractDaoGenericJPASpring&lt;INommage, Long&gt;.
 * </li>
 * <li>
 * <b>FACTORISE</b> les attributs et comportements 
 * des <i>descendants concrets</i>.
 * </li>
 * </ul>
 * 
 *  
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES AbstractDaoNommage</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAO_INommage.png" 
 * alt="implémentation des DAOs nommage" border="1" align="center" />
 * </li>
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
public abstract class AbstractDaoNommage 
		extends AbstractDaoGenericJPASpring<INommage, Long> 
										implements IDaoNommage {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_ABSTRACTDAO_NOMMAGE : String :<br/>
	 * "Classe AbstractDaoNommage".<br/>
	 */
	public static final String CLASSE_ABSTRACTDAO_NOMMAGE 
		= "Classe AbstractDaoNommage";

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select nommage from 
	 * AbstractNommage as nommage ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select nommage from "
				+ "AbstractNommage as nommage ";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractDaoNommage.class);



	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR AbstractDaoNommage() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoNommage() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final INommage pObject) throws AbstractDaoException {
		
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
		final INommage objetPersistant 
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
	public INommage retrieve(
			final INommage pObject) throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		INommage objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where nommage.nom = :pNom and nommage.prenom = :pPrenom";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pPrenom", pObject.getPrenom());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (INommage) requete.getSingleResult();
			
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
						CLASSE_ABSTRACTDAO_NOMMAGE
						, "Méthode retrieve(INommage pObject)", e);
		}
				
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public INommage retrieveByIdMetier(
			final INommage pObjet) throws AbstractDaoException {
		return this.retrieve(pObjet);
	} // Fin de retrieveByIdMetier(...).___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public INommage retrieveByNomPrenom(
			final String pNom
				, final String pPrenom) throws AbstractDaoException {

		/* return null si pNom est blank. */
		if (StringUtils.isBlank(pNom)) {
			return null;
		}
		
		/* return null si pNom est null. */
		if (pNom == null) {
			return null;
		}
		
		/* return null si pPrenom est blank. */
		if (StringUtils.isBlank(pPrenom)) {
			return null;
		}
		
		INommage objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where nommage.nom = :pNom and nommage.prenom = :pPrenom";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pNom);
		requete.setParameter("pPrenom", pPrenom);
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (INommage) requete.getSingleResult();
			
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
						CLASSE_ABSTRACTDAO_NOMMAGE
						, "Méthode retrieveByNomPrenom("
								+ "String pNom, String pPrenom", e);
		}
				
		return objetResultat;

	} // Fin de retrieveByNomPrenom(...).__________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract INommage findById(Long pId) 
				throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		INommage objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where nommage.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (INommage) requete.getSingleResult();
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
				.gererException(CLASSE_ABSTRACTDAO_NOMMAGE
						, "Méthode deleteById(Long pId)", e);
		}
		
	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		boolean resultat = false;
		
		INommage objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where nommage.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (INommage) requete.getSingleResult();
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
				.gererException(CLASSE_ABSTRACTDAO_NOMMAGE
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}
		
		return resultat;
		
	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final INommage pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		INommage objetResultat = null;
		
		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where nommage.nom = :pNom and nommage.prenom = :pPrenom";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", pObject.getNom());
		requete.setParameter("pPrenom", pObject.getPrenom());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (INommage) requete.getSingleResult();
			
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
				.gererException(CLASSE_ABSTRACTDAO_NOMMAGE
						, "Méthode exists(INommage pObject)", e);
		}
				
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
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
		
	} // Fin de exists(Long...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListe(
			final List<INommage> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final INommage objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________


	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * this.<b>classObjetMetier</b> dans AbstractDaoNommage : 
	 * <b>INommage.class</b><br/>
	 * <br/>
	 */
	@Override
	protected final void renseignerClassObjetMetier() {

		this.setClassObjetMetier(INommage.class);

	} // Fin de renseignerClassObjetMetier().______________________________



} // FIN DE LA CLASSE AbstractDaoNommage.------------------------------------

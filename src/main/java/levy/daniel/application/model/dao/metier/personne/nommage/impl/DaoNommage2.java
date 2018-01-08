package levy.daniel.application.model.dao.metier.personne.nommage.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.nommage.AbstractDaoNommage;
import levy.daniel.application.model.metier.personne.nommage.INommage;
import levy.daniel.application.model.metier.personne.nommage.impl.Nommage2;


/**
 * CLASSE CONCRETE <b>DaoNommage2</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>Nommage2</b> modélise un un <i>concept</i> 
 * de <b>Nommage</b> avec nom, un prenom et un deuxième prenom, 
 * c'est à dire un triplet <b>[nom - prenom - prenom2]</b>  
 * qui identifie <i>une ou plusieurs</i> <b>Personne</b>.<br/>
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DaoNommage</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>Nommage2</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoNommage.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DaoNommage2</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_INommage.png" 
 * alt="implémentation des DAOs nommage" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DaoNommage2</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_daoNommage.png" 
 * alt="utilisation des DAOs DaoNommage2" border="1" align="center" />
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
@Repository(value="DaoNommage2")
public class DaoNommage2 extends AbstractDaoNommage {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_DAO_NOMMAGE2 : String :<br/>
	 * "Classe DaoNommage2".<br/>
	 */
	public static final String CLASSE_DAO_NOMMAGE2 
		= "Classe DaoNommage2";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoNommage2.class);
	

	// *************************METHODES************************************/


	
	 /**
	 * method CONSTRUCTEUR DaoNommage2() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoNommage2() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * REDEFINI DANS LA CLASSE CONCRETE EN REMPLACANT 
	 * T PAR LA CLASSE CONCRETE.<br/>
	 * <br/>
	 */
	@Override
	public final INommage findById(
			final Long pId) throws AbstractDaoException {
		
		Nommage2 objetTrouve = null;
		
		/* retourne null si pId == null. */
		if (pId == null) {
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

		try {
			
			objetTrouve 
				= this.entityManager.find(Nommage2.class, pId);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_NOMMAGE2
						, "Méthode findById(ID)", e);
			
		}
		
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<INommage> findAllSousClasse() 
			throws AbstractDaoException {
		return this.findAllNommage2();
	} // Fin de findAllSousClasse()._______________________________________


	
	/**
	 * method findAllNommage2() :<br/>
	 * <ul>
	 * <li>Retourne la liste de tous les objets métier 
	 * de Type Nommage2
	 * présents en base.</li>
	 * </ul>
	 *
	 * @return List&lt;INommage&gt; : 
	 * liste de tous les objets métier de Type Nommage2 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private List<INommage> findAllNommage2() 
			throws AbstractDaoException {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from Nommage2";
		
		List<INommage> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_NOMMAGE2
						, "Méthode findAllNommage2()", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllNommage2()._________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<INommage> findAllMaxSousClasse(
			final Long pMax) 
					throws AbstractDaoException {
		return this.findAllMaxNommage2(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________



	/**
	 * method findAllMaxNommage2(
	 * Long pMax) :<br/>
	 * <ul>
	 * <li>Retourne la liste des pMax premiers Objets métier 
	 * de Type Nommage2 présents en base 
	 * et retournés par findAllNommage2().</li>
	 * <li>Le champ de tri des Objets métier semble être l'ID.</li>
	 * </ul>
	 * retourne null si pMax == null.<br/>
	 * retourne null si pMax < 1L.<br/>
	 * <br/>
	 * 
	 * @param pMax : Long : Nombre maximal d'objets métier 
	 * à remonter de la base.<br/>
	 * 
	 * @return List&lt;INommage&gt; :
	 * liste des pMax premiers objets métier 
	 * de Type Nommage2 présents en base.<br/>
	 *  
	 * @throws AbstractDaoException
	 */
	private List<INommage> findAllMaxNommage2(
			final Long pMax) throws AbstractDaoException {
		
		/* retourne null si pMax == null. */
		if (pMax == null) {
			return null;
		}
		
		/* retourne null si pMax < 1L. */
		if (pMax < 1L) {
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
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from Nommage2";
		
		List<INommage> resultat = null;
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(0).setMaxResults(pMax.intValue());
			
			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
						
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_DAO_NOMMAGE2
						, "Méthode findAllMaxNommage2(Long pMax)", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
				
	} // Fin de findAllMaxNommage2(...).___________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAllSousClasse() 
			throws AbstractDaoException {
		this.deleteAllNommage2();		
	} // Fin de deleteAllSousClasse()._____________________________________


		
	/**
	 * method deleteAllNommage2() :<br/>
	 * <ul>
	 * <li>Détruit en base toutes les instances 
	 * d'Objets métier de Type Nommage2.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	private void deleteAllNommage2() 
							throws AbstractDaoException {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from Nommage2";
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_NOMMAGE2
						, "Méthode deleteAllNommage2()", e);
			
		}
		
	} // Fin de deleteAllNommage2()._______________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBooleanSousClasse() 
			throws AbstractDaoException {
		return this.deleteAllBooleanNommage2();
	} // Fin de deleteAllBooleanSousClasse().______________________________


	
	/**
	 * method deleteAllBooleanNommage2() :<br/>
	 * <ul>
	 * <li>Détruit en base tous les enregistrements 
	 * d'Objets métier de Type Nommage2.</li>
	 * <li>Retourne true si la destruction a bien été effectuée.</li>
	 * </ul>
	 * 
	 * @return boolean : true si tous les enregistrements 
	 * ont été détruits en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private boolean deleteAllBooleanNommage2() 
									throws AbstractDaoException {
		
		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {
						
			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}
	
		
		boolean resultat = false;
		
		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from Nommage2";
		
		try {
			
			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);
			
			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();
			
			resultat = true;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_NOMMAGE2
						, "Méthode deleteAllBooleanNommage2()", e);
			
		}
		
		return resultat;
		
	} // Fin de deleteAllBooleanNommage2().________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean exists(
			final INommage pObject) throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		/* retourne false si pObject n'est pas un Nommage2*/
		if (!(pObject instanceof Nommage2)) {
			return false;
		}
		
		final Nommage2 nommage2 = (Nommage2) pObject;
		
		boolean resultat = false;		
		INommage objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where nommage.nom = :pNom and nommage.prenom = :pPrenom and nommage.prenom2 = :pPrenom2";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pNom", nommage2.getNom());
		requete.setParameter("pPrenom", nommage2.getPrenom());
		requete.setParameter("pPrenom2", nommage2.getPrenom2());
		
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
		return this.countNommage2();
	} // Fin de countSousClasse()._________________________________________


		
	/**
	 * method countNommage2() :<br/>
	 * <ul>
	 * <li>Retourne le nombre d'Objets metier 
	 * de type Nommage2 présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type Nommage2 
	 * présents en base.<br/>
	 *
	 * @throws AbstractDaoException
	 */
	private Long countNommage2() 
						throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type Nommage. */
		final List<INommage> listObjects 
			= this.findAllNommage2();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return 0L;
		
	} // Fin de countNommage2().___________________________________________
	


} // FIN DE LA CLASSE DaoNommage2.-------------------------------------------

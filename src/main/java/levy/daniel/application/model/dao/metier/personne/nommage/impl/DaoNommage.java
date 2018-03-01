package levy.daniel.application.model.dao.metier.personne.nommage.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.nommage.AbstractDaoNommage;
import levy.daniel.application.model.metier.personne.nommage.INommage;
import levy.daniel.application.model.metier.personne.nommage.impl.Nommage;


/**
 * CLASSE CONCRETE <b>DaoNommage</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>Nommage</b> modélise un un <i>concept</i> 
 * de <b>Nommage</b> avec nom et un seul prenom, c'est à dire un couple
 * <b>[nom - prenom]</b>  qui identifie <i>une ou plusieurs</i> <b>Personne</b>.<br/>
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DaoNommage</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>Nommage</b>.</li>
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
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DaoNommage</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_INommage.png" 
 * alt="implémentation des DAOs nommage" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DaoNommage</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_daoNommage.png" 
 * alt="utilisation des DAOs DaoNommage" border="1" align="center" />
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
@Repository(value="DaoNommage")
public class DaoNommage extends AbstractDaoNommage {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_NOMMAGE : String :<br/>
	 * "Classe DaoNommage".<br/>
	 */
	public static final String CLASSE_DAO_NOMMAGE 
		= "Classe DaoNommage";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoNommage.class);


	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR DaoNommage() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoNommage() {
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
	public INommage findById(
			final Long pId) throws AbstractDaoException {
		
		Nommage objetTrouve = null;
		
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
				= this.entityManager.find(Nommage.class, pId);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_NOMMAGE
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
		return this.findAllNommage();
	} // Fin de findAllSousClasse()._______________________________________


	
	/**
	 * method findAllNommage() :<br/>
	 * <ul>
	 * <li>Retourne la liste de tous les objets métier 
	 * de Type Nommage présents en base sous forme 
	 * de List&lt;INommage&gt;.</li>
	 * </ul>
	 *
	 * @return List&lt;INommage&gt; : 
	 * liste de tous les objets métier de Type Nommage 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private List<INommage> findAllNommage() 
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
			= "from Nommage";
		
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
						CLASSE_DAO_NOMMAGE
						, "Méthode findAllNommage()", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllNommage().__________________________________________
	



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<INommage> findAllMaxSousClasse(
			final Long pMax) throws AbstractDaoException {
		return this.findAllMaxNommage(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________



	/**
	 * method findAllMaxNommage(
	 * Long pMax) :<br/>
	 * <ul>
	 * <li>Retourne la liste des pMax premiers Objets métier 
	 * de Type Nommage présents en base 
	 * et retournés par findAllNommage().</li>
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
	 * de Type Nommage présents en base.<br/>
	 *  
	 * @throws AbstractDaoException
	 */
	private List<INommage> findAllMaxNommage(
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
			= "from Nommage";
		
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
				.gererException(CLASSE_DAO_NOMMAGE
						, "Méthode findAllMaxNommage(Long pMax)", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
				
	} // Fin de findAllMaxNommage(...).____________________________________
	



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAllSousClasse() 
					throws AbstractDaoException {
		this.deleteAllNommage();
	} // Fin de deleteAllSousClasse()._____________________________________


	
	/**
	 * method deleteAllNommage() :<br/>
	 * <ul>
	 * <li>Détruit en base toutes les instances 
	 * d'Objets métier de Type Nommage.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	private void deleteAllNommage() 
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
			= "delete from Nommage";
		
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
						CLASSE_DAO_NOMMAGE
						, "Méthode deleteAllNommage()", e);
			
		}
		
	} // Fin de deleteAllNommage().________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBooleanSousClasse() 
								throws AbstractDaoException {
		return this.deleteAllBooleanNommage();
	} // Fin de deleteAllBooleanSousClasse().______________________________

	
	
	/**
	 * method deleteAllBooleanNommage() :<br/>
	 * <ul>
	 * <li>Détruit en base tous les enregistrements 
	 * d'Objets métier de Type Nommage.</li>
	 * <li>Retourne true si la destruction a bien été effectuée.</li>
	 * </ul>
	 * 
	 * @return boolean : true si tous les enregistrements 
	 * ont été détruits en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private boolean deleteAllBooleanNommage() 
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
			= "delete from Nommage";
		
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
						CLASSE_DAO_NOMMAGE
						, "Méthode deleteAllBooleanNommage()", e);
			
		}
		
		return resultat;
		
	} // Fin de deleteAllBooleanNommage()._________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long countSousClasse() 
						throws AbstractDaoException {
		return this.countNommage();
	} // Fin de countSousClasse()._________________________________________


	
	/**
	 * method countNommage() :<br/>
	 * <ul>
	 * <li>Retourne le nombre d'Objets metier 
	 * de type Nommage présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type Nommage 
	 * présents en base.<br/>
	 *
	 * @throws AbstractDaoException
	 */
	private Long countNommage() 
						throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type Nommage. */
		final List<INommage> listObjects 
			= this.findAllNommage();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return 0L;
		
	} // Fin de countNommage().____________________________________________
	

	
} // FIN DE LA CLASSE DaoNommage.--------------------------------------------

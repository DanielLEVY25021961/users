package levy.daniel.application.model.dao.metier.personne.civilite.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.civilite.AbstractDaoCivilite;
import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.metier.personne.civilite.impl.CiviliteComplete;

/**
 * CLASSE CONCRETE <b>DaoCiviliteComplete</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <ul>
 * <li><b>CiviliteComplete</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * (MONSIEUR, MADAME, MADEMOISELLE ...) dans lequel la civilité 
 * est <i>intégrale</i>
 * associé de manière unique à une <b>Personne</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DaoCiviliteComplete</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>CiviliteComplete</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoCivilite.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DaoCiviliteComplete</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_Civilite.png" 
 * alt="implémentation des DAOs DaoCiviliteComplete" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DaoCiviliteComplete</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_daoCivilite.png" 
 * alt="utilisation des DAOs DaoCiviliteComplete" border="1" align="center" />
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
 * @since 31 déc. 2017
 *
 */
@Repository(value="DaoCiviliteComplete")
public class DaoCiviliteComplete extends AbstractDaoCivilite {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_CIVILITE_COMPLETE : String :<br/>
	 * "Classe DaoCiviliteComplete".<br/>
	 */
	public static final String CLASSE_DAO_CIVILITE_COMPLETE 
		= "Classe DaoCiviliteComplete";
	
	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select civilite from CiviliteComplete as civilite ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select civilite from CiviliteComplete as civilite ";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoCiviliteComplete.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR DaoCiviliteComplete() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoCiviliteComplete() {
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
	public final CiviliteComplete findById(
			final Long pId) throws AbstractDaoException {
		
		CiviliteComplete objetTrouve = null;
		
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
				= this.entityManager.find(CiviliteComplete.class, pId);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_CIVILITE_COMPLETE
						, "Méthode findById(ID)", e);
			
		}
		
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<ICivilite> findAllSousClasse() 
				throws AbstractDaoException {
		return this.findAllCiviliteComplete();
	} // Fin de findAllSousClasse()._______________________________________
	
	
	
	/**
	 * method findAllCiviliteComplete() :<br/>
	 * <ul>
	 * <li>Retourne la liste de tous les objets métier 
	 * de Type CiviliteComplete
	 * présents en base.</li>
	 * </ul>
	 *
	 * @return List&lt;ICivilite&gt; : 
	 * liste de tous les objets métier de Type CiviliteComplete 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private List<ICivilite> findAllCiviliteComplete() 
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
			= "from CiviliteComplete";
		
		List<ICivilite> resultat = null;
		
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
						CLASSE_DAO_CIVILITE_COMPLETE
						, "Méthode findallCiviliteComplete()", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllCiviliteComplete()._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<ICivilite> findAllMaxSousClasse(
			final Long pMax) 
			throws AbstractDaoException {
		return this.findAllMaxCiviliteComplete(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________
	
	
	
	/**
	 * method findAllMaxCiviliteComplete(
	 * Long pMax) :<br/>
	 * <ul>
	 * <li>Retourne la liste des pMax premiers Objets métier 
	 * de Type CiviliteComplete présents en base 
	 * et retournés par findAllCiviliteComplete().</li>
	 * <li>Le champ de tri des Objets métier semble être l'ID.</li>
	 * </ul>
	 * retourne null si pMax == null.<br/>
	 * retourne null si pMax < 1L.<br/>
	 * <br/>
	 * 
	 * @param pMax : Long : Nombre maximal d'objets métier 
	 * à remonter de la base.<br/>
	 * 
	 * @return List&lt;ICivilite&gt; :
	 * liste des pMax premiers objets métier 
	 * de Type CiviliteComplete présents en base.<br/>
	 *  
	 * @throws AbstractDaoException
	 */
	private List<ICivilite> findAllMaxCiviliteComplete(
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
			= "from CiviliteComplete";
		
		List<ICivilite> resultat = null;
		
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
				.gererException(CLASSE_DAO_CIVILITE_COMPLETE
						, "Méthode findAllMaxCiviliteComplete(Long pMax)", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
				
	} // Fin de findAllMaxCiviliteComplete(...).___________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAllSousClasse() throws AbstractDaoException {
		this.deleteAllCiviliteComplete();
	} // Fin de deleteAllSousClasse()._____________________________________
	
	

	/**
	 * method deleteAllCiviliteComplete() :<br/>
	 * <ul>
	 * <li>Détruit en base toutes les instances 
	 * d'Objets métier de Type CiviliteComplete.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	private void deleteAllCiviliteComplete() 
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
			= "delete from CiviliteComplete";
		
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
						CLASSE_DAO_CIVILITE_COMPLETE
						, "Méthode deleteAllCiviliteComplete()", e);
			
		}
		
	} // Fin de deleteAllCiviliteComplete()._______________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBooleanSousClasse() 
			throws AbstractDaoException {
		return this.deleteAllBooleanCiviliteComplete();
	} // Fin de deleteAllBooleanSousClasse().______________________________


	
	/**
	 * method deleteAllBooleanCiviliteComplete() :<br/>
	 * <ul>
	 * <li>Détruit en base tous les enregistrements 
	 * d'Objets métier de Type CiviliteComplete.</li>
	 * <li>Retourne true si la destruction a bien été effectuée.</li>
	 * </ul>
	 * 
	 * @return boolean : true si tous les enregistrements 
	 * ont été détruits en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private boolean deleteAllBooleanCiviliteComplete() 
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
			= "delete from CiviliteComplete";
		
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
						CLASSE_DAO_CIVILITE_COMPLETE
						, "Méthode deleteAllBooleanCiviliteComplete()", e);
			
		}
		
		return resultat;
		
	} // Fin de deleteAllBooleanCiviliteComplete().________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long countSousClasse() throws AbstractDaoException {
		return this.countCiviliteComplete();
	} // Fin de countSousClasse()._________________________________________
	
	
	
	/**
	 * method countCiviliteComplete() :<br/>
	 * <ul>
	 * <li>Retourne le nombre d'Objets metier 
	 * de type CiviliteComplete présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type CiviliteComplete 
	 * présents en base.<br/>
	 *
	 * @throws AbstractDaoException
	 */
	private Long countCiviliteComplete() 
						throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type CiviliteComplete. */
		final List<ICivilite> listObjects 
			= this.findAllCiviliteComplete();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return 0L;
		
	} // Fin de countCiviliteComplete().___________________________________
	
	
	
} // FIN DE LA CLASSE DaoCiviliteAbregee.------------------------------------

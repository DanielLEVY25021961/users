package levy.daniel.application.model.dao.metier.personne.civilite.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.civilite.AbstractDaoCivilite;
import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.metier.personne.civilite.impl.CiviliteAbregee;

/**
 * CLASSE CONCRETE <b>DaoCiviliteAbregee</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <ul>
 * <li>
 * <b>CiviliteAbregee</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * (M., Mme, Mlle ...) dans lequel la civilité est <i>abrégée</i>
 * associé de manière unique à une <b>Personne</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DaoCiviliteAbregee</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>CiviliteAbregee</b>.</li>
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
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DaoCiviliteAbregee</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_Civilite.png" 
 * alt="implémentation des DAOs DaoCiviliteAbregee" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DaoCiviliteAbregee</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_daoCivilite.png" 
 * alt="utilisation des DAOs DaoCiviliteAbregee" border="1" align="center" />
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
@Repository(value="DaoCiviliteAbregee")
public class DaoCiviliteAbregee extends AbstractDaoCivilite {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_CIVILITE_ABREGEE : String :<br/>
	 * "Classe DaoCiviliteAbregee".<br/>
	 */
	public static final String CLASSE_DAO_CIVILITE_ABREGEE 
		= "Classe DaoCiviliteAbregee";
	
	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select civilite from CiviliteAbregee as civilite ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select civilite from CiviliteAbregee as civilite ";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoCiviliteAbregee.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR DaoCiviliteAbregee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoCiviliteAbregee() {
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
	public final CiviliteAbregee findById(
			final Long pId) throws AbstractDaoException {
		
		CiviliteAbregee objetTrouve = null;
		
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
				= this.entityManager.find(CiviliteAbregee.class, pId);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_CIVILITE_ABREGEE
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
		return this.findAllCiviliteAbregee();
	} // Fin de findAllSousClasse()._______________________________________

	
	
	/**
	 * method findAllCiviliteAbregee() :<br/>
	 * <ul>
	 * <li>Retourne la liste de tous les objets métier 
	 * de Type CiviliteAbregee
	 * présents en base.</li>
	 * </ul>
	 *
	 * @return List&lt;ICivilite&gt; : 
	 * liste de tous les objets métier de Type CiviliteAbregee 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private List<ICivilite> findAllCiviliteAbregee() 
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
			= "from CiviliteAbregee";
		
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
						CLASSE_DAO_CIVILITE_ABREGEE
						, "Méthode findAllCiviliteAbregee()", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
		
	} // Fin de findAllCiviliteAbregee().__________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<ICivilite> findAllMaxSousClasse(
			final Long pMax) 
			throws AbstractDaoException {
		return this.findAllMaxCiviliteAbregee(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________
	
	

	/**
	 * method findAllMaxCiviliteAbregee(
	 * Long pMax) :<br/>
	 * <ul>
	 * <li>Retourne la liste des pMax premiers Objets métier 
	 * de Type CiviliteAbregee présents en base 
	 * et retournés par findAllCiviliteAbregee().</li>
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
	 * de Type CiviliteAbregee présents en base.<br/>
	 *  
	 * @throws AbstractDaoException
	 */
	private List<ICivilite> findAllMaxCiviliteAbregee(
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
			= "from CiviliteAbregee";
		
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
				.gererException(CLASSE_DAO_CIVILITE_ABREGEE
						, "Méthode findAllMaxCiviliteAbregee(Long pMax)", e);
			
		}
		
		/* Retourne la liste résultat. */
		return resultat;
				
	} // Fin de findAllMaxCiviliteAbregee(...).___________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAllSousClasse() throws AbstractDaoException {
		this.deleteAllCiviliteAbregee();
	} // Fin de deleteAllSousClasse()._____________________________________


	
	/**
	 * method deleteAllCiviliteAbregee() :<br/>
	 * <ul>
	 * <li>Détruit en base toutes les instances 
	 * d'Objets métier de Type CiviliteAbregee.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	private void deleteAllCiviliteAbregee() 
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
			= "delete from CiviliteAbregee";
		
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
						CLASSE_DAO_CIVILITE_ABREGEE
						, "Méthode deleteAllCiviliteAbregee()", e);
			
		}
		
	} // Fin de deleteAllCiviliteAbregee()._______________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBooleanSousClasse() 
			throws AbstractDaoException {
		return this.deleteAllBooleanCiviliteAbregee();
	} // Fin de deleteAllBooleanSousClasse().______________________________


	
	/**
	 * method deleteAllBooleanCiviliteAbregee() :<br/>
	 * <ul>
	 * <li>Détruit en base tous les enregistrements 
	 * d'Objets métier de Type CiviliteAbregee.</li>
	 * <li>Retourne true si la destruction a bien été effectuée.</li>
	 * </ul>
	 * 
	 * @return boolean : true si tous les enregistrements 
	 * ont été détruits en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private boolean deleteAllBooleanCiviliteAbregee() 
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
			= "delete from CiviliteAbregee";
		
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
						CLASSE_DAO_CIVILITE_ABREGEE
						, "Méthode deleteAllBooleanCiviliteAbregee()", e);
			
		}
		
		return resultat;
		
	} // Fin de deleteAllBooleanCiviliteAbregee().________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countSousClasse() throws AbstractDaoException {
		return this.countCiviliteAbregee();
	} // Fin de countSousClasse()._________________________________________
	

	
	/**
	 * method countCiviliteAbregee() :<br/>
	 * <ul>
	 * <li>Retourne le nombre d'Objets metier 
	 * de type CiviliteAbregee présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type CiviliteAbregee 
	 * présents en base.<br/>
	 *
	 * @throws AbstractDaoException
	 */
	private Long countCiviliteAbregee() 
						throws AbstractDaoException {
		
		/* Récupère la liste d'Objets métier de Type CiviliteAbregee. */
		final List<ICivilite> listObjects 
			= this.findAllCiviliteAbregee();
		
		if (listObjects != null) {
			
			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}
		
		return 0L;
		
	} // Fin de countCiviliteAbregee().____________________________________
	

	
} // FIN DE LA CLASSE DaoCiviliteAbregee.------------------------------------

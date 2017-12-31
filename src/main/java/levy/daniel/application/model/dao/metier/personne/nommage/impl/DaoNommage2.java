package levy.daniel.application.model.dao.metier.personne.nommage.impl;

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
	public INommage findById(
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
	public boolean exists(
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
		
	} // Fin de exists(...)._______________________________________________




} // FIN DE LA CLASSE DaoNommage2.-------------------------------------------

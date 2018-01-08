package levy.daniel.application.model.dao.metier.personne.idinsee.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.idinsee.AbstractDaoIdInsee;
import levy.daniel.application.model.metier.personne.idinsee.IIdInsee;
import levy.daniel.application.model.metier.personne.idinsee.impl.IdInsee;


/**
 * CLASSE CONCRETE <b>DaoIdInsee</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>IdInsee</b> modélise un <i>concept</i> d' <b>identifiant 
 * personnel</b>, c'est à dire un <b>identifiant unique 
 * d'une Personne</b>.
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DaoIdInsee</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>IdInsee</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoIdInsee.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DaoIdInsee</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_IIdInsee.png" 
 * alt="implémentation des DAOs DaoIdInsee" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DaoIdInsee</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_daoIdInsee.png" 
 * alt="utilisation des DAOs DaoIdInsee" border="1" align="center" />
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
 * @since 26 déc. 2017
 *
 */
@Repository(value="DaoIdInsee")
public class DaoIdInsee extends AbstractDaoIdInsee {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_IDINSEE : String :<br/>
	 * "Classe DaoIdInsee".<br/>
	 */
	public static final String CLASSE_DAO_IDINSEE 
		= "Classe DaoIdInsee";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoIdInsee.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR DaoIdInsee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoIdInsee() {
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
	public IdInsee findById(
			final Long pId) throws AbstractDaoException {
		
		IdInsee objetTrouve = null;
		
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
				= this.entityManager.find(IdInsee.class, pId);
			
		}
		catch (Exception e) {
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_IDINSEE
						, "Méthode findById(ID)", e);
			
		}
		
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IIdInsee> findAllSousClasse() 
					throws AbstractDaoException {
		return this.findAll();
	} // Fin de findAllSousClasse()._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IIdInsee> findAllMaxSousClasse(
			final Long pMax) 
								throws AbstractDaoException {
		return this.findAllMax(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________



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
	public final Long countSousClasse() 
				throws AbstractDaoException {
		return this.count();
	} // Fin de countSousClasse()._________________________________________
	

	
} // FIN DE LA CLASSE DaoIdInsee.--------------------------------------------

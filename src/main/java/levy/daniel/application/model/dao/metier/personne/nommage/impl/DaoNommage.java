package levy.daniel.application.model.dao.metier.personne.nommage.impl;

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


	
} // FIN DE LA CLASSE DaoNommage.--------------------------------------------

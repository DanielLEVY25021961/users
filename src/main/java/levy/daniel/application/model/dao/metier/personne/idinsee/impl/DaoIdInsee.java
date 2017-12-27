package levy.daniel.application.model.dao.metier.personne.idinsee.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.idinsee.AbstractDaoIdInsee;
import levy.daniel.application.model.metier.personne.idinsee.impl.IdInsee;


/**
 * class DaoIdInsee :<br/>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>IdInsee</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoIdInsee.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_IdInsee.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
 * </li>
 * </ul>
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
						CLASSE_ABSTRACTDAO_IDINSEE
						, "Méthode findById(ID)", e);
			
		}
		
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________
	

	
} // FIN DE LA CLASSE DaoIdInsee.--------------------------------------------

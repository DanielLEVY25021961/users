package levy.daniel.application.model.dao.metier.usersimple.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.usersimple.AbstractDaoUserSimple;
import levy.daniel.application.model.metier.user.usersimple.IUserSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.UserSimple;


/**
 * class DaoUserSimple :<br/>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>IUserSimple</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoUserSimple.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * <li>
 * Annoté (SPRING) <b>Repository(value="DaoUserSimple")</b> 
 * pour l'<b>injection</b> (Autowiring) dans les SERVICES par SPRING.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_dao_usersimple.png" 
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
 * @since 30 nov. 2017
 *
 */
@Repository(value="DaoUserSimple")
public class DaoUserSimple extends AbstractDaoUserSimple {

	// ************************ATTRIBUTS************************************/


	/**
	 * CLASSE_DAO_USERSIMPLE : String :<br/>
	 * "Classe DaoUserSimple".<br/>
	 */
	public static final String CLASSE_DAO_USERSIMPLE 
		= "Classe DaoUserSimple";

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoUserSimple.class);

	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR DaoUserSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoUserSimple() {
		super();		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final UserSimple findById(
			final Long pId) throws AbstractDaoException {
		
		UserSimple objetTrouve = null;
		
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
				= this.entityManager.find(UserSimple.class, pId);
			
		}
		catch (Exception e) {
			
			objetTrouve = null;
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_USERSIMPLE
						, "Méthode findById(Long pId)", e);
			
		}
		
		return objetTrouve;
				
	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IUserSimple> findAllSousClasse() 
			throws AbstractDaoException {
		return findAll();
	} // Fin de findAllSousClasse()._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IUserSimple> findAllMaxSousClasse(
			final Long pMax) throws AbstractDaoException {
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
	

		
} // FIN DE LA CLASSE DaoUserSimple.-----------------------------------------

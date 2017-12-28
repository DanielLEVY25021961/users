package levy.daniel.application.model.dao.metier.personne.nommage.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.nommage.AbstractDaoNommage;
import levy.daniel.application.model.metier.personne.nommage.INommage;
import levy.daniel.application.model.metier.personne.nommage.impl.Nommage2;


/**
 * class DaoNommage2 :<br/>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>Nommage2</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoNommage.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/.png" 
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
	


} // FIN DE LA CLASSE DaoNommage2.-------------------------------------------

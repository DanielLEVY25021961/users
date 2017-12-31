package levy.daniel.application.model.dao.metier.personne.civilite.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.personne.civilite.AbstractDaoCivilite;
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
public class DaoCiviliteComplete extends AbstractDaoCivilite {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_CIVILITE_COMPLETE : String :<br/>
	 * "Classe DaoCiviliteComplete".<br/>
	 */
	public static final String CLASSE_DAO_CIVILITE_COMPLETE 
		= "Classe DaoCiviliteComplete";
	
	
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
	public CiviliteComplete findById(
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
	

	
} // FIN DE LA CLASSE DaoCiviliteAbregee.------------------------------------

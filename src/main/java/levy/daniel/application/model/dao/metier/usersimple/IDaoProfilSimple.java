package levy.daniel.application.model.dao.metier.usersimple;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilSimple;


/**
 * class IDaoProfilSimple :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>ProfilSimple</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux ProfilSimple.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_DaoProfilSimple.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
 * </li>
 * </ul>
 * <br/>
 * 
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
 * @since 10 déc. 2017
 *
 */
public interface IDaoProfilSimple 
			extends IDaoGenericJPASpring<ProfilSimple, Long> {
	
	

	/**
	 * method retrieveByIdMetier(
	 * ProfilSimple pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un ProfilSimple pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne ProfilSimple trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : ProfilSimple : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : ProfilSimple : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	ProfilSimple retrieveByIdMetier(
			ProfilSimple pObjet) throws AbstractDaoException;


	
	/**
	 * method retrieveByProfil(
	 * String pProfilString) :<br/>
	 * <ul>
	 * <li>Recherche en base un ProfilSimple ayant 
	 * pour profilString pProfilString.</li>
	 * </ul>
	 * return null si pProfilString est blank.<br/>
	 * <br/>
	 *
	 * @param pProfilString : String.<br/>
	 * 
	 * @return ProfilSimple.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	ProfilSimple retrieveByProfil(
			String pProfilString) throws AbstractDaoException;
	
	

} // FIN DE L'INTERFACE IDaoProfilSimple.------------------------------------

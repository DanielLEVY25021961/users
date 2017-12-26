package levy.daniel.application.model.dao.metier.usersimple;

import java.util.List;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.user.usersimple.IUserSimple;

/**
 * INTERFACE IDaoUserSimple :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>IUserSimple</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux IUserSimple.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_dao_usersimple.png" 
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 30 nov. 2017
 *
 */
public interface IDaoUserSimple 
		extends IDaoGenericJPASpring<IUserSimple, Long> {
	
	
	/**
	 * method retrieveByIdMetier(
	 * IUserSimple pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un IUserSimple pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne IUserSimple trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : IUserSimple : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : IUserSimple : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	IUserSimple 
		retrieveByIdMetier(IUserSimple pObjet) 
				throws AbstractDaoException;
	

	
	/**
	 * method retrieveByNomPrenom(
	 * String pNom
	 * , String pPrenom) :<br/>
	 * <ul>
	 * <li>Recherche en base une liste de IUserSimple ayant 
	 * pour nom pNom et pour prénom pPrenom.</li>
	 * </ul>
	 * Retourne null si pNom est blank.<br/>
	 * Retourne null si pPrenom est blank.<br/>
	 * <br/>
	 * 
	 *
	 * @param pNom : String : Nom du UserSimple.<br/>
	 * @param pPrenom : String : Prénom du UserSimple.<br/>
	 * 
	 * @return List&lt;IUserSimple&gt; : Liste des UserSimple 
	 * [pNom, pPrenom].<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	List<IUserSimple> retrieveByNomPrenom(
			String pNom
				, String pPrenom) throws AbstractDaoException;
	
	

} // FIN DE L'INTERFACE IDaoUserSimple.--------------------------------------

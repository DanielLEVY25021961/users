package levy.daniel.application.model.dao.metier.personne.idinsee;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.personne.idinsee.IIdInsee;

/**
 * INTERFACE <b>IDaoIdInsee</b> :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>IIdInsee</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux IIdInsee.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAO_IIdInsee.png" 
 * alt="implémentation des DAOs IIdInsee" border="1" align="center" />
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
 * @since 26 déc. 2017
 *
 */
public interface IDaoIdInsee extends IDaoGenericJPASpring<IIdInsee, Long> {
	
	

	/**
	 * method retrieveByIdMetier(
	 * IIdInsee pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un IIdInsee pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne IIdInsee trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : IIdInsee : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : IIdInsee : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	IIdInsee retrieveByIdMetier(
			IIdInsee pObjet) throws AbstractDaoException;


	
	/**
	 * method retrieveByNumeroInsee(
	 * String pNumeroInsee) :<br/>
	 * <ul>
	 * <li>Recherche en base un IIdInsee ayant 
	 * pour numeroInsee pNumeroInsee.</li>
	 * </ul>
	 * return null si pNumeroInsee est blank.<br/>
	 * <br/>
	 *
	 * @param pNumeroInsee : String.<br/>
	 * 
	 * @return IIdInsee.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	IIdInsee retrieveByNumeroInsee(
			String pNumeroInsee) throws AbstractDaoException;
	


} // FIN DE L'INTERFACE IDaoIdInsee.-----------------------------------------

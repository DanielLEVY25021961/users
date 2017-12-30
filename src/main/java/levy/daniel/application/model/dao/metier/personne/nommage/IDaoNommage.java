package levy.daniel.application.model.dao.metier.personne.nommage;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.personne.nommage.INommage;


/**
 * INTERFACE <b>IDaoNommage</b> :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>INommage</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux INommage.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/.png" 
 * alt="implémentation des DAOs nommage" border="1" align="center" />
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
public interface IDaoNommage extends IDaoGenericJPASpring<INommage, Long> {
	

	/**
	 * method retrieveByIdMetier(
	 * INommage pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un INommage pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne INommage trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : INommage : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : INommage : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	INommage retrieveByIdMetier(
			INommage pObjet) throws AbstractDaoException;


	
	/**
	 * method retrieveByNomPrenom(
	 * String pNom
	 * , String pPrenom) :<br/>
	 * <ul>
	 * <li>Recherche en base un INommage ayant 
	 * pour nom pNom et pour prénom pPrenom.</li>
	 * </ul>
	 * return null si pNom ou pPrenom est blank.<br/>
	 * <br/>
	 *
	 * @param pNom : String.<br/>
	 * @param pPrenom : String.<br/>
	 * 
	 * @return INommage.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	INommage retrieveByNomPrenom(
			String pNom, String pPrenom) throws AbstractDaoException;
	


} // FIN DE L'INTERFACE IDaoNommage.-----------------------------------------

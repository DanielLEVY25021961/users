package levy.daniel.application.model.dao.metier.usersimple;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;


/**
 * class IDaoCivilite :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>Civilite</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux Civilite.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_DaoCivilite.png" 
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
public interface IDaoCivilite 
			extends IDaoGenericJPASpring<Civilite, Long> {
	
	

	/**
	 * method retrieveByIdMetier(
	 * Civilite pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un Civilite pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne Civilite trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : Civilite : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : Civilite : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	Civilite retrieveByIdMetier(
			Civilite pObjet) throws AbstractDaoException;


	
	/**
	 * method retrieveByCivilite(
	 * String pCiviliteString) :<br/>
	 * <ul>
	 * <li>Recherche en base un Civilite ayant 
	 * pour civiliteString pCiviliteString.</li>
	 * </ul>
	 * return null si pCiviliteString est blank.<br/>
	 * <br/>
	 *
	 * @param pCiviliteString : String.<br/>
	 * 
	 * @return Civilite.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	Civilite retrieveByCivilite(
			String pCiviliteString) throws AbstractDaoException;
	
	

} // FIN DE L'INTERFACE IDaoCivilite.--------------------------------------

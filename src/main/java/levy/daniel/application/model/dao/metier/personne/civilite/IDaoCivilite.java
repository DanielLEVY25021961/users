package levy.daniel.application.model.dao.metier.personne.civilite;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.personne.civilite.ICivilite;


/**
 * INTERFACE <b>IDaoCivilite</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>ICivilite</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * (MONSIEUR ou M., MADAME ou Mme, Mlle ...) 
 * associé de manière unique à une <b>Personne</b>.
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE IDaoCivilite</span>
 * </p>
 * <ul>
 * <li>Interface des DAOs pour les <b>ICivilite</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux ICivilite.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES IDaoCivilite</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAO_ICivilite.png" 
 * alt="implémentation des DAOs ICivilite" border="1" align="center" />
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
public interface IDaoCivilite 
		extends IDaoGenericJPASpring<ICivilite, Long> {
	

	/**
	 * method retrieveByIdMetier(
	 * ICivilite pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un ICivilite pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne ICivilite trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : ICivilite : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : ICivilite : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	ICivilite retrieveByIdMetier(
			ICivilite pObjet) throws AbstractDaoException;


	
	/**
	 * method retrieveByCiviliteString(
	 * String pCiviliteString) :<br/>
	 * <ul>
	 * <li>Recherche en base un ICivilite ayant 
	 * pour civiliteString pCiviliteString.</li>
	 * </ul>
	 * return null si pCiviliteString est blank.<br/>
	 * <br/>
	 *
	 * @param pCiviliteString : String.<br/>
	 * 
	 * @return ICivilite.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	ICivilite retrieveByCiviliteString(
			String pCiviliteString) throws AbstractDaoException;
	


} // FIN DE L'INTERFACE IDaoCivilite.----------------------------------------

package levy.daniel.application.model.metier.personne.idinsee.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.idinsee.AbstractIdInsee;

/**
 * class IdInsee :<br/>
 * .<br/>
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
public class IdInsee extends AbstractIdInsee {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(IdInsee.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR IdInsee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public IdInsee() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR IdInsee(
	 * String pNumeroInsee) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS id en BASE</li>
	 * </ul>
	 *
	 * @param pNumeroInsee : String : 
	 * Identifiant INSEE d'une Personne.<br/>
	 */
	public IdInsee(
			final String pNumeroInsee) {
		this(null, pNumeroInsee);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR IdInsee(
	 * Long pId
	 * , String pNumeroInsee) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC id en BASE</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pNumeroInsee : String : 
	 * Identifiant INSEE d'une Personne.<br/>
	 */
	public IdInsee(
			final Long pId
				, final String pNumeroInsee) {
		
		super(pId, pNumeroInsee);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	
} // FIN DE LA CLASSE IdInsee.-----------------------------------------------

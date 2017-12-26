package levy.daniel.application.model.metier.personne.idinsee.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.idinsee.AbstractIdInsee;

/**
 * class IdInsee :<br/>
 * <p>
 * <b>CLASSE CONCRETE</b> qui modélise un <b>IdInsee</b>, c'est à dire un 
 * <b>identifiant INSEE unique</b> qui identifie de manière 
 * unique une Personne.
 * </p>
 * 
 * <ul>
 * <li>Implémentation <b>CONCRETE</b> de IdInsee.</li>
 * <li>HERITE de AbstractIdInsee.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">ATTRIBUTS</span>
 * </p>
 * <ul>
 * <li>Les <b>attributs</b> d'un IdInsee sont : </li>
 * <ul>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>numeroInsee</b>.</li>
 * </ul>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_idinsee.png" 
 * alt="implémentation du IdInsee" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>
 * L'<b>égalité metier</b> d'un IdInsee est vérifiée sur :
 * <ul>
 * <li><b>numeroInsee</b></li>
 * </ul>
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

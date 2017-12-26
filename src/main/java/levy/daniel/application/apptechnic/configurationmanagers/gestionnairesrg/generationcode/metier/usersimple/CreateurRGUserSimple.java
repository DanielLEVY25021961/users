package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.generationcode.metier.usersimple;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.TypesValidation;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.generationcode.AbstractCreateurGestionnaireRG;

/**
 * class CreateurRGUserSimple :<br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 9 déc. 2017
 *
 */
public class CreateurRGUserSimple extends AbstractCreateurGestionnaireRG {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CreateurRGUserSimple.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CreateurRGUserSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CreateurRGUserSimple() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method affecterRgAuxAttributs() :<br/>
	 * <ul>
	 * <li>CREE la <b>mapRgsParAttribut</b>.</li>
	 * <li>A FAIRE A LA MAIN.</li>
	 * </ul>
	 */
	@Override
	protected void affecterRgAuxAttributs() {
		
		/* civilite. */
		final List<String> listCivilite = new ArrayList<String>();
		listCivilite.add(TypesValidation.NOMENCLATURE.toString());
		this.mapRgsParAttribut.put("civilite", listCivilite);
		
		/* prenom. */
		final List<String> listPrenom = new ArrayList<String>();
		listPrenom.add(TypesValidation.RENSEIGNE.toString());
		listPrenom.add(TypesValidation.LITTERAL.toString());
		listPrenom.add(TypesValidation.LONGUEUR.toString());
		this.mapRgsParAttribut.put("prenom", listPrenom);
		
		/* nom. */
		final List<String> listNom = new ArrayList<String>();
		listNom.add(TypesValidation.RENSEIGNE.toString());
		listNom.add(TypesValidation.LITTERAL.toString());
		listNom.add(TypesValidation.LONGUEUR.toString());
		this.mapRgsParAttribut.put("nom", listNom);
		
		/* email. */
		final List<String> listEmail = new ArrayList<String>();
		listEmail.add(TypesValidation.MOTIF.toString());
		this.mapRgsParAttribut.put("email", listEmail);
		
		/* login. */
		final List<String> listLogin = new ArrayList<String>();
		listLogin.add(TypesValidation.RENSEIGNE.toString());
		listLogin.add(TypesValidation.LONGUEUR.toString());
		this.mapRgsParAttribut.put("login", listLogin);
		
		/* mdp. */
		final List<String> listMdp = new ArrayList<String>();
		listMdp.add(TypesValidation.RENSEIGNE.toString());
		listMdp.add(TypesValidation.LONGUEUR.toString());
		listMdp.add(TypesValidation.MOTIF.toString());
		this.mapRgsParAttribut.put("mdp", listMdp);
		
		/* profil. */
		final List<String> listProfil = new ArrayList<String>();
		listProfil.add(TypesValidation.RENSEIGNE.toString());
		listProfil.add(TypesValidation.NOMENCLATURE.toString());
		this.mapRgsParAttribut.put("profil", listProfil);
		
	} // Fin de affecterRgAuxAttributs().__________________________________
	

	
} // FIN DE LA CLASSE CreateurRGUserSimple.----------------------------------

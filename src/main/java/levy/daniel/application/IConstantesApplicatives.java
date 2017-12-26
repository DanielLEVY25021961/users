package levy.daniel.application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;

/**
 * class IConstantesApplicatives :<br/>
 * <ul>
 * <li>INTERFACE contenant les constantes mises à disposition 
 * de l'ensemble de l'application.</li>
 * <p>
 * <br/>
 * <img src="../../../../../../javadoc/images/IConstantesApplicatives.png" 
 * alt="IConstantesApplicatives" border="1" align="center" />
 * <br/>
 * </p>
 * </ul>
 *
 * - Exemple d'utilisation :<br/>
 * <code>// Appel depuis n'importe quelle classe de l'application 
 * pour concaténer le point-virgule au StringBuilder stb : </code><br/>
 * <code>stb.append(IConstantesApplicatives.POINT_VIRGULE);</code><br/>
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
 * @since 6 oct. 2017
 *
 */
public interface IConstantesApplicatives {
	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'
	 */
	char POINT_VIRGULE = ';';

	
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", "
	 */
	String VIRGULE_ESPACE = ", ";

	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - "
	 */
	String SEPARATEUR_MOINS_AERE = " - ";
	
	
	/**
	 * UNDERSCORE : String :<br/>
	 * '_'
	 */
	char UNDERSCORE = '_';

	
	/**
	 * CROCHET_OUVRANT : char :<br/>
	 * '['
	 */
	char CROCHET_OUVRANT = '[';

	
	/**
	 * CROCHET_FERMANT : char :<br/>
	 * ']'
	 */
	char CROCHET_FERMANT = ']';
	

	
	/**
	 * SAUT_LIGNE_JAVA : String :<br/>
	 * "\n"
	 */
	String SAUT_LIGNE_JAVA = "\n";
	

	/**
	 * SAUT_LIGNE_HTML : String :<br/>
	 * "&lt;br/&gt;".<br/>
	 */
	String SAUT_LIGNE_HTML = "<br/>";
	
	
	
	/**
	 * NULL : String :<br/>
	 * "null"
	 */
	String NULL = "null";
	

	
	/**
	 * DIMENSION_ECRAN : Dimension :<br/>
	 * Toolkit.getDefaultToolkit().getScreenSize().<br/>
	 * La dimension de l'écran de l'utilisateur
	 */
	Dimension DIMENSION_ECRAN 
		= Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * LARGEUR_ECRAN : int :<br/>
	 * DIMENSION_ECRAN.width.<br/>
	 * Largeur de l'écran de l'utilisateur en pixels
	 */
	int LARGEUR_ECRAN = DIMENSION_ECRAN.width;
	
	
	/**
	 * HAUTEUR_ECRAN : int :<br/>
	 * DIMENSION_ECRAN.height.<br/>
	 * Hauteur de l'écran de l'utilisateur en pixels
	 */
	int HAUTEUR_ECRAN = DIMENSION_ECRAN.height;
	

	
	/**
	 * LOCALE_FR : Locale : <br/>
	 * new Locale("fr", "FR").<br/>
	 * Locale France
	 */
	Locale LOCALE_FR = new Locale("fr", "FR");
	
	
	
	/**
	 * SUCCES : String : <br/>
	 * "success".
	 */
	String SUCCES = "success";
	
	/**
	 * ECHEC : String : <br/>
	 * "failure".
	 */
	String ECHEC = "failure";
		
	/**
	 * LIST : String :<br/>
	 * "list".
	 */
	String LIST = "list";
	
	/**
	 * TROUVE : String :<br/>
	 * "trouve".
	 */
	String TROUVE = "trouve";


	/**
	 * SANS_OBJET : String :<br/>
	 * "Sans Objet (contrôle non effectué)".
	 */
	String SANS_OBJET 
		= "Sans Objet (contrôle non effectué)";
	

	
	/**
	 * ROOT : String :<br/>
	 * "ROOT : ".
	 */
	String ROOT = "ROOT : ";

	
	/**
	 * NODE : String :<br/>
	 * "NOEUD (balise ou attribut) : ".
	 */
	String NODE = "NOEUD (balise ou attribut) : ";
	
	
	/**
	 * ELEMENT : String :<br/>
	 * "ELEMENT (Balise) : ".
	 */
	String ELEMENT = "ELEMENT (Balise) : ";
	
	
	/**
	 * ATTRIBUT : String :<br/>
	 * "ATTRIBUT".
	 */
	String ATTRIBUT = "ATTRIBUT";
	

	
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 à rajouter au début d'un fichier CSV pour 
	 * forcer Excel 2010 à le lire en UTF-8.<br/>
	 * '\uFEFF'.
	 */
	char BOM_UTF_8 = '\uFEFF';


	
} // FIN DE L'INTERFACE IConstantesApplicatives.-----------------------------
package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.metier.usersimple;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.ConfigurationApplicationManager;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.ComparatorRG;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;



/**
 * class GestionnaireRGUserSimple :<br/>
 * <ul>
 * <li>Classe Utilitaire chargée de gérer les <b>RG</b> 
 * se rapportant à un <b>UserSimple</b>.</li>
 * <li>délégué du <b>GestionnaireRG</b> qui centralise en un 
 * <b>point unique</b> toute la gestion des RG de l'application.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/UserSimple_Entity.png" 
 * alt="implémentation de l'Entity UserSimple" border="1" align="center" />
 * </li>
 * <br/>
 * <li></li>
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
 * @since 5 déc. 2017
 *
 */
public final class GestionnaireRGUserSimple {

	// ************************ATTRIBUTS************************************/


	/**
	 * RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : String :<br/>
	 * "RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
	 * la civilite (M., Mme, ...) du UserSimple doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".<br/>
	 */
	public static final String RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 
	= "RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01"
			+ " : la civilite (M., Mme, ...) du UserSimple "
			+ "doit respecter un ensemble fini de valeurs (nomenclature)";

	
	/**
	 * RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : String :<br/>
	 * "RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : 
	 * le prénom du UserSimple doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_PRENOM_RENSEIGNE_02 
		= "RG_USERSIMPLE_PRENOM_RENSEIGNE_02"
			+ " : le prénom du UserSimple "
				+ "doit être renseigné (obligatoire)";

	
	/**
	 * RG_USERSIMPLE_PRENOM_LITTERAL_03 : String :<br/>
	 * "RG_USERSIMPLE_PRENOM_LITTERAL_03 : 
	 * le prénom du UserSimple 
	 * ne doit contenir que des lettres ou des 
	 * caractères spéciaux '-', '_', ... (aucun chiffre)".<br/>
	 */
	public static final String RG_USERSIMPLE_PRENOM_LITTERAL_03 
		= "RG_USERSIMPLE_PRENOM_LITTERAL_03"
				+ " : le prénom du UserSimple "
				+ "ne doit contenir que des "
				+ "lettres ou des caractères spéciaux '-', '_', ... "
				+ "(aucun chiffre)";


	/**
	 * RG_USERSIMPLE_PRENOM_LONGUEUR_04 : String :<br/>
	 * "RG_USERSIMPLE_PRENOM_LONGUEUR_04 : 
	 * le prénom du UserSimple doit contenir 
	 * entre [1] et [30] lettres".<br/>
	 */
	public static final String RG_USERSIMPLE_PRENOM_LONGUEUR_04 
		= "RG_USERSIMPLE_PRENOM_LONGUEUR_04"
				+ " : le prénom du UserSimple "
				+ "doit contenir entre [1] et [30] lettres";


	/**
	 * RG_USERSIMPLE_NOM_RENSEIGNE_05 : String :<br/>
	 * "RG_USERSIMPLE_NOM_RENSEIGNE_05
	 *  : le nom du UserSimple doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_NOM_RENSEIGNE_05 
		= "RG_USERSIMPLE_NOM_RENSEIGNE_05"
				+ " : le nom du UserSimple "
				+ "doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_NOM_LITTERAL_06 : String :<br/>
	 * "RG_USERSIMPLE_NOM_LITTERAL_06
	 *  : le nom du UserSimple 
	 *  ne doit contenir que des lettres ou des caractères spéciaux 
	 *  '-', '_', ... (aucun chiffre)".<br/>
	 */
	public static final String RG_USERSIMPLE_NOM_LITTERAL_06 
	= "RG_USERSIMPLE_NOM_LITTERAL_06"
			+ " : le nom du UserSimple "
			+ "ne doit contenir que des lettres ou des "
			+ "caractères spéciaux '-', '_', ... (aucun chiffre)";

	
	/**
	 * RG_USERSIMPLE_NOM_LONGUEUR_07 : String :<br/>
	 * "RG_USERSIMPLE_NOM_LONGUEUR_07
	 *  : le nom du UserSimple doit contenir entre 
	 *  [1] et [50] lettres".<br/>
	 */
	public static final String RG_USERSIMPLE_NOM_LONGUEUR_07 
		= "RG_USERSIMPLE_NOM_LONGUEUR_07"
				+ " : le nom du UserSimple "
				+ "doit contenir "
				+ "entre [1] et [50] lettres";
	

	/**
	 * RG_USERSIMPLE_EMAIL_MOTIF_08 : String :<br/>
	 * "RG_USERSIMPLE_EMAIL_MOTIF_08
	 *  : l'email du UserSimple doit respecter un motif (Regex) 
	 *  d'un email (du type albacor.trust@google.fr)".<br/>
	 */
	public static final String RG_USERSIMPLE_EMAIL_MOTIF_08 
		= "RG_USERSIMPLE_EMAIL_MOTIF_08"
				+ " : l'email du UserSimple "
				+ "doit respecter le motif "
				+ "(Regex) d'un email (du type albacor.trust@google.fr)";


	/**
	 * RG_USERSIMPLE_LOGIN_RENSEIGNE_09 : String :<br/>
	 * "RG_USERSIMPLE_LOGIN_RENSEIGNE_09
	 *  : le login du UserSimple
	 *   doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_LOGIN_RENSEIGNE_09 
		= "RG_USERSIMPLE_LOGIN_RENSEIGNE_09"
				+ " : le login du UserSimple"
				+ " doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_LOGIN_LONGUEUR_10 : String :<br/>
	 * "RG_USERSIMPLE_LOGIN_LONGUEUR_10
	 *  : le login du UserSimple 
	 *  doit contenir entre [1] et [100] caractères".<br/>
	 */
	public static final String RG_USERSIMPLE_LOGIN_LONGUEUR_10 
		= "RG_USERSIMPLE_LOGIN_LONGUEUR_10"
				+ " : le login du UserSimple"
				+ " doit contenir entre [1] et [100] caractères";


	/**
	 * RG_USERSIMPLE_MDP_RENSEIGNE_11 : String :<br/>
	 * "RG_USERSIMPLE_MDP_RENSEIGNE_11
	 *  : le mdp du UserSimple
	 *   doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_MDP_RENSEIGNE_11 
		= "RG_USERSIMPLE_MDP_RENSEIGNE_11"
				+ " : le mdp du UserSimple"
				+ " doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_MDP_LONGUEUR_12 : String :<br/>
	 * "RG_USERSIMPLE_MDP_LONGUEUR_12
	 *  : le mdp du UserSimple
	 *   doit contenir entre [3] et [20] caractères".<br/>
	 */
	public static final String RG_USERSIMPLE_MDP_LONGUEUR_12 
		= "RG_USERSIMPLE_MDP_LONGUEUR_12"
				+ " : le mdp du UserSimple"
				+ " doit contenir entre [3] et [20] caractères";


	/**
	 * RG_USERSIMPLE_MDP_MOTIF_13 : String :<br/>
	 * "RG_USERSIMPLE_MDP_MOTIF_13
	 *  : le mdp du UserSimple
	 *   doit respecter un motif (Regex)".<br/>
	 */
	public static final String RG_USERSIMPLE_MDP_MOTIF_13 
		= "RG_USERSIMPLE_MDP_MOTIF_13"
				+ " : le mdp du UserSimple"
				+ " doit respecter un motif (Regex)";

	
	/**
	 * RG_USERSIMPLE_PROFIL_RENSEIGNE_14 : String :<br/>
	 * "RG_USERSIMPLE_PROFIL_RENSEIGNE_14
	 *  : le profil du UserSimple
	 *   doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_PROFIL_RENSEIGNE_14 
		= "RG_USERSIMPLE_PROFIL_RENSEIGNE_14"
				+ " : le profil du UserSimple"
				+ " doit être renseigné (obligatoire)";

		
	/**
	 * RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 : String :<br/>
	 * "RG_USERSIMPLE_PROFIL_NOMENCLATURE_15
	 *  : le profil du UserSimple
	 *   doit respecter un ensemble fini de valeurs (nomenclature)".<br/>
	 */
	public static final String RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 
		= "RG_USERSIMPLE_PROFIL_NOMENCLATURE_15"
				+ " : le profil du UserSimple"
				+ " doit respecter un ensemble fini de valeurs"
				+ " (nomenclature)";


	/* CIVILITE. */	
	/**
	 * validerUserSimpleCivilite : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur la civilite du userSimple.<br/>
	 */
	private static Boolean validerUserSimpleCivilite;
	
	
	/**
	 * validerUserSimpleCiviliteNomenclature01 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 sur la civilite.<br/>
	 */
	private static Boolean validerUserSimpleCiviliteNomenclature01;
	
	
	/* PRENOM. */
	/**
	 * validerUserSimplePrenom : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur le prenom du userSimple.<br/>
	 */
	private static Boolean validerUserSimplePrenom;

	
	/**
	 * validerUserSimplePrenomRenseigne02 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_RENSEIGNE_02 sur le prenom.<br/>
	 */
	private static Boolean validerUserSimplePrenomRenseigne02;

	
	/**
	 * validerUserSimplePrenomLitteral03 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_LITTERAL_03 sur le prenom.<br/>
	 */
	private static Boolean validerUserSimplePrenomLitteral03;

	
	/**
	 * validerUserSimplePrenomLongueur04 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_LONGUEUR_04 sur le prenom.<br/>
	 */
	private static Boolean validerUserSimplePrenomLongueur04;
	

	/* NOM. */
	/**
	 * validerUserSimpleNom : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur le nom du userSimple.<br/>
	 */
	private static Boolean validerUserSimpleNom;

	
	/**
	 * validerUserSimpleNomRenseigne05 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_RENSEIGNE_05 sur le nom.<br/>
	 */
	private static Boolean validerUserSimpleNomRenseigne05;

	
	/**
	 * validerUserSimpleNomLitteral06 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_LITTERAL_06 sur le nom.<br/>
	 */
	private static Boolean validerUserSimpleNomLitteral06;

	
	/**
	 * validerUserSimpleNomLongueur07 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_LONGUEUR_07 sur le nom.<br/>
	 */
	private static Boolean validerUserSimpleNomLongueur07;
	

	/* EMAIL. */
	/**
	 * validerUserSimpleEmail : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur l'email du userSimple.<br/>
	 */
	private static Boolean validerUserSimpleEmail;
	
	
	/**
	 * validerUserSimpleEmailMotif08 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_EMAIL_MOTIF_08 sur l'email.<br/>
	 */
	private static Boolean validerUserSimpleEmailMotif08;
	

	/* LOGIN. */
	/**
	 * validerUserSimpleLogin : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur le login du userSimple.<br/>
	 */
	private static Boolean validerUserSimpleLogin;

	
	/**
	 * validerUserSimpleLoginRenseigne09 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_LOGIN_RENSEIGNE_09 sur le Login.<br/>
	 */
	private static Boolean validerUserSimpleLoginRenseigne09;

	
	/**
	 * validerUserSimpleLoginLongueur10 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_LOGIN_LONGUEUR_10 sur le Login.<br/>
	 */
	private static Boolean validerUserSimpleLoginLongueur10;

	
	/* MDP. */
	/**
	 * validerUserSimpleMdp : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur le mdp du userSimple.<br/>
	 */
	private static Boolean validerUserSimpleMdp;

	
	/**
	 * validerUserSimpleMdpRenseigne11 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_RENSEIGNE_11 sur le mdp.<br/>
	 */
	private static Boolean validerUserSimpleMdpRenseigne11;

	
	/**
	 * validerUserSimpleMdpLongueur12 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_LONGUEUR_12 sur le mdp.<br/>
	 */
	private static Boolean validerUserSimpleMdpLongueur12;

	
	/**
	 * validerUserSimpleMdpMotif13 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_MOTIF_13 sur le mdp.<br/>
	 */
	private static Boolean validerUserSimpleMdpMotif13;

	
	/* PROFIL. */
	/**
	 * validerUserSimpleProfil : Boolean :<br/>
	 * Boolean activant globalement la validation des RG 
	 * sur le profil du userSimple.<br/>
	 */
	private static Boolean validerUserSimpleProfil;

	
	/**
	 * validerUserSimpleProfilRenseigne14 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_PROFIL_RENSEIGNE_14 sur le profil.<br/>
	 */
	private static Boolean validerUserSimpleProfilRenseigne14;

	
	/**
	 * validerUserSimpleProfilNomenclature15 : Boolean :<br/>
	 * Boolean activant la validation de 
	 * RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 sur le profil.<br/>
	 */
	private static Boolean validerUserSimpleProfilNomenclature15;
	

	
	/**
	 * mapRG : Map&lt;String,LigneRG&gt; :<br/>
	 * <ul>
	 * Map contenant toutes les RG implémentées 
	 * dans le Gestionnaire de RG avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 * Une ligne RG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;].<br/>
	 */
	private static transient Map<String, LigneRG> mapRG 
		= new ConcurrentHashMap<String, LigneRG>();

	
	/**
	 * bundleExterneRG : ResourceBundle :<br/>
	 * ResourceBundle encapsulant rg-objet.properties.<br/>
	 * rg-objet.properties est un fichier EXTERNE (hors classpath) 
	 * qui doit être accessible à la Maîtrise d'Ouvrage (MOA).<br/>
	 */
	private static transient ResourceBundle bundleExterneRG;


	/**
	 * nomCompletProperties : String :<br/>
	 * <ul>
	 * <li>Nom complet (avec chemin) du fichier properties 
	 * utilisé par le présent gestionnaireRG</li>
	 * </ul>
	 */
	private static transient String nomCompletProperties;
	
	
	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnaireRGUserSimple.class);

	
	
	static {
		
		try {
			
			remplirMapRG();
			
		} catch (MalformedURLException malformedURLexc) {
			
			final String message 
				= "Impossible de fournir la liste des RG implémentées";
			
			if (LOG.isFatalEnabled()) {
				LOG.fatal(message, malformedURLexc);
			}
		}
	}

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR GestionnaireRGUserSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private GestionnaireRGUserSimple() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method remplirMapRG() :<br/>
	 * <ul>
	 * remplit et retourne la Map&lt;String, LigneRG&gt; mapRG 
	 * contenant toutes 
	 * les Règles de Gestion (RG) implémentées 
	 * dans les services de l'application avec :
	 * <li>String : le nom de la RG.</li>
	 * <li>LigneRG : pure fabrication encapsulant 
	 * tous les éléments relatifs à la RG.</li>
	 * </ul>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 * <ul>
	 * Types de contrôles :<br/>
	 * <li>1, "nullité"</li>
	 * <li>2, "format"</li>
	 * <li>3, "fourchette [Min-Max]"</li>
	 * <li>4, "nomenclature"</li>
	 * <li>5, "valeur par défaut"</li>
	 * <li>6, "longueur"</li>
	 * <li>7, "expression régulière (Regex)"</li>
	 * </ul>
	 *
	 * @return : Map&lt;String, LigneRG&gt; : mapRG.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private static Map<String, LigneRG> remplirMapRG() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRGUserSimple.class) {
			
			/* CIVILITE. */
			/* RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 */
			final LigneRG ligneRg1 
				= new LigneRG(getValiderUserSimpleCivilite()
						, getValiderUserSimpleCiviliteNomenclature01()
						, RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01
						, 4
						, fournirMessageRG(RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01)
						, "UserSimple", "Civilite"
						, "ValideurUserSimple"
						, "validerRGUserSimpleCiviliteNomenclature01(...)"
						, fournirNomCompletProperties()
						, fournirCleValiderUserSimpleCiviliteNomenclature01());
			
			mapRG.put(
					RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01
						, ligneRg1);
			
			/* PRENOM. */
			/* RG_USERSIMPLE_PRENOM_RENSEIGNE_02 */
			final LigneRG ligneRg2 
			= new LigneRG(getValiderUserSimplePrenom()
					, getValiderUserSimplePrenomRenseigne02()
					, RG_USERSIMPLE_PRENOM_RENSEIGNE_02
					, 1
					, fournirMessageRG(RG_USERSIMPLE_PRENOM_RENSEIGNE_02)
					, "UserSimple", "prenom"
					, "ValideurUserSimple"
					, "validerRGUserSimplePrenomRenseigne02(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimplePrenomRenseigne02());
			
			mapRG.put(
					RG_USERSIMPLE_PRENOM_RENSEIGNE_02
						, ligneRg2);
			
			/* RG_USERSIMPLE_PRENOM_LITTERAL_03 */
			final LigneRG ligneRg3 
			= new LigneRG(getValiderUserSimplePrenom()
					, getValiderUserSimplePrenomLitteral03()
					, RG_USERSIMPLE_PRENOM_LITTERAL_03
					, 2
					, fournirMessageRG(RG_USERSIMPLE_PRENOM_LITTERAL_03)
					, "UserSimple", "prenom"
					, "ValideurUserSimple"
					, "validerRGUserSimplePrenomLitteral03(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimplePrenomLitteral03());
			
			mapRG.put(
					RG_USERSIMPLE_PRENOM_LITTERAL_03
						, ligneRg3);
			
			/* RG_USERSIMPLE_PRENOM_LONGUEUR_04 */
			final LigneRG ligneRg4 
			= new LigneRG(getValiderUserSimplePrenom()
					, getValiderUserSimplePrenomLongueur04()
					, RG_USERSIMPLE_PRENOM_LONGUEUR_04
					, 6
					, fournirMessageRG(RG_USERSIMPLE_PRENOM_LONGUEUR_04)
					, "UserSimple", "prenom"
					, "ValideurUserSimple"
					, "validerRGUserSimplePrenomLongueur04(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimplePrenomLongueur04());
			
			mapRG.put(
					RG_USERSIMPLE_PRENOM_LONGUEUR_04
						, ligneRg4);
			
			/* NOM. */
			/* RG_USERSIMPLE_NOM_RENSEIGNE_05 */
			final LigneRG ligneRg5 
			= new LigneRG(getValiderUserSimpleNom()
					, getValiderUserSimpleNomRenseigne05()
					, RG_USERSIMPLE_NOM_RENSEIGNE_05
					, 1
					, fournirMessageRG(RG_USERSIMPLE_NOM_RENSEIGNE_05)
					, "UserSimple", "nom"
					, "ValideurUserSimple"
					, "validerRGUserSimpleNomRenseigne05(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleNomRenseigne05());
			
			mapRG.put(
					RG_USERSIMPLE_NOM_RENSEIGNE_05
						, ligneRg5);
			
			/* RG_USERSIMPLE_NOM_LITTERAL_06 */
			final LigneRG ligneRg6 
			= new LigneRG(getValiderUserSimpleNom()
					, getValiderUserSimpleNomLitteral06()
					, RG_USERSIMPLE_NOM_LITTERAL_06
					, 2
					, fournirMessageRG(RG_USERSIMPLE_NOM_LITTERAL_06)
					, "UserSimple", "nom"
					, "ValideurUserSimple"
					, "validerRGUserSimpleNomLitteral06(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleNomLitteral06());
			
			mapRG.put(
					RG_USERSIMPLE_NOM_LITTERAL_06
						, ligneRg6);
			
			/* RG_USERSIMPLE_NOM_LONGUEUR_07 */
			final LigneRG ligneRg7 
			= new LigneRG(getValiderUserSimpleNom()
					, getValiderUserSimpleNomLongueur07()
					, RG_USERSIMPLE_NOM_LONGUEUR_07
					, 6
					, fournirMessageRG(RG_USERSIMPLE_NOM_LONGUEUR_07)
					, "UserSimple", "nom"
					, "ValideurUserSimple"
					, "validerRGUserSimpleNomLongueur07(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleNomLongueur07());
			
			mapRG.put(
					RG_USERSIMPLE_NOM_LONGUEUR_07
						, ligneRg7);
			
			/* EMAIL. */
			/* RG_USERSIMPLE_EMAIL_MOTIF_08 */
			final LigneRG ligneRg8 
			= new LigneRG(getValiderUserSimpleEmail()
					, getValiderUserSimpleEmailMotif08()
					, RG_USERSIMPLE_EMAIL_MOTIF_08
					, 7
					, fournirMessageRG(RG_USERSIMPLE_EMAIL_MOTIF_08)
					, "UserSimple", "email"
					, "ValideurUserSimple"
					, "validerRGUserSimpleEmailMotif08(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleEmailMotif08());
			
			mapRG.put(
					RG_USERSIMPLE_EMAIL_MOTIF_08
						, ligneRg8);
			
			/* LOGIN. */
			/* RG_USERSIMPLE_LOGIN_RENSEIGNE_09 */
			final LigneRG ligneRg9 
			= new LigneRG(getValiderUserSimpleLogin()
					, getValiderUserSimpleLoginRenseigne09()
					, RG_USERSIMPLE_LOGIN_RENSEIGNE_09
					, 1
					, fournirMessageRG(RG_USERSIMPLE_LOGIN_RENSEIGNE_09)
					, "UserSimple", "login"
					, "ValideurUserSimple", "validerRGUserSimpleLoginRenseigne09(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleLoginRenseigne09());
			
			mapRG.put(
					RG_USERSIMPLE_LOGIN_RENSEIGNE_09
						, ligneRg9);
			
			/* RG_USERSIMPLE_LOGIN_LONGUEUR_10 */
			final LigneRG ligneRg10 
			= new LigneRG(getValiderUserSimpleLogin()
					, getValiderUserSimpleLoginLongueur10()
					, RG_USERSIMPLE_LOGIN_LONGUEUR_10
					, 6
					, fournirMessageRG(RG_USERSIMPLE_LOGIN_LONGUEUR_10)
					, "UserSimple", "login"
					, "ValideurUserSimple", "validerRGUserSimpleLoginLongueur10(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleLoginLongueur10());
			
			mapRG.put(
					RG_USERSIMPLE_LOGIN_LONGUEUR_10
						, ligneRg10);
			
			/* MDP. */
			/* RG_USERSIMPLE_MDP_RENSEIGNE_11 */
			final LigneRG ligneRg11 
			= new LigneRG(getValiderUserSimpleMdp()
					, getValiderUserSimpleMdpRenseigne11()
					, RG_USERSIMPLE_MDP_RENSEIGNE_11
					, 1
					, fournirMessageRG(RG_USERSIMPLE_MDP_RENSEIGNE_11)
					, "UserSimple", "mdp"
					, "ValideurUserSimple", "validerRGUserSimpleMdpRenseigne11(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleMdpRenseigne11());
			
			mapRG.put(
					RG_USERSIMPLE_MDP_RENSEIGNE_11
						, ligneRg11);
			
			
			/* RG_USERSIMPLE_MDP_LONGUEUR_12 */
			final LigneRG ligneRg12 
			= new LigneRG(getValiderUserSimpleMdp()
					, getValiderUserSimpleMdpLongueur12()
					, RG_USERSIMPLE_MDP_LONGUEUR_12
					, 6
					, fournirMessageRG(RG_USERSIMPLE_MDP_LONGUEUR_12)
					, "UserSimple", "mdp"
					, "ValideurUserSimple", "validerRGUserSimpleMdpLongueur12(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleMdpLongueur12());
			
			
			mapRG.put(
					RG_USERSIMPLE_MDP_LONGUEUR_12
						, ligneRg12);
			
			
			/* RG_USERSIMPLE_MDP_MOTIF_13 */
			final LigneRG ligneRg13 
			= new LigneRG(getValiderUserSimpleMdp()
					, getValiderUserSimpleMdpMotif13()
					, RG_USERSIMPLE_MDP_MOTIF_13
					, 7
					, fournirMessageRG(RG_USERSIMPLE_MDP_MOTIF_13)
					, "UserSimple", "mdp"
					, "ValideurUserSimple", "validerRGUserSimpleMdpMotif13(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleMdpMotif13());
			
			mapRG.put(
					RG_USERSIMPLE_MDP_MOTIF_13
						, ligneRg13);
			
			
			/* PROFIL. */
			/* RG_USERSIMPLE_PROFIL_RENSEIGNE_14 */
			final LigneRG ligneRg14 
			= new LigneRG(getValiderUserSimpleProfil()
					, getValiderUserSimpleProfilRenseigne14()
					, RG_USERSIMPLE_PROFIL_RENSEIGNE_14
					, 1
					, fournirMessageRG(RG_USERSIMPLE_PROFIL_RENSEIGNE_14)
					, "UserSimple", "profil"
					, "ValideurUserSimple", "validerRGUserSimpleRenseigne14(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleProfilRenseigne14());
			
			mapRG.put(
					RG_USERSIMPLE_PROFIL_RENSEIGNE_14
						, ligneRg14);
			
			
			/* RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 */
			final LigneRG ligneRg15 
			= new LigneRG(getValiderUserSimpleProfil()
					, getValiderUserSimpleProfilNomenclature15()
					, RG_USERSIMPLE_PROFIL_NOMENCLATURE_15
					, 4
					, fournirMessageRG(RG_USERSIMPLE_PROFIL_NOMENCLATURE_15)
					, "UserSimple", "profil"
					, "ValideurUserSimple", "validerRGUserSimpleNomenclature15(...)"
					, fournirNomCompletProperties()
					, fournirCleValiderUserSimpleProfilNomenclature15());
			
			mapRG.put(
					RG_USERSIMPLE_PROFIL_NOMENCLATURE_15
						, ligneRg15);
			
			return mapRG;
			
		} // Fin de bloc synchronized.__________________________
		
	} // Fin de remplirMapRG().____________________________________________
	

	
	/**
	 * <ul>
	 * <li>
	 * Fournit le ResourceBundle associé au fichier <i>externe</i> 
	 * (hors classpath) <b>rg-objet.properties</b> 
	 * avec la Locale Locale_fr_FR.
	 * </li>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : rg-objet.properties.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static ResourceBundle getBundleExterneRG() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (bundleExterneRG == null) {
				bundleExterneRG 
					= getBundleExterneRG(Locale.getDefault());
			}
			
			return bundleExterneRG;
			
		} // Fin de synchronized._____________________________
						
	} // Fin de getBundleExterneRG().______________________________________


	
	/**
	 * method getBundleExterneRG(
	 * Locale pLocale) :<br/>
	 * <ul>
	 * <li>
	 * Fournit le ResourceBundle associé au fichier <i>externe</i> 
	 * (hors classpath) <b>rg-objet.properties</b> avec la Locale pLocale.
	 * </li>
	 * </ul>
	 * <br/>
	 *
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : ResourceBundle.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private static ResourceBundle getBundleExterneRG(
			final Locale pLocale) throws MalformedURLException {

		synchronized(GestionnaireRGUserSimple.class) {
			
			ResourceBundle resourceBundle = null;
			
			/* Accède au répertoire externe 
			 * contenant rg-objet.properties. */
			final File repertoireRessourcesParametrables 
				= new File(fournirCheminRessourceExterneRG());
		
			final URL[] urlsRessourcesParametrables 
				= { repertoireRessourcesParametrables.toURI().toURL() };
		
			final ClassLoader loaderRessourcesParametrables 
				= new URLClassLoader(urlsRessourcesParametrables);
		
			/* Récupère le ResourceBundle en utilisant le bon ClassLoader. */
			resourceBundle 
				= ResourceBundle.getBundle(
						fournirNomBasePropertiesRG()
							, pLocale
								, loaderRessourcesParametrables);
		
			return resourceBundle;
			
		} // Fin de synchronized._____________________________
				
	} // Fin de getBundleExterneRG(...).___________________________________


	
	/**
	 * <ul>
	 * <li>fournit le chemin <b>externe</b> (hors classpath) du 
	 * <b>répertoire</b> contenant le fichier 
	 * <b>rg-objet.properties</b>.</li>
	 * <li>Ce chemin doit être écrit <b>EN ABSOLU</b> 
	 * (surtout pas relatif au projet Eclipse).</li>
	 * <li>Par exemple H:.../ressources_externes/rg/metier/ 
	 * pour le fichier "rg-usersimple_fr_FR.properties".</li>
	 * <br/>
	 * Pour le <b>GestionnaireRGUserSimple</b> qui gère 
	 * les RG du <b>UserSimple</b> : <br/>
	 * <li>Chemin absolu vers <b>rg-usersimple.properties</b> : </li>
	 * <li><b>H:.../ressources_externes/rg/metier/</b></li>
	 * </ul>
	 */
	private static String fournirCheminRessourceExterneRG() {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			String cheminRessourcesExternes = null;
			String cheminRessourcesExternesRG = null;
			
			try {
				
				/* Récupère le chemin vers les ressources externes
				 *  auprès du ConfigurationApplicationManager. */
				cheminRessourcesExternes 
					= ConfigurationApplicationManager
						.getPathRessourcesExternes();
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			/* constitue le chemin vers rg-usersimple.properties 
			 * à partir du chemin des ressources_externes. */
			cheminRessourcesExternesRG 
				= cheminRessourcesExternes + "/rg/metier/";
			
			return cheminRessourcesExternesRG;

		} // Fin de synchronized._____________________________
					
	} // Fin de fournirCheminRessourceExterneRG()._________________________
	
	
	
	/**
	 * <ul>
	 * <li>
	 * fournit le <b>nom de base</b> du rg-objet.properties 
	 * en fonction de l'objet traité par le <b>GestionnaireRGObjet</b>.
	 * </li>
	 * <li>Par exemple : "rg-usersimple" pour l'Object UserSimple.</li>
	 * </ul>
	 * <ul>
	 * Pour le <b>GestionnaireRGUserSimple</b> qui gère 
	 * les RG du <b>UserSimple</b> : <br/>
	 * <li><b>"rg-usersimple"</b>.</li>
	 * </ul>
	 */
	private static String fournirNomBasePropertiesRG() {
		return "rg-usersimple";
	} // Fin de fournirNomBasePropertiesRG().______________________________


	
	/**
	 * method fournirNomCompletProperties() :<br/>
	 * <ul>
	 * <li>fournit le Nom complet (avec chemin) du fichier properties 
	 * utilisé par le présent gestionnaireRG</li>
	 * <li>Par exemple :<br/> 
	 * H:/.../ressources_externes/rg/metier/
	 * rg-usersimple_fr_FR.properties</li>
	 * </ul>
	 *
	 * @return : String : Nom complet (avec chemin) 
	 * du fichier properties .<br/>
	 */
	private static String fournirNomCompletProperties() {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (nomCompletProperties == null) {
				
				final StringBuilder stb = new StringBuilder();
				
				stb.append(fournirCheminRessourceExterneRG());
				stb.append(fournirNomBasePropertiesRG());
				stb.append(Locale.getDefault().toString());
				stb.append(".properties");
				
				nomCompletProperties = stb.toString();
			}

			return nomCompletProperties;
			
		} // Fin de synchronized._____________________________
				
	} // Fin de fournirNomCompletProperties()._____________________________
	

	
	/**
	 * method fournirMessageRG(
	 * String pString) :<br/>
	 * <ul>
	 * <li>Extrait la partie "message" d'une RG.</li>
	 * <li>Split une String autour du séparateur " : ".</li>
	 * <li>Par exemple :<br/>
	 * "le prénom du UserSimple doit être renseigné (obligatoire)" 
	 * pour "RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : le prénom du 
	 * UserSimple doit être renseigné (obligatoire)"</lil>
	 * </ul>
	 * retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : RG dont on veut extraire le message.<br/>
	 * 
	 * @return : String : Message de la RG.<br/>
	 */
	private static String fournirMessageRG(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		final String[] morceaux 
			= StringUtils.splitByWholeSeparator(pString, " : ");
		
		return morceaux[1];
		
	} // Fin de fournirMessageRG(...)._____________________________________
	
	
	
	/**
	 * method getEnTeteCsv() :<br/>
	 * <ul>
	 * <li>Retourne l'<b>en-tête csv</b> d'une <b>LigneRG</b>.</li>
	 * <li>"id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;"</li>
	 * </ul>
	 *
	 * @return : String : "id;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;"<br/>
	 */
	public static String getEnTeteCsv() {
		
		return "id;Actif;activité des contrôles sur l'attribut;"
				+ "activité de la RG;RG implémentée;clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;properties;clé;";
		
	} // Fin de getEnTeteCsv().____________________________________________

	
	
	/**
	 * method getMapRG() :<br/>
	 * <ul>
	 * Getter de la Map contenant toutes les RG implémentées dans 
	 * le Gestionnaire de RG avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 * Une ligne RG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;].<br/>
	 *
	 * @return mapRG : Map<String,LigneRG>.<br/>
	 */
	public static Map<String, LigneRG> getMapRG() {
		return mapRG;
	} // Fin de getMapRG().________________________________________________
	
	
	
	/**
	 * method afficherListeRGImplementeesCsv() :<br/>
	 * <ul>
	 * <li>Retourne une String pour l'affichage de la liste 
	 * des RG implémentées dans le GestionnaireRG.</li>
	 * <li>La String contient la liste des LignesRG au format csv.</li>
	 * </ul>
	 * Trie la Map this.mapRG en fonction du numéro et du 
	 * nom des Règles de Gestion (RG).<br/>
	 * <br/>
	 * retourne null si mapRG == null.<br/>
	 * <br/>
	 *
	 * @return : String : liste csv des RG implémentées.<br/>
	 */
	public static String afficherListeRGImplementeesCsv() {

		/* retourne null si mapRG == null. */
		if (mapRG == null) {
			return null;
		}

		/* Tri de la Map en fonction du numéro des Règles de Gestion. */
		/*
		 * Instanciation d'un comparateur de RG qui trie 
		 * sur les numéros des RG.
		 */
		final ComparatorRG comparateurRG = new ComparatorRG();

		/* Instanciation d'une SortedMap vide avec le comparateur */
		final SortedMap<String, LigneRG> mapTriee 
			= new TreeMap<String, LigneRG>(comparateurRG);

		/* Remplissage de la map triée. */
		mapTriee.putAll(mapRG);

		final StringBuilder stb = new StringBuilder();

		stb.append(getEnTeteCsv());
		stb.append(SAUT_LIGNE);

		final Set<Entry<String, LigneRG>> entrySet = mapTriee.entrySet();

		final Iterator<Entry<String, LigneRG>> ite = entrySet.iterator();

		final int nbreEntry = entrySet.size();

		int compteur = 0;

		while (ite.hasNext()) {

			compteur++;

			final Entry<String, LigneRG> entry = ite.next();
			final LigneRG ligneRG = entry.getValue();

			stb.append(ligneRG.toStringCsv());

			if (compteur < nbreEntry) {
				stb.append(SAUT_LIGNE);
			}
		}

		return stb.toString();

	} // Fin de afficherListeRGImplementeesCsv().__________________________
	

	
	/**
	 * method getLigneRG(
	 * String pNomRG) :<br/>
	 * Retourne l'encapsulation LigneRG correspondant 
	 * à la RG de nom pNomRG dans la mapRG.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @param pNomRG : String : Nom de la Règle de Gestion (RG).<br/>
	 * 
	 * @return : LigneRG : pure fabrication.<br/>
	 * @throws MalformedURLException 
	 */
	public static LigneRG getLigneRG(
			final String pNomRG) throws MalformedURLException {
		
		return mapRG.get(pNomRG);
		
	} // Fin de getLigneRG(...).___________________________________________

	

	
	/* CIVILITE. */	
	/**
	 * method lireValiderUserSimpleCivilite() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleCivilite</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleCivilite() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleCivilite == null) {
				
				final String validerUserSimpleCiviliteString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleCivilite());
				
				validerUserSimpleCivilite 
				= Boolean.valueOf(validerUserSimpleCiviliteString.trim());
				
			}
			
		} // Fin de synchronized._____________________________
				
	} // Fin de lireValiderUserSimpleCivilite().___________________________


	
	/**
	 * method fournirCleValiderUserSimpleCivilite() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleCivilite</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur la civilite du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Civilite".<br/>
	 */
	private static String fournirCleValiderUserSimpleCivilite() {
		return "valider.UserSimple.Civilite";
	} // Fin de fournirCleValiderUserSimpleCivilite()._____________________


	
	/**
	 * method lireValiderUserSimpleCiviliteNomenclature01() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleCivilite</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleCiviliteNomenclature01() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleCiviliteNomenclature01 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleCiviliteNomenclature01());
				
				validerUserSimpleCiviliteNomenclature01 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleCiviliteNomenclature01()._____________
	
	
	
	/**
	 * method fournirCleValiderUserSimpleCiviliteNomenclature01() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleCiviliteNomenclature01</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 sur la civilite.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Civilite.Nomenclature.01".<br/>
	 */
	private static String fournirCleValiderUserSimpleCiviliteNomenclature01() {
		return "valider.UserSimple.Civilite.Nomenclature.01";
	} // Fin de fournirCleValiderUserSimpleCiviliteNomenclature01()._______
	
	
	
	/* PRENOM. */	
	/**
	 * method lireValiderUserSimplePrenom() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimplePrenom</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimplePrenom() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimplePrenom == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimplePrenom());
				
				validerUserSimplePrenom 
					= Boolean.valueOf(validerString.trim());
				
			}
			
		} // Fin de synchronized._____________________________
				
	} // Fin de lireValiderUserSimplePrenom()._____________________________


	
	/**
	 * method fournirCleValiderUserSimplePrenom() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimplePrenom</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur le prenom du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Prenom".<br/>
	 */
	private static String fournirCleValiderUserSimplePrenom() {
		return "valider.UserSimple.Prenom";
	} // Fin de fournirCleValiderUserSimplePrenom()._______________________
	

	
	/**
	 * method lireValiderUserSimplePrenomRenseigne02() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimplePrenomRenseigne02</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimplePrenomRenseigne02() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimplePrenomRenseigne02 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimplePrenomRenseigne02());
				
				validerUserSimplePrenomRenseigne02 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimplePrenomRenseigne02().__________________
	
	
	
	/**
	 * method fournirCleValiderUserSimplePrenomRenseigne02() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimplePrenomRenseigne01</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_RENSEIGNE_02 sur le prenom.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Prenom.Renseigne.02".<br/>
	 */
	private static String fournirCleValiderUserSimplePrenomRenseigne02() {
		return "valider.UserSimple.Prenom.Renseigne.02";
	} // Fin de fournirCleValiderUserSimplePrenomRenseigne02().____________
	

	
	/**
	 * method lireValiderUserSimplePrenomLitteral03() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimplePrenomLitteral03</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimplePrenomLitteral03() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimplePrenomLitteral03 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimplePrenomLitteral03());
				
				validerUserSimplePrenomLitteral03 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimplePrenomLitteral03().___________________
	

	
	/**
	 * method fournirCleValiderUserSimplePrenomLitteral03() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimplePrenomLitteral02</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_LITTERAL_03 sur le prenom.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Prenom.Litteral.03".<br/>
	 */
	private static String fournirCleValiderUserSimplePrenomLitteral03() {
		return "valider.UserSimple.Prenom.Litteral.03";
	} // Fin de fournirCleValiderUserSimplePrenomLitteral03()._____________

	
	
	/**
	 * method lireValiderUserSimplePrenomPrenomLongueur04() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimplePrenomLongueur04</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimplePrenomLongueur04() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimplePrenomLongueur04 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimplePrenomLongueur04());
				
				validerUserSimplePrenomLongueur04 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimplePrenomLongueur04().___________________
	

	
	/**
	 * method fournirCleValiderUserSimplePrenomLongueur04() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimplePrenomLongueur04</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_LONGUEUR_04 sur le prenom.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Prenom.Longueur.04".<br/>
	 */
	private static String fournirCleValiderUserSimplePrenomLongueur04() {
		return "valider.UserSimple.Prenom.Longueur.04";
	} // Fin de fournirCleValiderUserSimplePrenomLongueur04()._____________
	
	
	
	/* NOM. */
	/**
	 * method lireValiderUserSimpleNom() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleNom</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleNom() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleNom == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleNom());
				
				validerUserSimpleNom 
					= Boolean.valueOf(validerString.trim());
				
			}
			
		} // Fin de synchronized._____________________________
				
	} // Fin de lireValiderUserSimpleNom().________________________________
	


	/**
	 * method fournirCleValiderUserSimpleNom() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleNom</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur le nom du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Nom".<br/>
	 */
	private static String fournirCleValiderUserSimpleNom() {
		return "valider.UserSimple.Nom";
	} // Fin de fournirCleValiderUserSimpleNom().__________________________
	
	
	
	/**
	 * method lireValiderUserSimpleNomRenseigne05() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleNomRenseigne05</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleNomRenseigne05() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleNomRenseigne05 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleNomRenseigne05());
				
				validerUserSimpleNomRenseigne05 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleNomRenseigne05().__________________
	

	
	/**
	 * method fournirCleValiderUserSimpleNomRenseigne05() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleNomRenseigne05</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_RENSEIGNE_05 sur le nom.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Nom.Renseigne.05".<br/>
	 */
	private static String fournirCleValiderUserSimpleNomRenseigne05() {
		return "valider.UserSimple.Nom.Renseigne.05";
	} // Fin de fournirCleValiderUserSimpleNomRenseigne05()._______________
	
	
	
	/**
	 * method lireValiderUserSimpleNomLitteral06() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleNomLitteral06</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleNomLitteral06() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleNomLitteral06 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleNomLitteral06());
				
				validerUserSimpleNomLitteral06 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleNomLitteral06().______________________
	

	
	/**
	 * method fournirCleValiderUserSimpleNomLitteral06() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleNomLitteral06</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_LITTERAL_06 sur le nom.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Nom.Litteral.06".<br/>
	 */
	private static String fournirCleValiderUserSimpleNomLitteral06() {
		return "valider.UserSimple.Nom.Litteral.06";
	} // Fin de fournirCleValiderUserSimpleNomLitteral06().________________
	
	
	
	/**
	 * method lireValiderUserSimplePrenomNomLongueur07() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleNomLongueur07</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleNomLongueur07() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleNomLongueur07 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleNomLongueur07());
				
				validerUserSimpleNomLongueur07 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleNomLongueur07().______________________
	

	
	/**
	 * method fournirCleValiderUserSimpleNomLongueur07() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleNomLongueur07</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_LONGUEUR_07 sur le nom.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Nom.Longueur.07".<br/>
	 */
	private static String fournirCleValiderUserSimpleNomLongueur07() {
		return "valider.UserSimple.Nom.Longueur.07";
	} // Fin de fournirCleValiderUserSimpleNomLongueur07().________________
	

	
	/* EMAIL. */	
	/**
	 * method lireValiderUserSimpleEmail() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleEmail</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleEmail() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleEmail == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleEmail());
				
				validerUserSimpleEmail 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleEmail().______________________________
	

	
	/**
	 * method fournirCleValiderUserSimpleEmail() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleEmail</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur l'email du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Email".<br/>
	 */
	private static String fournirCleValiderUserSimpleEmail() {
		return "valider.UserSimple.Email";
	} // Fin de fournirCleValiderUserSimpleEmail().________________________
	

	
	/**
	 * method lireValiderUserSimpleEmailMotif08() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleEmailMotif08</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleEmailMotif08() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleEmailMotif08 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleEmailMotif08());
				
				validerUserSimpleEmailMotif08 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleEmailMotif08()._______________________

	
	
	/**
	 * method fournirCleValiderUserSimpleEmailMotif08() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleEmailMotif08</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_EMAIL_MOTIF_08 sur l'email.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Email.Motif.08".<br/>
	 */
	private static String fournirCleValiderUserSimpleEmailMotif08() {
		return "valider.UserSimple.Email.Motif.08";
	} // Fin de fournirCleValiderUserSimpleEmailMotif08()._________________
	

	
	/* LOGIN. */
	
	/**
	 * method lireValiderUserSimpleLogin() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleLogin</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleLogin() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleLogin == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
								fournirCleValiderUserSimpleLogin());
				
				validerUserSimpleLogin 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleLogin().______________________________


	
	/**
	 * method fournirCleValiderUserSimpleLogin() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleLogin</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur le login du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Login".<br/>
	 */
	private static String fournirCleValiderUserSimpleLogin() {
		return "valider.UserSimple.Login";
	} // Fin de fournirCleValiderUserSimpleLogin().________________________
	

	
	/**
	 * method lireValiderUserSimpleLoginRenseigne09() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleLoginRenseigne09</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleLoginRenseigne09() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleLoginRenseigne09 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleLoginRenseigne09());
				
				validerUserSimpleLoginRenseigne09 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleLoginRenseigne09().___________________

	
	
	/**
	 * method fournirCleValiderUserSimpleLoginRenseigne09() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleLoginRenseigne09</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_LOGIN_RENSEIGNE_09 sur le Login.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Login.Renseigne.09".<br/>
	 */
	private static String fournirCleValiderUserSimpleLoginRenseigne09() {
		return "valider.UserSimple.Login.Renseigne.09";
	} // Fin de fournirCleValiderUserSimpleLoginRenseigne09()._____________
	

	
	/**
	 * method lireValiderUserSimpleLoginLongueur10() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleLoginLongueur10</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleLoginLongueur10() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleLoginLongueur10 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleLoginLongueur10());
				
				validerUserSimpleLoginLongueur10 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleLoginLongueur10().____________________


	
	/**
	 * method fournirCleValiderUserSimpleLoginLongueur10() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleLoginLongueur10</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_LOGIN_LONGUEUR_10 sur le Login.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Login.Longueur.10".<br/>
	 */
	private static String fournirCleValiderUserSimpleLoginLongueur10() {
		return "valider.UserSimple.Login.Longueur.10";
	} // Fin de fournirCleValiderUserSimpleLoginLongueur10().______________
	

	
	/* MDP. */	
	/**
	 * method lireValiderUserSimpleMdp() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleMdp</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleMdp() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleMdp == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleMdp());
				
				validerUserSimpleMdp 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleMdp().________________________________


	
	/**
	 * method fournirCleValiderUserSimpleMdp() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleMdp</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur le mdp du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Mdp".<br/>
	 */
	private static String fournirCleValiderUserSimpleMdp() {
		return "valider.UserSimple.Mdp";
	} // Fin de fournirCleValiderUserSimpleMdp().__________________________
	

	
	/**
	 * method lireValiderUserSimpleMdpRenseigne11() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleMdpRenseigne11</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleMdpRenseigne11() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleMdpRenseigne11 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleMdpRenseigne11());
				
				validerUserSimpleMdpRenseigne11 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleMdpRenseigne11()._____________________


	
	/**
	 * method fournirCleValiderUserSimpleMdpRenseigne11() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleMdpRenseigne11</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_RENSEIGNE_11 sur le mdp.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Mdp.Renseigne.11".<br/>
	 */
	private static String fournirCleValiderUserSimpleMdpRenseigne11() {
		return "valider.UserSimple.Mdp.Renseigne.11";
	} // Fin de fournirCleValiderUserSimpleMdpRenseigne11()._______________
	
	
	
	/**
	 * method lireValiderUserSimpleMdpLongueur12() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleMdpLongueur12</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleMdpLongueur12() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleMdpLongueur12 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleMdpLongueur12());
				
				validerUserSimpleMdpLongueur12 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleMdpLongueur12().______________________


	
	/**
	 * method fournirCleValiderUserSimpleMdpLongueur12() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleMdpLongueur12</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_LONGUEUR_12 sur le mdp.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Mdp.Longueur.12".<br/>
	 */
	private static String fournirCleValiderUserSimpleMdpLongueur12() {
		return "valider.UserSimple.Mdp.Longueur.12";
	} // Fin de fournirCleValiderUserSimpleMdpLongueur12().________________
	

	
	/**
	 * method lireValiderUserSimpleMdpMotif13() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleMdpMotif13</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleMdpMotif13() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleMdpMotif13 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleMdpMotif13());
				
				validerUserSimpleMdpMotif13 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleMdpMotif13()._________________________


	
	/**
	 * method fournirCleValiderUserSimpleMdpMotif13() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleMdpMotif13</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_MOTIF_13 sur le mdp.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Mdp.Motif.13".<br/>
	 */
	private static String fournirCleValiderUserSimpleMdpMotif13() {
		return "valider.UserSimple.Mdp.Motif.13";
	} // Fin de fournirCleValiderUserSimpleMdpMotif13().________________
	

	
	/* PROFIL. */
	/**
	 * method lireValiderUserSimpleProfil() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleProfil</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleProfil() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleProfil == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleProfil());
				
				validerUserSimpleProfil 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleProfil()._____________________________

	
	
	/**
	 * method fournirCleValiderUserSimpleProfil() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleProfil</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant globalement la validation des RG 
	 * sur le profil du userSimple.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Profil".<br/>
	 */
	private static String fournirCleValiderUserSimpleProfil() {
		return "valider.UserSimple.Profil";
	} // Fin de fournirCleValiderUserSimpleProfil()._______________________
	

	
	/**
	 * method lireValiderUserSimpleProfilRenseigne14() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleProfilRenseigne14</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleProfilRenseigne14() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleProfilRenseigne14 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleProfilRenseigne14());
				
				validerUserSimpleProfilRenseigne14 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleProfilRenseigne14().__________________

	
	
	/**
	 * method fournirCleValiderUserSimpleProfilRenseigne14() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleProfilRenseigne14</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_PROFIL_RENSEIGNE_14 sur le profil.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Profil.Renseigne.14".<br/>
	 */
	private static String fournirCleValiderUserSimpleProfilRenseigne14() {
		return "valider.UserSimple.Profil.Renseigne.14";
	} // Fin de fournirCleValiderUserSimpleProfilRenseigne14().____________

	
	
	/**
	 * method lireValiderUserSimpleProfilNomenclature15() :<br/>
	 * <ul>
	 * <li>Lit dans <b>rg-usersimple.properties</b> la valeur de 
	 * <b>validerUserSimpleProfilNomenclature15</b>.</li>
	 * <li>Trim la valeur lue dans le properties.</li>
	 * </ul>
	 *
	 * @throws MalformedURLException
	 */
	private static void lireValiderUserSimpleProfilNomenclature15() 
			throws MalformedURLException {
		
		synchronized(GestionnaireRGUserSimple.class) {
			
			if (validerUserSimpleProfilNomenclature15 == null) {
				
				final String validerString 
					= getBundleExterneRG()
						.getString(
							fournirCleValiderUserSimpleProfilNomenclature15());
				
				validerUserSimpleProfilNomenclature15 
					= Boolean.valueOf(validerString.trim());
				
			}

		} // Fin de synchronized._____________________________
		
	} // Fin de lireValiderUserSimpleProfilNomenclature15()._______________


	
	/**
	 * method fournirCleValiderUserSimpleProfilNomenclature15() :<br/>
	 * <ul>
	 * <li>retourne la <b>clé</b> du Boolean 
	 * <b>validerUserSimpleProfilNomenclature15</b> 
	 * dans <b>rg-usersimple.properties</b>.</li>
	 * <li>Boolean activant la validation de 
	 * RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 sur le profil.</li>
	 * </ul>
	 *
	 * @return : String : "valider.UserSimple.Profil.Nomenclature.15".<br/>
	 */
	private static String fournirCleValiderUserSimpleProfilNomenclature15() {
		return "valider.UserSimple.Profil.Nomenclature.15";
	} // Fin de fournirCleValiderUserSimpleProfilNomenclature15()._________


	
	/**
	 * method getValiderUserSimpleCivilite() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur la civilite du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleCivilite : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleCivilite() 
			throws MalformedURLException {
		
		if (validerUserSimpleCivilite == null) {
			lireValiderUserSimpleCivilite();
		}
		
		return validerUserSimpleCivilite;
		
	} // Fin de getValiderUserSimpleCivilite().____________________________


	
	/**
	 * method getValiderUserSimpleCiviliteNomenclature01() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleCiviliteNomenclature01 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleCiviliteNomenclature01() 
			throws MalformedURLException {
		
		if (validerUserSimpleCiviliteNomenclature01 == null) {
			lireValiderUserSimpleCiviliteNomenclature01();
		}
		
		return validerUserSimpleCiviliteNomenclature01;
		
	} // Fin de getValiderUserSimpleCiviliteNomenclature01().______________



	/**
	 * method getValiderUserSimplePrenom() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur le prenom du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimplePrenom : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimplePrenom() 
			throws MalformedURLException {
		
		if (validerUserSimplePrenom == null) {
			lireValiderUserSimplePrenom();
		}
		
		return validerUserSimplePrenom;
		
	} // Fin de getValiderUserSimplePrenom().______________________________


	
	/**
	 * method getValiderUserSimplePrenomRenseigne01() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_RENSEIGNE_02 sur le prenom.<br/>
	 * <br/>
	 *
	 * @return validerUserSimplePrenomRenseigne02 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimplePrenomRenseigne02() 
			throws MalformedURLException {	
		
		if (validerUserSimplePrenomRenseigne02 == null) {
			lireValiderUserSimplePrenomRenseigne02();
		}
		
		return validerUserSimplePrenomRenseigne02;
		
	} // Fin de getValiderUserSimplePrenomRenseigne02().___________________



	/**
	 * method getValiderUserSimplePrenomLitteral03() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_LITTERAL_03 sur le prenom.<br/>
	 * <br/>
	 *
	 * @return validerUserSimplePrenomLitteral03 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimplePrenomLitteral03() 
				throws MalformedURLException {
		
		if (validerUserSimplePrenomLitteral03 == null) {
			lireValiderUserSimplePrenomLitteral03();
		}
		
		return validerUserSimplePrenomLitteral03;
		
	} // Fin de getValiderUserSimplePrenomLitteral03().____________________


	
	/**
	 * method getValiderUserSimplePrenomLongueur04() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_PRENOM_LONGUEUR_04 sur le prenom.<br/>
	 * <br/>
	 *
	 * @return validerUserSimplePrenomLongueur04 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimplePrenomLongueur04() 
				throws MalformedURLException {
		
		if (validerUserSimplePrenomLongueur04 == null) {
			lireValiderUserSimplePrenomLongueur04();
		}
		
		return validerUserSimplePrenomLongueur04;
		
	} // Fin de getValiderUserSimplePrenomLongueur04().____________________



	/**
	 * method getValiderUserSimpleNom() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur le nom du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleNom : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleNom() 
				throws MalformedURLException {
		
		if (validerUserSimpleNom == null) {
			lireValiderUserSimpleNom();
		}
		
		return validerUserSimpleNom;
		
	} // Fin de getValiderUserSimpleNom()._________________________________


	
	/**
	 * method getValiderUserSimpleNomRenseigne05() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_RENSEIGNE_05 sur le nom.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleNomRenseigne05 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleNomRenseigne05() 
			throws MalformedURLException {
		
		if (validerUserSimpleNomRenseigne05 == null) {
			lireValiderUserSimpleNomRenseigne05();
		}
		
		return validerUserSimpleNomRenseigne05;
		
	} // Fin de getValiderUserSimpleNomRenseigne05().______________________


	
	/**
	 * method getValiderUserSimpleNomLitteral06() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_LITTERAL_06 sur le nom.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleNomLitteral06 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleNomLitteral06() 
			throws MalformedURLException {
		
		if (validerUserSimpleNomLitteral06 == null) {
			lireValiderUserSimpleNomLitteral06();
		}
		
		return validerUserSimpleNomLitteral06;
		
	} // Fin de getValiderUserSimpleNomLitteral06()._______________________


	
	/**
	 * method getValiderUserSimpleNomLongueur07() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_NOM_LONGUEUR_07 sur le nom.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleNomLongueur07 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleNomLongueur07() 
			throws MalformedURLException {
		
		if (validerUserSimpleNomLongueur07 == null) {
			lireValiderUserSimpleNomLongueur07();
		}
		
		return validerUserSimpleNomLongueur07;
		
	} // Fin de getValiderUserSimpleNomLongueur07()._______________________


	
	/**
	 * method getValiderUserSimpleEmail() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur l'email du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleEmail : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleEmail() 
			throws MalformedURLException {
		
		if (validerUserSimpleEmail == null) {
			lireValiderUserSimpleEmail();
		}
		
		return validerUserSimpleEmail;
		
	} // Fin de getValiderUserSimpleEmail()._______________________________


	
	/**
	 * method getValiderUserSimpleEmailMotif08() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_EMAIL_MOTIF_08 sur l'email.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleEmailMotif08 : Boolean.<br/>
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleEmailMotif08() 
			throws MalformedURLException {
		
		if (validerUserSimpleEmailMotif08 == null) {
			lireValiderUserSimpleEmailMotif08();
		}
		
		return validerUserSimpleEmailMotif08;
		
	} // Fin de getValiderUserSimpleEmailMotif08().________________________


	
	/**
	 * method getValiderUserSimpleLogin() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur le login du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleLogin : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleLogin() 
			throws MalformedURLException {
		
		if (validerUserSimpleLogin == null) {
			lireValiderUserSimpleLogin();
		}
		
		return validerUserSimpleLogin;
		
	} // Fin de getValiderUserSimpleLogin()._______________________________


	
	/**
	 * method getValiderUserSimpleLoginRenseigne09() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_LOGIN_RENSEIGNE_09 sur le Login.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleLoginRenseigne09 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleLoginRenseigne09() 
			throws MalformedURLException {
		
		if (validerUserSimpleLoginRenseigne09 == null) {
			lireValiderUserSimpleLoginRenseigne09();
		}
		
		return validerUserSimpleLoginRenseigne09;
		
	} // Fin de getValiderUserSimpleLoginRenseigne09().____________________


	
	/**
	 * method getValiderUserSimpleLoginLongueur10() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_LOGIN_LONGUEUR_10 sur le Login.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleLoginLongueur10 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleLoginLongueur10() 
			throws MalformedURLException {
		
		if (validerUserSimpleLoginLongueur10 == null) {
			lireValiderUserSimpleLoginLongueur10();
		}
		
		return validerUserSimpleLoginLongueur10;
		
	} // Fin de getValiderUserSimpleLoginLongueur10()._____________________


	
	/**
	 * method getValiderUserSimpleMdp() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur le mdp du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleMdp : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleMdp() 
			throws MalformedURLException {
		
		if (validerUserSimpleMdp == null) {
			lireValiderUserSimpleMdp();
		}
		
		return validerUserSimpleMdp;
		
	} // Fin de getValiderUserSimpleMdp()._________________________________


	
	/**
	 * method getValiderUserSimpleMdpRenseigne11() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_RENSEIGNE_11 sur le mdp.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleMdpRenseigne11 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleMdpRenseigne11() 
			throws MalformedURLException {
		
		if (validerUserSimpleMdpRenseigne11 == null) {
			lireValiderUserSimpleMdpRenseigne11();
		}
		
		return validerUserSimpleMdpRenseigne11;
		
	} // Fin de getValiderUserSimpleMdpRenseigne11().______________________


	
	/**
	 * method getValiderUserSimpleMdpLongueur12() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_LONGUEUR_12 sur le mdp.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleMdpLongueur12 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleMdpLongueur12() 
			throws MalformedURLException {	
		
		if (validerUserSimpleMdpLongueur12 == null) {
			lireValiderUserSimpleMdpLongueur12();
		}
		
		return validerUserSimpleMdpLongueur12;
		
	} // Fin de getValiderUserSimpleMdpLongueur12()._______________________


		
	/**
	 * method getValiderUserSimpleMdpMotif13() :<br/>
	 * Getter Boolean activant la validation de 
	 * RG_USERSIMPLE_MDP_MOTIF_13 sur le mdp.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleMdpMotif13 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleMdpMotif13() 
			throws MalformedURLException {
		
		if (validerUserSimpleMdpMotif13 == null) {
			lireValiderUserSimpleMdpMotif13();
		}
		
		return validerUserSimpleMdpMotif13;
		
	} // Fin de getValiderUserSimpleMdpMotif13().__________________________


	
	/**
	 * method getValiderUserSimpleProfil() :<br/>
	 * Getter du Boolean activant globalement la validation des RG 
	 * sur le profil du userSimple.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleProfil : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleProfil() 
			throws MalformedURLException {
		
		if (validerUserSimpleProfil == null) {
			lireValiderUserSimpleProfil();
		}
		
		return validerUserSimpleProfil;
		
	} // Fin de getValiderUserSimpleProfil().______________________________


	
	/**
	 * method getValiderUserSimpleProfilRenseigne14() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_PROFIL_RENSEIGNE_14 sur le profil.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleProfilRenseigne14 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleProfilRenseigne14() 
			throws MalformedURLException {
		
		if (validerUserSimpleProfilRenseigne14 == null) {
			lireValiderUserSimpleProfilRenseigne14();
		}
		
		return validerUserSimpleProfilRenseigne14;
		
	} // Fin de getValiderUserSimpleProfilRenseigne14().___________________


	
	/**
	 * method getValiderUserSimpleProfilNomenclature15() :<br/>
	 * Getter du Boolean activant la validation de 
	 * RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 sur le profil.<br/>
	 * <br/>
	 *
	 * @return validerUserSimpleProfilNomenclature15 : Boolean.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static Boolean getValiderUserSimpleProfilNomenclature15() 
			throws MalformedURLException {
		
		if (validerUserSimpleProfilNomenclature15 == null) {
			lireValiderUserSimpleProfilNomenclature15();
		}
		
		return validerUserSimpleProfilNomenclature15;
		
	} // Fin de getValiderUserSimpleProfilNomenclature15().________________

	
	
} // FIN DE LA CLASSE GestionnaireRGUserSimple.------------------------------

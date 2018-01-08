package levy.daniel.application.model.metier.usersimple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.user.usersimple.IUserSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;
import levy.daniel.application.model.metier.user.usersimple.impl.CivilitesEnum;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilSimple;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilsSimplesEnum;
import levy.daniel.application.model.metier.user.usersimple.impl.UserSimple;

/**
 * class UserSimpleTest :<br/>
 * Test JUnit de la classe <b>UserSimple</b>.<br/>
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
 * @since 28 nov. 2017
 *
 */
public class UserSimpleTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * CIVILITE_M : Civilite :<br/>
	 * "M.".<br/>
	 */
	public static final Civilite CIVILITE_M 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());

	
	/**
	 * CIVILITE_MME : Civilite :<br/>
	 * "Mme".<br/>
	 */
	public static final Civilite CIVILITE_MME 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
	
	
	/**
	 * PRENOM_WALLACE1 : String :<br/>
	 * "Wallace1".<br/>
	 */
	public static final String PRENOM_WALLACE1 = "Wallace1";

		
	/**
	 * PRENOM_AMANDINE : String :<br/>
	 * "Amandine".<br/>
	 */
	public static final String PRENOM_AMANDINE = "Amandine";
	
	
	/**
	 * PRENOM_GERALDINE : String :<br/>
	 * "Géraldine".<br/>
	 */
	public static final String PRENOM_GERALDINE = "Géraldine";
	
	
	/**
	 * NOM_WATSON : String :<br/>
	 * "Watson".<br/>
	 */
	public static final String NOM_WATSON = "Watson";
	
	
	/**
	 * NOM_ROURKE_1 : String :<br/>
	 * "Rourke1".<br/>
	 */
	public static final String NOM_ROURKE_1 = "Rourke1";
	
	
	/**
	 * EMAIL_YAHOO : String :<br/>
	 * "email@yahoo.fr".<br/>
	 */
	public static final String EMAIL_YAHOO = "email@yahoo.fr";
	
	
	/**
	 * LOGIN : String :<br/>
	 * "login".<br/>
	 */
	public static final String LOGIN = "login";

	
	/**
	 * LOGIN_AMANDINE_WATSON : String :<br/>
	 * "Amandine.Watson".<br/>
	 */
	public static final String LOGIN_AMANDINE_WATSON = "Amandine.Watson";

	
	/**
	 * LOGIN_GERALDINE_WATSON : String :<br/>
	 * "Geraldine.Watson".<br/>
	 */
	public static final String LOGIN_GERALDINE_WATSON = "Geraldine.Watson";
			
			
	/**
	 * MDP : String :<br/>
	 * "mdp".<br/>
	 */
	public static final String MDP = "mdp";
	
	
	/**
	 * MDP_ZOZO93 : String :<br/>
	 * "zozo93".<br/>
	 */
	public static final String MDP_ZOZO93 = "zozo93";
	
	
	/**
	 * ADMINISTRATEUR : ProfilSimple :<br/>
	 * "ADMINISTRATEUR".<br/>
	 */
	public static final ProfilSimple ADMINISTRATEUR 
		= new ProfilSimple(
				ProfilsSimplesEnum.ADMINISTRATEUR.toString());
	
	
	/**
	 * UTILISATEUR : ProfilSimple :<br/>
	 * "UTILISATEUR".<br/>
	 */
	public static final ProfilSimple UTILISATEUR 
		= new ProfilSimple(
				ProfilsSimplesEnum.UTILISATEUR.toString());


	
	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";


	/**
	 * TEST_EQUALS : String :<br/>
	 * "testEquals()".<br/>
	 */
	public static final String TEST_EQUALS 
		= "testEquals()";
	
	
	/**
	 * TEST_COMPARETO : String :<br/>
	 * "testCompareTo()".<br/>
	 */
	public static final String TEST_COMPARETO 
		= "testCompareTo()";

	
	/**
	 * TEST_CLONE : String :<br/>
	 * "testClone()".<br/>
	 */
	public static final String TEST_CLONE 
		= "testClone()";

	
	/**
	 * TEST_TOSTRING : String :<br/>
	 * "testToString()".<br/>
	 */
	public static final String TEST_TOSTRING 
		= "testToString()";
	
	
	/**
	 * TEST_GETENTETECSV : String :<br/>
	 * "testgetEnTeteCsv()".<br/>
	 */
	public static final String TEST_GETENTETECSV 
		= "testgetEnTeteCsv()";
	
	
	/**
	 * TEST_TOSTRINGCSV : String :<br/>
	 * "testToStringCsv()".<br/>
	 */
	public static final String TEST_TOSTRINGCSV 
		= "testToStringCsv()";
	
	
	/**
	 * TEST_GETENTETECOLONNE : String :<br/>
	 * "testGetEnTeteColonne()".<br/>
	 */
	public static final String TEST_GETENTETECOLONNE 
		= "testGetEnTeteColonne()";
	
	
	/**
	 * TEST_GETVALEURCOLONNE : String :<br/>
	 * "testGetValeurColonne()".<br/>
	 */
	public static final String TEST_GETVALEURCOLONNE 
		= "testGetValeurColonne()";
	


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(UserSimpleTest.class);

	// *************************METHODES************************************/

	
	
	 /**
	 * method CONSTRUCTEUR UserSimpleTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public UserSimpleTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testEquals() :<br/>
	 * <ul>
	 * Teste la méthode <b>equals(Object pObj)</b> :
	 * <li>garantit le contrat Java reflexif x.equals(x).</li>
	 * <li>garantit le contrat Java symétrique 
	 * x.equals(y) ----> y.equals(x).</li>
	 * <li>garantit le contrat Java transitif 
	 * x.equals(y) et y.equals(z) ----> x.equals(z).</li>
	 * <li>garantit le contrat Java sur les hashcode 
	 * x.equals(y) ----> x.hashcode() == y.hashcode().</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans equals(Object pObj).</li>
	 * <li>garantit que x.equals(null) retourne false 
	 * (avec x non null).</li>
	 * <li>garantit le bon fonctionnement de equals() 
	 * en cas d'égalité métier.</li>
	 * <li>garantit le bon fonctionnement de equals() 
	 * en cas d'inégalité métier.</li>
	 * </ul>
	 */
	@Test
	public void testEquals() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objet1 
		= new UserSimple(2L
				, CIVILITE_M
				, PRENOM_WALLACE1, NOM_ROURKE_1
				, EMAIL_YAHOO
				, LOGIN, MDP
				, ADMINISTRATEUR);
		
		final IUserSimple objet2 
		= new UserSimple(3L
				, CIVILITE_MME
				, "June", "Rourke2"
				, EMAIL_YAHOO
				, LOGIN, MDP
				, UTILISATEUR);
		
		final IUserSimple objet3 
		= new UserSimple(4L
				, CIVILITE_M
				, "Wallace3", "Rourke3"
				, EMAIL_YAHOO
				, LOGIN, MDP
				, UTILISATEUR);

		
		/* garantit le contrat Java reflexif x.equals(x). */
		assertEquals("x.equals(x) : "
				, objet1
					, objet1);
				
		/* garantit le contrat Java symétrique 
		 * x.equals(y) ----> y.equals(x). */
		assertEquals("objet1.equals(objet2) : "
				, objet2
					, objet1);
		
		/* garantit le contrat Java transitif 
		 * x.equals(y) et y.equals(z) ----> x.equals(z). */
		assertEquals("objet1.equals(objet2) : ", objet1, objet2);
		assertEquals("objet2.equals(objet3) : ", objet2, objet3);
		assertEquals("objet1.equals(objet3) : ", objet1, objet3);
		
		/* garantit le contrat Java sur les hashcode 
		 * x.equals(y) ----> x.hashcode() == y.hashcode(). */
		assertEquals("objet1.hashCode().equals(objet2.hashCode()) : "
				, objet1.hashCode()
					, objet2.hashCode());

				
		/* garantit que les null sont bien gérés dans equals(...). */
		final IUserSimple objetNull1 
			= new UserSimple();
		final IUserSimple objetNull2 
			= new UserSimple();

		assertEquals("objetNull1.equals(objetNull2) : "
				, objetNull1
					, objetNull2);
		assertEquals("objetNull1.hashCode().equals(objetNull2.hashCode()) : "
				, objetNull1.hashCode()
					, objetNull2.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_EQUALS);
			System.out.println("OBJETNULL1 : " 
					+ objetNull1.toString());
			System.out.println("OBJETNULL2 : " 
					+ objetNull2.toString());
		}
		
		final IUserSimple objet1AvecNull 
			= new UserSimple(2L
					, null
					, PRENOM_WALLACE1, NOM_ROURKE_1
					, EMAIL_YAHOO
					, null, null
					, ADMINISTRATEUR);
		
		final IUserSimple objet2AvecNull 
			= new UserSimple(3L
					, CIVILITE_MME
					, "June1", NOM_ROURKE_1
					, EMAIL_YAHOO
					, null, null
					, ADMINISTRATEUR);

		assertEquals("objet1AvecNull.equals(objet2AvecNull) : "
				, objet1AvecNull
					, objet2AvecNull);
		assertEquals("objet1AvecNull.hashCode()"
				+ ".equals(objet2AvecNull.hashCode()) : "
				, objet1AvecNull.hashCode()
					, objet2AvecNull.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJET1AVECNULL : " 
					+ objet1AvecNull.toString());
			System.out.println("OBJET2AVECNULL : " 
					+ objet2AvecNull.toString());
		}

		
		/* garantit que x.equals(null) retourne false (avec x non null). */
		assertNotNull("objet1 pas equals(null) : "
				, objet1);
				
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'égalité métier. */
		assertEquals("objet1.equals(objet2) : "
				, objet1
					, objet2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_EQUALS);
			System.out.println("OBJET1 : " 
					+ objet1.toString());
			System.out.println("OBJET2 : " 
					+ objet2.toString());
		}

		
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'inégalité métier. */
		final IUserSimple objetDiff1 
			= new UserSimple(2L
					, CIVILITE_M
					, PRENOM_WALLACE1, NOM_ROURKE_1
					, EMAIL_YAHOO
					, "login1", "mdp1"
					, ADMINISTRATEUR);
		
		final IUserSimple objetDiff2 
			= new UserSimple(3L
					, CIVILITE_M
					, PRENOM_WALLACE1, NOM_ROURKE_1
					, EMAIL_YAHOO
					, "login1", "mdp2"
					, ADMINISTRATEUR);
		
		assertFalse("objetDiff1 PAS equals(objetDiff2) : "
				, objetDiff1.equals(objetDiff2));
		assertFalse("objetDiff1.hashCode() "
				+ "PAS equals(objetDiff2.hashCode()) : "
				, objetDiff1.hashCode() == objetDiff2.hashCode());
		

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_EQUALS);
			System.out.println("OBJETDIFF1 : " 
					+ objetDiff1.toString());
			System.out.println("OBJETDIFF2 : " 
					+ objetDiff2.toString());
		}
		
	} // Fin de testEquals().______________________________________________

	

	/**
	 * method testCompareTo() :<br/>
	 * <ul>
	 * Teste la méthode <b>compareTo(IUserSimple pLoc)</b> :
	 * <li>garantit que compareTo(memeInstance) retourne 0.</li>
	 * <li>garantit que compareTo(null) retourne un nombre négatif.</li>
	 * <li>garantit le contrat Java Contrat Java : 
	 * x.equals(y) ---> x.compareTo(y) == 0.</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans compareTo(IUserSimple pLoc).</li>
	 * <li>garantit le bon fonctionnement (bon ordre) de compareTo().</li>
	 * </ul>
	 */
	@Test
	public void testCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objet1 
			= new UserSimple(2L
					, CIVILITE_M
					, PRENOM_WALLACE1, NOM_ROURKE_1
					, EMAIL_YAHOO
					, LOGIN, MDP
					, ADMINISTRATEUR);
		
		final IUserSimple objet1MemeInstance = objet1;
		
		final IUserSimple objetEquals1 
			= new UserSimple(10L
					, CIVILITE_MME
					, PRENOM_GERALDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_GERALDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);
		
		final IUserSimple objetEquals2 
			= new UserSimple(11L
					, CIVILITE_MME
					, PRENOM_GERALDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_GERALDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);

		final IUserSimple objetNull1 
		= new UserSimple();
	
		final IUserSimple objetNull2 
			= new UserSimple();
				
		final IUserSimple objetCompAvant1 
			= new UserSimple(3L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);

		final IUserSimple objetCompApres2 
			= new UserSimple(3L
					, CIVILITE_MME
					, PRENOM_GERALDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_GERALDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);

	
		/* garantit que compareTo(memeInstance) retourne 0. */		
		final int compareMemeInstance 
			= objet1.compareTo(objet1MemeInstance);
		
		assertTrue("compareTo(memeInstance) doit retourner 0 : "
				, compareMemeInstance == 0);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO() DE LA MEME INSTANCE : " 
					+ compareMemeInstance);
		}
		
		/* garantit que compareTo(null) retourne -1. */
		final int compareToNull = objet1.compareTo(null);
		
		assertTrue("compareTo(null) doit retourner négatif : "
				, compareToNull < 0);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO(null)  : " 
					+ compareToNull);
		}
		
		/* garantit le contrat Java Contrat Java : 
		 * x.equals(y) ---> x.compareTo(y) == 0. */		
		final int compareToEquals = objetEquals1.compareTo(objetEquals2);

		assertTrue("Instance.compareTo(equalsInstance) doit retourner 0 : "
				, compareToEquals == 0);
		assertTrue("loc10.hashCode() == loc11.hashCode() : "
				, objetEquals1.hashCode() == objetEquals2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO(equalsInstance)  : " 
					+ compareToEquals);
		}
		
		
		/* garantit que les null sont bien gérés dans 
		 * compareTo(IUserSimple pLoc). */		
		final int compareToEqualsNull = objetNull1.compareTo(objetNull2);
		
		assertTrue("InstanceNull.compareTo(equalsInstanceNull) doit retourner 0 : "
				, compareToEqualsNull == 0);
		assertTrue("locNull10.hashCode() == locNull11.hashCode() : "
				, objetNull1.hashCode() == objetNull2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO(equalsInstanceNull)  : " 
					+ compareToEqualsNull);
		}

		
		/* garantit le bon fonctionnement (bon ordre) de compareTo(). */		
		final int compare = objetCompAvant1.compareTo(objetCompApres2);
		final int compareInverse = objetCompApres2.compareTo(objetCompAvant1);
		
		assertTrue("objetCompAvant1 doit être avant objetCompApres2 : "
				, compare < 0);
		assertTrue("objetCompAvant2 doit être après objetCompApres1 : "
				, compareInverse > 0);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO(existant)  : " 
					+ compare);
		}
		
	} // Fin de testCompareTo().___________________________________________
	

	
	/**
	 * method testClone() :<br/>
	 * <ul>
	 * Teste la méthode <b>clone()</b> :
	 * <li>garantit que les null sont bien gérés dans clone().</li>
	 * <li>garantit que clonex.equals(x).</li>
	 * <li>garantit que x et son clone ne sont pas la même instance.</li>
	 * </ul>
	 * @throws CloneNotSupportedException 
	 */
	@Test
	public void testClone() throws CloneNotSupportedException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		final IUserSimple objetNull1 
			= new UserSimple();
		
		final IUserSimple objetNullClone1 
			= (IUserSimple) objetNull1.clone();
		
		final IUserSimple objet1 
			= new UserSimple(23L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);
		
		final IUserSimple objetClone1 
		= (IUserSimple) objet1.clone();
		
		
		/* garantit que les null sont bien gérés dans clone(). */
		assertEquals("objetNull1.equals(objetNullClone1) : "
				, objetNull1
					, objetNullClone1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_CLONE);
			System.out.println("objetNull1 : " 
					+ objetNull1.toString());
			System.out.println("objetNullClone1 : " 
					+ objetNullClone1.toString());
		}
		
		/* garantit que clonex.equals(x). */
		assertEquals("clonex.equals(x) : "
				, objet1
					, objetClone1);
		
		/* garantit que x et son clone ne sont pas la même instance. */
		assertNotSame("x != clonex : "
				, objet1
					, objetClone1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_CLONE);
			System.out.println("objet1 : " 
					+ objet1.toString());
			System.out.println("objetClone1 : " 
					+ objetClone1.toString());
		}

	} // Fin de testClone()._______________________________________________
	
	
	
	/**
	 * method testToString() :<br/>
	 * <ul>
	 * Teste la méthode <b>toString()</b> :
	 * <li>garantit que les null sont bien gérés dans toString().</li>
	 * <li>garantit le bon affichage de toString().</li>
	 * </ul>
	 */
	@Test
	public void testToString() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objetNull 
			= new UserSimple();
		
		final IUserSimple objet1 
			= new UserSimple(2L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);

		
		/* garantit que les null sont bien gérés dans toString(). */
		assertEquals("objetNull.toString() retourne une chaine : "
				, "UserSimple [id=null, civilité=null, prénom=null, nom=null, e-mail=null, login=null, mdp=null, profil=null]"
						, objetNull.toString());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRING);
			System.out.println(objetNull.toString());
		}
		
		/* garantit le bon affichage de toString(). */
		assertEquals("affichage : "
				, "UserSimple [id=2, civilité=Mme, prénom=Amandine, nom=Watson, e-mail=email@yahoo.fr, login=Amandine.Watson, mdp=zozo93, profil=UTILISATEUR]"
						, objet1.toString());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRING);
			System.out.println(objet1.toString());
		}
		
	} // Fin de testToString().____________________________________________


	
	/**
	 * method testgetEnTeteCsv() :<br/>
	 * <ul>
	 * Teste la méthode <b>getEnTeteCsv()</b> :
	 * <li>garantit que getEnTeteCsv() retourne le bon en-tête csv.</li>
	 * </ul>
	 */
	@Test
	public void testgetEnTeteCsv() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objet1 
			= new UserSimple(2L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);

		/* garantit que getEnTeteCsv() retourne le bon en-tête csv. */
		final String entete = objet1.getEnTeteCsv();
		
		assertEquals("en-tête csv : "
				, "id;civilité;prénom;nom;e-mail;login;mdp;profil;"
					, entete);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_GETENTETECSV);
			System.out.println(entete);
		}
		
	} // Fin de testgetEnTeteCsv().________________________________________
	

	
	/**
	 * method testToStringCsv() :<br/>
	 * <ul>
	 * Teste la méthode <b>toStringCsv()</b> :
	 * <li>garantit que les null sont gérés dans toStringCsv().</li> 
	 * <li>garantit que toStringCsv() retourne la bonne ligne csv.</li>
	 * </ul>
	 */
	@Test
	public void testToStringCsv() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objetNull 
		= new UserSimple();
	
		final IUserSimple objet1 
			= new UserSimple(27L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);
		
		/* garantit que les null sont gérés dans toStringCsv(). */
		final String ligneCsvNull = objetNull.toStringCsv();
						
		assertEquals("ligne csv null : "
				, "null;null;null;null;null;null;null;null;"
					, ligneCsvNull);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRINGCSV);
			System.out.println(ligneCsvNull);
		}
						
		/* garantit que toStringCsv() retourne la bonne ligne csv. */
		final String ligneCsv = objet1.toStringCsv();
		
		assertEquals("ligne csv : "
				, "27;Mme;Amandine;Watson;email@yahoo.fr;Amandine.Watson;zozo93;UTILISATEUR;"
					, ligneCsv);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRINGCSV);
			System.out.println(ligneCsv);
		}
		
	} // Fin de testToStringCsv()._________________________________________
	

	
	/**
	 * method testGetEnTeteColonne() :<br/>
	 * <ul>
	 * Teste la méthode <b>getEnTeteColonne(int pI)</b> :
	 * <li>garantit que les null sont gérés dans 
	 * getEnTeteColonne(int pI).</li> 
	 * <li>garantit que getEnTeteColonne(int pI) retourne 
	 * la bonne en-tête de colonne.</li>
	 * </ul>
	 */
	@Test
	public void testGetEnTeteColonne() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objetNull 
		= new UserSimple();
	
		final IUserSimple objet1 
			= new UserSimple(27L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);
		
		/* garantit que les null sont gérés 
		 * dans getEnTeteColonne(int pI). */
		final String entete0 = objet1.getEnTeteColonne(0);
		final String enteteNull0 = objetNull.getEnTeteColonne(0);
		
		/* garantit que getEnTeteColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String entete1 = objet1.getEnTeteColonne(1);
		final String enteteNull1 = objetNull.getEnTeteColonne(1);
		final String entete2 = objet1.getEnTeteColonne(2);
		final String enteteNull2 = objetNull.getEnTeteColonne(2);
		
		assertEquals("entete0 : ", "id", entete0);
		assertEquals("enteteNull0 : ", "id", enteteNull0);
		
		assertEquals("entete1 : ", "civilité", entete1);
		assertEquals("enteteNull1 : ", "civilité", enteteNull1);
		
		assertEquals("entete2 : ", "prénom", entete2);
		assertEquals("enteteNull2 : ", "prénom", enteteNull2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_GETENTETECOLONNE);
			System.out.println("entete0 : " + entete0);
			System.out.println("enteteNull0 : " + enteteNull0);
			
			System.out.println("entete1 : " + entete1);
			System.out.println("enteteNull1 : " + enteteNull1);
			
			System.out.println("entete2 : " + entete2);
			System.out.println("enteteNull2 : " + enteteNull2);
		}

	} // Fin de testGetEnTeteColonne().____________________________________
	

	
	/**
	 * method testGetValeurColonne() :<br/>
	 * <ul>
	 * Teste la méthode <b>getValeurColonne(int pI)</b> :
	 * <li>garantit que les null sont gérés dans 
	 * getValeurColonne(int pI).</li> 
	 * <li>garantit que getValeurColonne(int pI) retourne 
	 * la bonne valeur de colonne.</li>
	 * </ul>
	 */
	@Test
	public void testGetValeurColonne() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final IUserSimple objetNull 
		= new UserSimple();
	
		final IUserSimple objet1 
			= new UserSimple(27L
					, CIVILITE_MME
					, PRENOM_AMANDINE, NOM_WATSON
					, EMAIL_YAHOO
					, LOGIN_AMANDINE_WATSON, MDP_ZOZO93
					, UTILISATEUR);
		
		/* garantit que les null sont gérés 
		 * dans getValeurColonne(int pI). */
		final String valeurNull0 = (String) objetNull.getValeurColonne(0);
		final String valeurNull1 = (String) objetNull.getValeurColonne(1);
		final String valeurNull2 = (String) objetNull.getValeurColonne(2);
		final String valeurNull3 = (String) objetNull.getValeurColonne(3);
		final String valeurNull4 = (String) objetNull.getValeurColonne(4);
		final String valeurNull5 = (String) objetNull.getValeurColonne(5);
		final String valeurNull6 = (String) objetNull.getValeurColonne(6);
		final String valeurNull7 = (String) objetNull.getValeurColonne(7);
		
		assertEquals("valeurNull0 : ", null, valeurNull0);
		assertEquals("valeurNull1 : ", null, valeurNull1);
		assertEquals("valeurNull2 : ", null, valeurNull2);
		assertEquals("valeurNull3 : ", null, valeurNull3);
		assertEquals("valeurNull4 : ", null, valeurNull4);
		assertEquals("valeurNull5 : ", null, valeurNull5);
		assertEquals("valeurNull6 : ", null, valeurNull6);
		assertEquals("valeurNull7 : ", null, valeurNull7);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_GETVALEURCOLONNE);
			System.out.println("valeurNull0 : " + valeurNull0);
			System.out.println("valeurNull1 : " + valeurNull1);			
			System.out.println("valeurNull2 : " + valeurNull2);
			System.out.println("valeurNull3 : " + valeurNull3);
			System.out.println("valeurNull4 : " + valeurNull4);
			System.out.println("valeurNull5 : " + valeurNull5);
			System.out.println("valeurNull6 : " + valeurNull6);
			System.out.println("valeurNull7 : " + valeurNull7);
		}

		
		/* garantit que getValeurColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String valeur0 = (String) objet1.getValeurColonne(0);
		final String valeur1 = (String) objet1.getValeurColonne(1);		
		final String valeur2 = (String) objet1.getValeurColonne(2);
		final String valeur3 = (String) objet1.getValeurColonne(3);
		final String valeur4 = (String) objet1.getValeurColonne(4);
		final String valeur5 = (String) objet1.getValeurColonne(5);
		final String valeur6 = (String) objet1.getValeurColonne(6);
		final String valeur7 = (String) objet1.getValeurColonne(7);
		
		assertEquals("valeur0 : ", "27", valeur0);		
		assertEquals("valeur1 : ", "Mme", valeur1);
		assertEquals("valeur2 : ", "Amandine", valeur2);
		assertEquals("valeur3 : ", "Watson", valeur3);
		assertEquals("valeur4 : ", "email@yahoo.fr", valeur4);
		assertEquals("valeur5 : ", "Amandine.Watson", valeur5);
		assertEquals("valeur6 : ", "zozo93", valeur6);
		assertEquals("valeur7 : ", "UTILISATEUR", valeur7);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {	
			System.out.println();
			System.out.println(TEST_GETVALEURCOLONNE);
			System.out.println("valeur0 : " + valeur0);
			System.out.println("valeur1 : " + valeur1);			
			System.out.println("valeur2 : " + valeur2);
			System.out.println("valeur3 : " + valeur3);
			System.out.println("valeur4 : " + valeur4);
			System.out.println("valeur5 : " + valeur5);
			System.out.println("valeur6 : " + valeur6);
			System.out.println("valeur7 : " + valeur7);
		}

	} // Fin de testGetValeurColonne().____________________________________
	


} // FIN DE LA CLASSE UserSimpleTest.----------------------------------------

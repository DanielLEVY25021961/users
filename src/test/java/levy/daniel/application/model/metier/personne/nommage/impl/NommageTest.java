package levy.daniel.application.model.metier.personne.nommage.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.personne.nommage.INommage;


/**
 * class NommageTest :<br/>
 * Test JUnit de la classe Nommage.<br/>
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
public class NommageTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
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
	 * NOM1 : String :<br/>
	 * "Gonzales".<br/>
	 */
	public static final String NOM1 
		= "Gonzales";
	
	/**
	 * NOM2 : String :<br/>
	 * "Halliday".<br/>
	 */
	public static final String NOM2 
		= "Halliday";
	
	/**
	 * NOM3 : String :<br/>
	 * "Mougeot".<br/>
	 */
	public static final String NOM3 
		= "Mougeot";
	
	/**
	 * PRENOM1 : String :<br/>
	 * "Papy".<br/>
	 */
	public static final String PRENOM1 
		= "Papy";
	
	/**
	 * PRENOM2 : String :<br/>
	 * "Jean-Philippe".<br/>
	 */
	public static final String PRENOM2 
		= "Jean-Philippe";
	
	/**
	 * PRENOM3 : String :<br/>
	 * "Papy".<br/>
	 */
	public static final String PRENOM3 
		= "Papy";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(NommageTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR NommageTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public NommageTest() {
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

		final INommage objet1 
		= new Nommage(2L
				, PRENOM1, NOM1);
		
		final INommage objet2 
		= new Nommage(3L
				, PRENOM1, NOM1);
		
		final INommage objet3 
		= new Nommage(4L
				, PRENOM1, NOM1);

		
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
		final INommage objetNull1 
			= new Nommage();
		final INommage objetNull2 
			= new Nommage();

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
		
		final INommage objet1AvecNull 
			= new Nommage(2L
					, null, null);
		
		final INommage objet2AvecNull 
			= new Nommage(3L
					, null, null);

		assertEquals("objet1AvecNull.equals(objet2AvecNull) : "
				, objet1AvecNull
					, objet2AvecNull);
		assertEquals("objet1AvecNull.hashCode()"
				+ ".equals(objet2AvecNull.hashCode()) : "
				, objet1AvecNull.hashCode()
					, objet2AvecNull.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_EQUALS);
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
		final INommage objetDiff1 
			= new Nommage(2L
					, PRENOM1, NOM1);
		
		final INommage objetDiff2 
			= new Nommage(3L
					, PRENOM2, NOM2);
		
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
	 * Teste la méthode <b>compareTo(INommage pObject)</b> :
	 * <li>garantit que compareTo(memeInstance) retourne 0.</li>
	 * <li>garantit que compareTo(null) retourne un nombre négatif.</li>
	 * <li>garantit le contrat Java Contrat Java : 
	 * x.equals(y) ---> x.compareTo(y) == 0.</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans compareTo(INommage pObject).</li>
	 * <li>garantit le bon fonctionnement (bon ordre) de compareTo().</li>
	 * </ul>
	 */
	@Test
	public void testCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final INommage objet1 
			= new Nommage(2L
					, PRENOM1, NOM1);
		
		final INommage objet1MemeInstance = objet1;
		
		final INommage objetEquals1 
			= new Nommage(10L
					, PRENOM2, NOM2);
		
		final INommage objetEquals2 
			= new Nommage(11L
					, PRENOM2, NOM2);

		final INommage objetNull1 
		= new Nommage();
	
		final INommage objetNull2 
			= new Nommage();
				
		final INommage objetCompAvant1 
			= new Nommage(3L
					, PRENOM1, NOM1);

		final INommage objetCompApres2 
			= new Nommage(3L
					, PRENOM2, NOM2);

	
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
		assertTrue("objetEquals1.hashCode() == objetEquals2.hashCode() : "
				, objetEquals1.hashCode() == objetEquals2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO(equalsInstance)  : " 
					+ compareToEquals);
		}
		
		
		/* garantit que les null sont bien gérés dans 
		 * compareTo(ProfilSimple pLoc). */		
		final int compareToEqualsNull = objetNull1.compareTo(objetNull2);
		
		assertTrue("InstanceNull.compareTo(equalsInstanceNull) doit retourner 0 : "
				, compareToEqualsNull == 0);
		assertTrue("objetNull1.hashCode() == objetNull2.hashCode() : "
				, objetNull1.hashCode() == objetNull2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_COMPARETO);
			System.out.println("COMPARETO(equalsInstanceNull)  : " 
					+ compareToEqualsNull);
		}

		
		/* garantit le bon fonctionnement (bon ordre) de compareTo(). */		
		final int compare = objetCompAvant1.compareTo(objetCompApres2);
		
		assertTrue("objetCompAvant1 doit être avant objetCompApres2 : "
				, compare < 0);

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
		
		final INommage objetNull1 
			= new Nommage();
		
		final INommage objetNullClone1 
			= (INommage) objetNull1.clone();
		
		final INommage objet1 
			= new Nommage(23L
					, PRENOM1, NOM1);
		
		final INommage objetClone1 
		= (INommage) objet1.clone();
		
		
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
	
		final INommage objetNull 
			= new Nommage();
		
		final INommage objet1 
			= new Nommage(2L
					, PRENOM2, NOM2);
	
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRING);
			System.out.println(objetNull.toString());
		}
		
		/* garantit que les null sont bien gérés dans toString(). */
		assertEquals("objetNull.toString() retourne une chaine : "
				, "AbstractNommage [id=null, nom=null, prenom=null]"
						, objetNull.toString());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRING);
			System.out.println(objet1.toString());
		}
		
		/* garantit le bon affichage de toString(). */
		assertEquals("affichage : "
				, "AbstractNommage [id=2, nom=Halliday, prenom=Jean-Philippe]"
						, objet1.toString());
				
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

		final INommage objet1 
			= new Nommage(2L
					, PRENOM1, NOM1);

		/* garantit que getEnTeteCsv() retourne le bon en-tête csv. */
		final String entete = objet1.getEnTeteCsv();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_GETENTETECSV);
			System.out.println(entete);
		}
		
		assertEquals("en-tête csv : "
				, "id;nom;prenom;"
					, entete);
				
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

		final INommage objetNull 
		= new Nommage();
	
		final INommage objet1 
			= new Nommage(27L
					, PRENOM1, NOM1);
		
		/* garantit que les null sont gérés dans toStringCsv(). */
		final String ligneCsvNull = objetNull.toStringCsv();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRINGCSV);
			System.out.println(ligneCsvNull);
		}

		assertEquals("ligne csv null : "
				, "null;null;null;"
					, ligneCsvNull);
		
						
		/* garantit que toStringCsv() retourne la bonne ligne csv. */
		final String ligneCsv = objet1.toStringCsv();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_TOSTRINGCSV);
			System.out.println(ligneCsv);
		}
		
		assertEquals("ligne csv : "
				, "27;Gonzales;Papy;"
					, ligneCsv);
				
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

		final INommage objetNull 
			= new Nommage();
	
		final INommage objet1 
			= new Nommage(27L
					, PRENOM1, NOM1);
		
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

		assertEquals("entete0 : ", "id", entete0);
		assertEquals("enteteNull0 : ", "id", enteteNull0);
		
		assertEquals("entete1 : ", "nom", entete1);
		assertEquals("enteteNull1 : ", "nom", enteteNull1);
		
		assertEquals("entete2 : ", "prenom", entete2);
		assertEquals("enteteNull2 : ", "prenom", enteteNull2);
				
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
		
		final INommage objetNull 
		= new Nommage();
	
		final INommage objet1 
			= new Nommage(27L
					, PRENOM1, NOM1);
		
		/* garantit que les null sont gérés 
		 * dans getValeurColonne(int pI). */
		final String valeurNull0 = (String) objetNull.getValeurColonne(0);
		final String valeurNull1 = (String) objetNull.getValeurColonne(1);
		final String valeurNull2 = (String) objetNull.getValeurColonne(2);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_GETVALEURCOLONNE);
			System.out.println("valeurNull0 : " + valeurNull0);
			System.out.println("valeurNull1 : " + valeurNull1);
			System.out.println("valeurNull2 : " + valeurNull2);
		}

		assertEquals("valeurNull0 : ", null, valeurNull0);
		assertEquals("valeurNull1 : ", null, valeurNull1);
		assertEquals("valeurNull2 : ", null, valeurNull2);
		
		/* garantit que getValeurColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String valeur0 = (String) objet1.getValeurColonne(0);
		final String valeur1 = (String) objet1.getValeurColonne(1);
		final String valeur2 = (String) objet1.getValeurColonne(2);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {	
			System.out.println();
			System.out.println(TEST_GETVALEURCOLONNE);
			System.out.println("valeur0 : " + valeur0);
			System.out.println("valeur1 : " + valeur1);
			System.out.println("valeur2 : " + valeur2);
		}

		assertEquals("valeur0 : ", "27", valeur0);		
		assertEquals("valeur1 : ", "Gonzales", valeur1);
		assertEquals("valeur2 : ", "Papy", valeur2);
		
	} // Fin de testGetValeurColonne().____________________________________
	


} // FIN DE LA CLASSE NommageTest.-------------------------------------------

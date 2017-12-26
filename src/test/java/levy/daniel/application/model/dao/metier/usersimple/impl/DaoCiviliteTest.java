package levy.daniel.application.model.dao.metier.usersimple.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.usersimple.IDaoCivilite;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;
import levy.daniel.application.model.metier.user.usersimple.impl.CivilitesEnum;


/**
 * class DaoCiviliteTest :<br/>
 * <ul>
 * <li>Test JUnit de la classe <b>DaoCivilite</b>.</li>
 * <li>Test JUnit sous <b>SPRING</b>.</li>
 * <li>Le <b>fichier de configuration SPRING</b> utilisé pour ce test est 
 * <b>classpath*:applicationContext-test.xml</b> grâce à l'annotation 
 * <b>ContextConfiguration</b>.</li>
 * </ul>
 * <br/>
 *
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Test Spring, Test JUnit Spring, SPRING, TEST DAO SPRING,<br/>
 * fabriquer liste à partir d'un Iterable,<br/>
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext-test.xml"})
public class DaoCiviliteTest {

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
	 * NBRE_OBJETS_FINAL_DOIT : String :<br/>
	 * "nombreObjetsFinal doit valoir ".<br/>
	 */
	public static final String NBRE_OBJETS_FINAL_DOIT 
		= "nombreObjetsFinal doit valoir ";
	
	
	/**
	 * NBRE_INITIAL_PLUS_ZERO : String :<br/>
	 * "nombreObjetsinitial + 0 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_ZERO 
		= "nombreObjetsinitial + 0 : ";
	
	
	/**
	 * NBRE_INITIAL_PLUS_UN : String :<br/>
	 * "nombreObjetsinitial + 1 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_UN 
		= "nombreObjetsinitial + 1 : ";

	
	/**
	 * NBRE_INITIAL_PLUS_DEUX : String :<br/>
	 * "nombreObjetsinitial + 2 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_DEUX 
		= "nombreObjetsinitial + 2 : ";

	
	/**
	 * NBRE_INITIAL_PLUS_TROIS : String :<br/>
	 * "nombreObjetsinitial + 3 : ".<br/>
	 */
	public static final String NBRE_INITIAL_PLUS_TROIS 
	= "nombreObjetsinitial + 3 : ";

	
	/**
	 * TEST_CREATE : String :<br/>
	 * "testCreate()".<br/>
	 */
	public static final String TEST_CREATE 
		= "testCreate()";
	
	
	/**
	 * LOT_OBJET_INITIAL : String :<br/>
	 * "LOT D'OBJETS INITIALEMENT EN BASE : ".<br/>
	 */
	public static final String LOT_OBJET_INITIAL 
	= "LOT D'OBJETS INITIALEMENT EN BASE : ";
	
	
	/**
	 * LOT_OBJETS_APRES_DELETE : String :<br/>
	 * "LOT D'OBJETS EN BASE APRES DELETE : ".<br/>
	 */
	public static final String LOT_OBJETS_APRES_DELETE 
		= "LOT D'OBJETS EN BASE APRES DELETE : ";

	
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
	 * CIVILITE_MLLE : Civilite :<br/>
	 * "Mlle".<br/>
	 */
	public static final Civilite CIVILITE_MLLE 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());

		
	/**
	 * daoCivilite : IDaoCivilite :<br/>
	 * DAO pour les Civilite.<br/>
	 * INJECTE PAR SPRING (Autowired).<b/>
	 */
	@Autowired
	private transient IDaoCivilite daoCivilite;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoCiviliteTest.class);
	

	// *************************METHODES************************************/

		
	 /**
	 * method CONSTRUCTEUR DaoCiviliteTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoCiviliteTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * method testCreateNull() :<br/>
	 * <ul>
	 * Teste la méthode <b>create(null)</b>.<br/>
	 * <li>garantit que create(null) ne fait rien 
	 * et retourne null.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testCreateNull() throws AbstractDaoException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testCreateNull()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final Civilite objet1 = null;
		Civilite objet1Persistant = null;
						
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testCreateNull()");
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoCivilite.create(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que create(null) ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testCreateNull()");
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testCreateNull()");
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testCreateNull().__________________________________________
	
	
	
	/**
	 * method testCreate() :<br/>
	 * <ul>
	 * Teste la méthode <b>create(Civilite pObject)</b>.<br/>
	 * <li>garantit que create(Civilite pObject) insère 
	 * un objet en base.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testCreate() throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Civilite objet2Persistant = null;
		Civilite objet3Persistant = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		final Civilite objet2 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_CREATE);
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT : " + objet2.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoCivilite.create(objet1);
			objet2Persistant = this.daoCivilite.create(objet2);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que create(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_DEUX
					, nombreObjetsFinal == nombreObjetsinitial + 2);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_CREATE);
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES CREATE : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES Create(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES Create(T Object) : null");
			}
			
			if (objet2Persistant != null) {
				System.out.println(
						"OBJET2 PERSISTANT APRES Create(T Object) : " 
								+ objet2Persistant.toString());
			} else {
				System.out.println(
						"OBJET2 PERSISTANT APRES Create(T Object) : null");
			}
			
			System.out.println(TIRETS);
			System.out.println();
		}
		
		
		final Civilite objet3 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet3Persistant = this.daoCivilite.create(objet3);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_CREATE);
			if (objet3Persistant != null) {
				System.out.println(
						"OBJET3 PERSISTANT APRES Create(T Object) : " 
								+ objet3Persistant.toString());
			} else {
				System.out.println(
						"OBJET3 PERSISTANT APRES Create(T Object) : null");
			}
			
			System.out.println(TIRETS);
			System.out.println();
		}
		
	} // Fin de testCreate().______________________________________________
	

	
	/**
	 * method testCreateDoublon() :<br/>
	 * <ul>
	 * Teste la méthode <b>create(Civilite pDoublon)</b>.<br/>
	 * <li>garantit que create(Civilite pDoublon) retourne 
	 * null sans lever d'Exception.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testCreateDoublon() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testCreateDoublon()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Civilite objet2PersistantEquals1 = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		/* Instanciation d'un Civilite. */
		final Civilite objet2Equals1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testCreateDoublon()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoCivilite.create(objet1);
			objet2PersistantEquals1 = this.daoCivilite.create(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que create(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testCreateDoublon()");
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testCreateDoublon()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES CREATE : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES Create(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES Create(T Object) : null");
			}
			
			if (objet2PersistantEquals1 != null) {
				System.out.println(
						"OBJET2 PERSISTANT (DOUBLON DE OBJET1) APRES Create(T Object) : " 
								+ objet2PersistantEquals1.toString());
			} else {
				System.out.println(
						"OBJET2 PERSISTANT (DOUBLON DE OBJET1)  APRES Create(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}

	} // Fin de testCreateDoublon()._______________________________________

	
	
	/**
	 * method testSaveNull() :<br/>
	 * <ul>
	 * Teste la méthode <b>save(null)</b>.<br/>
	 * <li>garantit que save(null) ne fait rien 
	 * et retourne null.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testSaveNull() throws AbstractDaoException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testSaveNull()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final Civilite objet1 = null;
		Civilite objet1Persistant = null;
				
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testSaveNull()");
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoCivilite.save(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que save(null) ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testSaveNull()");
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testSaveNull()");
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testSaveNull().____________________________________________
	
	
	
	/**
	 * method testSave() :<br/>
	 * <ul>
	 * Teste la méthode <b>save(Civilite pObject)</b>.<br/>
	 * <li>garantit que save(Civilite pObject) insère 
	 * un objet en base.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testSave() throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testSave()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testSave()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoCivilite.save(objet1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que save(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
						
		}
		catch (AbstractDaoException e) {
			System.out.println("testSave()");
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testSave()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES SAVE : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES Save(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES Save(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}
		
	} // Fin de testSave().________________________________________________
	

	
	/**
	 * method testSaveDoublon() :<br/>
	 * <ul>
	 * Teste la méthode <b>save(Civilite pDoublon)</b>.<br/>
	 * <li>garantit que save(Civilite pDoublon) retourne 
	 * null sans lever d'Exception.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testSaveDoublon() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testSaveDoublon()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Civilite objet2PersistantEquals1 = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		/* Instanciation d'un Civilite. */
		final Civilite objet2Equals1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testSaveDoublon()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoCivilite.save(objet1);
			objet2PersistantEquals1 = this.daoCivilite.save(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que save(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testSaveDoublon()");
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testSaveDoublon()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES SAVE : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES Save(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES Save(T Object) : null");
			}
			
			if (objet2PersistantEquals1 != null) {
				System.out.println(
						"OBJET2 PERSISTANT (DOUBLON DE OBJET1) APRES Save(T Object) : " 
								+ objet2PersistantEquals1.toString());
			} else {
				System.out.println(
						"OBJET2 PERSISTANT (DOUBLON DE OBJET1)  APRES Save(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}

	} // Fin de testSaveDoublon()._________________________________________

	

	/**
	 * method testPersistNull() :<br/>
	 * <ul>
	 * Teste la méthode <b>persist(null)</b>.<br/>
	 * <li>garantit que persist(null) ne fait rien.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testPersistNull() throws AbstractDaoException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testPersistNull()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final Civilite objet1 = null;
		Civilite objet1Persistant = null;
				
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testPersistNull()");
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoCivilite.persist(objet1);
			objet1Persistant = this.daoCivilite.retrieve(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets 
			 * en base après le traitement. */
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que persist(null) 
			 * ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testPersistNull()");
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testPersistNull()");
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testPersistNull()._________________________________________
	
	
	
	/**
	 * method testPersist() :<br/>
	 * <ul>
	 * Teste la méthode <b>persist(Civilite pObject)</b>.<br/>
	 * <li>garantit que persist(Civilite pObject) insère 
	 * un objet en base.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testPersist() throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		
		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testPersist()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersist()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoCivilite.persist(objet1);
			objet1Persistant = this.daoCivilite.retrieve(objet1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que persist(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testPersist()");
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersist()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES PERSIST : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES persist(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES persist(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}
		
	} // Fin de testPersist()._____________________________________________
	

	
	/**
	 * method testPersistDoublon() :<br/>
	 * <ul>
	 * Teste la méthode <b>persist(Civilite pDoublon)</b>.<br/>
	 * <li>garantit que persist(Civilite pDoublon) ne fait 
	 * rien (n'insère pas de doublon) sans lever d'Exception.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testPersistDoublon() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testPersistDoublon()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Civilite objet2PersistantEquals1 = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		/* Instanciation d'un Civilite. */
		final Civilite objet2Equals1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersistDoublon()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoCivilite.persist(objet1);
			this.daoCivilite.persist(objet2Equals1);
			objet1Persistant = this.daoCivilite.retrieve(objet1);
			objet2PersistantEquals1 = this.daoCivilite.retrieve(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que persist(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
			/* Garantit que objet1Persistant et objet2PersistantEquals1 
			 * sont la même instance. */
			assertSame("Instance unique : "
					, objet1Persistant, objet2PersistantEquals1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println("testPersistDoublon()");
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersistDoublon()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES PERSIST : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES persist(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES persist(T Object) : null");
			}
			
			if (objet2PersistantEquals1 != null) {
				System.out.println(
						"OBJET2 PERSISTANT (INSTANCE OBJET1) APRES persist(T Object) : " 
								+ objet2PersistantEquals1.toString());
			} else {
				System.out.println(
						"OBJET2 PERSISTANT (INSTANCE OBJET1)  APRES persist(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}

	} // Fin de testPersistDoublon().______________________________________


	
	/**
	 * method testPersistSousClasseNull() :<br/>
	 * <ul>
	 * Teste la méthode <b>persistSousClasse(null)</b>.<br/>
	 * <li>garantit que persistSousClasse(null) ne fait rien.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testPersistSousClasseNull() throws AbstractDaoException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final Civilite objet1 = null;
		Civilite objet1Persistant = null;
				
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testPersistSousClasseNull()");
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoCivilite.persistSousClasse(objet1);
			objet1Persistant = this.daoCivilite.retrieve(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que persistSousClasse(null) ne fait 
			 * rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {			
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testPersistSousClasseNull()");
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testPersistSousClasseNull()._______________________________
	

	
	/**
	 * method testPersistSousClasse() :<br/>
	 * <ul>
	 * Teste la méthode 
	 * <b>persistSousClasse(Civilite pObject)</b>.<br/>
	 * <li>garantit que persistSousClasse(Civilite pObject) insère 
	 * un objet en base.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testPersistSousClasse() throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersistSousClasse()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoCivilite.persistSousClasse(objet1);
			objet1Persistant = this.daoCivilite.retrieve(objet1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que persistSousClasse(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersistSousClasse()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES PERSISTSOUSCLASSE : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES persistSousClasse(S Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES persistSousClasse(S Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}
		
	} // Fin de testPersistSousClasse().___________________________________
	

	
	/**
	 * method testPersistSousClasseDoublon() :<br/>
	 * <ul>
	 * Teste la méthode 
	 * <b>persistSousClasse(Civilite pDoublon)</b>.<br/>
	 * <li>garantit que persistSousClasse(Civilite pDoublon) 
	 * ne fait rien (n'insère pas de doublon) sans lever d'Exception.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testPersistSousClasseDoublon() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Civilite objet2PersistantEquals1 = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
		/* Instanciation d'un Civilite. */
		final Civilite objet2Equals1 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersistSousClasseDoublon()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoCivilite.persistSousClasse(objet1);
			this.daoCivilite.persistSousClasse(objet2Equals1);
			objet1Persistant = this.daoCivilite.retrieve(objet1);
			objet2PersistantEquals1 = this.daoCivilite.retrieve(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que persistSousClasse(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
			/* Garantit que objet1Persistant et objet2PersistantEquals1 
			 * sont la même instance. */
			assertSame("Instance unique : "
					, objet1Persistant, objet2PersistantEquals1);

		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testPersistSousClasseDoublon()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES PERSISTSOUSCLASSE : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES persistSousClasse(S Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES persistSousClasse(S Object) : null");
			}
			
			if (objet2PersistantEquals1 != null) {
				System.out.println(
						"OBJET2 PERSISTANT (INSTANCE OBJET1) APRES persistSousClasse(S Object) : " 
								+ objet2PersistantEquals1.toString());
			} else {
				System.out.println(
						"OBJET2 PERSISTANT (INSTANCE OBJET1)  APRES persistSousClasse(S Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}

	} // Fin de testPersistSousClasseDoublon().____________________________



	/**
	 * method testCreateReturnIdNull() :<br/>
	 * <ul>
	 * Teste la méthode <b>createReturnId(null)</b>.<br/>
	 * <li>garantit que createReturnId(null) ne fait rien 
	 * et retourne null.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testCreateReturnIdNull() throws AbstractDaoException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final Civilite objet1 = null;
		Civilite objet1Persistant = null;
		Long idObjetPersistant = null;
				
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testCreateReturnIdNull()");
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			idObjetPersistant = this.daoCivilite.createReturnId(objet1);
			objet1Persistant = this.daoCivilite.findById(idObjetPersistant);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que create(null) ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {			
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testCreateReturnIdNull()");
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testCreateReturnId().______________________________________
	

	
	/**
	 * method testCreateReturnId() :<br/>
	 * <ul>
	 * Teste la méthode <b>createReturnId(Civilite pObject)</b>.<br/>
	 * <li>garantit que createReturnId(Civilite pObject) insère 
	 * un objet en base et retourne son ID.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testCreateReturnId() throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Long idObjetPersistant = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testCreateReturnId()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			idObjetPersistant = this.daoCivilite.createReturnId(objet1);
			objet1Persistant = this.daoCivilite.findById(idObjetPersistant);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que create(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testCreateReturnId()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES CREATERETURNID : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES createReturnId(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES createReturnId(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}
		
	} // Fin de testCreateReturnId().______________________________________
	

	
	/**
	 * method testCreateReturnIdDoublon() :<br/>
	 * <ul>
	 * Teste la méthode <b>createReturnId(Civilite pDoublon)</b>.<br/>
	 * <li>garantit que createReturnId(Civilite pDoublon) retourne 
	 * null sans lever d'Exception.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testCreateReturnIdDoublon() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objet1Persistant = null;
		Civilite objet2PersistantEquals1 = null;
		
		Long idObjet1Persistant = null;
		Long idObjet2PersistantEquals1 = null;
		
		/* Instanciation d'un Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		/* Instanciation d'un Civilite. */
		final Civilite objet2Equals1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testCreateReturnIdDoublon()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			idObjet1Persistant = this.daoCivilite.createReturnId(objet1);
			idObjet2PersistantEquals1 = this.daoCivilite.createReturnId(objet2Equals1);
			objet1Persistant = this.daoCivilite.findById(idObjet1Persistant);
			objet2PersistantEquals1 = this.daoCivilite.findById(idObjet2PersistantEquals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que create(Civilite pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testCreateReturnIdDoublon()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES CREATERETURNID : " + nombreObjetsFinal);
			if (objet1Persistant != null) {
				System.out.println(
						"OBJET1 PERSISTANT APRES createReturnId(T Object) : " 
				+ objet1Persistant.toString());
			} else {
				System.out.println(
						"OBJET1 PERSISTANT APRES createReturnId(T Object) : null");
			}
			
			if (objet2PersistantEquals1 != null) {
				System.out.println(
						"OBJET2 PERSISTANT APRES createReturnId(T Object) : " 
								+ objet2PersistantEquals1.toString());
			} else {
				System.out.println(
						"OBJET2 PERSISTANT APRES createReturnId(T Object) : null");
			}
			System.out.println(TIRETS);
			System.out.println();
		}

	} // Fin de testCreateReturnIdDoublon()._______________________________



	/**
	 * method testSaveLot() :<br/>
	 * <ul>
	 * Teste la méthode <b>save(Iterable&lt;S&gt; pObjects)</b>.<br/>
	 * <li>garantit que save(Iterable&lt;S&gt; pObjects) insère 
	 * un lot d'objets en base.</li>
	 * <li>garantit que save(Iterable&lt;S&gt; pObjects) 
	 * saute les null.</li>
	 * <li>garantit que save(Iterable&lt;S&gt; pObjects) 
	 * saute les doublons.</li>
	 * </ul>
	 * 
	 * @throws AbstractDaoException 
	 */
	@Commit
	@Transactional
	@Test
	public void testSaveLot() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testSaveLot()");
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		List<Civilite> lotPersistant = null;
		
		/* Instanciation de Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		final Civilite objet2Null = null;
		
		final Civilite objet3Equals1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		final Civilite objet4 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		/* Constitution d'un lot d'objets. */
		final List<Civilite> lot = new ArrayList<Civilite>();
		
		lot.add(objet1);
		lot.add(objet2Null);
		lot.add(objet3Equals1);
		lot.add(objet4);
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testSaveLot()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT : NULL");
			System.out.println("OBJET3 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet3Equals1.toString());
			System.out.println("OBJET4 NON PERSISTANT : " + objet4.toString());
			System.out.println(TIRETS);
			System.out.println();
		}

		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			lotPersistant = (List<Civilite>) this.daoCivilite.save(lot);
			/* *********************************************** */
			
			assertEquals("2 Objets dans le lot : "
					, 2
						, lotPersistant.size());
			
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que save(Lot pObjects) 
			 * insère des objets en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_DEUX
					, nombreObjetsFinal == nombreObjetsinitial + 2);
									
		}
		catch (AbstractDaoException e) {
			System.out.println("testSaveLot()");
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testSaveLot()");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES save(Lot) : " + nombreObjetsFinal);
			System.out.println("LOT D'ENREGISTREMENTS EN BASE : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();

		}
				
	} // Fin de testSaveLot()._____________________________________________
	

	
	/**
	 * method testRetrieve() :<br/>
	 * <ul>
	 * Teste la méthode <b>retrieve(Civilite pObject)</b>.<br/>
	 * <li>garantit que retrieve(Civilite pObject) retrouve 
	 * un objet existant en base.</li>
	 * <li>garantit que retrieve(objetInexistant) retourne null.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testRetrieve() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		Civilite objetpersistantInexistant = null;
		Civilite objetpersistant = null;
		
		List<Civilite> lotPersistant = null;
		
		/* Instanciation de Civilite. */
		final Civilite objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		final Civilite objet2Null = null;
		
		final Civilite objet3Equals1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		final Civilite objet4 
		= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		
		final Civilite objet5 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
		final Civilite objetInexistant 
		= new Civilite("Pouetr* Pouet");
		
		/* Constitution d'un lot d'objets. */
		final List<Civilite> lot = new ArrayList<Civilite>();
		
		lot.add(objet1);
		lot.add(objet2Null);
		lot.add(objet3Equals1);
		lot.add(objet4);
		lot.add(objet5);
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testRetrieve()");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT : NULL");
			System.out.println("OBJET3 NON PERSISTANT (DOUBLON DE OBJET1) : " + objet3Equals1.toString());
			System.out.println("OBJET4 NON PERSISTANT : " + objet4.toString());
			System.out.println("OBJET5 NON PERSISTANT : " + objet5.toString());
			System.out.println(TIRETS);
			System.out.println();
		}

		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			lotPersistant = (List<Civilite>) this.daoCivilite.save(lot);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que save(Lot pObjects) 
			 * insère des objets en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_TROIS
					, nombreObjetsFinal == nombreObjetsinitial + 3);
			
		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testRetrieve()");
			System.out.println("LOT D'ENREGISTREMENTS EN BASE : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();

		}
		
		/* *********************************************** */
		/* ********************* RETRIEVE **************** */
		objetpersistantInexistant = this.daoCivilite.retrieve(objetInexistant);
		
		/* garantit que retrieve(objetInexistant) retourne null. */
		assertNull("Un objet non persistant ne peut être trouvé en base : "
				, objetpersistantInexistant);

		/* *********************************************** */
		/* ********************* RETRIEVE **************** */
		objetpersistant = this.daoCivilite.retrieve(objet5);
		
		/* garantit que retrieve(Civilite pObject) retrouve 
		 * objet existant en base.*/
		assertEquals("Un objet persistant doit être trouvé en base : "
				, objet5
					, objetpersistant);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testRetrieve()");
			this.afficherObjetPersistant(
					objetpersistant, nombreObjetsFinal);
		}
		
	} // Fin de testRetrieve().____________________________________________
	

	
	/**
	 * method testFindById() :<br/>
	 * <ul>
	 * Teste la méthode <b>findById(Long pId)</b>.<br/>
	 * <li>garantit que findById(Long pId) retrouve un
	 * objet existant en base.</li>
	 * <li>garantit que findById(Long pIdInexistant) retourne null.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testFindById() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
				

		Long nombreObjetsFinal = 0L;
		
		Civilite objetpersistantInexistant = null;
		Civilite objetpersistant = null;
		
		/* remplit de la table. */
		this.remplirTable(affichage);
		
		nombreObjetsFinal = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDBYID **************** */
		objetpersistantInexistant = this.daoCivilite.findById(100L);
		
		/* garantit que findById(Long pIdInexistant) retourne null. */
		assertNull("Un objet non persistant ne peut être trouvé en base : "
				, objetpersistantInexistant);

		/* *********************************************** */
		/* ********************* FINDBYID **************** */
		objetpersistant = this.daoCivilite.findById(3L);
		
		if (objetpersistant != null) {
			
			/* garantit que findById(Long pIdExistant) retrouve 
			 * un objet existant en base.*/
			assertNotNull("Un objet persistant doit être trouvé en base : "
					, objetpersistant.getId());
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println("testFindById()");
				this.afficherObjetPersistant(
						objetpersistant, nombreObjetsFinal);
			}
			
		}
				
	} // Fin de testFindById().____________________________________________
	

	
	/**
	 * method testFindAll() :<br/>
	 * <ul>
	 * Teste la méthode <b>findAll()</b>.<br/>
	 * <li>garantit que findAll() retrouve 
	 * tous les objets existants en base.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testFindAll() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
				

		List<Civilite> lotPersistant = null;
				
		/* remplit de la table. */
		this.remplirTable(affichage);
		
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testFindAll()");
			System.out.println("LOT D'OBJETS TROUVES EN BASE PAR findAll() : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}
		
		/* garantit que findAll() retrouve tous 
		 * les objets existants en base. */
		assertEquals("Le nombre d'objets trouvés "
				+ "par findAll() doit être 3 : "
				, 3
					, lotPersistant.size());
				
	} // Fin de testFindAll()._____________________________________________
	

	
	/**
	 * method testFindAllMax() :<br/>
	 * <ul>
	 * Teste la méthode <b>findAllMax(Long pMax)</b>.<br/>
	 * <li>garantit que findAll(Long pMax) retrouve 
	 * les pMax premiers objets existants en base.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testFindAllMax() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
				

		List<Civilite> lotPersistant = null;
				
		/* remplit de la table. */
		this.remplirTable(affichage);
		
		
		/* *********************************************** */
		/* ********************* FINDALLMax ************** */
		lotPersistant = this.daoCivilite.findAllMax(2L);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testFindAllMax()");
			System.out.println("LOT D'OBJETS TROUVES EN BASE PAR findAllMax(2) : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		if (lotPersistant != null) {
			
			/* garantit que findAllMax() retrouve tous 
			 * les pMax premiers objets existants en base. */
			assertEquals("Le nombre d'objets trouvés "
					+ "par findAll() doit être 2 : "
					, 2
						, lotPersistant.size());
			
		}
						
	} // Fin de testFindAllMax().__________________________________________
	

		
	/**
	 * method testFindAllIterable() :<br/>
	 * <ul>
	 * Teste la méthode <b>findAll(Iterable<ID> pIds)</b>.<br/>
	 * <li>garantit que findAll(Iterable<ID> pIds) retrouve 
	 * les objets existants en base.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testFindAllIterable() 
							throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
	
		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________
	
		
		/* Vide la table. */
		this.viderTable();
				
	
		List<Civilite> lotPersistant = null;
		Iterable<Civilite> lotPersistantIterable = null;
				
		/* remplit de la table. */
		this.remplirTable(affichage);
		
		final List<Long> listIds = new ArrayList<Long>();
		listIds.add(1L);
		listIds.add(2L);
		
		/* *********************************************** */
		/* ***************** FINDALL(Ite) **************** */
		lotPersistantIterable = this.daoCivilite.findAll(listIds);
		
		lotPersistant = this.fabriquerList(lotPersistantIterable);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testFindAllIterable()");
			System.out.println("LOT D'OBJETS TROUVES EN BASE PAR findAll(listIds) : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}
	
		if (lotPersistant != null) {
			
			final boolean exists1 = this.daoCivilite.exists(1L);
			final boolean exists2 = this.daoCivilite.exists(2L);
			
			if (exists1 && exists2) {
				
				/* garantit que findAllMax() retrouve tous 
				 * les objets existants en base. */
				assertEquals("Le nombre d'objets trouvés "
						+ "par findAll() doit être 2 : "
						, 2
							, lotPersistant.size());
			}
						
		}
						
	} // Fin de testFindAllIterable()._____________________________________
	

	
	/**
	 * method testUpdateInexistant() :<br/>
	 * <ul>
	 * Teste la méthode <b>update(T pObjectInexistant)</b>.<br/>
	 * <li>garantit que update(T pObjectInexistant) ne fait rien 
	 * et ne persiste pas pObjectInexistant en base.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testUpdateInexistant() 
			throws AbstractDaoException {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Civilite objetpersistantInexistant = null;
		
		
		final Civilite objetInexistant 
		= new Civilite("civiliteInexistant");
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testUpdateInexistant()");
			this.afficherObjetNonPersistant(
					objetInexistant, 0L);
		}
		
		/* ************************************************ */
		/* ***************** UPDATE(Objet) **************** */
		objetpersistantInexistant 
			= this.daoCivilite.update(objetInexistant);
		
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testUpdateInexistant()");
			this.afficherObjetPersistant(
					objetpersistantInexistant, 0L);
		}
		
		if (objetpersistantInexistant != null) {
						
			assertSame("L'objet à modifer et l'objet modifié "
					+ "sont la même instance : "
					, objetInexistant
						, objetpersistantInexistant);
			
			/* garantit que update(T pObjectInexistant) ne fait rien 
			 * et ne persiste pas pObjectInexistant en base. */
			assertNull("l'ID de l'objet inexistant doit être null : "
					, objetpersistantInexistant.getId());
			
		}
		
	} // Fin de testUpdateInexistant().____________________________________
	

	
	/**
	 * method testUpdate() :<br/>
	 * <ul>
	 * Teste la méthode <b>update(T pObject)</b>.<br/>
	 * <li>garantit que update(T pObject) modifie 
	 * l'objet existant en base.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testUpdate() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Civilite objet1 = null;
		Civilite objet1Persistant = null;
		Civilite objet1ModifiePersistant = null;

		
		/* remplit de la table. */
		this.remplirTable(affichage);

		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
				
		/* Récupération de l'objet persistant. */
		objet1Persistant = this.daoCivilite.retrieve(objet1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testUpdate()");
			this.afficherObjetPersistant(
					objet1Persistant, 3L);
		}
		
		/* ************** */
		/* Modifications. */
		objet1Persistant.setCiviliteString("Mr modifié");

		
		/* ************************************************ */
		/* ***************** UPDATE(Objet) **************** */
		objet1ModifiePersistant = this.daoCivilite.update(objet1Persistant);

		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("testUpdate()");
			this.afficherObjetPersistant(
					objet1ModifiePersistant, 3L);
		}
		
		if (objet1ModifiePersistant != null) {
			
			/* garantit que update(T pObject) modifie 
			 * l'objet existant en base.*/
			assertEquals("Le civilite doit être Mr modifié : "
					, "Mr modifié"
						, objet1ModifiePersistant.getCiviliteString());
			
			assertSame("L'objet à modifer et l'objet modifié sont la même instance : "
					, objet1Persistant
						, objet1ModifiePersistant);
			
		}
		
	} // Fin de testUpdate().______________________________________________
	

		
	/**
	 * method testDeleteInexistant() :<br/>
	 * <ul>
	 * Teste la méthode <b>delete(T pObjectInexistant)</b>.<br/>
	 * <li>garantit que delete(T pObjectInexistant) ne fait rien 
	 * et retourne false.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testDeleteInexistant() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
	
		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________
	
		
		/* Vide la table. */
		this.viderTable();
	
	
		Civilite objet1 = null;
		boolean resultat = false;
		List<Civilite> lotPersistant = null;
		List<Civilite> lotPersistantApresDelete = null;
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		final Civilite objetInexistant 
		= new Civilite("Civilite inexistante");
	
	
		/* remplit de la table. */
		this.remplirTable(affichage);
		this.daoCivilite.create(objet1);
		
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteInexistant()");
			System.out.println(LOT_OBJET_INITIAL);
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}
	
		
		/* ************************************************ */
		/* ***************** DELETE(Objet) **************** */
		resultat = this.daoCivilite.delete(objetInexistant);
	
		
		nombreObjetsFinal = this.daoCivilite.count();
		
		lotPersistantApresDelete = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteInexistant()");
			System.out.println("LOT D'OBJETS EN BASE APRES DELETE (INEXISTANT) : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistantApresDelete));
			System.out.println(TIRETS);
			System.out.println();
			
		}
	
		/* garantit que delete(T pObject) retourne false. */
		assertFalse("Le résultat de delete() doit être false : "
				, resultat);
		
		assertEquals("NbreObjetsFinal = NbreObjetsInitial : "
				, nombreObjetsFinal
					, nombreObjetsinitial);
		
	} // Fin de testDeleteInexistant().____________________________________
	
	
	
	/**
	 * method testDelete() :<br/>
	 * <ul>
	 * Teste la méthode <b>delete(T pObject)</b>.<br/>
	 * <li>garantit que delete(T pObject) détruit 
	 * l'objet existant en base et retourne true.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testDelete() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Civilite objet1 = null;
		boolean resultat = false;
		List<Civilite> lotPersistant = null;
		List<Civilite> lotPersistantApresDelete = null;
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());

		/* remplit de la table. */
		this.remplirTable(affichage);
		this.daoCivilite.create(objet1);
		
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDelete()");
			System.out.println(LOT_OBJET_INITIAL);
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		
		/* ************************************************ */
		/* ***************** DELETE(Objet) **************** */
		resultat = this.daoCivilite.delete(objet1);

		
		nombreObjetsFinal = this.daoCivilite.count();
		
		lotPersistantApresDelete = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDelete()");
			System.out.println(LOT_OBJETS_APRES_DELETE);
			System.out.println(this.daoCivilite.afficherListe(lotPersistantApresDelete));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		/* garantit que delete(T pObject) détruit l'objet existant en base. */
		assertTrue("Le résultat de delete() doit être true : "
				, resultat);
		
		assertTrue(NBRE_OBJETS_FINAL_DOIT 
				+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial - 1);
		
	} // Fin de testDelete().______________________________________________
	

	
	/**
	 * method testDeleteByIdInexistant() :<br/>
	 * <ul>
	 * Teste la méthode <b>deleteById(Long pId)</b>.<br/>
	 * <li>garantit que deleteById(Long pIdInexistant) ne fait rien.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testDeleteByIdInexistant() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Civilite objet1 = null;

		List<Civilite> lotPersistant = null;
		List<Civilite> lotPersistantApresDelete = null;
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());

		/* remplit de la table. */
		this.remplirTable(affichage);
		this.daoCivilite.create(objet1);
		
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteByIdInexistant()");
			System.out.println(LOT_OBJET_INITIAL);
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		
		/* **************************************************** */
		/* ***************** DELETEBYID(Objet) **************** */
		this.daoCivilite.deleteById(100L);

		
		nombreObjetsFinal = this.daoCivilite.count();
		
		lotPersistantApresDelete = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteByIdInexistant()");
			System.out.println("LOT D'OBJETS EN BASE APRES DELETEBYID(inexistant) : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistantApresDelete));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		/* garantit que deleteById(T pObject) ne fait rien. */
		assertEquals("deleteById(inexistant) ne fait rien : "
				, nombreObjetsinitial, nombreObjetsFinal);

	} // Fin de testDeleteByIdInexistant().________________________________
	

	
	/**
	 * method testDeleteById() :<br/>
	 * <ul>
	 * Teste la méthode <b>deleteById(Long pId)</b>.<br/>
	 * <li>garantit que deleteById(Long pId) détruit 
	 * l'objet existant en base.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testDeleteById() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Civilite objet1 = null;
		Civilite objet1Persistant = null;
		Long idExistant = 0L;
		
		List<Civilite> lotPersistant = null;
		List<Civilite> lotPersistantApresDelete = null;
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());

		/* remplit de la table. */
		this.remplirTable(affichage);
		this.daoCivilite.create(objet1);
		
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteById()");
			System.out.println(LOT_OBJET_INITIAL);
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		objet1Persistant = this.daoCivilite.retrieve(objet1);
		
		if (objet1Persistant != null) {
			idExistant = objet1Persistant.getId();
		}
		
		
		/* ************************************************ */
		/* ***************** DELETEBYID(Objet) **************** */
		this.daoCivilite.deleteById(idExistant);

		
		nombreObjetsFinal = this.daoCivilite.count();
		
		lotPersistantApresDelete = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteById()");
			System.out.println(LOT_OBJETS_APRES_DELETE);
			System.out.println(this.daoCivilite.afficherListe(lotPersistantApresDelete));
			System.out.println(TIRETS);
			System.out.println();
			
		}
		
		/* garantit que deleteById(Long pId) détruit l'objet existant en base. */		
		assertTrue("NbreObjetsFinal = NbreObjetsInitial - 1 : "
				, nombreObjetsFinal == nombreObjetsinitial - 1);
		
	} // Fin de testDeleteById().__________________________________________
	

	
	/**
	 * method testDeleteByIdBooleanInexistant() :<br/>
	 * <ul>
	 * Teste la méthode <b>deleteByIdBoolean(Long pId)</b>.<br/>
	 * <li>garantit que deleteByIdBoolean(Long pIdInexistant) 
	 * ne fait rien et retourne false.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testDeleteByIdBooleanInexistant() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Civilite objet1 = null;
		boolean resultat = false;
		List<Civilite> lotPersistant = null;
		List<Civilite> lotPersistantApresDelete = null;
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());

		/* remplit de la table. */
		this.remplirTable(affichage);
		this.daoCivilite.create(objet1);
		
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteByIdBooleanInexistant()");
			System.out.println(LOT_OBJET_INITIAL);
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		
		/* *************************************************** */
		/* ********* DELETEBYIDBOOLEAN(Objet) **************** */
		resultat = this.daoCivilite.deleteByIdBoolean(100L);
		
		nombreObjetsFinal = this.daoCivilite.count();
		
		lotPersistantApresDelete = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteByIdBooleanInexistant()");
			System.out.println("LOT D'OBJETS EN BASE APRES DELETEBYIDBOOLEAN(inexistant) : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistantApresDelete));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		/* garantit que deleteByIdBoolean(pIdInexistant) retourne false. */
		assertFalse("Le résultat de delete() doit être false : "
				, resultat);
		
		/* garantit que deleteByIdBoolean(pIdInexistant) ne fait rien. */
		assertEquals("Nombre d'objets doit rester inchangé : "
				, nombreObjetsinitial
					, nombreObjetsFinal);
		
	} // Fin de testDeleteByIdBooleanInexistant()._________________________
	

	
	/**
	 * method testDeleteByIdBoolean() :<br/>
	 * <ul>
	 * Teste la méthode <b>deleteByIdBoolean(Long pId)</b>.<br/>
	 * <li>garantit que deleteByIdBoolean(Long pId) détruit 
	 * l'objet existant en base et retourne true.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	@Commit
	@Transactional
	@Test
	public void testDeleteByIdBoolean() 
			throws AbstractDaoException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		/* daoCivilite NON INJECTE. */
		if (this.daoCivilite == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoCivilite NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
				

		Civilite objet1 = null;
		Civilite objet1Persistant = null;
		Long idExistant = 0L;
		boolean resultat = false;
		
		List<Civilite> lotPersistant = null;
		List<Civilite> lotPersistantApresDelete = null;
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		/* Instanciation de Civilite. */
		objet1 
		= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());

		/* remplit de la table. */
		this.remplirTable(affichage);
		this.daoCivilite.create(objet1);
		
		nombreObjetsinitial = this.daoCivilite.count();
		
		/* *********************************************** */
		/* ********************* FINDALL ***************** */
		lotPersistant = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteByIdBoolean()");
			System.out.println(LOT_OBJET_INITIAL);
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		objet1Persistant = this.daoCivilite.retrieve(objet1);
		
		if (objet1Persistant != null) {
			idExistant = objet1Persistant.getId();
		}
		
		/* ************************************************ */
		/* ***************** DELETE(Objet) **************** */
		resultat = this.daoCivilite.deleteByIdBoolean(idExistant);
		
		nombreObjetsFinal = this.daoCivilite.count();
		
		lotPersistantApresDelete = this.daoCivilite.findAll();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
						
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("testDeleteByIdBoolean()");
			System.out.println("LOT D'OBJETS EN BASE APRES DELETEBYIDBOOLEAN : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistantApresDelete));
			System.out.println(TIRETS);
			System.out.println();
			
		}

		/* garantit que deleteByIdBoolean(Long pId) retourne true. */
		assertTrue("Le résultat de testDeleteByIdBoolean() doit être true : "
				, resultat);
		
		/* garantit que deleteByIdBoolean(Long pId) détruit l'objet existant en base. */
		assertTrue("NbreObjetsFinal = NbreObjetsInitial - 1 : "
				, nombreObjetsFinal == nombreObjetsinitial - 1);
		
	} // Fin de testDeleteByIdBoolean().___________________________________
	

	
	/**
	 * method remplirTable(
	 * boolean pAffichage) :<br/>
	 * Remplit la table CIVILITES avec 3 enregistrements.<br/>
	 * <br/>
	 * 
	 * @param pAffichage : boolean.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	private void remplirTable(
			final boolean pAffichage) throws AbstractDaoException {
		
		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		List<Civilite> lotPersistant = null;
		
		final Civilite objet1 
			= new Civilite(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		final Civilite objet2 
			= new Civilite(CivilitesEnum.MADAME.getAbreviationEnum());
		final Civilite objet3 
			= new Civilite(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
		/* Constitution d'un lot d'objets. */
		final List<Civilite> lot = new ArrayList<Civilite>();
		
		lot.add(objet1);
		lot.add(objet2);
		lot.add(objet3);
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoCivilite.count();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("remplirTable(boolean)");
			System.out.println("NOMBRE D'OBJETS INITIALEMENT En BASE : " + nombreObjetsinitial);
			System.out.println("OBJET1 NON PERSISTANT : " + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT : " + objet2.toString());
			System.out.println("OBJET3 NON PERSISTANT : " + objet3.toString());
			System.out.println(TIRETS);
			System.out.println();
		}

		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			lotPersistant = (List<Civilite>) this.daoCivilite.save(lot);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoCivilite.count();
			
			/* garantit que save(Lot pObjects) 
			 * insère des objets en base.*/
			assertEquals(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_TROIS
					, Long.valueOf(nombreObjetsinitial + 3)
						, nombreObjetsFinal);
			
		}
		catch (AbstractDaoException e) {
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && pAffichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("remplirTable(boolean)");
			System.out.println("NOMBRE D'OBJETS PERSISTES APRES save(Lot) : " + nombreObjetsFinal);
			System.out.println("LOT D'ENREGISTREMENTS EN BASE APRES remplirTable(boolean) : ");
			System.out.println(this.daoCivilite.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();

		}

		final Long nbeObjetsFinal = this.daoCivilite.count();
		
		assertEquals("La table doit être contenir 3 enregistements : "
				, Long.valueOf(3L), nbeObjetsFinal);
		
	} // Fin de remplirTable(...)._________________________________________
	
	
	
	/**
	 * method viderTable() :<br/>
	 * Vide la table.<br/>
	 * <br/>
	 *
	 * @throws AbstractDaoException
	 */
	private void viderTable() throws AbstractDaoException {
		
		this.daoCivilite.deleteAll();
		
		final Long nbreObjetsFinal = this.daoCivilite.count();
		
		assertEquals("La table doit être vide : "
				, Long.valueOf(0L), nbreObjetsFinal);
		
	} // Fin de viderTable().______________________________________________
	
	
	
	/**
	 * method afficherDAONonInstancie() :<br/>
	 * Affiche à la console de
	 * <b>"DAO NON INSTANCIE - this.daoCivilite est NULL"</b>.<br/>
	 * <br/>
	 */
	private void afficherDAONonInstancie() {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("DAO NON INSTANCIE "
				+ "- this.daoCivilite est NULL");
		System.out.println(TIRETS);
		System.out.println();
		
	} // Fin de afficherDAONonInstancie()._________________________________
	

	
	/**
	 * method afficherNbreObjetsInitial(
	 * Long pNbreObjetsInitial) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>Le nombre d'objets pNbreObjetsInitial initialement 
	 * en base avant le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pNbreObjetsInitial : Long : 
	 * Nombre d'objets initialement en base.<br/>
	 */
	private void afficherNbreObjetsInitial(
						final Long pNbreObjetsInitial) {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("nombre d'objets initialement en base = " 
				+ pNbreObjetsInitial);
		System.out.println(TIRETS);
		System.out.println();

	} // Fin de afficherNbreObjetsInitial(...).____________________________
	

	
	/**
	 * method afficherObjetPersistant(
	 * Civilite pObjetPersistant
	 * , Long pNbreObjetsFinal) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>l'objet pObjetPersistant persisté en base.</li>
	 * <li>Le nombre d'objets pNbreObjetsFinal finalement 
	 * en base après le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pObjetPersistant : Civilite : 
	 * Objet persistant en base.<br/>
	 * @param pNbreObjetsFinal : Long : 
	 * Nombre d'objets finalement en base.<br/>
	 */
	private void afficherObjetPersistant(
			final Civilite pObjetPersistant
				, final Long pNbreObjetsFinal) {
		
		if (pObjetPersistant != null) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objet persistant : " 
					+ pObjetPersistant.toString());
			System.out.println("nombre d'objets finalement en base = " 
					+ pNbreObjetsFinal);
			System.out.println(TIRETS);
			System.out.println();
			
		} else {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objetPersistant est NULL");
			System.out.println(TIRETS);
			System.out.println();
			
		}
		
	} // Fin de afficherObjetPersistant(...).______________________________
	
	
	
	/**
	 * method afficherObjetNonPersistant(
	 * Civilite pObjetNonPersistant
	 * , Long pNbreObjetsInitial) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>l'objet pObjetNonPersistant non persisté en base.</li>
	 * <li>Le nombre d'objets pNbreObjetsInitial initialement 
	 * en base avant le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pObjetNonPersistant : Civilite : 
	 * Objet non persistant en base.<br/>
	 * @param pNbreObjetsInitial : Long : 
	 * Nombre d'objets initialement en base.<br/>
	 */
	private void afficherObjetNonPersistant(
			final Civilite pObjetNonPersistant
				, final Long pNbreObjetsInitial) {
		
		if (pObjetNonPersistant != null) {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objet non persistant : " 
					+ pObjetNonPersistant.toString());
			System.out.println("nombre d'objets initialement en base = " 
					+ pNbreObjetsInitial);
			System.out.println(TIRETS);
			System.out.println();

		}
		else {
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("objet non persistant est NULL");
			System.out.println("nombre d'objets initialement en base = " 
					+ pNbreObjetsInitial);
			System.out.println(TIRETS);
			System.out.println();
			
		}
		
	} // Fin de afficherObjetNonPersistSousClasseant(...).___________________________
	
	

	/**
	 * method afficherAbstractDaoException(
	 * AbstractDaoException pE) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>le message Utilisateur d'une AbstractDaoException pE.</li>
	 * <li>le message Technique d'une AbstractDaoException pE.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pE : AbstractDaoException.<br/>
	 */
	private void afficherAbstractDaoException(
			final AbstractDaoException pE) {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("MESSAGE UTILISATEUR : " 
				+ pE.getMessageUtilisateur());
		System.out.println();
		System.out.println("MESSAGE TECHNIQUE : " 
				+ pE.getMessageTechnique());
		System.out.println(TIRETS);
		System.out.println();

	} // Fin de afficherAbstractDaoException(...)._________________________
	

	
	/**
	 * method fabriquerList(
	 * Iterable<Civilite> pIterable) :<br/>
	 * fabrique une liste à partir d'un Iterable.<br/>
	 * <br/>
	 *
	 * @param pIterable : Iterable<Civilite>.<br/>
	 * 
	 * @return : List<Civilite>.<br/>
	 */
	public final List<Civilite> fabriquerList(
			final Iterable<Civilite> pIterable) {
		
		final List<Civilite> list = new ArrayList<Civilite>();
		
	    for (final Civilite item : pIterable) {
	        list.add(item);
	    }
	    
	    return list;
	    
	} // Fin de fabriquerList(...).________________________________________
	
	


} // FIN DE LA CLASSE DaoCiviliteTest.---------------------------------------

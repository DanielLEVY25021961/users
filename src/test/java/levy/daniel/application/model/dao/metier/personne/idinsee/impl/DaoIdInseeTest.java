package levy.daniel.application.model.dao.metier.personne.idinsee.impl;

import static org.junit.Assert.assertEquals;
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
import levy.daniel.application.model.dao.metier.personne.idinsee.IDaoIdInsee;
import levy.daniel.application.model.metier.personne.idinsee.IIdInsee;
import levy.daniel.application.model.metier.personne.idinsee.impl.IdInsee;


/**
 * class DaoIdInseeTest :<br/>
 * <ul>
 * <li>Test JUnit de la classe <b>DaoIdInsee</b>.</li>
 * <li>Test JUnit sous <b>SPRING</b>.</li>
 * <li>Le <b>fichier de configuration SPRING</b> utilisé pour ce test est 
 * <b>classpath*:applicationContext-test.xml</b> grâce à l'annotation 
 * <b>ContextConfiguration</b>.</li>
 * </ul>
 * <br/>
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
 * @since 26 déc. 2017
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext-test.xml"})
public class DaoIdInseeTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * TEST_CREATE_NULL : String :<br/>
	 * "testCreateNull()".<br/>
	 */
	public static final String TEST_CREATE_NULL 
		= "testCreateNull()";
	
	
	/**
	 * TEST_CREATE : String :<br/>
	 * "testCreate()".<br/>
	 */
	public static final String TEST_CREATE 
		= "testCreate()";
	
	
	/**
	 * TEST_CREATE_DOUBLON : String :<br/>
	 * "testCreateDoublon()".<br/>
	 */
	public static final String TEST_CREATE_DOUBLON 
		= "testCreateDoublon()";
	
	
	/**
	 * TEST_SAVE_NULL : String :<br/>
	 * "testSaveNull()".<br/>
	 */
	public static final String TEST_SAVE_NULL 
		= "testSaveNull()";

	
	/**
	 * TEST_SAVE : String :<br/>
	 * "testSave()".<br/>
	 */
	public static final String TEST_SAVE 
		= "testSave()";
	
	
	/**
	 * TEST_SAVE_DOUBLON : String :<br/>
	 * "testSaveDoublon()".<br/>
	 */
	public static final String TEST_SAVE_DOUBLON 
		= "testSaveDoublon()";
	
	
	/**
	 * TEST_PERSIST_NULL : String :<br/>
	 * "testPersistNull()".<br/>
	 */
	public static final String TEST_PERSIST_NULL 
		= "testPersistNull()";
	
	
	/**
	 * TEST_PERSIST : String :<br/>
	 * "testPersist()".<br/>
	 */
	public static final String TEST_PERSIST 
		= "testPersist()";
	
	
	/**
	 * TEST_PERSIST_DOUBLON : String :<br/>
	 * "testPersistDoublon()".<br/>
	 */
	public static final String TEST_PERSIST_DOUBLON 
	= "testPersistDoublon()";

	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";

	
	/**
	 * NBRE_OBJET_INITIAL : String :<br/>
	 * "NOMBRE D'OBJETS INITIALEMENT En BASE : ".<br/>
	 */
	public static final String NBRE_OBJET_INITIAL 
		= "NOMBRE D'OBJETS INITIALEMENT En BASE : ";
	
	
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
	 * OBJET1_NON_PERSISTANT : String :<br/>
	 * "OBJET1 NON PERSISTANT : ".<br/>
	 */
	public static final String OBJET1_NON_PERSISTANT 
		= "OBJET1 NON PERSISTANT : ";

	/**
	 * OBJET2_NON_PERSISTANT_DOUBLON1 : String :<br/>
	 * "OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : ".<br/>
	 */
	public static final String OBJET2_NON_PERSISTANT_DOUBLON1 
		= "OBJET2 NON PERSISTANT (DOUBLON DE OBJET1) : ";

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
	 * NUM_INSEE1 : String :<br/>
	 * "001254 789".<br/>
	 */
	public static final String NUM_INSEE1 = "001254 789";
	
	/**
	 * NUM_INSEE2 : String :<br/>
	 * "701254 790".<br/>
	 */
	public static final String NUM_INSEE2 = "701254 790";
	
	/**
	 * NUM_INSEE3 : String :<br/>
	 * "801257 791".<br/>
	 */
	public static final String NUM_INSEE3 = "801257 791";
	
		
	/**
	 * daoIdInsee : IDaoIdInsee :<br/>
	 * DAO pour les IIdInsee.<br/>
	 * INJECTE PAR SPRING (Autowired).<b/>
	 */
	@Autowired
	private transient IDaoIdInsee daoIdInsee;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoIdInseeTest.class);


	// *************************METHODES************************************/
			
	 /**
	 * method CONSTRUCTEUR DaoIdInseeTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoIdInseeTest() {
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATE_NULL);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IIdInsee objet1 = null;
		IIdInsee objet1Persistant = null;
						
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_CREATE_NULL);
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoIdInsee.create(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que create(null) ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_CREATE_NULL);
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testCreateNull().__________________________________________
	
	
	
	/**
	 * method testCreate() :<br/>
	 * <ul>
	 * Teste la méthode <b>create(IIdInsee pObject)</b>.<br/>
	 * <li>garantit que create(IIdInsee pObject) insère 
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoProfilSimple NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IIdInsee objet1Persistant = null;
		IIdInsee objet2Persistant = null;
		IIdInsee objet3Persistant = null;
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet1 
		= new IdInsee(NUM_INSEE1);
		
		final IIdInsee objet2 
		= new IdInsee(NUM_INSEE2);
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_CREATE);
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println("OBJET2 NON PERSISTANT : " + objet2.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoIdInsee.create(objet1);
			objet2Persistant = this.daoIdInsee.create(objet2);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que create(ProfilSimple pObject) 
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
		
		
		final IIdInsee objet3 
		= new IdInsee(NUM_INSEE3);
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet3Persistant = this.daoIdInsee.create(objet3);
			
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
	 * Teste la méthode <b>create(IIdInsee pDoublon)</b>.<br/>
	 * <li>garantit que create(IIdInsee pDoublon) retourne 
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_CREATE_DOUBLON);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IIdInsee objet1Persistant = null;
		IIdInsee objet2PersistantEquals1 = null;
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet1 
		= new IdInsee(NUM_INSEE1);
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet2Equals1 
			= new IdInsee(NUM_INSEE1);
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_CREATE_DOUBLON);
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println(OBJET2_NON_PERSISTANT_DOUBLON1 + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoIdInsee.create(objet1);
			objet2PersistantEquals1 = this.daoIdInsee.create(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que create(ProfilSimple pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_CREATE_DOUBLON);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_CREATE_DOUBLON);
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE_NULL);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IIdInsee objet1 = null;
		IIdInsee objet1Persistant = null;
				
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_SAVE_NULL);
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoIdInsee.save(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets en base après le traitement. */
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que save(null) ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_SAVE_NULL);
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testSaveNull().____________________________________________
	

	
	/**
	 * method testSave() :<br/>
	 * <ul>
	 * Teste la méthode <b>save(IIdInsee pObject)</b>.<br/>
	 * <li>garantit que save(IIdInsee pObject) insère 
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IIdInsee objet1Persistant = null;
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet1 
			= new IdInsee(NUM_INSEE1);
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_SAVE);
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoIdInsee.save(objet1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que save(ProfilSimple pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
						
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_SAVE);
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
	 * Teste la méthode <b>save(IIdInsee pDoublon)</b>.<br/>
	 * <li>garantit que save(IIdInsee pDoublon) retourne 
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_SAVE_DOUBLON);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IIdInsee objet1Persistant = null;
		IIdInsee objet2PersistantEquals1 = null;
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet1 
		= new IdInsee(NUM_INSEE1);
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet2Equals1 
		= new IdInsee(NUM_INSEE1);
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_SAVE_DOUBLON);
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println(OBJET2_NON_PERSISTANT_DOUBLON1 + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			objet1Persistant = this.daoIdInsee.save(objet1);
			objet2PersistantEquals1 = this.daoIdInsee.save(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que save(ProfilSimple pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_SAVE_DOUBLON);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_SAVE_DOUBLON);
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

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST_NULL);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		final IIdInsee objet1 = null;
		IIdInsee objet1Persistant = null;
				
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_PERSIST_NULL);
			this.afficherNbreObjetsInitial(nombreObjetsinitial);			
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoIdInsee.persist(objet1);
			objet1Persistant = this.daoIdInsee.retrieve(objet1);
			/* *********************************************** */
			
			/* Calcul du nombre d'objets 
			 * en base après le traitement. */
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que persist(null) 
			 * ne fait rien et retourne null. */
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_ZERO
					, nombreObjetsFinal == nombreObjetsinitial + 0);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_PERSIST_NULL);
			this.afficherAbstractDaoException(e);			
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(TEST_PERSIST_NULL);
			this.afficherObjetPersistant(
					objet1Persistant, nombreObjetsFinal);						
		}

	} // Fin de testPersistNull()._________________________________________
	

	
	/**
	 * method testPersist() :<br/>
	 * <ul>
	 * Teste la méthode <b>persist(IIdInsee pObject)</b>.<br/>
	 * <li>garantit que persist(IIdInsee pObject) insère 
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
		
		
		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();
		

		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IIdInsee objet1Persistant = null;
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet1 
		= new IdInsee(NUM_INSEE1);
		
				
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_PERSIST);
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoIdInsee.persist(objet1);
			objet1Persistant = this.daoIdInsee.retrieve(objet1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que persist(ProfilSimple pObject) 
			 * insère un objet en base.*/
			assertTrue(NBRE_OBJETS_FINAL_DOIT
					+ NBRE_INITIAL_PLUS_UN
					, nombreObjetsFinal == nombreObjetsinitial + 1);
			
		}
		catch (AbstractDaoException e) {
			System.out.println(TEST_PERSIST);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_PERSIST);
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
	 * Teste la méthode <b>persist(IIdInsee pDoublon)</b>.<br/>
	 * <li>garantit que persist(IIdInsee pDoublon) ne fait 
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
		final boolean affichage = true;
		// **********************************

		/* daoIdInsee NON INJECTE. */
		if (this.daoIdInsee == null) {
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				System.out.println(TEST_PERSIST_DOUBLON);
				this.afficherDAONonInstancie();
			}			
			return;
		} // Fin de daoIdInsee NON INJECTE._______________

		
		/* Vide la table. */
		this.viderTable();


		Long nombreObjetsinitial = 0L;
		Long nombreObjetsFinal = 0L;
		
		IIdInsee objet1Persistant = null;
		IIdInsee objet2PersistantEquals1 = null;
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet1 
		= new IdInsee(NUM_INSEE1);
		
		/* Instanciation d'un ProfilSimple. */
		final IIdInsee objet2Equals1 
		= new IdInsee(NUM_INSEE1);
		
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_PERSIST_DOUBLON);
			System.out.println(NBRE_OBJET_INITIAL + nombreObjetsinitial);
			System.out.println(OBJET1_NON_PERSISTANT + objet1.toString());
			System.out.println(OBJET2_NON_PERSISTANT_DOUBLON1 + objet2Equals1.toString());
			System.out.println(TIRETS);
			System.out.println();
		}
		
		try {
			
			/* *********************************************** */
			/* ********************* CREATION **************** */
			this.daoIdInsee.persist(objet1);
			this.daoIdInsee.persist(objet2Equals1);
			objet1Persistant = this.daoIdInsee.retrieve(objet1);
			objet2PersistantEquals1 = this.daoIdInsee.retrieve(objet2Equals1);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
			/* garantit que persist(ProfilSimple pObject) 
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
			System.out.println(TEST_PERSIST_DOUBLON);
			this.afficherAbstractDaoException(e);
			e.printStackTrace();
		}
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(TIRETS);
			System.out.println(TEST_PERSIST_DOUBLON);
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
	 * method remplirTable(
	 * boolean pAffichage) :<br/>
	 * Remplit les tables ABSTRACT_IDS_INSEE 
	 * et IDS_INSEE avec 3 enregistrements.<br/>
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
		
		List<IIdInsee> lotPersistant = null;
		
		final IIdInsee objet1 
			= new IdInsee(NUM_INSEE1);
		final IIdInsee objet2 
			= new IdInsee(NUM_INSEE2);
		final IIdInsee objet3 
			= new IdInsee(NUM_INSEE3);
		
		/* Constitution d'un lot d'objets. */
		final List<IIdInsee> lot = new ArrayList<IIdInsee>();
		
		lot.add(objet1);
		lot.add(objet2);
		lot.add(objet3);
		
		/* Compte du nombre d'Objets initialement en base. */
		nombreObjetsinitial = this.daoIdInsee.count();

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
			lotPersistant = (List<IIdInsee>) this.daoIdInsee.save(lot);
			/* *********************************************** */
			
			nombreObjetsFinal = this.daoIdInsee.count();
			
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
			System.out.println(this.daoIdInsee.afficherListe(lotPersistant));
			System.out.println(TIRETS);
			System.out.println();

		}

		final Long nbeObjetsFinal = this.daoIdInsee.count();
		
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
		
		this.daoIdInsee.deleteAll();
		
		final Long nbreObjetsFinal = this.daoIdInsee.count();
		
		assertEquals("La table doit être vide : "
				, Long.valueOf(0L), nbreObjetsFinal);
		
	} // Fin de viderTable().______________________________________________
	
	
	
	/**
	 * method afficherDAONonInstancie() :<br/>
	 * Affiche à la console
	 * <b>"DAO NON INSTANCIE - this.daoIIdInsee est NULL"</b>.<br/>
	 * <br/>
	 */
	private void afficherDAONonInstancie() {
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("DAO NON INSTANCIE "
				+ "- this.daoIIdInsee est NULL");
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
	 * IIdInsee pObjetPersistant
	 * , Long pNbreObjetsFinal) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>l'objet pObjetPersistant persisté en base.</li>
	 * <li>Le nombre d'objets pNbreObjetsFinal finalement 
	 * en base après le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pObjetPersistant : IIdInsee : 
	 * Objet persistant en base.<br/>
	 * @param pNbreObjetsFinal : Long : 
	 * Nombre d'objets finalement en base.<br/>
	 */
	private void afficherObjetPersistant(
			final IIdInsee pObjetPersistant
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
	 * IIdInsee pObjetNonPersistant
	 * , Long pNbreObjetsInitial) :<br/>
	 * <ul>
	 * Affiche à la console :
	 * <li>l'objet pObjetNonPersistant non persisté en base.</li>
	 * <li>Le nombre d'objets pNbreObjetsInitial initialement 
	 * en base avant le test.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pObjetNonPersistant : IIdInsee : 
	 * Objet non persistant en base.<br/>
	 * @param pNbreObjetsInitial : Long : 
	 * Nombre d'objets initialement en base.<br/>
	 */
	private void afficherObjetNonPersistant(
			final IIdInsee pObjetNonPersistant
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
		
	} // Fin de afficherObjetNonPersistant(...).___________________________
	
	

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
	 * Iterable<IIdInsee> pIterable) :<br/>
	 * fabrique une liste à partir d'un Iterable.<br/>
	 * <br/>
	 *
	 * @param pIterable : Iterable<IIdInsee>.<br/>
	 * 
	 * @return : List<IIdInsee>.<br/>
	 */
	public final List<IIdInsee> fabriquerList(
			final Iterable<IIdInsee> pIterable) {
		
		final List<IIdInsee> list = new ArrayList<IIdInsee>();
		
	    for (final IIdInsee item : pIterable) {
	        list.add(item);
	    }
	    
	    return list;
	    
	} // Fin de fabriquerList(...).________________________________________
	
	

} // FIN DE LA CLASSE DaoIdInseeTest.----------------------------------------

package levy.daniel.application.model.metier.personne.civilite.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.AbstractCivilite;

/**
 * class <b>CiviliteComplete</b> :<br/>
 * <ul>
 * <li>Classe CONCRETE modélisant une <b>CiviliteComplete</b> 
 * (MONSIEUR, MADAME, MADEMOISELLE).</li>
 * <li>La civilité ne peut prendre <i>que les valeurs</i> définies dans 
 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
 * <li>"RG_CIVILITECOMPLETE_CIVILITESTRING_NOMENCLATURE_01 : 
 * la civilite (MONSIEUR, MADAME, ...) doit respecter 
 * un ensemble fini de valeurs (nomenclature)".</li>
 * </ul>
 * 
 *
 * - Exemple d'utilisation :<br/>
 * <code>//Instanciation d'un CiviliteComplete en lui passant la String 
 * associée à l'instance MONSIEUR de l'énumération.</code><br/>
 * <code>CiviliteComplete CIVILITE_MONSIEUR = new 
 * CiviliteComplete(CivilitesEnum.MONSIEUR.toString());</code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enumération, utilisation d'une énumeration dans classe,<br/>
 * enumeration, utilisation enum, <br/>
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
@Entity(name="CiviliteComplete")
@Table(name="CIVILITES_COMPLETES", schema="PUBLIC")
@PrimaryKeyJoinColumn(name = "ID_CIVILITE"
, foreignKey=@ForeignKey(name="FK_CIVILITECOMPLETE_ABSTRACTCIVILITE"))
public class CiviliteComplete extends AbstractCivilite {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * MONSIEUR : CiviliteComplete :<br/>
	 * "MONSIEUR".<br/>
	 */
	public static final CiviliteComplete MONSIEUR
		= new CiviliteComplete(CivilitesEnum.MONSIEUR.toString());

	
	/**
	 * MADAME : CiviliteComplete :<br/>
	 * "MADAME".<br/>
	 */
	public static final CiviliteComplete MADAME 
		= new CiviliteComplete(CivilitesEnum.MADAME.toString());

	
	/**
	 * MADEMOISELLE : CiviliteComplete :<br/>
	 * "MADEMOISELLE".<br/>
	 */
	public static final CiviliteComplete MADEMOISELLE 
		= new CiviliteComplete(CivilitesEnum.MADEMOISELLE.toString());
	

	/**
	 * valeursPossibles : List&lt;String&gt; :<br/>
	 * <ul>
	 * <li>Liste des valeurs possibles pour civiliteString 
	 * fournie par CivilitesEnum.</li>
	 * <li>MONSIEUR, MADAME, MADEMOISELLE.</li>
	 * </ul>
	 */
	private static List<String> valeursPossibles;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(CiviliteComplete.class);



	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CiviliteComplete() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CiviliteComplete() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR CiviliteComplete(
	 * String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pCiviliteString : String : Civilité complète 
	 * (MONSIEUR, MADAME, ...).<br/>
	 */
	public CiviliteComplete(
			final String pCiviliteString) {
		
		this(null, pCiviliteString);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR CiviliteComplete(
	 * Long pId
	 * , String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCiviliteString : String : Civilité complète 
	 * (MONSIEUR, MADAME, ...).<br/>
	 */
	public CiviliteComplete(
			final Long pId
				, final String pCiviliteString) {
		
		super(pId, pCiviliteString);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("CiviliteComplete [");
		
		builder.append("id=");
		if (this.id != null) {
			builder.append(this.id);
		} else {
			builder.append(NULL);			
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("civilité=");
		if (this.civiliteString != null) {
			builder.append(this.civiliteString);
		} else {
			builder.append(NULL);			
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________


		
	/**
	 * method getValeursPossibles() :<br/>
	 * <ul>
	 * <li>retourne la Liste des valeurs possibles pour civiliteString 
	 * fournie par CivilitesEnum.</li>
	 * <li>MONSIEUR, MADAME, MADEMOISELLE.</li>
	 * </ul>
	 *
	 * @return : List&lt;String&gt; : valeursPossibles.<br/>
	 */
	public static final List<String> getValeursPossibles() {
		
		synchronized (CiviliteComplete.class) {
			
			if (valeursPossibles == null) {
				
				valeursPossibles = new ArrayList<String>();
				
				final CivilitesEnum[] valeurs = CivilitesEnum.values();
				
				for (int i = 0; i < valeurs.length; i ++) {
					valeursPossibles.add(valeurs[i].toString());
				}
				
			}
					
			return valeursPossibles;
			
		} // Fin de synchronized._________________________________
				
	} // Fin de getValeursPossibles()._____________________________________
	
	
	
} // FIN DE LA CLASSE CiviliteComplete.--------------------------------------

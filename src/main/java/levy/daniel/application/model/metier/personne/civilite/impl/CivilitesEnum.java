package levy.daniel.application.model.metier.personne.civilite.impl;



/**
 * ENUMERATION CivilitesEnum :<br/>
 * <ul>
 * <li>Enumération permettant de limiter les civilités (M., Mme, ...) 
 * d'un UserSimple.</li>
 * <li>Le constructeur et les accesseurs permettent 
 * d'accéder aux abréviations des civilités ("M." pour MONSIEUR).</li>
 * </ul>
 * <br/>
 *
 *
 * - Exemple d'utilisation :<br/>
 * <code>// Récupère l'abréviation "M." dans l'Enumération.</code><br/>
 * <code>String CIVILITE_M = 
 * CivilitesEnum.MONSIEUR.getAbreviationEnum();</code><br/>
 * <br/>
 * <code>//Instanciation d'un Civilite en lui passant la String 
 * associée à l'instance MONSIEUR de l'énumération.</code><br/>
 * <code>Civilite CIVILITE_M = new 
 * Civilite(CivilitesEnum.MONSIEUR.toString());</code><br/>
 *<br/>
 * 
 * 
 * - Mots-clé :<br/>
 * Enumeration, enumeration, enumeration.toString(),<br/>
 * constructeur private, <br/>
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
public enum CivilitesEnum {
	
	/**
	 * MONSIEUR : CivilitesEnum :<br/>
	 * MONSIEUR("M.").<br/>
	 * "M." est l'abréviation de l'<b>instance</b> 
	 * de CivilitesEnum MONSIEUR.<br/>
	 */
	MONSIEUR("M.")
	
	, /**
	 * MADAME : CivilitesEnum :<br/>
	 * MADAME("Mme").<br/>
	 * "Mme" est l'abréviation de l'<b>instance</b> 
	 * de CivilitesEnum MADAME.<br/>
	 */
	MADAME("Mme")
	
	
	, /**
	 * MADEMOISELLE : CivilitesEnum :<br/>
	 * MADEMOISELLE("Mlle").<br/>
	 * "Mme" est l'abréviation de l'<b>instance</b> 
	 * de CivilitesEnum MADAME.<br/>
	 */
	MADEMOISELLE("Mlle");

	
	/**
	 * abreviationEnum : String :<br/>
	 * Abréviation de l'instance de l'Enumération.<br/>
	 * Par exemple "M." pour MONSIEUR.<br/>
	 */
	private String abreviationEnum;
	
	
	
	 /**
	 * method CONSTRUCTEUR CivilitesEnum(
	 * String pAbreviationEnum) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * forcément <b>private</b> afin de préserver 
	 * les valeurs définies dans l'enum.<br/>
	 * <br/>
	 *
	 * @param pAbreviationEnum : String.<br/>
	 */
	CivilitesEnum(
			final String pAbreviationEnum) {
		this.abreviationEnum = pAbreviationEnum;
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * method getAbreviationEnum() :<br/>
	 * Getter de l'Abréviation de l'instance de l'Enumération.<br/>
	 * Par exemple "M." pour MONSIEUR.<br/>
	 * <br/>
	 *
	 * @return abreviationEnum : String.<br/>
	 */
	public final String getAbreviationEnum() {	
		return this.abreviationEnum;
	} // Fin de getAbreviationEnum().______________________________________


	
	/**
	* method setAbreviationEnum(
	* String pAbreviationEnum) :<br/>
	* Setter de l'Abréviation de l'instance de l'Enumération.<br/>
	* Par exemple "M." pour MONSIEUR.<br/>
	* <br/>
	*
	* @param pAbreviationEnum : String : 
	* valeur à passer à abreviationEnum.<br/>
	*/
	public final void setAbreviationEnum(
			final String pAbreviationEnum) {	
		this.abreviationEnum = pAbreviationEnum;
	} // Fin de setAbreviationEnum(...).___________________________________
	
	
	
} // FIN DE ENUMERATION CivilitesEnum.---------------------------------------

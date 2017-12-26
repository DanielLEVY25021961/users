package levy.daniel.application.model.metier.user.usersimple.impl;



/**
 * ENUMERATION ProfilsSimplesEnum :<br/>
 * <ul>
 * <li>
 * Enumération permettant de <i>limiter</i> les valeurs possibles de 
 * l'attribut <b>profil</b> (Objet <b>ProfilSimple</b>) 
 * d'un <b>UserSimple</b> avec des instances de ProfilSimple encapsulant 
 * un attribut profilString limité par la présente énumération comme 
 * ADMINISTRATEUR, UTILISATEUR, ...
 * </li>
 * 
 * <br/>
 * 
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/Implementation_ProfilSimple.png" 
 * alt="Enumération ProfilsSimplesEnum" border="1" align="center" />
 * </li>
 * <br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code>// Récupère une instance de 
 * <b>ProfilsSimplesEnum</b>.</code><br/>
 * <code>ProfilsSimplesEnum ADMINISTRATEUR 
 * = ProfilsSimplesEnum.ADMINISTRATEUR;</code><br/>
 * <br/>
 * <code>// Récupère la <b>String</b> associée à l'instance 
 * "ADMINISTRATEUR" de ProfilsSimplesEnum
 * dans l'Enumération.</code><br/>
 * <code>String PROFIL_ADMIN = 
 * ProfilsSimplesEnum.ADMINISTRATEUR.toString();</code><br/>
 * <br/>
 * <code>// Instancie un <b>ProfilSimple</b> associée à l'instance 
 * "ADMINISTRATEUR" de ProfilsSimplesEnum
 * dans l'Enumération.</code><br/>
 * <code>ProfilSimple ADMIN = new ProfilSImple(
 * ProfilsSimplesEnum.ADMINISTRATEUR.toString());</code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enumeration, énumération, utilisation enum,<br/>
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
public enum ProfilsSimplesEnum {

	
	/**
	 * ADMINISTRATEUR : ProfilsSimplesEnum :<br/>
	 * Profil qui peut tout voir dans l'application.<br/>
	 */
	ADMINISTRATEUR

	
	, /**
	 * GESTIONNAIRE_DONNEES : ProfilsSimplesEnum :<br/>
	 * Profil qui peut téléverser des données dans l'application 
	 * mais ne peut voir que ce qui concerne sa zone géographique.<br/>
	 */
	GESTIONNAIRE_DONNEES
	
	
	, /**
	 * UTILISATEUR : ProfilsSimplesEnum :<br/>
	 * Profil qui ne peut que consulter les pages 
	 * <b>publiques</b> de l'application.<br/>
	 */
	UTILISATEUR;
	

} // FIN DE ENUMERATION ProfilsSimplesEnum.----------------------------------

/**
 * class package-info :<br/>
 * <ul>
 * Ce package contient toutes les classes définissant un 
 * <b>UserSimple</b>, c'est à dire un User (Internaute) qui se logge 
 * à l'application et qui n'a pas plusieurs <i>profils</i> 
 * ou <i>Rôles</i>.
 * <li>
 * Le <b>profil</b> d'un UserSimple est <b>un Objet ProfilSimple</b>
 * , mais ProfilSimple 
 * contient une <i>simple String</i> provenant d'une <b>énumération</b> 
 * ProfilsSimplesEnum.
 * </li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">ATTRIBUTS</span>
 * </p>
 * <li>Les <b>attributs</b> d'un UserSimple sont : </li>
 * <ul>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>civilite</b> (M., Mme, ...).</li>
 * <li><b>prenom</b>.</li>
 * <li><b>nom</b>.</li>
 * <li><b>email</b>.</li>
 * <li><b>login</b>.</li>
 * <li><b>mot de passe (mdp)</b>.</li>
 * <li><b>profil</b> (Adminstrateur, Utilisateur, ...).</li>
 * </ul>
 * 
 * <br/>
 * <li>
 * La Civilité est un <b>Objet</b> contenant une <i>simple String</i> 
 * provenant d'une <b>énumération</b> CivilitesEnum.
 * </li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <li>
 * L'<b>égalité metier</b> d'un UserSimple est vérifiée sur :
 * <ul>
 * <li><b>login</b></li>
 * <li><b>mdp</b></li>
 * </ul>
 * </li>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">
 * DIAGRAMME DE CLASSES AVEC LES COMPOSANTS
 * </span>
 * </p>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_UserSimple_Enumerations.png" 
 * alt="implémentation du UserSimple avec énumérations" border="1" align="center" />
 * </li>
 * <br/>
 * <li>
 * Le diagramme de classes simplifié (sans les composants et énumérations) 
 * peut se résumer à : 
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_UserSimple.png" 
 * alt="implémentation du UserSimple sans énumérations" border="1" align="center" />
 * </li>
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
 * @author dan Lévy
 * @version 1.0
 * @since 25 sept. 2017
 *
 */
package levy.daniel.application.model.metier.user.usersimple;

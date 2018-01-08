package levy.daniel.application.model.metier.user.usersimple;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;
import levy.daniel.application.model.metier.user.usersimple.impl.Civilite;
import levy.daniel.application.model.metier.user.usersimple.impl.ProfilSimple;

/**
 * INTERFACE IUserSimple :<br/>
 * <p>
 * Modélise un <b>User</b>, c'est à dire un 
 * <b>utilisateur de l'application</b> qui doit se connecter 
 * à l'application via un <b>login</b> <i>et</i> un mot de passe <b>mdp</b>.
 * </p>
 * <p>
 * un <b>UserSimple</b> modélise un User (Internaute) qui se logge 
 * à l'application et qui n'a pas plusieurs <i>profils</i> 
 * ou <i>Rôles</i> (ADMINISTRATEUR, UTILISATEUR, ...) 
 * dans l'application.<br/>
 * Le UserSimple n'a <b>qu'un seul profil</b> ou rôle 
 * dans l'application.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE de :
 * </span>
 * </p>
 * <li><b>IExportateurCsv</b> pour l'export d'un Objet 
 * métier en csv.</li>
 * <li><b>IExportateurJTable</b> pour l'affichage dans 
 * une JTable (Swing).</li>
 * <li><b>Comparable</b> pour l'affichage des Collections 
 * sous forme triée.</li>
 * <li><b>Cloneable</b> pour garantir que tout objet métier 
 * implémentant cette interface saura se cloner.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout UserSimple sait :
 * </span>
 * </p>
 * <li>se <b>comparer</b> à un autre IUserSimple.</li>
 * <li>se <b>cloner</b>.</li>
 * <li>s'exporter sous forme <b>csv</b>.</li>
 * <li>s'exporter sous forme <b>JTable</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout UserSimple possède :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>civilite</b> (M., Mme, ...).</li>
 * <li><b>prenom</b>.</li>
 * <li><b>nom</b>.</li>
 * <li><b>e-mail</b>.</li>
 * <li><b>login</b>.</li>
 * <li><b>mot de passe</b>.</li>
 * <li><b>profil</b> (Adminstrateur, Utilisateur, ...).</li>
 * </ul>
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
 * <span style="text-decoration: underline;">INTERFACES ET HERITAGE</span>
 * </p>
 * <li>l'objet UserSimple implémente l'INTERFACE IUserSimple : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_UserSimple.png" 
 * alt="implémentation du UserSimple" border="1" align="center" />
 * </li>
 *
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">REGLES DE GESTION</span>
 * </p>
 * <ul>
 * <li>
 * Les <b>Règles de Gestion (RG)</b> applicables aux attributs 
 * d'un UserSimple sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * <tr>
 * <td>civilite</td>
 * <td>"RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : la civilite (M., Mme, ...) 
 * du UserSimple doit respecter un ensemble fini de valeurs (nomenclature)"</td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">
 * prenom
 * </td>
 * <td>
 * "RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : le prénom du UserSimple 
 * doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_PRENOM_LITTERAL_03 : le prénom du UserSimple ne 
 * doit contenir que des lettres ou des caractères spéciaux 
 * '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_PRENOM_LONGUEUR_04 : le prénom du UserSimple 
 * doit contenir entre [1] et [30] lettres"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">nom</td>
 * <td>"RG_USERSIMPLE_NOM_RENSEIGNE_05 : le nom du UserSimple 
 * doit être renseigné (obligatoire)"</td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_NOM_LITTERAL_06 : le nom du UserSimple 
 * ne doit contenir que des lettres ou des caractères spéciaux 
 * '-', '_', ... (aucun chiffre)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_NOM_LONGUEUR_07 : le nom du UserSimple 
 * doit contenir entre [1] et [50] lettres"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td>email</td>
 * <td>"RG_USERSIMPLE_EMAIL_MOTIF_08 : l'email du UserSimple 
 * doit respecter un motif (Regex) d'un email 
 * (du type albacor.trust@google.fr)"</td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * login
 * </td>
 * <td>
 * "RG_USERSIMPLE_LOGIN_RENSEIGNE_09 : le login 
 * du UserSimple doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_LOGIN_LONGUEUR_10 : le login du UserSimple
 *  doit contenir entre [1] et [100] caractères"
 *  </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="3">
 * mdp
 * </td>
 * <td>
 * "RG_USERSIMPLE_MDP_RENSEIGNE_11 : le mdp du UserSimple
 *  doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_MDP_LONGUEUR_12 : le mdp du UserSimple
 *  doit contenir entre [3] et [20] caractères"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_MDP_MOTIF_13 : le mdp du UserSimple
 *  doit respecter un motif (Regex)"
 * </td>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * profil
 * </td>
 * <td>
 * "RG_USERSIMPLE_PROFIL_RENSEIGNE_14 : le profil du UserSimple
 *  doit être renseigné (obligatoire)"
 * </td>
 * </tr>
 * <tr>
 * <td>
 * "RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 : le profil du UserSimple
 *  doit respecter un ensemble fini de valeurs (nomenclature)"
 * </td>
 * </tr>
 * </table>
 * </ul>
 * <br/>
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
public interface IUserSimple 
	extends IExportateurCsv, IExportateurJTable
		, Comparable<IUserSimple>, Cloneable {


	
	/**
	 * method compareTo(
	 * IUserSimple pUserSimple) :<br/>
	 * <ol>
	 * Comparaison de 2 UserSimple par rapport : <br/>
	 * <li>au login.</li>
	 * <li>au mot de passe.</li>
	 * </ol>
	 *
	 * @param pUserSimple : IUserSimple.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pUserSimple.<br/>
	 */
	@Override
	int compareTo(IUserSimple pUserSimple);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un IUserSimple.<br/>
	 * <br/>
	 *
	 * @return IUserSimple : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IUserSimple clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un UserSimple</b> :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	Object getValeurColonne(int pI);
	
	

	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();

	
	
	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);
	
	

	/**
	 * method getCivilite() :<br/>
	 * Getter de la Civilité du UserSimple (M., Mme, Mlle, ...).<br/>
	 * <ul>
	 * <li>La civilité ne peut prendre <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
	 * <li>"RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
	 * la civilite (M., Mme, ...) du UserSimple doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 *
	 * @return civilite : Civilite.<br/>
	 */
	Civilite getCivilite();
	
	

	/**
	* method setCivilite(
	* String pCivilite) :<br/>
	* Setter de la Civilité du UserSimple (M., Mme, Mlle, ...).<br/>
	* <br/>
	*
	* @param pCivilite : Civilite : valeur à passer à civilite.<br/>
	*/
	void setCivilite(Civilite pCivilite);
	
	

	/**
	 * method getPrenom() :<br/>
	 * Getter du Prénom du User.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : 
	 * le prénom du UserSimple doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_PRENOM_LITTERAL_03 : 
	 * le prénom du UserSimple 
	 * ne doit contenir que des lettres ou des 
	 * caractères spéciaux '-', '_', ... (aucun chiffre)".</li>
	 * <li>"RG_USERSIMPLE_PRENOM_LONGUEUR_04 : 
	 * le prénom du UserSimple doit contenir 
	 * entre [1] et [30] lettres".</li>
	 * </ul>
	 *
	 * @return prenom : String.<br/>
	 */
	String getPrenom();
	
	

	/**
	* method setPrenom(
	* String pPrenom) :<br/>
	* Setter du Prénom du User.<br/>
	* <br/>
	*
	* @param pPrenom : String : valeur à passer à prenom.<br/>
	*/
	void setPrenom(String pPrenom);
	
	

	/**
	 * method getNom() :<br/>
	 * Getter du Nom du User.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_NOM_RENSEIGNE_05
	 *  : le nom du UserSimple doit être renseigné (obligatoire)".<br/></li>
	 *  <li>"RG_USERSIMPLE_NOM_LITTERAL_06
	 *  : le nom du UserSimple 
	 *  ne doit contenir que des lettres ou des caractères spéciaux 
	 *  '-', '_', ... (aucun chiffre)".</li>
	 *  <li>
	 *  "RG_USERSIMPLE_NOM_LONGUEUR_07
	 *  : le nom du UserSimple doit contenir entre 
	 *  [1] et [50] lettres".
	 *  </li>
	 * </ul>
	 *
	 * @return nom : String.<br/>
	 */
	String getNom();
	
	

	/**
	* method setNom(
	* String pNom) :<br/>
	* Setter du Nom du User.<br/>
	* <br/>
	*
	* @param pNom : String : valeur à passer à nom.<br/>
	*/
	void setNom(String pNom);
	
	

	/**
	 * method getEmail() :<br/>
	 * Getter de l'E-mail du UserSimple.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_EMAIL_MOTIF_08
	 *  : l'email du UserSimple doit respecter un motif (Regex) 
	 *  d'un email (du type albacor.trust@google.fr)".<br/></li>
	 * </ul>
	 *
	 * @return email : String.<br/>
	 */
	String getEmail();
	
	

	/**
	* method setEmail(
	* String pEmail) :<br/>
	* Setter de l'E-mail du UserSimple.<br/>
	* <br/>
	*
	* @param pEmail : String : valeur à passer à email.<br/>
	*/
	void setEmail(String pEmail);
	
	

	/**
	 * method getLogin() :<br/>
	 * Getter du Login.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_LOGIN_RENSEIGNE_09
	 *  : le login du UserSimple
	 *   doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_LOGIN_LONGUEUR_10
	 *  : le login du UserSimple 
	 *  doit contenir entre [1] et [100] caractères".</li>
	 * </ul>
	 *
	 * @return login : String.<br/>
	 */
	String getLogin();
	
	

	/**
	* method setLogin(
	* String pLogin) :<br/>
	* Setter du Login.<br/>
	* <br/>
	*
	* @param pLogin : String : valeur à passer à login.<br/>
	*/
	void setLogin(String pLogin);
	
	

	/**
	 * method getMdp() :<br/>
	 * Getter du Mot de passe.<br/>
	 * <ul>
	 * <li>"RG_USERSIMPLE_MDP_RENSEIGNE_11
	 *  : le mdp du UserSimple
	 *   doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_MDP_LONGUEUR_12
	 *  : le mdp du UserSimple
	 *   doit contenir entre [3] et [20] caractères".</li>
	 * <li>"RG_USERSIMPLE_MDP_MOTIF_13
	 *  : le mdp du UserSimple
	 *   doit respecter un motif (Regex)".</li>
	 * </ul>
	 *
	 * @return mdp : String.<br/>
	 */
	String getMdp();
	
	

	/**
	* method setMdp(
	* String pMdp) :<br/>
	* Setter du Mot de passe.<br/>
	* <br/>
	*
	* @param pMdp : String : valeur à passer à mdp.<br/>
	*/
	void setMdp(String pMdp);
	
	

	/**
	 * method getProfil() :<br/>
	 * Getter du Profil du UserSimple 
	 * (administrateur, modérateur, ...).<br/>
	 * <ul>
	 * <li>Le profil ne peut prendre <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>ProfilsSimplesEnum</b>.</li>
	 * <li>"RG_USERSIMPLE_PROFIL_RENSEIGNE_14
	 *  : le profil du UserSimple
	 *   doit être renseigné (obligatoire)".</li>
	 * <li>"RG_USERSIMPLE_PROFIL_NOMENCLATURE_15
	 *  : le profil du UserSimple
	 *   doit respecter un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 *
	 * @return profil : ProfilSimple.<br/>
	 */
	ProfilSimple getProfil();
	
	

	/**
	* method setProfil(
	* ProfilSimple pProfil) :<br/>
	* Setter du Profil du UserSimple 
	* (administrateur, modérateur, ...).<br/>
	* <br/>
	*
	* @param pProfil : String : valeur à passer à profil.<br/>
	*/
	void setProfil(ProfilSimple pProfil);
	
	

} // FIN DE L'INTERFACE IUserSimple.-----------------------------------------
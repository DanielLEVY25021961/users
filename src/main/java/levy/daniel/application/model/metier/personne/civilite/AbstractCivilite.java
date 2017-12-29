package levy.daniel.application.model.metier.personne.civilite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractCivilite :<br/>
 * .<br/>
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
 * @since 29 déc. 2017
 *
 */
public class AbstractCivilite implements ICivilite {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractCivilite.class);
	

	// *************************METHODES************************************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(ICivilite pObject) {

		// TODO Auto-generated method stub
		return 0;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICivilite clone() throws CloneNotSupportedException {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEnTeteCsv() {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEnTeteColonne(int pI) {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValeurColonne(int pI) {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(Long pId) {

		// TODO Auto-generated method stub

	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCiviliteString() {

		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCiviliteString(String pCivilite) {

		// TODO Auto-generated method stub

	}


	
}

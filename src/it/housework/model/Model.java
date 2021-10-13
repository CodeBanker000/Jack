/**
 * 
 */
package it.housework.model;

import it.housework.db.UsersDAO;

/**
 * @author mtank
 *
 */
public class Model {

	public Model () {}
	
	public User findUser(String user, String pass) 
	{
		UsersDAO dao = new UsersDAO();
		
		return dao.search(user, pass);
	}
	
}

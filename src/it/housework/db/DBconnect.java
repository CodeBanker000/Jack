/**
 * 
 */
package it.housework.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * Handle the connection for PostgreSQL, create a static object that contains 
 * connection pool
 * 
 * @author 	Matteo Tancredi <matteotank@gmail.com>
 * @version 1.0
 */
public class DBconnect
{
	/** position of driver jdbc of postgreSQL */
	private final static String jdbcURL = "jdbc:postgresql://localhost:5432/db_ristobar_dev";
	
	/** username of database */
	private final static String user = "postgres";
	
	/** password of database */
	private final static String pass = "mtank";
	
	/** Object :: DataSource */
	private static DataSource ds;
	
	/**
	 * Create the connection to the database if throws an excetion
	 * return null
	 * @return the connection or null
	 */
	public static Connection getConnection()
	{
		//create the DataSource
		if (ds == null) {
			try {
				ds = DataSources.pooledDataSource(
						DataSources.unpooledDataSource(jdbcURL, user, pass));
			} catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		//create the connection
		try {
			Connection c = ds.getConnection();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

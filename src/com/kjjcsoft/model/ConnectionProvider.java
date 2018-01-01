/**
 * 
 */
package com.kjjcsoft.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.kjjcsoft.model.Provider.*;

/**
 * @author Seekraw
 *
 */
public class ConnectionProvider {
private static Connection con=null;
public static Connection getConnection(){
	try {
		Class.forName(DRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		con=DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}

}

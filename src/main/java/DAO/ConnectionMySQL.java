package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL{

	/**
	 * URL de connection
	 */
	private static String url = "jdbc:mysql://localhost/test";
	/**
	 * Nom du user
	 */
	private static String user = "user";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "password";
	/**
	 * Objet Connection
	 */
	private static Connection connect;
	
	private ConnectionMySQL()  {
		
	};
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 * @throws ClassNotFoundException 
	 */
	public static Connection getInstance() throws ClassNotFoundException{
		if(connect == null){
			try {
	            Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
}
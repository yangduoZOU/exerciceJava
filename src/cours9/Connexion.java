package cours9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {

	Connection con = null;
	
	public Connexion() {
		Chargement();
		try {
			String url = "jdbc:mysql://localhost:3306/?user=root";
			Properties props = new Properties();
			props.setProperty("user","root");
	    	props.setProperty("password","zyd987210!");
			con = DriverManager.getConnection(url, props);
			System.out.println("Connexion à la base données");			
		} catch (SQLException ex) {
			System.out.println("Erreur de connexion à la base données");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private void Chargement() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Chargement du pilote");
		} catch (Exception ex) {
			System.out.println("Erreur de chargement du pilote");
		}
	}
	
	public Connection getConnexion() {
			return con;
}
	
	public void close() {
		try {
		con.close();
		System.out.println("Fermeture de connexion à la base données");
		}
		catch (SQLException ex) {
			System.out.println("Erreur de fermeture de connexion à la base données");
		}
		}

}
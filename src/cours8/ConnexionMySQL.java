package cours8;

import java.sql.*;

public class ConnexionMySQL {
	public static void main(String[] args) {
        // Informations de connexion
        String url = "jdbc:mysql://localhost:3306/?user=root/student";
        String utilisateur = "root";
        String motDePasse = "zyd987210!";

        // Connexion à la base de données
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données établie !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        } finally {
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }
}
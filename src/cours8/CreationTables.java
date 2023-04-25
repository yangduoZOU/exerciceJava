package cours8;

import java.sql.*;

public class CreationTables {
    public static void main(String[] args) {
        // Informations de connexion
    	String url = "jdbc:mysql://localhost:3306/?user=root/ZOU";
        String utilisateur = "root";
        String motDePasse = "zyd987210!";

        // Connexion à la base de données
        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données établie !");

            // Création de la table Etudiant
            Statement statement = connexion.createStatement();
            String sql = "CREATE TABLE ZOU.Etudiant " +
                         "(Nom VARCHAR(255), " +
                         "Age INT, " +
                         "Niveau VARCHAR(255))";
            statement.executeUpdate(sql);
            System.out.println("Table Etudiant créée avec succès !");

            // Création de la table Livre
            sql = "CREATE TABLE ZOU.Livre " +
                  "(Titre VARCHAR(255), " +
                  "Auteur VARCHAR(255), " +
                  "Date DATE)";
            statement.executeUpdate(sql);
            System.out.println("Table Livre créée avec succès !");

            // Création de la table Groupe
            sql = "CREATE TABLE ZOU.Groupe " +
                  "(Nom VARCHAR(255), " +
                  "Taille INT, " +
                  "Date DATE)";
            statement.executeUpdate(sql);
            System.out.println("Table Groupe créée avec succès !");
            
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création de la table : " + e.getMessage());
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

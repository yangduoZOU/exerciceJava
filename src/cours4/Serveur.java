package cours4;

import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Créer un socket d'écoute sur le port 5000
            ServerSocket serveurSocket = new ServerSocket(5001);
            
            System.out.println("Serveur en attente de connexions...");
            
            // Attendre qu'un client se connecte
            Socket clientSocket = serveurSocket.accept();
            
            System.out.println("Client connecté !");
            
            // Ouvrir un flux d'entrée depuis le client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            // Ouvrir un flux de sortie vers le client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Lire une chaîne de caractères envoyée par le client
            String message = in.readLine();
            
            // Afficher le message reçu
            System.out.println("Message reçu : " + message);
            
            // Envoyer une réponse au client
            out.println("Bonjour, client !");
            
            // Fermer les flux et le socket
            in.close();
            out.close();
            clientSocket.close();
            serveurSocket.close();
        } catch (IOException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}

/* Le programme Serveur écoute sur le port 5000, attend qu'un client se connecte,
 * puis ouvre un flux d'entrée et un flux de sortie pour communiquer avec le client. 
 * Il lit une chaîne de caractères envoyée par le client, l'affiche à l'écran, puis envoie une réponse.
 * Le programme Client se connecte au serveur sur le port 5000,
 * ouvre un flux d'entrée et un flux de sortie pour communiquer avec le serveur.
 * Il envoie une chaîne de caractères au serveur, lit la réponse, puis l'affiche à l'écran.
 * Pour tester ce programme, vous pouvez d'abord lancer le Serveur,
 * puis lancer un ou plusieurs Clients et observer les messages échangés entre le Serveur et les Clients.
 * */

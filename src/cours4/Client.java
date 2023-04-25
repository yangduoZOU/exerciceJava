package cours4;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Créer un socket client et se connecter au serveur sur le port 5000
            Socket clientSocket = new Socket("localhost", 5001);
            
            // Ouvrir un flux de sortie vers le serveur
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Ouvrir un flux d'entrée depuis le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            // Envoyer un message au serveur
            out.println("Bonjour, serveur !");
            
            // Lire la réponse du serveur
            String reponse = in.readLine();
            
            // Afficher la réponse du serveur
            System.out.println("Réponse du serveur : " + reponse);
            
            // Fermer les flux et le socket
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}

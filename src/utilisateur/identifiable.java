package utilisateur;

import utilisateur.admin.AdminEmploye;
import utilisateur.admin.Administrateur;
import utilisateur.admin.PropriètaireduPharmacie;

import java.util.Scanner;

public interface identifiable {
    Scanner scanner = new Scanner(System.in);

    static Client inscription() {
        int id = 0;

        String prénom = null;
        String nom = null;
        String email = null;
        int telephone = 0;
        String genre = null;
        String password = null;
        while (email == null && password == null) {
            System.out.println("donner votre prénom:");
            prénom = scanner.nextLine();

            System.out.println("donner votre nom:");

            nom = scanner.nextLine();


            email = getEmail();

            System.out.println("password:");
            password = scanner.nextLine();


            System.out.println("telephone");

            telephone = scanner.nextInt();
            scanner.nextLine();


            System.out.println("saisir votre genre");
            genre = scanner.nextLine();


        }
        Client client = new Client(prénom, nom, email, password, telephone, genre, null, null);

        return client;
    }
    static AdminEmploye inscriptionAdmin() {

        String prénom = null;
        String nom = null;
        String email = null;
        int telephone = 0;
        String genre = null;
        String password = null;
        while (email == null && password == null) {
            System.out.println("donner votre prénom:");
            prénom = scanner.nextLine();

            System.out.println("donner votre nom:");

            nom = scanner.nextLine();


            email = getEmail();

            System.out.println("password:");
            password = scanner.nextLine();


            System.out.println("telephone");

            telephone = scanner.nextInt();
            scanner.nextLine();


            System.out.println("saisir votre genre");
            genre = scanner.nextLine();


        }
        AdminEmploye adminEmploye = new AdminEmploye(prénom, nom, email, telephone, genre, password);

        return adminEmploye;
    }

    static Client identificationClient(String email, String password) {
        for (Client client : Client.listeClient
        ) {
            if (client.getEmail().equals(email) && client.getPassword().equals(password)) {

                return client;
            }
        }
        return null;
    }

    static Administrateur identificationVendeur(String email, String password) {
        for (Administrateur admin : Administrateur.listeAdmin
        ) {
            if (admin.email.equals(email) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    static PropriètaireduPharmacie identificationGérant(String email, String password) {
            PropriètaireduPharmacie gerant=MenuPropriètaireduPharmacie.propriètaireduPharmacie;
            if (gerant.getEmail().equals(email)
                    && gerant.getPassword().equals(password)) {
                return gerant;
            }

        return null;
    }


    static boolean inscritOuNon() {
        System.out.println("inscrit  ou non ? si oui mettez 1 sinon mettez 2");
        String reponse = scanner.next();
        scanner.nextLine();
        return reponse.equals("1");
    }


    static String getEmail() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir votre email");
        String email = scanner.nextLine();
        for (Client client : Client.listeClient
        ) {
            if (client.getEmail().equals(email)) {

                return null;

            }

        }
        return email;

    }

    static String getPassword() {
        System.out.println("donner votre password");
        String password = scanner.nextLine();
        return password;
    }

    public static String vendeurOuClient() {
        System.out.println("Client Ou administrateur si client entrez 1 sinon entrez 2");
        Scanner scanner = new Scanner(System.in);
        String utilisateur = scanner.next();
        switch (utilisateur) {
            case "1":
                MenuClient.affichageClient();
            case "2":
                MenuAdministrateur.affichageVendeur();
        }
        scanner.nextLine();
        return utilisateur;
    }


}

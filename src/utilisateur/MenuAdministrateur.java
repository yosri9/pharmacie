package utilisateur;

import produit.Accessoire;
import produit.Medicament;
import produit.Produit;
import utilisateur.admin.AdminEmploye;
import utilisateur.admin.Administrateur;

import java.util.Scanner;
import java.util.Set;

public class MenuAdministrateur {



    public static void affichageVendeur() {
        boolean reponse = identifiable.inscritOuNon();
        if (reponse) {

            String email = identifiable.getEmail();
            String password = identifiable.getPassword();

            if (identifiable.identificationVendeur(email, password) != null) {
                Administrateur admin = identifiable.identificationVendeur(email, password);
                listerChoixVendeur();
                choisirChoixVendeur();


            } else {
                System.out.println("verifiez vous données ");
                listerChoixVendeur2();
                choisirChoixVendeur2();
            }
        } else {
            Client client = identifiable.inscription();
            if (client.getEmail() == null) {
                System.out.println("ce compte est déja inscrit");
                listerChoixVendeur2();
                choisirChoixVendeur2();
            } else {
                Client.listeClient.add(client);
                listerChoixVendeur();
                choisirChoixVendeur();
            }


        }
    }






   private static void listerChoixVendeur() {
        Set<String>listechoix=null;
        listechoix.add("ajouterProduit");
        listechoix.add("ajouterMedicament");
        listechoix.add(" ajouterAccessoir");
        listechoix.add("supprimerProduit");
        listechoix.add("supprimerMedicament");
        listechoix.add(" supprimerAccessoir");
    }
   private static void  choisirChoixVendeur() {
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        scanner.nextLine();
        switch (choix) {
            case "1":
                Administrateur.ajouterProduit(Produit.CreerNouveauProduit());
            case "2":
                Administrateur.ajouterMedicament(Medicament.CreerNouveauMedicament());
            case "3":
                Administrateur.ajouterAccessoir((Accessoire) Produit.CreerNouveauProduit());
            case "4":
                Administrateur.supprimerProduit(saisirproduitaSupprimer());
            case "5":
                Administrateur.supprimerMedicament(saisirMedicamentaSupprimer());
            case "6":
                Administrateur.supprimerAccessoir(saisirAccessoireaSupprimer());
            case "7":identifiable.vendeurOuClient();
        }
    }

    private static Produit saisirproduitaSupprimer() {
        System.out.println("saisire le nom du produit à supprimer");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Produit produit: Administrateur.listeProduitAjouté
             ) {
            if (produit.getNom().equals(nomProduit)){
               return produit;
            }
        }
        System.out.println("le produit n existe pas déja");

        return null;
    }

    private static Medicament saisirMedicamentaSupprimer() {
        System.out.println("saisire le nom du produit à supprimer");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Medicament medicament: Administrateur.listeMedicamentsAjouté
        ) {
            if (medicament.getNom().equals(nomProduit)){
                return medicament;
            }
        }
        System.out.println("le produit n existe pas déja");

        return null;
    }

    private static Accessoire saisirAccessoireaSupprimer() {
        System.out.println("saisire le nom du produit à supprimer");
        Scanner scanner = new Scanner(System.in);
        String nomAccessoire = scanner.next();
        for (Accessoire accessoire: Administrateur.listeAccessoirAjouté
        ) {
            if (accessoire.getNom().equals(nomAccessoire)){
                return accessoire;
            }
        }
        System.out.println("Accessoire n existe pas déja");

        return null;
    }

    private static void listerChoixVendeur2() {
        System.out.println("1 :login  ,2 :quitter");
    }
    private static void choisirChoixVendeur2() {
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        scanner.nextLine();
        switch (choix) {
            case "1":
                MenuClient.affichageClient();
            case "2":
                identifiable.inscription();
            case "3": identifiable.vendeurOuClient();
        }
    }


}

// email et mot de passe par defaut
//update profile
//l'ajout ou supprissiion d'admin
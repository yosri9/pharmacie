package utilisateur;

import produit.Accessoire;
import produit.Medicament;
import produit.Produit;
import utilisateur.admin.AdminEmploye;
import utilisateur.admin.Administrateur;
import utilisateur.admin.PropriètaireduPharmacie;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MenuPropriètaireduPharmacie extends MenuAdministrateur {
    static PropriètaireduPharmacie propriètaireduPharmacie = new PropriètaireduPharmacie(null, null,
            "pharmacie@exemple.com", 0, null, "password");

    public static void affichagePropriètaireduPharmacie() {

        String email = identifiable.getEmail();
        String password = identifiable.getPassword();

        if (identifiable.identificationGérant(email, password) != null) {
            PropriètaireduPharmacie gérant = identifiable.identificationGérant(email, password);
            listerChoixGerant();
            choisirChoixGerant();


        } else {
            System.out.println("verifiez vous données ");
            listerChoixGerant2();
            choisirChoixGerant2();
        }
    }


    public static void listerChoixGerant() {
        int i = 0;
        String listeChoix[] = {"ajouterProduit", "ajouterMedicament", "ajouterAccessoir", "supprimerProduit", "supprimerMedicament",
                "supprimerAccessoir", "Ajouter un administrateur", "Ajouter un administrateur", "voir votre gain total",
                "lister tous les produit ajoutées", "quitter"
        };

        for (String choix : listeChoix
        ) {
            i += 1;
            System.out.println(i + " :" + choix);
        }

    }

    public static void choisirChoixGerant() {
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        scanner.nextLine();
        switch (choix) {
            case "1":
                Administrateur.ajouterProduit(Produit.CreerNouveauProduit());
                listerChoixGerant();
                choisirChoixGerant();


            case "2":
                Administrateur.ajouterMedicament(Medicament.CreerNouveauMedicament());
                listerChoixGerant();
                choisirChoixGerant();
            case "3":
                Administrateur.ajouterAccessoir((Accessoire) Produit.CreerNouveauProduit());
                listerChoixGerant();
                choisirChoixGerant();
            case "4":
                Administrateur.supprimerProduit(saisirproduitaSupprimer());
                listerChoixGerant();
                choisirChoixGerant();
            case "5":
                Administrateur.supprimerMedicament(saisirMedicamentaSupprimer());
                listerChoixGerant();
                choisirChoixGerant();
            case "6":
                Administrateur.supprimerAccessoir(saisirAccessoireaSupprimer());
                listerChoixGerant();
                choisirChoixGerant();
            case "7":
                PropriètaireduPharmacie.ajoutAdminEmploye(adminEmployeaAjouter());
                break;
            case "8":
                PropriètaireduPharmacie.suppressionAdminEmploye(saisirAdminEmployeaSupprimer());
                listerChoixGerant();
                choisirChoixGerant();
                ;
            case "9":
                PropriètaireduPharmacie.gainTotal();
                listerChoixGerant();
                choisirChoixGerant();
            case "10":
                Client.listerProduits();
                listerChoixGerant();
                choisirChoixGerant();

            case "11":
                identifiable.vendeurOuClient();

        }
    }

    private static AdminEmploye saisirAdminEmployeaSupprimer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("donner le  prènom du administrateur que vous voulez supprimez");
        String nom = scanner.nextLine();
        System.out.println("donner le nom  du administrateur que vous voulez supprimez");
        String prenom = scanner.nextLine();
        for (AdminEmploye adminEmploye : PropriètaireduPharmacie.getListeEmploye()
        ) {
            if (nom.equals(adminEmploye.getNom()) && prenom.equals(adminEmploye.getPrénom())) {
                return adminEmploye;
            }
        }
        return null;
    }

    private static AdminEmploye adminEmployeaAjouter() {
        AdminEmploye adminEmploye = identifiable.inscriptionAdmin();
        return adminEmploye;
    }

    private static Produit saisirproduitaSupprimer() {
        System.out.println("saisire le nom du produit à supprimer");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Produit produit : Administrateur.listeProduitAjouté
        ) {
            System.out.println("t3ada1");

            if (produit.getTitre()==(nomProduit)) {
                System.out.println("t3ada");
                return produit;
            }
        }
        System.out.println("le produit n'existe pas déja");
        listerChoixGerant();
        choisirChoixGerant();
        return null;
    }

    private static Medicament saisirMedicamentaSupprimer() {
        System.out.println("saisire le nom du produit à supprimer");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Medicament medicament : Administrateur.listeMedicamentsAjouté
        ) {
            if (medicament.getNom().equals(nomProduit)) {
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
        for (Accessoire accessoire : Administrateur.listeAccessoirAjouté
        ) {
            if (accessoire.getNom().equals(nomAccessoire)) {
                return accessoire;
            }
        }
        System.out.println("Accessoire n existe pas déja");

        return null;
    }

    private static void listerChoixGerant2() {
        System.out.println("1 :un autre essaie  ,2 :quitter");
    }

    private static void choisirChoixGerant2() {
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        scanner.nextLine();
        switch (choix) {
            case "1":
                MenuPropriètaireduPharmacie.affichagePropriètaireduPharmacie();
            case "2":
                identifiable.vendeurOuClient();
        }
    }

}

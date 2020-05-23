package utilisateur;

import produit.*;
import utilisateur.admin.Administrateur;

import java.util.Scanner;

import static utilisateur.admin.Administrateur.*;

public abstract class Utilisateur {
    protected int id;
    protected String prénom;
    protected String nom;
    protected String email;
    protected int téléphone;
    protected String genre;
    protected String password;

    public Utilisateur(String prénom, String nom, String email, int téléphone, String genre, String password) {
        this.prénom = prénom;
        this.nom = nom;
        this.email = email;
        this.téléphone = téléphone;
        this.genre = genre;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTéléphone() {
        return téléphone;
    }

    public void setTéléphone(int téléphone) {
        this.téléphone = téléphone;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    static void listerProduits() {
        if (!Administrateur.listeProduitAjouté.isEmpty()) {
            for (Produit produit : listeProduitAjouté
            ) {
                System.out.println(produit.getNom());

            }
        } else {
            System.out.println("Aucun produit disponible");
        }
    }

    static void listerAccessoirs() {
        if (!Administrateur.listeAccessoirAjouté.isEmpty()) {
            for (Accessoire accessoire : listeAccessoirAjouté
            ) {
                System.out.println(accessoire.getNom());

            }
        } else {
            System.out.println("Aucun accessoire disponible");
        }
    }

    static void listerMedicaments() {

        if (!Administrateur.listeMedicamentsAjouté.isEmpty()) {
            for (Medicament medicament : listeMedicamentsAjouté
            ) {
                System.out.println(medicament.getNom());

            }
        } else {
            System.out.println("Aucun medicament disponible");
        }
    }

    static void rechercherProduit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donnez le nom du produit à rechercher ");
        String produitRecherché = scanner.nextLine();

        if (!Administrateur.listeProduitAjouté.isEmpty()) {
            if (listeProduitAjouté.contains(produitRecherché)) {
                System.out.println("le produit existe");
            } else {
                System.out.println("le produit n existe pas");

            }
        } else {
            System.out.println("Aucun produit disponible");
        }
    }

    static void rechercherMedicament() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donnez le nom du produit à rechercher ");
        String medicamentRecherché = scanner.nextLine();
        scanner.nextLine();

        if (!listeMedicamentsAjouté.isEmpty()) {
            for (Medicament medicament : listeMedicamentsAjouté
            ) {
                if (medicament.getNom().equals(medicamentRecherché))

                    identifiable.vendeurOuClient();

            }
        } else {
            System.out.println("Aucun medicament disponible");
        }
        identifiable.vendeurOuClient();
    }

    static void rechercherAccessoire() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Donnez le nom du l'accessoire à rechercher ");
        String accessoirecherché = scanner.nextLine();
        scanner.nextLine();

        if (!Administrateur.listeAccessoirAjouté.isEmpty()) {
            for (Accessoire accessoire : listeAccessoirAjouté
            ) {
                if (accessoire.getNom().equals(accessoirecherché))

                    identifiable.vendeurOuClient();

            }
        } else {
            System.out.println("Aucun accessoire disponible");
        }
        identifiable.vendeurOuClient();
    }

    String miseaJourEmailPassword() {
        System.out.println("saisir votre nouveau email");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("saisir votre nouveau password");
        String password = scanner.nextLine();
        System.out.println("saisir de nouveau votre nouveau password");
        String passwordVerification = scanner.nextLine();

        if (password!=passwordVerification){
            System.out.println("votre mot de passe n'est pas vérifié");
            return null;
        }else {

            this.email = email;
            this.password = password;
        }


        return "vous a avez fait le mise à jour de votre profule avec succee";
    }

}


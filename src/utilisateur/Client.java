package utilisateur;

import demande.Demande;
import produit.Medicament;
import produit.Produit;

import java.util.List;
import java.util.Scanner;

public class Client extends Utilisateur {

    Adresse adresseLivraison;
    Adresse adresseFacturation;
    List<Produit> listeSuivi;
    List<Demande> Demandes;

    public Client(
            String id,
            Adresse adresseLivraison,
            Adresse adresseFacturation,
            List<Produit> listeSuivi,
            List<Demande> Demandes,
            String prénom,
            String nom,
            String email,
            String téléphone,

            String genre) {
        super(id, prénom, nom, email, téléphone, genre);
        this.adresseFacturation = adresseFacturation;
        this.adresseLivraison = adresseLivraison;
        this.listeSuivi = listeSuivi;
        this.Demandes=Demandes;


    }
    protected static Scanner scanner = new Scanner(System.in);
    Client client;


    void ajouteràDemande(Demande demande) {
        this.client.Demandes.add(demande);
    }

    void ajouteràlisteSuivi(Produit produit) {
        this.client.listeSuivi.add(produit);
    }

    boolean existanceDemandeDansDemandes(Demande demande) {
        return this.client.Demandes.contains(demande);
    }

    boolean existanceProduitDansListeSuivi(Produit produit) {
        return this.client.listeSuivi.contains(produit);
    }

    boolean supprimerProduitdeListeSuivi(Produit produit) {
        return this.client.listeSuivi.remove(produit);
    }

    public static String lireMedicament() {
        String med;
        System.out.println("medicament acheté? ");
        med = scanner.nextLine();
        scanner.nextLine();
        return med;
    }

    public void afficherMaladie() {

        String ch;

        ch = lireMedicament();
        for (Medicament medicament :PropriètaireDuPharmacie.listeMedicamentsAjouté) {
            if (medicament.getNom().equals(ch)) {
                System.out.println(" ce medicament est pour:" + medicament.getMaladies());
            }
        }
    }
}

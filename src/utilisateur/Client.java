package utilisateur;

import demande.Demande;
import produit.Produit;

import java.util.List;

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
}

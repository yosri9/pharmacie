package utilisateur;

import produit.Produit;

import java.util.List;

public class PropriètaireDuPharmacie extends Utilisateur {
    List<Produit> listeProduitAjouté;

    public PropriètaireDuPharmacie(String id, String prénom, String nom, String email, String téléphone, String genre
            ,List<Produit> listeProduitAjouté) {
        super(id, prénom, nom, email, téléphone, genre);
        this.listeProduitAjouté=listeProduitAjouté;
    }
}

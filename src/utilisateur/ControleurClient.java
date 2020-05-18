package utilisateur;

import demande.Demande;
import produit.Produit;

public class ControleurClient {
    Client client ;

    public ControleurClient(Client client) {
        this.client = client;
    }

    void ajouteràDemande(Demande demande){
        this.client.Demandes.add(demande);
    }

    void ajouteràlisteSuivi(Produit produit){
        this.client.listeSuivi.add(produit) ;
    }
    boolean existanceDemandeDansDemandes(Demande demande){
        return this.client.Demandes.contains(demande);
    }

    boolean existanceProduitDansListeSuivi(Produit produit){
        return this.client.listeSuivi.contains(produit);
    }

    boolean removeProductFromWatchList(Produit produit){
        return this.client.listeSuivi.remove(produit);
    }
}

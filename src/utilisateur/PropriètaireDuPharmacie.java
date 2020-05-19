package utilisateur;

import produit.*;

import java.util.List;

public class PropriètaireDuPharmacie extends Utilisateur   {
    static List<Produit> listeProduitAjouté;
    static public List<Medicament> listeMedicamentsAjouté;
    static List<Accessoire> listeAccessoirAjouté;


    public PropriètaireDuPharmacie(String id, String prénom, String nom, String email, String téléphone, String genre
            ,List<Produit> listeProduitAjouté, List<Medicament> listeMedicamentsAjouté,List<Accessoire> listeAccessoirAjouté) {
        super(id, prénom, nom, email, téléphone, genre);
        this.listeProduitAjouté=listeProduitAjouté;
        this.listeMedicamentsAjouté=listeMedicamentsAjouté;
         this.listeAccessoirAjouté=listeAccessoirAjouté;
    }

    void ajouterProduit(Produit produit){
        listeProduitAjouté.add(produit);
    }
    void ajouterMedicament(Medicament medicament){
        listeMedicamentsAjouté.add(medicament);
        listeProduitAjouté.add(medicament);
    }
    void ajouterAccessoir(Accessoire accessoire){
        listeProduitAjouté.add(accessoire);
        listeAccessoirAjouté.add(accessoire);
    }
}

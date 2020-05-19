package utilisateur;

import produit.*;

import static utilisateur.PropriètaireDuPharmacie.*;

public abstract class Utilisateur {
    String id;
    String prénom;
    String nom;
    String email;
    String téléphone;
    String genre;

    public Utilisateur(String id, String prénom, String nom, String email, String téléphone, String genre) {
        this.id = id;
        this.prénom = prénom;
        this.nom = nom;
        this.email = email;
        this.téléphone = téléphone;
        this.genre = genre;
    }

    void listerProduits(){
        for (Produit produit: listeProduitAjouté
        ) {
            System.out.println(produit.getNom());
        }
    }
    void listerAccessoirs(){
        for (Accessoire accessoir: listeAccessoirAjouté
        ) {
            System.out.println(accessoir.getNom());
        }
    }
    void listerMedicaments(){
        for (Medicament medicament: listeMedicamentsAjouté
        ) {
            System.out.println(medicament.getNom());
        }
    }
}

package utilisateur.admin;

import commande.Commande;
import produit.Produit;
import utilisateur.Client;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Set;

public class PropriètaireduPharmacie extends Administrateur {
    private static AbstractCollection<AdminEmploye> listeEmploye=new HashSet<>();
    public PropriètaireduPharmacie(String prénom, String nom, String email, int téléphone, String genre, String password) {
        super(prénom, nom, email, téléphone, genre, password);
        this.prénom=prénom;
        this.nom=password;
        this.téléphone=téléphone;
        this.genre=genre;
        this.email=email;
        this.password=password;

    }



    public static Set<AdminEmploye> getListeEmploye() {
        return (Set<AdminEmploye>) listeEmploye;
    }

    public static void ajoutAdminEmploye(AdminEmploye adminEmploye){
       listeEmploye.add(adminEmploye );
    }
    public static void  suppressionAdminEmploye(AdminEmploye adminEmploye){
        listeEmploye.remove(adminEmploye );
    }
    public static double gainTotal(){
        double gain=0;
        for (Produit produit: Administrateur.listeProduitAjouté
             ) {
            gain+=produit.benificetotalProduit();
        }

        return gain;
    }

    //voir les données de ses clients
    // rechecher un produit

}


package utilisateur.admin;

import produit.*;
import utilisateur.MenuPropriètaireduPharmacie;
import utilisateur.Utilisateur;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class  Administrateur extends Utilisateur {
    private static final AtomicInteger count = new AtomicInteger(0);

    static public Set<Produit> listeProduitAjouté=new HashSet<>();
    static public Set<Medicament> listeMedicamentsAjouté=new HashSet<>();
    static public Set<Accessoire> listeAccessoirAjouté=new HashSet<>();
    static public Set<Administrateur> listeAdmin=new HashSet<>();


    public Administrateur(String prénom, String nom, String email, int téléphone, String genre
            , String password) {
        super(prénom, nom, email, téléphone, genre, password);
       this.id=count.incrementAndGet();

    }

    @Override
    public int getId() {
        return id;
    }

    public static void supprimerProduit(Produit produit) {
        listeProduitAjouté.remove(produit);
    }


    public static void supprimerMedicament(Medicament medicament) {
        listeMedicamentsAjouté.remove(medicament);
        listeProduitAjouté.remove(medicament);
    }

    public static void supprimerAccessoir(Accessoire accessoire) {
        listeProduitAjouté.remove(accessoire);
        listeAccessoirAjouté.remove(accessoire);
    }

    public static void ajouterProduit(Produit produit) {
        listeProduitAjouté.add(produit);

    }

    public static void ajouterMedicament(Medicament medicament) {
        listeMedicamentsAjouté.add(medicament);
        listeProduitAjouté.add(medicament);
    }

    public static void ajouterAccessoir(Accessoire accessoire) {
        listeProduitAjouté.add(accessoire);
        listeAccessoirAjouté.add(accessoire);
    }


}

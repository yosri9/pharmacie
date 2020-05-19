package chariot;

import produit.Produit;

import java.util.List;

public class Chariot {
    String id;
    List<Produit> chariot;

    public Chariot(String id, List<Produit> chariot) {
        this.id = id;
        this.chariot = chariot;
    }
    private void ajouterauChariot(Produit produit){
        chariot.add(produit);
    }
    private void enlèverduChariot(Produit produit){
        chariot.remove(produit);
    }
}

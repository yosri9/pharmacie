package chariot;

import produit.Produit;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Chariot {
    private static final AtomicInteger count = new AtomicInteger(0);

    int id;
   private List<Map<Produit,Double>> chariot;

    public Chariot( ) {
        this.chariot = Collections.emptyList();
        this.id=count.incrementAndGet();
    }
    private void ajouterauChariot(Map<Produit,Double> produitQuantité){
        chariot.add(produitQuantité);
    }
    private void enlèverduChariot(Map<Produit,Double> produitQuantité){
        chariot.remove(produitQuantité);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Map<Produit, Double>> getChariot() {
        return chariot;
    }

    public void setChariot(List<Map<Produit, Double>> chariot) {
        this.chariot = chariot;
    }

    public double montant(){
       double montant=0;
        for (Map<Produit, Double> produitQantité:chariot
             ) {

            for (Produit produit : produitQantité.keySet()
                 ) {
                for (Double quantité:produitQantité.values()
                     ) {
                    montant+=produit.getSellPrice()*quantité       ;
                }
            }

        }
        return montant;
    }

   public void viderChariot(){
        this.chariot.clear();
    }

}

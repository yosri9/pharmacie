package produit;


import java.util.Date;
import java.util.Scanner;

public class ControleurProduit {
     private Produit produit;

    public ControleurProduit(Produit produit) {
        this.produit = produit;
    }


    public double getBuyPrice() {
        return this.produit.buyPrice;
    }
    public void setBuyPrice(double buyPrice) {
        this.produit.buyPrice = buyPrice;
    }
    public double getSellPrice() {
        return this.produit.sellPrice;
    }
    public void setSellPrice(double sellPrice) {
        this.produit.sellPrice = sellPrice;
    }
    public String  getNom() {
        return this.produit.titre;
    }
    public void setStock(int stock) {
        this.produit.stock = stock ;
    }
    public double getPrix() {
        return this.produit.prix ;
    }
    public String getID() {
        return this.produit.id;
    }
    public int getStock() {
        return this.produit.stock;
    }
    public Date expiration(){
        return this.produit.expiration;
    }
//    void ajouter(double buyPrice,double sellPrice,String nom, int stock, int numero, double prix,Date expiration) {
//        for (int i=0;i<7;i++) {
//            tab[i]=new Produit(buyPrice,sellPrice,nom,stock,numero,prix,expiration);
//        }
//    }
}




package produit;

import categorie.Categorie;
import image.Image;
import remise.Remise;

import java.util.Date;
import java.util.List;

public class Produit {
    protected int id;
    protected String titre;
    protected String description;
    protected double prix;
    protected double quantité;
    protected List<Image> images;
    protected List<Categorie> categories;
    protected List<Remise> remises;

    protected double buyPrice, sellPrice;
    protected int stock;
    protected Date expiration;

    public Produit(int id, String titre, String description, double prix,
                   double quantité, List<Image> images, List<Categorie> categories,
                   List<Remise> remises, double buyPrice, double sellPrice, int stock, Date expiration) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.quantité = quantité;
        this.images = images;
        this.categories = categories;
        this.remises = remises;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.stock = stock;
    }

    protected Produit produit;



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

    public String getNom() {
        return this.produit.titre;
    }

    public void setStock(int stock) {
        this.produit.stock = stock;
    }

    public double getPrix() {
        return this.produit.prix;
    }

    public int getID() {
        return this.produit.id;
    }

    public int getStock() {
        return this.produit.stock;
    }

    public Date expiration() {
        return this.produit.expiration;
    }

    public List<Categorie> getCategories() {
        return this.produit.categories;
    }

    public void addCategorie(Categorie categorie) {
        this.produit.categories.add(categorie);
    }

    public void removeCategorie(Categorie categorie) {
        this.produit.categories.remove(categorie);
    }

}

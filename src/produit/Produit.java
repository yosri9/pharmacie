package produit;

import categorie.Categorie;
import image.Image;
import remise.Remise;

import java.util.Date;
import java.util.List;

public class Produit {
    protected String id;
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

    public Produit(String id, String titre, String description, double prix,
                   double quantité, List<Image> images, List<Categorie> categories,
                   List<Remise> remises ,double buyPrice,double sellPrice,int stock,Date expiration) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.quantité = quantité;
        this.images = images;
        this.categories = categories;
        this.remises = remises;
        this.buyPrice=buyPrice;
        this.sellPrice=sellPrice;
        this.stock=stock;
    }


}

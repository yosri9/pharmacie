package produit;

import categorie.Categorie;
import image.Image;
import remise.Remise;

import java.util.List;

public class Produit {
    String id;
    String titre;
    String description;
    double prix;
    double quantité;
    List<Image> images;
    List<Categorie> categories;
    List<Remise> remises;

    public Produit(String id, String titre, String description, double prix,
                   double quantité, List<Image> images, List<Categorie> categories,
                   List<Remise> remises) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.quantité = quantité;
        this.images = images;
        this.categories = categories;
        this.remises = remises;
    }
}

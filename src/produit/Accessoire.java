package produit;

import categorie.Categorie;
import categorie.CategorieAccessoire;
import image.Image;
import remise.Remise;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Accessoire extends Produit {
    Set<String> categorieAccessoire ;

    public Accessoire(int id, String titre, String description, double prix, double quantité,
                      List<Image> images, List<Categorie> categories,Set<String> categorieAccessoire, List<Remise> remises, double buyPrice, double sellPrice,
                      int stock, Date expiration) {
        super(id, titre, description, prix, quantité, images, categories, remises,
                buyPrice, sellPrice, stock, expiration);
        this.categorieAccessoire=categorieAccessoire;
    }


}

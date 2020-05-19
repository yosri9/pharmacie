package produit;

import categorie.Categorie;
import image.Image;
import remise.Remise;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Medicament extends Produit {

    List<String>    maladies;


    public Medicament(String id, String titre, String description, List<String>   maladies, double prix, double quantité, List<Image> images,
                      List<Categorie> categories, List<Remise> remises, double buyPrice, double sellPrice, int stock, Date expiration) {
        super(id, titre, description, prix, quantité, images, categories, remises,
                buyPrice, sellPrice, stock, expiration);
       this.maladies=maladies;

    }
}

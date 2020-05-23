package produit;

import categorie.Categorie;
import categorie.CategorieMedicament;
import image.Image;
import remise.Remise;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Medicament extends Produit {
    static Scanner scanner = new  Scanner (System.in);


    List<String>    maladies;
    List<CategorieMedicament> categorieMedicaments;



    public Medicament(int id, String titre, String description, List<String>   maladies, double prix, double quantité, List<Image> images,
                      List<Categorie> categories, List<CategorieMedicament> categorieMedicaments
            , List<Remise> remises, double buyPrice, double sellPrice, Integer stock, Date expiration) {
        super(id, titre, description, prix, quantité, images, categories, remises,
                buyPrice, sellPrice, stock, expiration);
       this.maladies=maladies;
        this.categorieMedicaments=categorieMedicaments;

    }
    Medicament medicament;

    public List<String> getMaladies() {
        return this.medicament.maladies;
    }
    public void addMaladie(String maladie) {
        this.medicament.maladies.add(maladie);
    }
    public void removeMaladie(String maladie) {
        this.medicament.maladies.remove(maladie);
    }



    private static int id = 0;

    public static Medicament CreerNouveauMedicament() {


        String nomMedicament = null;
        String description = null;
        double quantité = 0;
        double buyPrice = 0;
        double sellPrice = 0;
        List<Image> Images;
        int expiration = 0;
        String genre;
        while (nomMedicament == null || buyPrice == 0 || sellPrice == 0) {
            System.out.print("Nom de Produit:");
            nomMedicament = scanner.nextLine();
            System.out.print("prix d'achat:");

            buyPrice = scanner.nextDouble();

            System.out.print("description:");
            description = scanner.nextLine();

            System.out.print("quantité:");
            quantité = scanner.nextDouble();
            System.out.print("1 er Images:");

            System.out.print("prix de la vente:");
            sellPrice = scanner.nextDouble();
            System.out.print("Date d'expiration:");
            expiration = scanner.nextInt();
            System.out.print("le produit pharmaceutique est de genre:");
            genre = scanner.next();
            scanner.nextLine();
            System.out.println();
            System.out.print("maladie concerné pour ce medicament:");
            String maladie = scanner.nextLine();
            System.out.print("prix d'achat:");



        }
        Medicament medicament = new Medicament( id, nomMedicament ,  description, null,   sellPrice,  quantité, null,
                null, null
                ,null, buyPrice,  sellPrice, null,null);
        id+=1;
        return medicament;
    }
}

package produit;

import categorie.Categorie;
import image.Image;
import remise.Remise;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
 //TODO minimiser le stock en commandant
public class Produit {
    protected int id;
    protected String titre;
    protected String description;
    protected List<Image> images;
    protected List<Categorie> categories;
    protected double quantitéVendu;

    protected double buyPrice, sellPrice;
    protected double stock;
    protected Date expiration;

     public double getQuantitéVendu() {
         return quantitéVendu;
     }

     public void setQuantitéVendu(double quantitéVendu) {
         this.quantitéVendu = quantitéVendu;
     }

     public Produit(int id, String titre, String description, double prix,
                    double quantité, List<Image> images, List<Categorie> categories,
                    List<Remise> remises, double buyPrice, double sellPrice, int stock, Date expiration) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.images = images;
        this.categories = categories;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.stock = stock;
        this.quantitéVendu=0;
    }

    protected Produit produit;

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getTitre() {
         return titre;
     }

     public void setTitre(String titre) {
         this.titre = titre;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public List<Image> getImages() {
         return images;
     }

     public void setImages(List<Image> images) {
         this.images = images;
     }

     public void setCategories(List<Categorie> categories) {
         this.categories = categories;
     }

     public Date getExpiration() {
         return expiration;
     }

     public void setExpiration(Date expiration) {
         this.expiration = expiration;
     }

     public Produit getProduit() {
         return produit;
     }

     public void setProduit(Produit produit) {
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

    public String getNom() {
        return this.produit.titre;
    }

    public void setStock(double stock) {
        this.produit.stock = stock;
    }





    public int getID() {
        return this.produit.id;
    }

    public double getStock() {
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

    static Scanner scanner = new  Scanner (System.in);



    public static Produit CreerNouveauProduit() {
        int id=0;

        String ProduitpharmaceutiqueNom = null;
        String description = null;
        double quantité = 0;
        double buyPrice = 0;
        double sellPrice = 0;
        List<Image> Images;
        int expiration = 0;
        String genre;
        while (ProduitpharmaceutiqueNom == null || buyPrice == 0 || sellPrice == 0) {
            System.out.println("Nom de Produit:");
            ProduitpharmaceutiqueNom = scanner.nextLine();

            System.out.println("prix d'achat:");
            buyPrice = scanner.nextDouble();

            System.out.println("description:");
            description = scanner.next();
            scanner.nextLine();

            System.out.println("quantité:");
            quantité = scanner.nextDouble();

            System.out.println("prix de la vente:");
            sellPrice = scanner.nextDouble();

            System.out.println("Date d'expiration:");
            expiration = scanner.nextInt();



        }
        Produit produit = new Produit(id , ProduitpharmaceutiqueNom, description, buyPrice,
                quantité, null, null, null, buyPrice, sellPrice, expiration, null);
        id+=1;

        return produit;
    }

    public double benificetotalProduit(){
       return this.quantitéVendu*(this.sellPrice-this.buyPrice);
    }


}

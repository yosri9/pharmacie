package administrateur;

import image.Image;
import produit.Produit;

import java.util.List;
import java.util.Scanner;

public class Pharmacie {
    private int id;
    private double expenses ,income;
    private Produitpharmaceutique [] produits = new Produitpharmaceutique [100];

    public Pharmacie(double expenses, double income, Produitpharmaceutique[] produits) {
        this.expenses = expenses;
        this.income = income;
        this.produits = produits;
    }

    static Scanner scanner = new  Scanner (System.in);

    public Produit CreateNewProduit() {
        String ProduitpharmaceutiqueNom = null;
        String description = null;
        double quantité = 0;
        double buyPrice = 0;
        double sellPrice = 0;
        List<Image> Images;
        int expiration = 0;
        String genre;
        while (ProduitpharmaceutiqueNom == null || buyPrice == 0 || sellPrice == 0) {
            System.out.print("Nom de Produit:");
            ProduitpharmaceutiqueNom = scanner.nextLine();
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


        }
        Produit produit = new Produit(id + 1, ProduitpharmaceutiqueNom, description, buyPrice, quantité, null, null, null, buyPrice, sellPrice, expiration, null);
        return produit;
    }

//    public void addtoProduitpharmaceutique () {
//        for(int x=0 ; x<produits.length;x++) {
//            if (produits[x]==null) {
//                produits[x]=CreateNewProduit();
//                x=produits.length;
//            }
//        }
//    }
//    public void printAll() {
//        for(int x=0; x<produits.length;x++) {
//            if ( produits[x] != null) {
//                System.out.println("numero: "+ (x+1) + "nom: "+produits[x].getNom()+" stock: "
//                        +produits[x].getstock());
//            }
//        }
//    }

    public void buyProduitpharmaceutique() {
        int Produitpharmaceutiquenumero=-1, quantite=0;
        String ProduitpharmaceutiqueNom = null;
        double ProduitpharmaceutiquebuyPrice=0;
        String ProduitpharmaceutiqueType = null;
        String ClientNom = null;
        while (Produitpharmaceutiquenumero<0 || produits[Produitpharmaceutiquenumero]==null) {
            System.out.print("numero de produits acheter : ");
            Produitpharmaceutiquenumero= scanner.nextInt()-1;
            scanner.nextLine();
        }
        System.out.println();
        while (quantite<1) {
            System.out.print("numero de produit acheter:");
            quantite=scanner.nextInt();
            scanner.nextLine();
        }
        while (ProduitpharmaceutiqueNom == null ) {
            System.out.print("nom du produit acheter :");
            ProduitpharmaceutiqueNom=scanner.next();
            scanner.nextLine();
        }
        while (ProduitpharmaceutiqueType == null) {
            System.out.print("type de produit acheter:");
            ProduitpharmaceutiqueType =scanner.next();
            scanner.nextLine();
        }
        while (ClientNom == null) {
            System.out.print("nom du client:");
            ClientNom =scanner.next();
            scanner.nextLine();
        }
        while(ProduitpharmaceutiquebuyPrice<0) {
            System.out.print("prix d'achat :");
            ProduitpharmaceutiquebuyPrice=scanner.nextDouble();
            scanner.nextLine();
        }
        produits[Produitpharmaceutiquenumero].setstock ( produits[Produitpharmaceutiquenumero].getstock()+quantite);
        expenses+= produits[Produitpharmaceutiquenumero].getBuyPrice()*quantite;
    }
    public void gain() {
        System.out.println (income-expenses+" Dinar");
    }
    public void sellProduitpharmaceutique() {
        int Produitpharmaceutiquenumero=-1, quantite=0;
        String ProduitpharmaceutiqueNom = null;
        double ProduitpharmaceutiquesellPrice=0;
        String ProduitpharmaceutiqueType = null;
        String FourniseurNom = null ;
        while (Produitpharmaceutiquenumero<0 || produits[Produitpharmaceutiquenumero]==null) {
            System.out.print("numero de produits vendue : ");
            Produitpharmaceutiquenumero= scanner.nextInt()-1;
            scanner.nextLine();
        }
        System.out.println();
        while (ProduitpharmaceutiqueNom == null ) {
            System.out.print("nom du produit acheter :");
            ProduitpharmaceutiqueNom=scanner.next();
            scanner.nextLine();
        }
        while(ProduitpharmaceutiquesellPrice<0) {
            System.out.print("prix de vente :");
            ProduitpharmaceutiquesellPrice=scanner.nextDouble();
            scanner.nextLine();
        }
        while (ProduitpharmaceutiqueType == null) {
            System.out.print("type de produit acheter:");
            ProduitpharmaceutiqueType =scanner.next();
            scanner.nextLine();
        }
        while (FourniseurNom == null) {
            System.out.print("nom du fourniseur:");
            FourniseurNom =scanner.next();
            scanner.nextLine();
        }
        while (quantite<1) {
            System.out.print("numero de produits vendue :");
            quantite=scanner.nextInt();
            if (quantite>produits[Produitpharmaceutiquenumero].getstock()) {
                System.out.println("la quantite en vente est plus grande que la quantite en stock");
                System.out.println();
            }
        }
        produits[Produitpharmaceutiquenumero].setstock ( produits[Produitpharmaceutiquenumero].getstock()-quantite);
        expenses+= produits[Produitpharmaceutiquenumero].getSellPrice()*quantite;
    }
}


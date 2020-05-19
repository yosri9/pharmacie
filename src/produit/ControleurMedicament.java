package produit;

import categorie.Categorie;

import java.util.List;

public class ControleurMedicament extends ControleurProduit{
    public static List<ControleurMedicament> medicaments;

    Medicament medicament;

    public ControleurMedicament(Produit produit, Medicament medicament) {
        super(produit);
        this.medicament = medicament;
    }

    public String getNom(){
        return this.medicament.titre;
    }
    public List<Categorie> getCategories() {
        return this.medicament.categories;
    }
    public void addCategorie(Categorie categorie) {
        this.medicament.categories.add(categorie) ;
    }
    public void removeCategorie(Categorie categorie) {
        this.medicament.categories.remove(categorie) ;
    }
    public List<String> getMaladies() {
        return this.medicament.maladies;
    }
    public void addMaladie(String maladie) {
        this.medicament.maladies.add(maladie);
    }
    public void removeMaladie(String maladie) {
        this.medicament.maladies.remove(maladie);
    }


    }
    static void categorie (medicament [] medicaments) {
        String nom;
        nom = lireMedicament();
        for (int i=0;i<8;i++) {
            if (medicaments[i].getnom()==nom) {
                System.out.println ("ce medicament est de catégorie:"+medicaments[i].getCategorie());
            }
        }
    }
}

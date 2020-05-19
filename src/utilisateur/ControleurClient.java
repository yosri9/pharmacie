package utilisateur;

import demande.Demande;
import produit.ControleurMedicament;
import produit.Medicament;
import produit.Produit;

import java.util.List;
import java.util.Scanner;

public class ControleurClient {
    protected static Scanner scanner = new  Scanner (System.in);
    List<ControleurMedicament>medicaments;
    Client client ;

    public ControleurClient(Client client) {
        this.client = client;
    }

    void ajouteràDemande(Demande demande){
        this.client.Demandes.add(demande);
    }

    void ajouteràlisteSuivi(Produit produit){
        this.client.listeSuivi.add(produit) ;
    }
    boolean existanceDemandeDansDemandes(Demande demande){
        return this.client.Demandes.contains(demande);
    }

    boolean existanceProduitDansListeSuivi(Produit produit){
        return this.client.listeSuivi.contains(produit);
    }

    boolean supprimerProduitdeListeSuivi(Produit produit){
        return this.client.listeSuivi.remove(produit);
    }

    public static String lireMedicament() {
        String med;
        System.out.println("medicament acheté? ");
        med=scanner.nextLine();
        scanner.nextLine();
        return med;
    }
    public void maladie () {

        String ch;
        ch= lireMedicament();
        cont=ControleurMedicament.med
        for(Medicament medicament : medicaments ) {
            if(medicament.titre==ch) {
                System.out.println(" ce medicament est pour:"+ getMaladies());
            }
        }
}

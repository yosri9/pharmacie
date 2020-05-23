import utilisateur.MenuClient;
import utilisateur.MenuAdministrateur;
import utilisateur.MenuPropriètaireduPharmacie;

import java.util.Scanner;


public  class main {

    public static void main(String[] args) {
        vendeurOuClient();
    }
    public static String vendeurOuClient(){
        System.out.println("Client Ou administrateur si client entrez 1 sinon entrez 2");
        Scanner scanner = new Scanner(System.in);
        String utilisateur = scanner.nextLine();
        switch (utilisateur){
            case "1" : MenuClient.affichageClient();
            case "2" : propriètaireOuEmplye();
        }
        return utilisateur;
    }

   static void propriètaireOuEmplye(){
       System.out.println("Propriètaire du pharmacie Ou employé si oui Propriètaire du pharmacie tapez 1 sinon tapez 2");
       Scanner scanner = new Scanner(System.in);
       String utilisateur = scanner.nextLine();

       switch (utilisateur){
           case "1" : MenuPropriètaireduPharmacie.affichagePropriètaireduPharmacie();
           case "2" : MenuAdministrateur.affichageVendeur();
       }
    }

}

package utilisateur;

import chariot.Chariot;
import commande.Commande;
import produit.Produit;
import utilisateur.admin.Administrateur;

import java.util.*;

public class MenuClient {

    public static void affichageClient() {
        boolean reponse = identifiable.inscritOuNon();
        if (reponse) {

            String email = identifiable.getEmail();
            String password = identifiable.getPassword();

            if (identifiable.identificationClient(email, password) != null) {
                Client client = identifiable.identificationClient(email, password);
                listerChoix();
                choisirChoix(client);


            } else {
                System.out.println("verifiez vous données ");
                listerChoix2();
                choisirChoix2();
            }
        } else {
            Client client = identifiable.inscription();
            if (client.getEmail() == null) {
                System.out.println("ce compte est déja inscrit");
                listerChoix2();
                choisirChoix2();
            } else {
                Client.listeClient.add(client);
                listerChoix();
                choisirChoix(client);
            }


        }
    }


    static void listerChoix() {
        int i = 0;
        String listeChoix[] = {"listerProduits", "listerAccessoirs", "listerMedicaments", "commanderleChariot"
                , "ajouteràlisteSuivi", "existanceCommandeDansCommandes", "existanceProduitDansListeSuivi",
                "supprimerProduitdeListeSuivi", "rechercherProduit", "afficherMaladie", "ajouterProduitauChariot",
                "supprimerProduitduChariot", "Le cout actuel de votre chariot", "quitter"
        };


        for (String choix : listeChoix
        ) {
            i += 1;
            System.out.println(i + " :" + choix);
        }
    }

    static void choisirChoix(Client client) {
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        scanner.nextLine();
        switch (choix) {
            case "1":
                Client.listerProduits();
                listerChoix();
                choisirChoix(client);
            case "2":
                Client.listerAccessoirs();
                listerChoix();
                choisirChoix(client);

            case "3":
                Client.listerMedicaments();
                listerChoix();
                choisirChoix(client);

            case "4":
              Chariot  reponse=saisirleChariotaCommander(client);
                if ((reponse!=null)) {
                    client.commanderleChariot((reponse)
                            , methodePaiement());
                } else {
                    System.out.println("Votre chariot est vide ");
                }
                listerChoix();
                choisirChoix(client);

            case "5":
                if (saisirproduitaAjouteralalisteSuivi() != null) {
                    client.ajouteràlisteSuivi(saisirproduitaAjouteralalisteSuivi());
                    listerChoix();
                    choisirChoix(client);
                } else {
                    listerChoix();
                    choisirChoix(client);
                }


            case "6":
                client.existanceCommandeDansCemandes(saisirlaCommandePourVerifiersonExistance(client));
                listerChoix();
                choisirChoix(client);

            case "7":
                client.existanceProduitDansListeSuivi(saisirProduitPourVerifierSonExistaanceDanslaListesuivi());
                listerChoix();
                choisirChoix(client);

            case "8":
                client.supprimerProduitdeListeSuivi(saisirProduitàSupprimerdelaListeSuivi(client));
                listerChoix();
                choisirChoix(client);

            case "9":
                Client.rechercherProduit();
                listerChoix();
                choisirChoix(client);

            case "10":
                Client.afficherMaladie();
                listerChoix();
                choisirChoix(client);

            case "11":
                if (saisirproduitaAjouteraauChariot(client) != null) {
                    client.ajouterProduitauChariot(saisirproduitaAjouteraauChariot(client));
                    listerChoix();
                    choisirChoix(client);
                } else {
                    listerChoix();
                    choisirChoix(client);
                }


            case "12":
                client.supprimerProduitduChariot(saisirproduitaSupprimeraduChariot());
                listerChoix();
                choisirChoix(client);
            case "13":
                System.out.println("Votre chariot coute " + client.getChariot().montant() + " dt");
                listerChoix();
                choisirChoix(client);

            case "14":
                System.out.println("Aurevoir");
                identifiable.vendeurOuClient();

            default:
                choisirChoix(client);
        }
    }


    static void listerChoix2() {
        System.out.println("1 : login ,2 :inscription  ,3 :quitter  ");
    }

    static void choisirChoix2() {
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.next();
        scanner.nextLine();
        switch (choix) {
            case "1":
                affichageClient();
            case "2":
                identifiable.inscription();
            case "3":
                identifiable.vendeurOuClient();
        }
    }


    private static Produit saisirproduitaAjouteralalisteSuivi() {
        System.out.println("saisire le nom du produit à ajouter à la liste suivi");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Produit produit : Administrateur.listeProduitAjouté
        ) {
            if (produit.getNom().equals(nomProduit)) {
                return produit;
            }
        }
        System.out.println("le produit  n existe pas ");

        return null;
    }

    private static Produit saisirProduitPourVerifierSonExistaanceDanslaListesuivi() {
        System.out.println("saisire le nom du produit à ajouter à la liste suivi");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Produit produit : Administrateur.listeProduitAjouté
        ) {
            if (produit.getNom().equals(nomProduit)) {
                return produit;
            }
        }
        System.out.println("le produit  existe  déja");

        return null;
    }

    private static Produit saisirProduitàSupprimerdelaListeSuivi(Client client) {
        System.out.println("saisire le nom du produit à supprimer de la liste suivi");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        if (Administrateur.listeProduitAjouté.contains(nomProduit)) {
            if (client.getChariot().getChariot().contains(nomProduit)) {
                for (Produit produit : Administrateur.listeProduitAjouté
                ) {
                    if (produit.getNom().equals(nomProduit)) {
                        return produit;
                    }
                }
            } else {
                System.out.println("le  produit n existe pas  déja ");
                listerChoix();
                choisirChoix(client);
            }


        } else {
            System.out.println("le nom du produit n existe pas  ");
            listerChoix();
            choisirChoix(client);
        }


        return null;
    }

    private static Map<Produit, Double> saisirproduitaAjouteraauChariot(Client client) {
        System.out.println("saisire le nom du produit à ajouter au chariot");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        Map<Produit, Double> map = new HashMap<>();


        if (!client.getChariot().getChariot().contains(nomProduit)) {
            if (Administrateur.listeProduitAjouté.contains(nomProduit)) {
                for (Produit produit : Administrateur.listeProduitAjouté
                ) {
                    if (produit.getNom().equals(nomProduit)) {
                        System.out.println("saisire la quantité que vous voulez achetez  ");
                        double quantité = scanner.nextDouble();
                        if (quantité > produit.getStock()) {
                            System.out.println("la quantité  maximale = " + produit.getStock());
                            return null;
                        } else {
                            map.put(produit, quantité);
                            return map;

                        }


                    } else {
                        System.out.println("Ce produit n'existe pas");
                    }
                }
            } else {
                System.out.println("verifier le nom saisi du produit");

            }
        } else {
            System.out.println("le produit  existe  déja");
        }

        return null;
    }

    private static Produit saisirproduitaSupprimeraduChariot() {
        System.out.println("saisire le nom du produit à supprimer de la liste suivi");
        Scanner scanner = new Scanner(System.in);
        String nomProduit = scanner.next();
        for (Produit produit : Administrateur.listeProduitAjouté
        ) {
            if (produit.getNom().equals(nomProduit)) {
                return produit;
            }
        }
        System.out.println("le produit  n existe pas dans le chariot");

        return null;
    }

    private static Commande saisirlaCommandePourVerifiersonExistance(Client client) {
        System.out.println("donner id du chariot");
        Scanner scanner = new Scanner(System.in);
        int idChariot = scanner.nextInt();

        for (Commande commande : client.getCommandes()
        ) {
            if (commande.getChariot().getId() == (idChariot)) {
                return commande;
            }
        }
        System.out.println("la commande   n existe pas ");

        return null;
    }

    private static Chariot saisirleChariotaCommander(Client client) {

        if (client.getChariot().getChariot().size() > 0) {
            System.out.println("Vous avez payez " + client.getChariot().montant());


            return client.getChariot();
        } else {
            System.out.println("le chariot est Vide");


        }


        return null;
    }

    private static String methodePaiement() {
        System.out.println("donner la méthode de paiement");
        Scanner scanner = new Scanner(System.in);
        String methodePaiement = scanner.next();
        return methodePaiement;
    }

}








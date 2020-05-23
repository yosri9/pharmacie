package utilisateur;

import chariot.Chariot;
import commande.Commande;
import paiement.Paiement;
import produit.Medicament;
import produit.Produit;
import utilisateur.admin.Administrateur;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends Utilisateur implements identifiable {
    private static final AtomicInteger count = new AtomicInteger(0);

    public static Set<Client> listeClient = new HashSet<>();
    private String adresseLivraison;
    private Adresse adresseFacturation;
    public Set<Produit> listeSuivi;
    private Set<Commande> commandes;
    private Chariot chariot;

    public Client(String prénom, String nom, String email, String password,
                  int téléphone, String genre, String adresseLivraison,
                  Adresse adresseFacturation) {
        super(prénom, nom, email, téléphone, genre, password);
        this.adresseLivraison = adresseLivraison;
        this.adresseFacturation = adresseFacturation;
        this.listeSuivi = new HashSet<>();
        this.commandes = new HashSet<>();
        this.id = count.incrementAndGet();
        this.chariot = new Chariot();
    }

    @Override
    public int getId() {
        return this.id;
    }

    public Chariot getChariot() {
        return chariot;
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public static Set<Client> getListeClient() {
        return listeClient;
    }

    public static void setListeClient(Set<Client> listeClient) {
        Client.listeClient = listeClient;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Adresse getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(Adresse adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public Set<Produit> getListeSuivi() {
        return listeSuivi;
    }

    public void setListeSuivi(Set<Produit> listeSuivi) {
        this.listeSuivi = listeSuivi;
    }

    public  Set<Commande> getCommandes() {
        return this.commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    protected static Scanner scanner = new Scanner(System.in);


    public void ajouterCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public void ajouteràlisteSuivi(Produit produit) {
        this.listeSuivi.add(produit);
    }

    public boolean existanceCommandeDansCemandes(Commande commande) {
        return this.commandes.contains(commande);
    }

    public boolean existanceProduitDansListeSuivi(Produit produit) {
        return this.listeSuivi.contains(produit);
    }

    public void supprimerProduitdeListeSuivi(Produit produit) {
        this.listeSuivi.remove(produit);
    }

    public void ajouterProduitauChariot(Map<Produit, Double> produitQuantité) {
        ;
        this.chariot.getChariot().add(produitQuantité);
    }

    public void supprimerProduitduChariot(Produit produit) {
        ;
        this.chariot.getChariot().remove(produit);
    }


    public static String lireMedicament() {
        String med;
        System.out.println("Donnez le nom du medicament pour voir ses maladies concernées ");
        med = scanner.nextLine();
        return med;
    }

    public static void afficherMaladie() {

        String ch;

        ch = lireMedicament();
        if (!Administrateur.listeMedicamentsAjouté.isEmpty()) {
            for (Medicament medicament : Administrateur.listeMedicamentsAjouté) {
                if (medicament.getNom().equals(ch)) {
                    if (!medicament.getMaladies().isEmpty()) {
                        System.out.println(" ce medicament est pour:" + medicament.getMaladies());
                    }
                    System.out.println("Aucune information trouvé");
                }
            }
        }
        System.out.println("Aucun medicament existant");
    }

    public void commanderleChariot(Chariot chariot, String methodePaiement) {
        for (Map<Produit, Double> produitQantité : chariot.getChariot()
        ) {

            for (Produit produit : produitQantité.keySet()
            ) {
                for (Double quantité : produitQantité.values()
                ) {
                    produit.setStock(produit.getStock() - quantité);
                    produit.setQuantitéVendu(produit.getQuantitéVendu()+quantité);
                }
                Paiement paiement = new Paiement(chariot.montant(),
                        new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()),
                        methodePaiement);
                Commande commande = new Commande(this.chariot, this, paiement);
                commande.setChariot(chariot);

                ajouterCommande(commande);
                chariot.viderChariot();
            }


        }

    }
}
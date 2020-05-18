package utilisateur;

public class Adresse {

        String nomDeRue;
        String numéroDeRue;
        String cité;
        String etat;
        String pays;
        String codePostal;

    public Adresse(String nomDeRue, String numéroDeRue, String cité, String etat, String pays, String codePostal) {
        this.nomDeRue = nomDeRue;
        this.numéroDeRue = numéroDeRue;
        this.cité = cité;
        this.etat = etat;
        this.pays = pays;
        this.codePostal = codePostal;
    }
}

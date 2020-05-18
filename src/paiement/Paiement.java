package paiement;

import java.util.Date;

public class Paiement {
    String idPaiement;
    double montant ;
    Date datePaiement;
    String metodePaiement;

    public Paiement(String idPaiement, double montant, Date datePaiement, String metodePaiement) {
        this.idPaiement = idPaiement;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.metodePaiement = metodePaiement;
    }
}

package paiement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

//
public class Paiement {
    private static final AtomicInteger count = new AtomicInteger(0);


    private int idPaiement;
    private double montant;
    private String datePaiement;
    private String metodePaiement;

    public Paiement( double montant, String datePaiement, String metodePaiement) {
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.metodePaiement = metodePaiement;
        this.idPaiement=count.incrementAndGet();
    }

    public int getIdPaiement() {
        return idPaiement;
    }



    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        ;
    }

    public String getMetodePaiement() {
        return metodePaiement;
    }

    public void setMetodePaiement(String metodePaiement) {
        this.metodePaiement = metodePaiement;
    }
}

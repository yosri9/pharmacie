package demande;

import chariot.Chariot;
import paiement.Paiement;
import utilisateur.Client;

public class Demande {
    Chariot chariot ;
    Client client ;
    Paiement paiement ;

    public Demande(Chariot chariot, Client client, Paiement paiement) {
        this.chariot = chariot;
        this.client = client;
        this.paiement = paiement;
    }
}

package commande;

import chariot.Chariot;
import paiement.Paiement;
import utilisateur.Client;

public class Commande {
    private Chariot chariot ;
    private Client client ;
    private Paiement paiement ;

    public Commande(Chariot chariot, Client client, Paiement paiement) {
        this.chariot = chariot;
        this.client = client;
        this.paiement = paiement;
    }

    public Chariot getChariot() {
        return chariot;
    }

    public void setChariot(Chariot chariot) {
        this.chariot = chariot;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}

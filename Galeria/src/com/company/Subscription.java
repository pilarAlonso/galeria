package com.company;

public class Subscription {
    //private int idPainter
    //private int idClient;
  private Client client;
  private Painter painter;

    public Subscription(Client client, Painter painter) {
        this.client = client;
        this.painter = painter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }
}

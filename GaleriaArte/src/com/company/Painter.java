package com.company;

import java.util.ArrayList;
import java.util.List;

public class Painter {
   private int idPainter;
    private String name;
    private String description;
    private Technique technique;
    private List<Picture>pictures=new ArrayList<>();
   private List<Subscription>clientsSubscriptionsList=new ArrayList<>();

    public int getIdPainter() {
        return idPainter;
    }

    public String getName() {
        return name;
    }

    public List<Subscription> getClientsSubscriptionsList() {
        return clientsSubscriptionsList;
    }

    public void setClientsSubscriptionsList(List<Subscription> clientsSubscriptionsList) {
        this.clientsSubscriptionsList = clientsSubscriptionsList;
    }

    public void addFollower(Subscription subscription){
       clientsSubscriptionsList.add(subscription);
   }

    public Painter(int idPainter,String name, String description, Technique technique) {
        this.idPainter=idPainter;
        this.name = name;
        this.description = description;
        this.technique = technique;

    }

    public Technique getTechnique() {
        return technique;
    }

    public List<Picture> getPictures() {
        return pictures;
    }



    @Override
    public String toString() {
        return "Painter{" +
                "name='" + name + '\'' +

                '}';
    }

    public void addPicture(Picture picture){
        pictures.add(picture);
}

}

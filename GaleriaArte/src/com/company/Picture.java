package com.company;

import java.util.ArrayList;
import java.util.List;

public class Picture {

    private String title;
    private Painter painter;
    private String description;
    private final double price;
    private int stock;
    private Technique technique;
    private PictureStatus pictureStatus;
    private Client client;
    private List<Client>clientList=new ArrayList<>();
    public void addClient(Client client){
        clientList.add(client);
    }
    public boolean isSold(){
       return  !this.clientList.isEmpty();

    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Technique getTechnique() {
        return technique;
    }

    public String getTitle() {
        return title;
    }

    public void setClient(Client client) {
        this.client = client;
        setPictureStatus(PictureStatus.SOLD);
        stock=stock-1;
    }

    public Client getClient() {
        return client;
    }


    public Painter getPainter() {
        return painter;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "title='" + title + '\'' +
                ", painter=" + painter.getName() +
                ", description='" + description + '\'' +
                ", price=" + price +

                ", pictureStatus=" + pictureStatus +
                '}';
    }



    public PictureStatus getPictureStatus() {
        return pictureStatus;
    }




    public void setPictureStatus(PictureStatus pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Picture(String title, Painter painter, String description, double price,  int stock,Technique technique) {
        this.stock = stock;
        this.title = title;
        this.painter = painter;
        this.description = description;
        this.price = price;
        this.technique=technique;

        this.pictureStatus = PictureStatus.STOCK;

    }

}


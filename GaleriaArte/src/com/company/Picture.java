package com.company;

public class Picture {
    //private int idPainter
    //private int idClient;
    private String title;
    private int idPicture;
   private Painter painter;
   private String description;
   private final double price;
   private Technique technique;
   private int stock;
   private PictureStatus pictureStatus;
   private Client client;

    public void setClient(Client client) {
        this.client = client;
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
                ", technique=" + technique +

                ", pictureStatus=" + pictureStatus +
                '}';
    }

    public int getIdPicture() {
        return idPicture;
    }

    public PictureStatus getPictureStatus() {
        return pictureStatus;
    }


    public Technique getTechnique() {
        return technique;
    }

    public void setPictureStatus(PictureStatus pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Picture(String title, Painter painter, String description, double price, Technique technique, int idPicture,int stock) {
        this.stock=stock;
        this.title = title;
        this.painter = painter;
        this.description = description;
        this.price = price;
        this.technique = technique;
        this.idPicture=idPicture;

        this.pictureStatus=PictureStatus.STOCK;
    }

}


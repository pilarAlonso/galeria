package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    private int idClient;
    private String name;
    private String address;
    private List<Picture> purchases =new ArrayList<>();
    private List<Painter>followList=new ArrayList<>();

    public List<Painter> getFollowList() {
        return followList;
    }

    public void addP(Painter painter){
        followList.add(painter);
    }
    public int getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }





    public Client(int idClient,String name, String address, Picture picture) {

        this.idClient=idClient;
        this.name = name;
        this.address = address;
        addPurchases(picture);




    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
    public double expensivePurchase(){
        Comparator<Picture> comparador2 = (p1, p2) -> Double.compare( p1.getPrice(), p2.getPrice());
        Picture maxim = purchases.stream()
                .max(comparador2)
                .get();
        return maxim.getPrice();
    }
    public double totalPrice(){
        double totalPricePurchases= purchases.stream().mapToDouble(Picture::getPrice).sum();
        return totalPricePurchases;
    }

    public List<Picture> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Picture> purchases) {
        this.purchases = purchases;
    }

    public void addPurchases(Picture picture) {
        purchases.add(picture);
        picture.setPictureStatus(PictureStatus.SOLD);
    }
}

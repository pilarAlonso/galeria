package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Painter {

    private String name;
    private String description;

    private List<Picture>pictures=new ArrayList<>();
    private List<Technique>techniqueList=new ArrayList<>();

    public List<Technique> getTechniqueList() {
        return techniqueList;
    }
    public void addTech(Technique technique){
        techniqueList.add(technique);
    }

    public List<Client> getFollowers() {
        return followers;
    }

    private List<Client>followers=new ArrayList<>();
    public boolean isSubscribed() {
        Predicate<Picture> isSold = picture -> picture.getPictureStatus().equals(PictureStatus.SOLD);

        List<Client>list=pictures.stream().map(Picture::getClient).collect(Collectors.toList());



         return list.stream().anyMatch(followers::contains);
    }

    public String getName() {
        return name;
    }

    public void addFollower(Client client){
       followers.add(client);
   }

    public Painter(String name, String description) {
        this.name = name;
        this.description = description;



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

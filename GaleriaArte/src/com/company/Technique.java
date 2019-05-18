package com.company;

import java.util.ArrayList;
import java.util.List;

public class Technique {
    private List<Painter> list=new ArrayList();
   String tipo ;
   private List<Picture>pictureList=new ArrayList<>();
   public  void addPicture(Picture picture){
       pictureList.add(picture);
   }
   public void addPainter(Painter painter){
       list.add(painter);


   }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public Technique(String tipo) {
        this.tipo = tipo;
    }

    public List<Painter> getList() {
        return list;
    }

    public void setList(List<Painter> list) {
        this.list = list;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

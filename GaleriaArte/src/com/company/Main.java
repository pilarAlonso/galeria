package com.company;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Client> clientList = new ArrayList<>();
        List<Picture> pictureList = new ArrayList<>();
        List<Painter> painterList = new ArrayList<>();
        Painter painter1 = new Painter("salvador","bienvenido al surrealismo", Technique.CHARCOAL);
        Painter painter2 = new Painter("edvar","el grito siempre vuelve",Technique.OLEO);
        painterList.add(painter1);
        painterList.add(painter2);
        Picture picture3 = new Picture("lovely", painter2, "pintura", 12.4, Technique.OLEO, 3);
        Picture picture1 = new Picture("el grito", painter2, "pintura", 123.4, Technique.OLEO, 5);
        Picture picture2 = new Picture("cristo", painter1, "religioso", 145, Technique.CHARCOAL, 4);
        pictureList.add(picture1);
        pictureList.add(picture2);
        pictureList.add(picture3);
        painter1.addPicture(picture2);
        painter2.addPicture(picture1);
        painter2.addPicture(picture3);
        Client client1 = new Client(1,"pedro", "calle norte", picture1);
        Client client2 = new Client(2,"paco", "calle rota", picture2);
        picture1.setClient(client1);
        picture2.setClient(client2);
        picture3.setClient(client1);
        client1.addPurchases(picture3);
        clientList.add(client1);
        clientList.add(client2);
       painter2.addFollower(client1);
       painter1.addFollower(client2);


        System.out.println("1)Listado de pintores que dominan   óleo");
        Stream<Painter> list = painterList.stream().filter(painter -> painter.getTechnique().equals(Technique.OLEO));
        list.forEach(painter -> System.out.println(painter.getName()));
        System.out.println("2)Listar número de artistas que maneja cada técnica");
        System.out.println(painterList.stream().collect(Collectors.groupingBy(Painter::getTechnique)));
        System.out.println("3)Número de cuadros pintados por cada artista");
        Map<Painter, Long> painter = pictureList.stream().collect(Collectors.groupingBy(Picture::getPainter, Collectors.counting()));
        painter.forEach((k, v) -> System.out.println("artista" + ("=") + k + "\nnúmero de cuadros" + ("=") + v));
        System.out.println("4)Número de cuadros vendidos por cada artista");
        System.out.println(pictureList.stream().filter(picture -> picture.getPictureStatus().equals(PictureStatus.SOLD)).collect(Collectors.groupingBy(
                Picture::getPainter,
                Collectors.counting())));
        System.out.println("5)cuadros óleo vendidos");
        Predicate<Picture> isSold = picture -> picture.getPictureStatus().equals(PictureStatus.SOLD);
        Predicate<Picture> isOleo = picture -> picture.getTechnique().equals(Technique.OLEO);
        Long result = pictureList.stream().filter(isOleo.and(isSold)).map(Picture::getTitle).count();
        System.out.println(result);
        System.out.println("6)dinero ganado por artista");
        System.out.println(pictureList.stream().filter(picture -> picture.getPictureStatus().equals(PictureStatus.SOLD)).collect(Collectors.groupingBy(
                Picture::getPainter,
                Collectors.summingDouble(Picture::getPrice))));
        System.out.println("numero de cuadros vendidos por un artista a cliente subscritos");

        Long any= painterList.stream().filter(Painter::isSubscribed).count();
       System.out.println(any);

        System.out.println("artista que mas cuadros ha pintado");
        Comparator<Painter> comp = (p1, p2) -> Integer.compare(p1.getPictures().size(), p2.getPictures().size());
        Painter max = painterList.stream()
                .max(comp)
                .get();
        System.out.println(max);
        System.out.println("cliente que mas cuadros ha comprado");
        Comparator<Client> comparador = (p1, p2) -> Integer.compare(p1.getPurchases().size(), p2.getPurchases().size());
        Client mclientemax = clientList.stream()
                .max(comparador)
                .get();
        System.out.println(mclientemax);
        System.out.println("cliente que mas dinero se ha gastado");

        Comparator<Client> comparador1 = (p1, p2) -> Double.compare(p1.totalPrice(), p2.totalPrice());
        Client maxi = clientList.stream()
                .max(comparador1)
                .get();
        System.out.println(maxi);
        System.out.println("cliente que ha hecho la compra más cara");
        Comparator<Client> comparador2 = (p1, p2) -> Double.compare(p1.expensivePurchase(), p2.expensivePurchase());
        Client maxim = clientList.stream()
                .max(comparador2)
                .get();
        System.out.println(maxim);


    }
}

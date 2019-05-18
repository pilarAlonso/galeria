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
        List<Technique> techniqueList = new ArrayList<>();
        Technique technique = new Technique("oleo");
        Technique technique1 = new Technique("charcoal");
        Technique technique2 = new Technique("waxes");
        techniqueList.add(technique);
        techniqueList.add(technique1);
        techniqueList.add(technique2);

        Painter painter1 = new Painter("salvador", "bienvenido al surrealismo");
        Painter painter2 = new Painter("edvar", "el grito siempre vuelve");
        painterList.add(painter1);
        painter1.addTech(technique);
        technique.addPainter(painter1);
        painter1.addTech(technique1);
        technique1.addPainter(painter1);
        painterList.add(painter2);
        painter2.addTech(technique2);
        technique2.addPainter(painter2);
        Picture picture3 = new Picture("lovely", painter2, "pintura", 12.4, 3, technique1);
        Picture picture1 = new Picture("el grito", painter2, "pintura", 123.4, 5, technique1);
        Picture picture2 = new Picture("cristo", painter1, "religioso", 145, 4, technique);
        pictureList.add(picture1);
        pictureList.add(picture2);
        pictureList.add(picture3);
        painter1.addPicture(picture2);
        painter2.addPicture(picture1);
        painter2.addPicture(picture3);
        Client client1 = new Client(1, "pedro", "calle norte", picture1);
        Client client2 = new Client(2, "paco", "calle rota", picture2);
        picture1.addClient(client1);
        picture2.addClient(client1);
        picture3.addClient(client2);
        client1.addPurchases(picture3);
        clientList.add(client1);
        clientList.add(client2);
        painter2.addFollower(client1);
        client1.addP(painter2);
        painter1.addFollower(client2);
        client2.addP(painter1);
        client2.addP(painter2);
        painter2.addFollower(client2);


        System.out.println("1)Listado de pintores que dominan   óleo");
        painterList.stream().map(painter -> painter.getTechniqueList().stream().filter(technique4 -> technique.getTipo().equals("oleo")));
        System.out.println("2)Listar número de artistas que maneja cada técnica");
        techniqueList.forEach(technique3 -> System.out.println(technique.getTipo() + (technique.getList().size())));
        System.out.println("3)Número de cuadros pintados por cada artista");
        painterList.forEach(painter -> System.out.println(painter.getName() + (painter.getPictures().size())));
        //Map<Painter, Long> painter = pictureList.stream().collect(Collectors.groupingBy(Picture::getPainter, Collectors.counting()));
        // painter.forEach((k, v) -> System.out.println("artista" + ("=") + k + "\nnúmero de cuadros" + ("=") + v));
        System.out.println("4)Número de cuadros vendidos por cada artista");
        painterList.forEach(painter -> System.out.println(painter.getName() + (painter.getPictures().stream().map(picture -> picture.getClientList().size()).count())));
        //System.out.println(pictureList.stream().filter(picture -> picture.getPictureStatus().equals(PictureStatus.SOLD)).collect(Collectors.groupingBy(
        // Picture::getPainter,
        //Collectors.counting())));
        System.out.println("5)cuadros óleo vendidos");
        System.out.println(painterList.stream().filter(painter -> painter.getTechniqueList().stream().anyMatch(technique3 -> technique.getTipo().equalsIgnoreCase("oleo"))).map(painter -> painter.getPictures().stream().filter(Picture::isSold).count())
                                      .reduce((a, b) -> a + b));
        // painterList.forEach(painter -> painter.getPictures().stream().filter(picture -> picture.getTechnique().getTipo().equalsIgnoreCase("oleo")).forEach(picture -> System.out.println(picture.getClientList().size())));
        //LOS CUADROS NO TIENEN ATRIBUTO TECNICA.
        //Predicate<Picture> isSold = picture -> picture.getPictureStatus().equals(PictureStatus.SOLD);
        // Predicate<Picture> isOleo = picture -> picture.getTechnique().equals(Technique.OLEO);
        // Long result = pictureList.stream().filter(isOleo.and(isSold)).map(Picture::getTitle).count();
        // System.out.println(result);
        System.out.println("6)dinero ganado por artista");
        painterList.forEach(painter -> System.out.println(painter.getPictures().stream().filter(picture -> picture.getClientList().size() > 0).collect(Collectors.groupingBy(Picture::getPainter, Collectors.summingDouble(Picture::getPrice)))));
        //precio por el tamaño  de la lista de clientes
        //System.out.println(pictureList.stream().filter(picture -> picture.getPictureStatus().equals(PictureStatus.SOLD)).collect(Collectors.groupingBy(
        //Picture::getPainter,
        //Collectors.summingDouble(Picture::getPrice))));
        painterList.forEach(painter -> { double totalGanado=painter.getPictures()
                                            .stream().filter(Picture::isSold).mapToDouble(picture->picture.getPrice()*picture1->picture1.getClientList.size()).sum()};
        System.out.println("numero de cuadros vendidos por un artista a cliente subscritos");
      painterList.forEach(painter -> {int totalVendido=painter.getPictures().stream().filter(picture -> picture)});
        painterList.forEach(painter -> System.out.println(painter.getName() + painter.getFollowers().stream().filter(client -> client.getPurchases().contains(painter.getName()))));
        //1coger pinturas y coger la lista de clientes que han comprado esas pinturas y si tienen artista en follow


        System.out.println("artista que mas cuadros ha pintado");
        //painterList.stream().max(Comparator.comparing(painter -> painter.getPictures().size())).get();
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

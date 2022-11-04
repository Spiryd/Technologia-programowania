package gen.factury;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Faktura {
    private final int numer;
    private final Date data;
    private final List<Element> elementy = new ArrayList<>();
    
    public void addElement(String nazwa, int ilosc, int cena){
        Produkt produktDoElementu = new Produkt(nazwa, cena);
        Element nowyElement = new Element(ilosc, produktDoElementu);
        elementy.add(nowyElement);
    }

    public void print(Klient klient){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.printf("data:%s numer:%d%n",formatter.format(data), numer);
        System.out.printf("Odbiorca:%s NIP:%d%n",klient.nazwa, klient.nip);
        System.out.println("Nazwa|Cena Jednostkowa|Ilosc|Suma Czastkowa");
        String line;
        for(Element element : elementy){
            line = String.format("%s|%d|%d|%d", element.podajNazwe(), element.podajCene(), element.ilosc, element.sumaCzastkowa());
            System.out.println(line);
        }
        System.out.print("Suma:");
        System.out.println(this.suma());
    }

    public int suma(){
        int suma = 0;
        for(Element element : elementy){
            suma = suma + element.sumaCzastkowa();
        }
        return suma;
    }

    Faktura(int numer){
        this.numer = numer;
        this.data = new Date();
    }

}

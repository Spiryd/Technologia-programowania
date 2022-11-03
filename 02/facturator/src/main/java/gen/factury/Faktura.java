package gen.factury;

import java.util.ArrayList;
import java.util.List;

public class Faktura {
    List<Element> elementy = new ArrayList<>();
    
    public void addElement(String nazwa, int ilosc, int cena){
        Produkt produktDoElementu = new Produkt(nazwa, cena);
        Element nowyElement = new Element(ilosc, produktDoElementu);
        elementy.add(nowyElement);
    }

    public void print(){ 
        String line = "Nazwa|Cena Jednostkowa|Ilosc|Suma Czastkowa";
        System.out.println(line);
        for(Element element : elementy){
            line = String.format("%s|%d|%d|%d", element.produkt.nazwa, element.produkt.cena, element.ilosc, element.sumaCzastkowa());
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

}

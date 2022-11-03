package gen.factury;

public class Element {
    int ilosc;
    Produkt produkt;

    Element(int ilosc, Produkt produkt){
        this.ilosc = ilosc;
        this.produkt = produkt;
    }

    public int sumaCzastkowa(){
        return ilosc * produkt.cena;
    }
}

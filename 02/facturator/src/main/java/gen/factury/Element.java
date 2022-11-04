package gen.factury;

public class Element {
    int ilosc;
    private final Produkt produkt;

    Element(int ilosc, Produkt produkt){
        this.ilosc = ilosc;
        this.produkt = produkt;
    }

    public String podajNazwe(){
        return  produkt.nazwa;
    }

    public int podajCene(){
        return produkt.cena;
    }

    public int sumaCzastkowa(){
        return ilosc * produkt.cena;
    }
}

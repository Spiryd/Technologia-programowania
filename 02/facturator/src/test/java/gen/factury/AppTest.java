package gen.factury;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testDodawania(){
        Faktura faktura = new Faktura(2137, new Klient(2137, "a"));
        faktura.addElement("a", 4, 5);
    }
    @Test
    public void testSumy()
    {
        Faktura faktura = new Faktura(2137, new Klient(2137, "a"));
        faktura.addElement("a", 1, 4);
        faktura.addElement("b", 2, 5);
        assertEquals(14, faktura.suma());
    }
    @Test
    public void testKlient(){new Klient(2137, "a");}

    @Test
    public void testPrint(){
        Klient klient =  new Klient(2137, "a");
        Faktura faktura = new Faktura(2137, klient);
        faktura.addElement("a", 1, 4);
        faktura.print();
    }

    @Test
    public void testDodaj(){
        Faktura faktura = new Faktura(2137, new Klient(2137, "a"));
        DataService dataService = new DataService(new DataMenager1());
        dataService.dodajDoBazy(faktura);
    }
}

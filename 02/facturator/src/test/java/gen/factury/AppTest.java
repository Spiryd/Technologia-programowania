package gen.factury;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testDodawania(){
        Faktura faktura = new Faktura(2137);
        faktura.addElement("a", 4, 5);
    }
    @Test
    public void testSumy()
    {
        Faktura faktura = new Faktura(2137);
        faktura.addElement("a", 1, 4);
        faktura.addElement("b", 2, 5);
        assertEquals(14, faktura.suma());
    }
    @Test
    public void testKlient(){new Klient(2137, "a");}

    @Test
    public void testPrint(){
        Faktura faktura = new Faktura(2137);
        faktura.addElement("a", 1, 4);
        Klient klient =  new Klient(2137, "a");
        faktura.print(klient);
    }
}

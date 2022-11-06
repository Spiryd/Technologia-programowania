package gen.factury;

import java.util.Scanner;

// odpowiada z komunikacje z urzytkownikiem
public class App 
{
  public static void main( String[] args )
  {
    try(Scanner scanner = new Scanner(System.in)){
      System.out.println("WELCOME TO FACTURATOR!!!");
      boolean exitClient = false;
      String choice;
  
      while (!exitClient){
        System.out.println("Choose your poison:\n1. Podaj klijenta\n2. Wyjdz");
        System.out.print("Your choice(1): ");
        choice = scanner.nextLine();
        switch (choice) {
          case "1":
            String nazwaKlienta;
            int nip;
            int numerFaktury;
            System.out.print("Nazwa Klienta: ");
            nazwaKlienta = scanner.nextLine();
            System.out.print("NIP: ");
            nip = Integer.parseInt(scanner.nextLine());
            System.out.print("Numer faktury: ");
            numerFaktury = Integer.parseInt(scanner.nextLine());
            Klient klient = new Klient( nip, nazwaKlienta);
            Faktura faktura = new Faktura(numerFaktury, klient);
            boolean exitFaktura = false;
            while(!exitFaktura){
              System.out.println("Choose your poison:\n1. Dodaj Element\n2. Drukuj\n3. Zapisz do Bazy\n4. Wyjdz");
              System.out.print("Your choice(1): ");
              choice = scanner.nextLine();
              switch (choice){
                case "1":
                  String nazwaProduktu;
                  int ilosc;
                  int cena;
                  System.out.print("Nazwa Produktu: ");
                  nazwaProduktu = scanner.nextLine();
                  System.out.print("Ilosc: ");
                  ilosc = Integer.parseInt(scanner.nextLine());
                  System.out.print("Cena: ");
                  cena = Integer.parseInt(scanner.nextLine());
                  faktura.addElement(nazwaProduktu, ilosc, cena);
                  break;

                case "2":
                  faktura.print();
                  break;

                case "3":
                  DataService dataService = new DataService(new DataMenager1());
                  dataService.dodajDoBazy(faktura);
                  break;

                case "4":
                  exitFaktura = true;
                  break;

                default:
                  System.out.println("Zły input");
                  break;
              }
            }
            break;

          case "2":
            exitClient = true;
            break;
        
          default:
            System.out.println("Zły input");
            break;
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}

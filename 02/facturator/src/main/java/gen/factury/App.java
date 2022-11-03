package gen.factury;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
  public static void main( String[] args )
  {
    try(Scanner scanner = new Scanner(System.in);){
      System.out.println("WELCOME TO FACTURATOR!!!");
      boolean exit = false;
      String choice;

      Faktura faktura = new Faktura();
  
      while (!exit){
        System.out.println("Choose your poison:\n1. Dodaj Element\n2. Drukuj\n3.Wyjdz");
        System.out.print("Your choice(1): ");
        choice = scanner.nextLine();
        switch (choice) {
          case "1":
            String nazwa;
            int ilosc;
            int cena;
            System.out.print("Nazwa: ");
            nazwa = scanner.nextLine();          
            System.out.print("Ilosc: ");
            ilosc = scanner.nextInt();
            System.out.print("Cena: ");
            cena = scanner.nextInt();
            faktura.addElement(nazwa, ilosc, cena);
            break;

          case "2":
            faktura.print();
            break;

          case "3":
            exit = true;
            break;
        
          default:
            System.out.println("");
            break;
        }
      }
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}

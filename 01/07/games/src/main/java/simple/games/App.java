package simple.games;

import java.util.Scanner;

/**
 * Gaming app
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        String welcomeString = "Welcome To THE GAMES!!!!!";
        String menuString = "1. Play TicTacToe\n2. Play Connect 4 \n0. Exit";
        String choice = "";

        System.out.println(welcomeString);

        while (!"0".equals(choice)) 
        {
            System.out.println(menuString);
            System.out.print("Your choice: ");
            choice = scanner.nextLine();
            String shot;
            switch (choice) {
                case "1":
                    TicTacToe ticTacToe = new TicTacToe();
                    System.out.print(ticTacToe.toText());
                    
                    while(ticTacToe.gameState == 0)
                    {

                        System.out.print("Your shot(ex. A0): ");
                        shot = scanner.nextLine();
                        ticTacToe.playerShot(shot);
                        System.out.println(ticTacToe.toText());
                        
                    }

                    switch (ticTacToe.gameState) {
                        case 1:
                            System.out.println("YOU WON!!!!");
                            break;
                    
                        case 2:
                            System.out.println("YOU LOST!!!!");
                            break;

                        case 3:
                            System.out.println("IT'S A DRAW!!!!");
                            break;
                        default:
                            break;
                    }
                    
                    break;
                
                case "2":
                    Connect4 connect4 = new Connect4();
                    System.out.print(connect4.toText());
                    while(connect4.gameState == 0)
                    {

                        System.out.print("Your shot(ex. 0): ");
                        shot = scanner.nextLine();
                        connect4.playerShot(shot);
                        System.out.println(connect4.toText());
                        
                    }

                    switch (connect4.gameState) {
                        case 1:
                            System.out.println("YOU WON!!!!");
                            break;
                    
                        case 2:
                            System.out.println("YOU LOST!!!!");
                            break;

                        case 3:
                            System.out.println("IT'S A DRAW!!!!");
                            break;
                        default:
                            break;
                    }
                    break;    

                case "0":
                    break;

                default:
                    System.out.println("Choose a correct number");
                    break;
            }

        }

        scanner.close();
    }
}

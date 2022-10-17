package simple.games;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToe 
{   
    private int[][] board = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    private boolean playerFirst;// 1-first 2-last

    private ArrayList<Integer> avaliableSpaces = new ArrayList<>(9);

    public int gameState = 0;// 0-unresolved, 1-won, 2-draw, 3-lost

    private Random rand = new Random();

    TicTacToe()
    {

        for (int i = 0; i < 9; i++) 
        {
            avaliableSpaces.add(i);
        }

        if (rand.nextInt(2) == 1)
        {
            playerFirst = true;
        }
        else
        {
            playerFirst = false;
        }

        if (!playerFirst) 
        {
            System.out.println("You are x!!!\n Me first!!!");
            this.computerShot();
        } 
        else
        {
            System.out.println("You are x!!!\n Your turn!!!");
        }
        

    }

    String toText()
    { 
        String txt = "   | A | B | C |\n---+---+---+---+\n";
        String line = "---+---+---+---+\n";
        for (int i = 0; i < 3; i++) 
        {
            txt = txt + " " + Integer.toString(i) + " ";
            txt = txt.concat("|");
            for(int j = 0; j < 3;j++)
            {
                txt = txt.concat(" "); 
                if (board[i][j] == 1) 
                {
                    txt = txt.concat("x");
                } 
                else if(board[i][j] == 2)
                {
                    txt = txt.concat("o");
                }
                else
                {
                    txt = txt.concat(" ");
                }
                
                txt = txt.concat(" |");
            }
            txt = txt.concat("\n");
            txt = txt.concat(line);
        }
        return txt;
    }

    void playerShot(String coord)
    {
        int y = 0;
        int x = 0;

        try 
        {
            y = Character.getNumericValue(coord.charAt(1));
            switch (coord.charAt(0))
            {
                case 'A':
                    x = 0;
                    break;

                case 'B':
                    x = 1;
                    break;
            
                case 'C':
                    x = 2;
                    break;
            
                default:
                    break;
            }

            if(board[y][x] == 0)
            {
                board[y][x] = 1;

                avaliableSpaces.remove(Integer.valueOf(y*3 + x));

                this.check();
                if(gameState == 0)
                {
                    this.computerShot();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void computerShot()
    {
        int shot = avaliableSpaces.get(rand.nextInt(avaliableSpaces.size()));
        avaliableSpaces.remove(Integer.valueOf(shot));

        int x = shot % 3;
        int y = (shot - x)/3;

        board[y][x] = 2;

        this.check();
    }

    void check()
    {
        int counterPlayer1;
        int counterPlayer2;
        int counterBlank = 0;
        //check horizonrtal
        for(int i = 0; i < 3; i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;
            
            for (int j = 0; j < 3; j++) 
            {
                switch (board[i][j]) {
                    case 1:
                        counterPlayer1++;
                        break;

                    case 2:
                        counterPlayer2++;
                        break;

                    default:
                        break;
                }
                if(counterPlayer1 == 3 )
                {
                    gameState = 1;
                }
                else if(counterPlayer2 == 3)
                {
                    gameState = 2;
                }

            }
            
        }
        //check vertical
        for(int i = 0; i < 3; i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;

            for (int j = 0; j < 3; j++) 
            {
                switch (board[j][i]) {
                    case 1:
                        counterPlayer1++;
                        break;

                    case 2:
                        counterPlayer2++;
                        break;

                    default:
                        break;
                }
                if(counterPlayer1 == 3 )
                {
                    gameState = 1;
                }
                else if(counterPlayer2 == 3)
                {
                    gameState = 2;
                }
            }
        }
        //check cross0
        counterPlayer1 = 0;
        counterPlayer2 = 0;
        for (int i = 0; i < 3; i++)
        {
            switch (board[i][i]) {
                case 1:
                    counterPlayer1++;
                    break;

                case 2:
                    counterPlayer2++;
                    break;

                default:
                    break;
            }
        }
        if(counterPlayer1 == 3 )
        {
            gameState = 1;
        }
        else if(counterPlayer2 == 3)
        {
            gameState = 2;
        }
        //check cross1
        counterPlayer1 = 0;
        counterPlayer2 = 0;
        for (int i = 0; i < 3; i++)
        {
            switch (board[2-i][i]) {
                case 1:
                    counterPlayer1++;
                    break;

                case 2:
                    counterPlayer2++;
                    break;

                default:
                    break;
            }
        }
        if(counterPlayer1 == 3 )
        {
            gameState = 1;
        }
        else if(counterPlayer2 == 3)
        {
            gameState = 2;
        }
        //check draw
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if(board[i][j] == 0){
                    counterBlank++;
                }   
            }    
        }
        if(counterBlank == 0 && gameState == 0)
        {
            gameState = 3;
        }
    }
}

package simple.games;

import java.util.Random;

public class Connect4 
{
    private int[][] board = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}
    };

    private boolean playerFirst;// 1-first 2-last

    public int gameState = 0;// 0-unresolved, 1-won, 2-draw, 3-lost

    private Random rand = new Random();

    Connect4()
    {

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
        String txt = " | 0 | 1 | 2 | 3 | 4 | 5 | 6 |\n +---+---+---+---+---+---+---+\n";
        String line = " +---+---+---+---+---+---+---+\n";
        for (int i = 0; i < 6; i++) 
        {
            txt = txt.concat(" |");
            for(int j = 0; j < 7;j++)
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
        try 
        {
            int shot = Integer.parseInt(coord);

            for (int i = 5; i >=0; i--) 
            {
                if(board[i][shot] == 0)
                {
                    board[i][shot] = 1;
                    break;
                }
            }

            this.check();
            System.out.print("1");
            if(this.gameState == 0)
            {
                System.out.print("1");
                this.computerShot();
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    void computerShot()
    {
        int shot = rand.nextInt(7);

        for (int i = 5; i >=0; i--) 
        {
            if(board[i][shot] == 0)
            {
                board[i][shot] = 2;
                break;
            }
        }

        this.check();
    }

    void check()
    {
        int counterPlayer1 = 0;
        int counterPlayer2 = 0;
        //check horizonrtal
        for(int i = 0; i < 6; i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;
            
            for (int j = 0; j < 7; j++) 
            {
                switch (board[i][j]){
                    case 1:
                        counterPlayer1++;
                        break;

                    case 2:
                        counterPlayer2++;
                        break;

                    default:
                        break;
                }
                if(counterPlayer1 >= 4 )
                {
                    gameState = 1;
                }
                else if(counterPlayer2 >= 4)
                {
                    gameState = 2;
                }

            }
            
        }
        //check vertical
        for(int i = 0; i < 7; i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;

            for (int j = 0; j < 6; j++) 
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
                if(counterPlayer1 >= 4 )
                {
                    gameState = 1;
                }
                else if(counterPlayer2 >= 4)
                {
                    gameState = 2;
                }
            }
        }
        //check cross0.0
        for(int i = 3; i < 6;i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;    
        
            for(int j = 0; j < i;j++)
            {
                switch (board[i-j][j]) 
                {
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
            
            if(counterPlayer1 >= 4 )
            {
                gameState = 1;
            }
            else if(counterPlayer2 >= 4)
            {
                gameState = 2;
            }
        }

        //check cross0.1
        for(int i = 6; i < 9; i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;    
        

            for(int k = (i - 5); k < 7; k++)
            {
                switch (board[i-k][k]) 
                {
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
            
            if(counterPlayer1 >= 4 )
            {
                gameState = 1;
            }
             else if(counterPlayer2 >= 4)
            {
                gameState = 2;
            }
            
        }

        //check cross1.0
        counterPlayer1 = 0;
        counterPlayer2 = 0;
        
        for(int i = 2; i >= 0 ; i--)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;

            for(int j = 0; j+i < 6; j++)
            {
                switch (board[i][i+j])
                {
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
        
        }


        for(int i = 1; i < 4 ; i++)
        {
            counterPlayer1 = 0;
            counterPlayer2 = 0;

            for(int j = 0; j+i < 7; j++)
            {
                switch (board[j][i+j])
                {
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
        
        }

    }

}

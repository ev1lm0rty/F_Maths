/**

* This program will perform the following tasks :
  * Simple math game
  * Infinite game
_______________________________________________________________________________

* Issues and problems :
  * Timer is still not set.
  * High score saving problem ( File Handling) (Solved).
_______________________________________________________________________________

* Credits :
    * Made by : mr_joker
    * Start Date : 26/04/2019
    * End Date :

*/

import java.util.*;
import java.io.*;

class Game
{
    Random rad = new Random();  // To generate Random numbers
    Scanner in = new Scanner(System.in);
    
    static int HighScore = 2;
    static int lives = 3;
    static int score = 0;
    static int level = 3;

    public static void main(String[] args)  throws FileNotFoundException
    {
        Game g = new Game();
        g.display();

        while(true)
        {
            g.math(level);
            level = level + 9;
            System.out.println("\nCurrent Score: "+score+"\nKeep going...");
            System.out.println("\n.......LeVeL Up.......\n");
        }
    }

    void display() throws FileNotFoundException
    {
        try
        {
            File file = new File("highscore.txt");
            Scanner hs = new Scanner(file);
            HighScore = hs.nextInt();
        }

        catch(FileNotFoundException e)
            {
                System.out.println("HighScore File not found..!!!");
            }   

        
        

       
        try
        {

        System.out.println("..........Welcome to The Math Game..........\n");
        Thread.sleep(1000);
        System.out.print("Loading.");

        for(int i = 0 ; i < 36 ; i++)
        {
            System.out.print(".");
            Thread.sleep(100);
        }

        System.out.println("\nDone\n");
        Thread.sleep(1000);
        System.out.println("Instructions :\n");
        Thread.sleep(1000);
        System.out.println(" 1. Solve as many math problems as you can.");
        Thread.sleep(1000);
        System.out.println(" 2. There will be three types of problems....Addition, subtraction and multiplication.");
        Thread.sleep(1000);
        System.out.println(" 3. The game will start with 3 lives...each wrong answer takes a live..");
        Thread.sleep(1000);
        System.out.println(" 4. The game will get tough with time, lets see how much you can score.....");
        Thread.sleep(1000);
        System.out.println(" 5. And ofcourse, don't use a calculator...");
        Thread.sleep(1000);
        System.out.println(" 5. Highest Score till now is : " + HighScore);
        Thread.sleep(1000);
        System.out.println("\nPress Enter to Begin ");
        String s = in.nextLine();
        /* Display high score here */
        }

        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    void gameover() 
    {

        try
        {

            System.out.println("GaMe OvEr SoN...!!!!\n");
            Thread.sleep(1000);

        if(score >= HighScore)
        {
            System.out.println("DaMn..YoU jUsT cReAtEd A hIgH ScOrE oF "+score+" pOiNtS...!!!");
            Thread.sleep(1000);
            System.out.println("WeLl DoNe...!!!");
            Thread.sleep(1000);

            try
            {
                Writer wr = new FileWriter("highscore.txt");
                wr.write( String.valueOf(score));
                wr.close();
            }

            catch(IOException e)
            {
                System.out.println("HighScore File not found..!!!");
            }    
        }

        else
        {

        System.out.println("YoUr ScOrE iS :"+ score);
        Thread.sleep(1000);
        System.out.println("YoU fAiLeD tO bReAk ThE hIgHsCoRe...");
        Thread.sleep(1000);
        System.out.println("BeTtEr LuCk NeXt TiMe...\n");
        Thread.sleep(1000);
        }
        
        System.exit(0);
        }


        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            System.exit(0);
        }
    }

    void math(int level)
    {
        int n = 2;

        while(n > 0)
        {
            add(level);
            sub(level);
            mul(level);
            n--;
        }
    }

    void add(int level)
    {
        int r1= rad.nextInt(level)+1;
        int r2= rad.nextInt(level)+1;
        System.out.print(r1 + " + " + r2 +" = ");
        int res = in.nextInt();
        System.out.print("\n");

        if(res != r1+r2)
            {
                lives--;
                System.out.println("Oops Wrong Answer\nLives Left: "+lives+"\n");
                
                if(lives == 0)
                {
                   gameover();
                }
            }  

        else
            {
                score++;
            }      
        
    }

    void sub(int level)
    {
        int r1= rad.nextInt(level)+1;
        int r2= rad.nextInt(level)+1;
        System.out.print(r1 + " - " + r2+" = ");
        int res = in.nextInt();
        System.out.print("\n");

        if(res != r1-r2)
            {
                lives--;
                System.out.println("Oops Wrong Answer\nLives Left: "+lives+"\n");
                
                if(lives == 0)
                {
                   gameover();
                }
            }  

        else
            {
                score++;
            }      
        
    }

    void mul(int level)
    {
        int r1= rad.nextInt(level)+1;
        int r2= rad.nextInt(level)+1;
        System.out.print(r1 + " * " + r2+" = ");
        int res = in.nextInt();
        System.out.print("\n");

        if(res != r1*r2)
            {
                lives--;
                System.out.println("Oops Wrong Answer\nLives Left: "+lives+"\n");
                
                if(lives == 0)
                {
                   gameover();
                }
            }  

        else
            {
                score++;
            }      
        
    }

    
   
}


/**

* This program will perform the following tasks :
  * Simple math game
  * Infinite game
  * A dummy for my malware for windows
_______________________________________________________________________________

* Issues and problems :
  * Timer is still not set.
  * High score saving problem ( File Handling).
_______________________________________________________________________________

* Credits :
    * Made by : mr_joker
    * Start Date : 26/04/2019
    * End Date :

*/



#include<iostream>
#include<fstream>
#include<unistd.h>
#include<string>

using namespace std;

int HighScore = 25;
int lives = 3;
int score = 0;
int level = 3;
int sublevel = 2;
int res;
string strr;


void display();
void math(int level,int sublevel);
void add(int level,int sublevel);
void sub(int level,int sublevel);
void mul(int level,int sublevel);
void gameover();


int main()
{
    srand(time(0));
    display();

    while(1)
    {
        math(level,sublevel);
        sublevel = level + 5;
        level = level + 9;
        cout<<"\nCurrent Score: "<<score<<"\nKeep going..."<<endl;
        cout<<"\n.......LeVeL Up......."<<endl;
    }
}

void display()
{
        cout<<"..........Welcome to The Math Game.........."<<endl;
        sleep(1);
        cout<<"Instructions :"<<endl;
        sleep(1);
        cout<<" 1. Solve as many math problems as you can."<<endl;
        sleep(1);
        cout<<" 2. There will be four types of problems....Addition, subtraction and multiplication."<<endl;
        sleep(1);
        cout<<" 3. The game will start with 3 lives...each wrong answer takes a live.."<<endl;
        sleep(1);
        cout<<" 4. The game will get tough with time, lets see how much you can score....."<<endl;
        sleep(1);
        cout<<" 5. Highest Score till now is : "<<HighScore<<endl;
        sleep(1);
        cout<<" Press Enter to Begin "<<endl;
        getline(cin,strr);
}


void math(int level, int sublevel)
{
    int n = 2;

        while(n--)
        {
            add(level,sublevel);
            sub(level,sublevel);
            mul(level,sublevel);
        }
}

void add(int level, int sublevel)
{
    int r1 = (rand() % level) + 1;
    int r2 = (rand() % sublevel) + 1;
    

    cout << r1 <<" + "<< r2 <<" = ";
    cin >> res;

    if(res != r1 + r2)
    {
        lives--;
        cout << "Oops Wrong Answer\nLives Left: "<<lives<<"\n";
        
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

void sub(int level,int sublevel)
{
    int r1 = (rand() % level) + 1;
    int r2 = (rand() % sublevel) + 1;
    

    cout << r1 <<" - "<< r2 <<" = ";
    cin >> res;

    if(res != r1 - r2)
    {
        lives--;
        cout << "Oops Wrong Answer\nLives Left: "<<lives<<"\n";
        
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

void mul(int level, int sublevel)
{
    int r1 = (rand() % level) + 1;
    int r2 = (rand() % sublevel) + 1;
    

    cout << r1 <<" * "<< r2 <<" = ";
    cin >> res;

    if(res != r1 * r2)
    {
        lives--;
        cout <<endl<< "Oops Wrong Answer\nLives Left: "<<lives<<endl<<endl;
        
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

void gameover()
{
    cout<<endl<<"GaMe OvEr SoN...!!!!"<<endl<<endl;
    sleep(1);
    
    if(score > HighScore)
    {
        HighScore = score;
        cout <<"DaMn..YoU jUsT cReAtEd A hIgH ScOrE oF "<<score<<" pOiNtS...!!!"<<endl<<endl;
        sleep(1);
        cout <<"YoU aRe DaMn GoOd"<<endl<<endl;
        sleep(1);
        
    }

    else
    {   
        cout<<endl<<"YoUr ScOrE iS : "<<score<<endl<<endl;
        sleep(1);
        cout<<"YoU fAiLeD tO bReAk ThE hIgHsCoRe..."<<endl<<endl;
        sleep(1);
        cout<<"BeTtEr LuCk NeXt TiMe..."<<endl<<endl;
        sleep(1);
    }

    exit(0);
    
}
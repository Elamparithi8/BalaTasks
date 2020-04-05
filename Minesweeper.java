import java.util.Random;
import java.util.Scanner;

public class Minesweeper
{
    public static void displayTable(String[][] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.print(i+"\t");
            for (int j=0;j<array[i].length;j++)
            {
                System.out.print(array[i][j]+"\t");

            }
            System.out.println();
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int rows = 5;//how many rows in minesweeper
        int column = 5;//how many column in minesweeper
        int mines = 5;//how many mines in minesweeper
        int win = 0;//to decide the win or loss
        int[][] minesweeper = new int[rows][column];//forming table using 2d array
        for(int i=0;i<mines;i++)
        {
            Random random_bombs = new Random();
             int row = random_bombs.nextInt(rows);
            int cols = random_bombs.nextInt(column);
            if(minesweeper[row][cols]!=-1)
            {
                minesweeper[row][cols]=-1;//set mines in random place
            }
            else
            {
                i-=1;
            }
        }
        int i=0;
        int j=0;
        //compute the number for all mines to the neighbour
        for(int k=0;k<minesweeper.length;k++)
        {
            for (int m=0;m<minesweeper[k].length;m++)
            {
                if(minesweeper[k][m]==-1){
                    i=k;
                    j=m;
                     if(i==0 && j==(column-1))
                     {
                         if(minesweeper[i][j-1]!=-1){
                             minesweeper[i][j-1]+=1;
                         }
                         if(minesweeper[i+1][j-1]!=-1) {
                             minesweeper[i + 1][j - 1] += 1;
                         }
                         if(minesweeper[i + 1][j]!=-1){
                             minesweeper[i + 1][j] += 1;
                         }
                     }
                     else if(i==0 && j==0)
                     {
                         if(minesweeper[i][j+1]!=-1){
                             minesweeper[i][j+1]+=1;
                         }
                         if(minesweeper[i+1][j]!=-1){
                             minesweeper[i+1][j]+=1;
                         }
                         if(minesweeper[i+1][j+1]!=-1) {
                             minesweeper[i + 1][j + 1] += 1;
                         }
                     }
                     else if(i==(rows-1) && j==0)
                     {
                         if(minesweeper[i-1][j]!=-1) {
                             minesweeper[i - 1][j] += 1;
                         }
                         if(minesweeper[i-1][j+1]!=-1) {
                             minesweeper[i - 1][j + 1] += 1;
                         }
                         if(minesweeper[i][j+1]!=-1) {
                             minesweeper[i][j + 1] += 1;
                         }
                     }
                     else if(i==(rows-1) && j==(column-1))
                     {
                         if(minesweeper[i-1][j-1]!=-1){
                             minesweeper[i-1][j-1]+=1;
                         }
                         if(minesweeper[i-1][j]!=-1){
                             minesweeper[i-1][j]+=1;
                         }
                         if(minesweeper[i][j-1]!=-1){
                             minesweeper[i][j-1]+=1;
                         }
                     }
                     else if((i>0 && i<(rows-1)) && j==0)
                     {
                         if(minesweeper[i-1][j]!=-1){
                             minesweeper[i-1][j]+=1;
                         }
                         if(minesweeper[i-1][j+1]!=-1){
                             minesweeper[i-1][j+1]+=1;
                         }
                         if(minesweeper[i][j+1]!=-1){
                             minesweeper[i][j+1]+=1;
                         }
                         if(minesweeper[i+1][j]!=-1){
                             minesweeper[i+1][j]+=1;
                         }
                         if(minesweeper[i+1][j+1]!=-1){
                             minesweeper[i+1][j+1]+=1;
                         }
                     }
                     else if((i>0 && i<(rows-1)) && j==(column-1))
                     {
                         if(minesweeper[i-1][j-1]!=-1){
                             minesweeper[i-1][j-1]+=1;
                         }
                         if(minesweeper[i-1][j]!=-1){
                             minesweeper[i-1][j]+=1;
                         }
                         if(minesweeper[i][j-1]!=-1){
                             minesweeper[i][j-1]+=1;
                         }
                         if(minesweeper[i+1][j-1]!=-1){
                             minesweeper[i+1][j-1]+=1;
                         }
                         if(minesweeper[i+1][j]!=-1){
                             minesweeper[i+1][j]+=1;
                         }
                     }
                     else if(i==0 && (j>0 && j<(column-1) ))
                     {
                         if(minesweeper[i][j-1]!=-1){
                             minesweeper[i][j-1]+=1;
                         }
                         if(minesweeper[i][j+1]!=-1){
                             minesweeper[i][j+1]+=1;
                         }
                         if(minesweeper[i+1][j-1]!=-1){
                             minesweeper[i+1][j-1]+=1;
                         }
                         if(minesweeper[i+1][j]!=-1){
                             minesweeper[i+1][j]+=1;
                         }
                         if(minesweeper[i+1][j+1]!=-1){
                             minesweeper[i+1][j+1]+=1;
                         }
                     }
                     else if(i==(rows-1) && (j>0 && j<(column-1)))
                     {
                         if(minesweeper[i-1][j-1]!=-1){
                             minesweeper[i-1][j-1]+=1;
                         }
                         if(minesweeper[i-1][j]!=-1){
                             minesweeper[i-1][j]+=1;
                         }
                         if(minesweeper[i-1][j+1]!=-1){
                             minesweeper[i-1][j+1]+=1;
                         }
                         if(minesweeper[i][j-1]!=-1){
                             minesweeper[i][j-1]+=1;
                         }
                         if(minesweeper[i][j+1]!=-1){
                             minesweeper[i][j+1]+=1;
                         }
                     }
                     else if((i>0 && i<(rows-1)) && (j>0 && j<(column-1))){
                         if(minesweeper[i-1][j-1]!=-1){
                             minesweeper[i-1][j-1]+=1;
                         }
                         if(minesweeper[i-1][j]!=-1){
                             minesweeper[i-1][j]+=1;
                         }
                         if(minesweeper[i-1][j+1]!=-1){
                             minesweeper[i-1][j+1]+=1;
                         }
                         if(minesweeper[i][j-1]!=-1){
                             minesweeper[i][j-1]+=1;
                         }
                         if(minesweeper[i][j+1]!=-1){
                             minesweeper[i][j+1]+=1;
                         }
                         if(minesweeper[i+1][j-1]!=-1){
                             minesweeper[i+1][j-1]+=1;
                         }
                         if(minesweeper[i+1][j]!=-1){
                             minesweeper[i+1][j]+=1;
                         }
                         if(minesweeper[i+1][j+1]!=-1){
                             minesweeper[i+1][j+1]+=1;
                         }
                     }
                }
            }
        }
        int flag_count = 0;//how many flags used by player
        String[][] minesweeper_display = new String[rows][column];
        for( i=0;i<minesweeper_display.length;i++)
        {
            for(j=0;j<minesweeper_display[i].length;j++)
            {
                minesweeper_display[i][j]="?";
            }
        }
        for(i=0;i<column;i++)
        {
            System.out.print("\t"+i);
        }
        System.out.println();
        displayTable(minesweeper_display);//show the minesweeper board
        Scanner scanner = new Scanner(System.in);
        boolean mine = false;
        while(mine!=true)
        {
            System.out.println("Enter f or o (f is mark flag and o is to open)");
            String mark_flag_or_open = scanner.next();
            mark_flag_or_open = mark_flag_or_open.toUpperCase();
            System.out.println("Enter the rows");
            int playing_rows = scanner.nextInt();
            System.out.println("Enter the columns");
            int playing_columns = scanner.nextInt();
            if(mark_flag_or_open.equals("F") && flag_count<mines)
            {
                    minesweeper_display[playing_rows][playing_columns]=(String) "F";
                    flag_count=0;
                for( i=0;i<minesweeper_display.length;i++)
                {
                    for ( j=0;j<minesweeper_display[i].length;j++)
                    {
                        if(minesweeper_display[i][j]=="F")
                        {
                            flag_count++;
                        }
                    }
                }

            }
            else if(mark_flag_or_open.equals("O"))
            {
                int value_in_box = minesweeper[playing_rows][playing_columns];
                if(value_in_box==-1)
                {
                    System.out.println("Game ends");
                    //show all bomb places
                    mine=true;
                    for(i=0;i<minesweeper.length;i++)
                    {
                        for(j=0;j<minesweeper[i].length;j++)
                        {
                            if(minesweeper[i][j]==-1)
                            {
                                minesweeper_display[i][j]=""+-1;
                            }
                        }
                    }
                }
                else if(value_in_box!=-1)
                {
                    for( i=0;i<minesweeper_display.length;i++)
                        {
                            for ( j=0;j<minesweeper_display[i].length;j++)
                            {
                                if(minesweeper[i][j]==0)
                                {
                                    minesweeper_display[i][j]=""+0;
                                }

                            }
                        }
                        minesweeper_display[playing_rows][playing_columns]=""+minesweeper[playing_rows][playing_columns];
                }
            }
            else
            {
                System.out.println("No flags left");
            }
            for(i=0;i<column;i++)
            {
                System.out.print("\t"+i);
            }
            System.out.println();
            displayTable(minesweeper_display);
            win=0;
            for(i=0;i<minesweeper_display.length;i++)
            {
                for (j=0;j<minesweeper_display[i].length;j++)
                {
                    if(minesweeper_display[i][j].equals("?"))
                    {
                        win++;
                    }
                }
            }
            if(win==0)
            {
                System.out.println("You wins");
                mine=true;
            }
        }
    }
}
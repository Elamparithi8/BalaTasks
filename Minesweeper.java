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
    public static void displayTable(int[][] array)
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
    public static void setDefaultValues(int[][] arr,int value){
        for(int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=value;
            }
        }
    }
    public static void setDefaultValues(String[][] arr,String value){
        for(int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++)
            {
                arr[i][j]=value;
            }
        }
    }
    public static void setMines(int rows,int column,int mines,int[][] minesweeper){
        for(int i=0;i<mines;i++)
        {
            Random random_bombs = new Random();
            int row = random_bombs.nextInt(rows);
            int cols = random_bombs.nextInt(column);
            if(minesweeper[row][cols]!=-1)
            {
                minesweeper[row][cols]=-1;//set mines in random place
            }
            else if(row<(rows-1) && minesweeper[row][cols]==-1)
            {
                if(minesweeper[row+1][cols]!=-1)
                {
                    minesweeper[row+1][cols]=-1;
                }
                else{
                    i-=1;
                }
            }
            else if(column<(cols-1) && minesweeper[row][cols]==-1)
            {
                if(minesweeper[row][cols]!=-1)
                {
                    minesweeper[row][cols+1]=-1;
                }
                else{
                    i-=1;
                }
            }
            else
            {
                i-=1;
            }
        }
    }
    public static void countFlagLeft(int mines,int flagcount)
    {
        System.out.println("Flag left : "+(mines-flagcount));
    }
    public static void showBomb(int[][] minesweeper,String[][] minesweeper_display)
    {
        for(int i=0;i<minesweeper.length;i++)
        {
            for(int j=0;j<minesweeper[i].length;j++)
            {
                if(minesweeper[i][j]==-1)
                {
                    minesweeper_display[i][j]=""+-1;
                }
            }
        }
    }
    public static int forCounting(String[][] minesweeper_display,int flag_count,String match)
    {
        for(int i=0;i<minesweeper_display.length;i++)
        {
            for (int j=0;j<minesweeper_display[i].length;j++)
            {
                if(minesweeper_display[i][j].equals(match))
                {
                    flag_count++;
                }
            }
        }
        return flag_count;
    }
    public static void columnIndex(int column)
    {
        for(int i=0;i<column;i++)
        {
            System.out.print("\t"+i);
        }
        System.out.println();
        System.out.println();
    }
    public static void computeNumbers(int[][] minesweeper,int rows,int column)
    {
        for(int i=0;i<minesweeper.length;i++)
        {
            for(int j=0;j<minesweeper[i].length;j++)
            {
                if(minesweeper[i][j]==-1) {
                    int x =i;
                    int y=j;
                    x--;
                    y--;
                    for(int k=0;k<3;k++)
                    {
                        for(int l=0;l<3;l++)
                        {
                            int count = 0;
                            try{
                                    minesweeper[x][y]=minesweeper[x][y];
                            }
                            catch (ArrayIndexOutOfBoundsException e){
                                count = 1;
                            }
                            if(count==1){
                                y++;
                                continue;
                            }
                            else if(count==0 && minesweeper[x][y]!=-1){
                               
                                minesweeper[x][y]+=1;
                                
                            }
                            y++;
                        }
                        x++;
                        y-=3;
                    }
                }
            }
        }
    }
    public static void startGame() throws InterruptedException {
        int rows = 5;//how many rows in minesweeper
        int column = 5;//how many column in minesweeper
        int mines = 5;//how many mines in minesweeper
        int win = 0;//to decide the win or loss
        int[][] minesweeper = new int[rows][column];//forming table using 2d array
        //setdefault values
        setDefaultValues(minesweeper,0);
        //set mines
        setMines(rows,column,mines,minesweeper);
        //compute the number for all mines to the neighbour
        computeNumbers(minesweeper,rows,column);
        displayTable(minesweeper);
        int flag_count = 0;//how many flags used by player
        String[][] minesweeper_display = new String[rows][column];
        setDefaultValues(minesweeper_display,"?");
        columnIndex(column);
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
            countFlagLeft(mines,flag_count);
            if(mark_flag_or_open.equals("F") && flag_count<mines)
            {
                minesweeper_display[playing_rows][playing_columns]=(String) "F";
                flag_count=0;
                //for flag count
                flag_count=forCounting(minesweeper_display,flag_count,"F");

            }
            else if(mark_flag_or_open.equals("O"))
            {
                int value_in_box = minesweeper[playing_rows][playing_columns];
                if(value_in_box==-1)
                {
                    System.out.println("Game ends");
                    //show all bomb places
                    mine=true;
                    //show bomb
                    showBomb(minesweeper,minesweeper_display);
                }
                else if(value_in_box!=-1)
                {
                    for(int i=0;i<minesweeper_display.length;i++)
                    {
                        for (int j=0;j<minesweeper_display[i].length;j++)
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
            //colum index
            columnIndex(column);
            displayTable(minesweeper_display);
            win=0;
            win=forCounting(minesweeper_display,win,"?");
            if(win==0)
            {
                System.out.println("You wins");
                mine=true;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Minesweeper mines = new Minesweeper();
        mines.startGame();
    }
}

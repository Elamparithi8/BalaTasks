import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder
{
    static HashMap ladder_places;
    static HashMap snake_places;
    static int[][] board;

    public static HashMap getSnake_place()
    {
        HashMap<Integer,Integer> snake_places = new HashMap<>();
        snake_places.put(32,10);
        snake_places.put(36,6);
        snake_places.put(48,26);
        snake_places.put(62,18);
        snake_places.put(88,24);
        snake_places.put(95,56);
        snake_places.put(97,78);
        return snake_places;
    }

    public static HashMap getLadder_places()
    {
        HashMap<Integer,Integer> ladder_places = new HashMap<>();
        ladder_places.put(1,38);
        ladder_places.put(4,14);
        ladder_places.put(8,30);
        ladder_places.put(21,42);
        ladder_places.put(28,76);
        ladder_places.put(50,67);
        ladder_places.put(71,92);
        ladder_places.put(80,99);
        return ladder_places;
    }

    public static int[][] getBoard()
    {
       int[][] board = new int[10][10];
       int num = 100;
       int num1 = 81;
       for(int i=0;i<board.length;i+=2)
       {
           for(int j=0;j<board[i].length;j++)
           {
               board[i][j]=num;
               num--;
           }
           num-=10;
       }
        for(int i=1;i<board.length;i+=2)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j]=num1;
                num1++;
            }
            num1-=30;
        }
       return board;
    }
    public static int rollDice()
    {
        Random random = new Random();
        int random_num = random.nextInt(6)+1;
        return random_num;
    }
    public static void printDice(int num)
    {
        System.out.println("--------");
        System.out.println("   "+num);
        System.out.println("--------");
    }
    public static void movePlayers(int num,int[][] board,int player)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(num==board[i][j] && num<=100)
                {
                    board[i][j]=player;
                }
            }
        }
    }
    public static void showBoard(int[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            System.out.print("\t\t\t\t");
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j] < 0)
                {
                    System.out.print(+board[i][j] + "*\t\t");
                }
                else
                {
                    System.out.print(+board[i][j]+"\t\t");
                }
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
    public static void clearScreen()
    {
	System.out.print("\033[H\033[2J");
	System.out.flush();
    }

    public static void startGame()
    {
        snake_places=getSnake_place();
        ladder_places=getLadder_places();
        board = getBoard();
        System.out.print("\t\t\tYou = -1");
        System.out.println();
        System.out.print("\t\t\tPlayer2 = -2");
        System.out.println();
        int player1 = 0;
        int player1_coin = -1;
        int player2_coin = -2;
        int player2 = 0;
        while(board[0][0]!=-1 && board[0][0]!=-2){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Roll dice 'yes/no'");
            String answer = scanner.next();
            if(answer.equals("yes")) {
                int dice_num1 = rollDice();
                player1 += dice_num1;
		clearScreen();
                System.out.println("You got !");
                printDice(dice_num1);
                if (snake_places.containsKey(player1)) {
                    System.out.println("Snake bites you");
                    int value = (int) snake_places.get(player1);
                    player1 = value;
                }
                if (ladder_places.containsKey(player1)) {
                    System.out.println("You got a ladder");
                    int value = (int) ladder_places.get(player1);
                    player1 = value;
                }
                if (player1 > 100) {
                    player1 -= dice_num1;
                }
                if (dice_num1 == 6) {
                    System.out.println("You got a Extra Dice");
                    board = getBoard();
                    movePlayers(player1, board, player1_coin);
                    movePlayers(player2,board,player2_coin);
                    showBoard(board);
                    continue;
                }
                boolean opponent_dice = false;
                do{
                    opponent_dice = false;
                    int dice_num2 = rollDice();
		    System.out.println("Opponent got !");
                    printDice(dice_num2);
                    player2 += dice_num2;
                    if (snake_places.containsKey(player2)) {
                        System.out.println("Snake bites opponents");
                        int value = (int) snake_places.get(player2);
                        player2 = value;
                    }
                    if (ladder_places.containsKey(player2)) {
                        System.out.println("Opponents got a ladder");
                        int value = (int) ladder_places.get(player2);
                        player2 = value;
                    }
                    if (player2 > 100) {
                        player2 -= dice_num2;
                    }
                    if(dice_num2==6){
                        System.out.println("Opponents got Extra Dice");
                        opponent_dice = true;
                    }
                    board = getBoard();
                    movePlayers(player1, board, player1_coin);
                    movePlayers(player2, board, player2_coin);
                    showBoard(board);
                }while(opponent_dice==true);
            }
            else if(answer.equals("no"))
            {
                System.out.println("Match quit");
                System.exit(0);
            }
        }
        while(board[0][0]==-1)
        {
            System.out.println("You won");
            break;
        }
        while(board[0][0]==-2)
        {
            System.out.println("Opponents won");
            break;
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        startGame();
    }
}

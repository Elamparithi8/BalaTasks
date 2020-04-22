import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadder
{
    static int[][] board;
        public static int[][] getBoard()
    {
        int j=0;
        int[][] board = new int[10][10];
        int num = 100;
        int value = 1;
        for(int i=0;i<board.length;i++)
        {
            value=value*(-1);
            for(j=0;j<board[i].length-1;j++)
            {
                board[i][j]=num;
                num +=value;
            }
            board[i][j]=num;
            num-=10;
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
    public static int checkSnake(int player_position)
    {
        int change_position = 0;
        switch (player_position)
        {
            case 32 :
                System.out.println("Snake Bites You");
                change_position = 10;
                break;
            case 36 :
                System.out.println("Snake Bites You");
                change_position = 6;
                break;
            case 48 :
                System.out.println("Snake Bites You");
                change_position = 26;
                break;
            case 62 :
                System.out.println("Snake Bites You");
                change_position = 18;
                break;
            case 88 :
                System.out.println("Snake Bites You");
                change_position = 24;
                break;
            case 95 :
                System.out.println("Snake Bites You");
                change_position = 56;
                break;
            case 97 :
                System.out.println("Snake Bites You");
                change_position = 78;
                break;
            default:
                change_position = player_position;
        }
        return change_position;
    }

    public static int checkLadder(int player_position)
    {
        int change_position = 0;
        switch (player_position)
        {
            case 1 :
                System.out.println("You got a ladder!");
                change_position = 38;
                break;
            case 4 :
                System.out.println("You got a ladder!");
                change_position = 14;
                break;
            case 8 :
                System.out.println("You got a ladder!");
                change_position = 30;
                break;
            case 21 :
                System.out.println("You got a ladder!");
                change_position = 42;
                break;
            case 28 :
                System.out.println("You got a ladder!");
                change_position = 76;
                break;
            case 50 :
                System.out.println("You got a ladder!");
                change_position = 67;
                break;
            case 71 :
                System.out.println("You got a ladder!");
                change_position = 92;
                break;
            case 80 :
                System.out.println("You got a ladder!");
                change_position = 99;
                break;
            default:
                change_position = player_position;

        }
        return change_position;
    }
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void startGame()
    {
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
                player1 = checkSnake(player1);
                player1 = checkLadder(player1);
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
                    player2 = checkSnake(player2);
                    player2 = checkLadder(player2);
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
        if(board[0][0]==-1)
        {
            System.out.println("You won");
        }
        else if(board[0][0]==-2)

        {
            System.out.println("Opponents won");
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        startGame();
    }
}

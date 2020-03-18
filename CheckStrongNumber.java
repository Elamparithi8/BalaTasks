import java.util.Scanner;
public class CheckStrongNumber{
    public static int factorial(int num){
        int answer = 1;
        while(num>0)
        {
            answer *= num;
            num--;
        }
        return answer;
    }
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the number :");
       int input = (int)scanner.nextInt();
       int copy_input = input;
       int output = 0;
       
        while(copy_input>0)
       {
            int rem = copy_input%10;
            output+=factorial(rem);
            copy_input = (int)copy_input/10;

       }
       if (input==output)
       {
           System.out.println("Strong number");
       }
       else
       {
           System.out.println("Not a Strong Number");
       }

       }

}

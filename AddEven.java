public class AddEven
{

        public static void main(String[] args) 
        {

           int input = 2345;

           int output = 0;

           int copy_input = input;


            while(copy_input>0)
            {
                int rem = copy_input%10;
                if(rem%2==0)
                {
                    output+=rem;
                }
                else
                {
                    output=output;
                }
                copy_input = (int) copy_input/10;
            }
            System.out.println(output);
        }

}
/*
    6) @ZS2020 write a program to print the sum of digits that are even.

    Input : 123
    Output : 2
    (as 2 is only even)

    Input : 2345
    Output : 6
    (2+4)



*/

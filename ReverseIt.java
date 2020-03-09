public class ReverseIt{

        public static void main(String[] args) {

           int input = 123;

           int output = 0;

           int size = (int) (Math.log10(input) + 1);

           size = size - 1;

           int copy_input = input;


            while(copy_input>0)
            {
                int rem = copy_input%10;
                int digits = (int) Math.pow(10,size);
                output += rem*digits;
                copy_input = (int) copy_input/10;
                size--;
            }
            System.out.println(output);
        }

}
/*
    5) @ZS2020, write a program to find the reverse of a number.

    Input : 123
    Output : 321

    Strings and Arrays should not be used.

*/
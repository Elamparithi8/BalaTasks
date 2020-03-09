public class AritmeticProgession{
    public static String removeLastCharacter(String words){

        int size = words.length();

        String string = "";

            for(int i=0;i<size-1;i++)
            {

                string+=words.charAt(i);

            }

            return string;
    }

    public static void main(String[] args) {
            int no_of_elements = 5;

            int initial_num = 2;

            int clone_initial_num = initial_num;

            int difference = 3;

            String output = "";

            for(int i=1;i<=no_of_elements;i++)
            {

                output+=clone_initial_num+",";
                clone_initial_num+=difference;

            }

            int size = output.length();

            System.out.println(removeLastCharacter(output));
    }

}
/*
    4) Write a program to print Arithmetic Progression series. 

    Input 
    No.Of.Elements : 5 
    Start : 2 
    Difference : 3 
    
    Output 
    2, 5, 8, 11, 14
    
*/
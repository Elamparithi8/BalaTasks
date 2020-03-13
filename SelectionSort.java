import java.util.Arrays;
public class SelectionSort{
    public static void main(String[] args) {
        int[] input = {18 ,9 ,33 ,4 ,84 ,32,32,42,11,44,21,52 };
        int index = 0;
        int minimum = 0;
        int[] output = new int[input.length];

        for (int i=0;i<input.length;i++)
        {
            index = i;
            minimum = input[i];
            for (int j=i;j<input.length;j++)
            {
                if(minimum>input[j])
                {
                    minimum=input[j];
                    index = j;
                }
                else
                {
                    minimum=minimum;
                }
            }
            input[index]=input[i];
            input[i]=minimum;

        }
        System.out.println(Arrays.toString(input));
    }
}

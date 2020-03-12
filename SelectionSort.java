import java.util.Arrays;
public class SelectionSort{
    public static void main(String[] args) {
        int[] input = {18 ,9 ,33 ,4 ,84 ,32 };
        int[] copy_input = input;
        int minimum = 0;
        int[] output = new int[copy_input.length];

        for (int i=0;i<copy_input.length;i++)
        {
            minimum = copy_input[i];
            for (int j=0;j<copy_input.length;j++)
            {
                 if(minimum>copy_input[j])
                 {
                     minimum=copy_input[j];
                 }
                 else
                 {
                     minimum=minimum;
                 }
            }
            output[i]=minimum;
            for(int k=0;k<copy_input.length;k++)
            {
                if(copy_input[k]==minimum){
                    copy_input[k]=1000;
                }
                else
                {
                    copy_input[k]=copy_input[k];
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }
}

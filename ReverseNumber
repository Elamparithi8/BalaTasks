import java.util.*;
public class ReverseNumber{

    public static void main(String[] args) {
        
	int input =564321789;

        int copy_input = input;

        String output = "";

        ArrayList<Integer> array_numbers = new ArrayList<>();

        while(copy_input>0)
	{
            int rem = copy_input%10;
            array_numbers.add(rem);
            copy_input=(int)copy_input/10;
        }

        Collections.sort(array_numbers);

        Collections.reverse(array_numbers);

        Object[] filtered_array = array_numbers.toArray();

        for(Object j:filtered_array)
	{
            output+=j;
        }
        System.out.println(output);
    }

}


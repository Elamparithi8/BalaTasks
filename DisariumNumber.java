public class DisariumNumber{
    public static void main(String[] args) {
        int input = 518;
        int copy_input = input;
        int output = 0;
        int size = (int) (Math.log10(input) + 1);

        while (copy_input>0)
        {
            int rem = copy_input%10;
            output+=(int)Math.pow(rem,size);
            size--;
            copy_input= (int)copy_input/10;

        }

        if(input==output)
        {
            System.out.println("Disarium Number");
        }
        else{
            System.out.println("Not a Disarium Number");
        }
    }
}

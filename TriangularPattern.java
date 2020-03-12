public class TriangularPattern{
    public static void main(String[] args) {

       int input = 7;

       int column = 1;

       int initial_num = 1;
       
       for(int i=0;i<input;i++)
       {
            for(int j=0;j<column;j++)
            {
                System.out.print(initial_num+" ");
                if(j<Math.round(column/2))
                {
                    initial_num++;
                }
                else
                {
                       initial_num--;
                }

            }
            column+=2;
            initial_num=1;
           System.out.println();

       }

    }
}

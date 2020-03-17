public class TriangularPattern{
    public static void main(String[] args) {

        int input = 7;
        int column = 1;
        int triangular_array [][] = new int[input][];
        for(int i=0;i<triangular_array.length;i++)
        {
            int initial_num = 0;
            triangular_array[i] = new int[column];
            int j;
            for(j=0;j<=(triangular_array[i].length-(triangular_array[i].length/2)-1);j++)
            {
                initial_num+=1;
                System.out.print(initial_num+" ");
            }
            for(int k=j;k<triangular_array[i].length;k++)
            {
                initial_num--;
                System.out.print(initial_num+" ");
            }
            column+=2;

            System.out.println();

        }

    }
}
/*
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

*/

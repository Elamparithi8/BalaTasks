public class Triangle{
        public static void main(String[] args) {
            int num = 1;
            int k=4;
            for(int i=0;i<4;i++){
                for(int j=0;j<k;j++){
                    System.out.print(num+" ");
                    num++;
                }
                System.out.println();
                k--;
            }
        }

}
//revised code after the session
public class Triangle{
    public static void main(String[] args) {
        int intial_number = 1;
        int rows=4;
        int intial_columns = rows;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<intial_columns;j++)
            {
                System.out.print(num+"\t");
                num++;
            }
            System.out.println();
            intial_columns--;
        }
    }

}

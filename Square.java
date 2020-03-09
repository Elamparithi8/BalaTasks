public class Square{
        public static void main(String[] args) {
            int num = 1;
            int k=4;
            int num1 = 16;
            int num2 = 8;
            for(int i=0;i<4;i++){
                for(int j=0;j<k;j++){
                    if(i==3){
                        System.out.print(num1+" ");
                        num1--;
                        num++;
                    }
                    else if(i==1){
                        System.out.print(num2+" ");
                        num2--;
                        num++;
                    }
                    else {
                        System.out.print(num + " ");
                        num++;
                    }

                }
                System.out.println();

            }
        }

}
//revised after the session
public class Square{
    public static void main(String[] args) {
        int num = 1;
        int row_column = 4;
        int copy_num = 1;
        int incre_three = 3;

        for(int i=0;i<row_column;i++)
        {
            
            for(int j=0;j<row_column;j++)
            {
                if(i%2!=0)
                {
                    if(j==0)
                    {
                        copy_num = num+incre_three;
                    }
                    System.out.print(copy_num+" ");
                    copy_num--;
                    num++;
                }
                else 
                {
                    System.out.print(num + " ");
                    num++;
                }

            }
            System.out.println();

        }
    }

}




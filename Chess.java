public class Chess{
        public static void main(String[] args) {
            int chess = 1;
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < 4; k++) {
                    if(chess<0){
                        System.out.print(1+" ");
                    }
                    else{
                        System.out.print(chess+" ");
                    }
                    if ((k % 2) == 0) {
                        chess--;
                    } else {
                        chess++;
                    }
                }
                if(chess==1){
                    chess--;
                }
                else{
                    chess++;
                }

                System.out.println();
            }
        }

}
//revised code after the session

public class Chess{
        public static void main(String[] args) {
            int chess_black = 1;
            int chess_white = 0;
            int rows_column = 4;    
            for (int i = 0; i < rows_column; i++)
            {
                for (int k = 0; k < rows_column; k++)
                {
                    if(i%2==0 && k%2==0)
                    {
                        System.out.print(chess_black);
                    }
                    else if(i%2==0 && k%2!=0)
                    {
                        System.out.print(chess_white);
                    }
                    else if(i%2!=0 && k%2==0)
                    {
                        System.out.print(chess_white);
                    }
                    else
                    {
                        System.out.print(chess_black);

                    }
                }
                System.out.println();
            }
        }
}




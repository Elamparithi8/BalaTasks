//code updated
public class Chess{
        public static void main(String[] args) {
            int chess = 1;
            int chess1 = 0;
            for (int i = 0; i < 4; i++) {
                for (int k = 0; k < 4; k++) {
                    if(i%2==0 && k%2==0){
                        System.out.print(chess);
                    }
                    else if(i%2==0 && k%2!=0){
                        System.out.print(chess1);
                    }
                    else if(i%2!=0 && k%2==0){
                        System.out.print(chess1);
                    }
                    else{
                        System.out.print(chess);

                    }
                }
                System.out.println();
            }
        }
}
/*
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




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
        //output
       /* 1 2 3 4 
        8 7 6 5 
        9 10 11 12 
        16 15 14 13*/




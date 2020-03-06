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

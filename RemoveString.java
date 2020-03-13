import java.util.Arrays;

public class RemoveString{
        public static void main(String[] args) {
            String sentance = "I am elamparithi am running";
            String remove = "am";
            int remove_len = remove.length()-1;
            String output = "";
            if(sentance.contains(remove)){
                String[] words = sentance.split(" ");
                for (String k:words){
                    if(k.equals(remove)){

                    }
                    else{
                        output+=k+" ";
                    }
                }
            }
            else{
                System.out.println(sentance);
            }
            System.out.println(output);
        }
    }

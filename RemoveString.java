public class RemoveString{
    public static void main(String[] args) {
        String sentance = "I am elamparithi";
        String remove = "am";
        sentance=sentance.replace(remove,"");
        System.out.println(sentance);
    }
}

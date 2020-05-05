import java.util.*;

public class WhatsappApi{
    static HashMap<String,String> contacts_array = new HashMap<>();
    static HashMap<String, LinkedList> mssgs_array = new HashMap<>();
    public static void showContacts()
    {
        Set list_of_contact = contacts_array.keySet();
        Iterator iterator = list_of_contact.iterator();
        while (iterator.hasNext()) {
            String num = (String) iterator.next();
            System.out.println("Name :  "+contacts_array.get(num));
        }
    }
    public static LinkedList showMessages(String number)
    {
        LinkedList list = mssgs_array.get(number);
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        return list;
    }
    public static void createContacts()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the mobile number");
        String num = scanner.next();
        System.out.println("Enter the name");
        String name = scanner.next();
        if(!contacts_array.containsKey(num)) {
            contacts_array.put(num, name);
            System.out.println("create successfully");
        }
        else
        {
            System.out.println("this contacts is already exist");
        }
    }
    @SuppressWarnings("unchecked")
    public static void sendMessages(LinkedList incoming,String num)
    {
        incoming = showMessages(num);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the mssg do you want to sent");
        String mssg = ">"+scanner.nextLine();
        incoming.add(mssg);
        mssgs_array.put(num, incoming);
        System.out.println("mssg sended");
    }
    public static void editContacts(String num)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number : "+num);
        System.out.println("Name : "+contacts_array.get(num));
        System.out.println("Enter the name to change");
        String name = scanner.nextLine();
        System.out.println("Enter the mobile number to change else enter the same");
        String number = scanner.next();
        contacts_array.remove(num);
        contacts_array.put(number, name);
    }
    public static void blockContact(String num)
    {
        contacts_array.remove(num);
        System.out.println("deleted successfully");
    }
    @SuppressWarnings("unchecked")
    public static void clearChat(String num,LinkedList incoming)
    {
        incoming = new LinkedList<>();
        mssgs_array.remove(num);
        mssgs_array.put(num, incoming);
        System.out.println("chat cleared successfully");
    }
    public static void start()
    {
        LinkedList<String> incoming = new LinkedList<>();
        contacts_array.put("9360619395","Elam");
        contacts_array.put("9876543210","Gopi");
        incoming.add(">how are you?");
        incoming.add("<fine!");
        incoming.add(">what are you doing?");
        incoming.add(">answer me");
        incoming.add("<playing snake and ladder");
        mssgs_array.put("9876543210",incoming);
        incoming = new LinkedList<>();
        incoming.add(">good morining");
        incoming.add("<gm");
        mssgs_array.put("9360619395",incoming);
        boolean begin = true;
        while(begin!=false) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the method and url");
            String input = scanner.nextLine();
            String[] words = input.split(" ");
            String method = words[0];
            String url = words[1];
            String[] split_url = (url.split("/"));
            int len = split_url.length;
            if (method.equals("GET")) {
                for (int i = 1; i < len; i++) {
                    int j = i;
                    j++;
                    if (split_url[i].equals("contacts") && i == len - 1) {
                        //show list of contacts
                        showContacts();
                    } else if (split_url[i].equals("contacts") && mssgs_array.containsKey(split_url[j]) && j == len - 1) {
                        showMessages(split_url[j]);
                    } else if (split_url[i].equals("contacts") && contacts_array.containsKey(split_url[j])) {
                        j++;
                        if (j == len - 1 && split_url[j].equals("about")) {
                            j--;
                            System.out.println("Number :  "+split_url[j]);
                            System.out.println("Name :  "+contacts_array.get(split_url[j]));
                        }

                    }
                    else
                    {
                        System.out.println("enter the wrong URL ");
                    }
                    break;

                }
            } else if (method.equals("POST")) {
                for (int i = 1; i < len; i++) {
                    int j = i;
                    j++;
                    if (split_url[i].equals("contacts") && i == len - 1) {
                        createContacts();
                    } else if (split_url[i].equals("contacts") && contacts_array.containsKey(split_url[j]) && j == len - 1) {
                        sendMessages(incoming, split_url[j]);
                    }
                    else
                    {
                        System.out.println("enter the wrong URL ");
                    }
                    break;

                }
            } else if (method.equals("PUT")) {
                for (int i = 1; i < len; i++) {
                    int j = i;
                    j++;
                    if (split_url[i].equals("contacts") && contacts_array.containsKey(split_url[j]) && j == len - 1) {
                        editContacts(split_url[j]);
                    }
                    else
                    {
                        System.out.println("enter the wrong URL ");
                    }
                    break;
                }
            } else if (method.equals("DELETE")) {
                for (int i = 1; i < len; i++) {
                    int j = i;
                    j++;
                    if (split_url[i].equals("contacts") && contacts_array.containsKey(split_url[j]) && j == len - 1) {
                        blockContact(split_url[j]);
                    } else if (split_url[i].equals("contacts") && contacts_array.containsKey(split_url[j])) {
                        j++;
                        if (j == len - 1 && split_url[j].equals("clear")) {
                            j--;
                            clearChat(split_url[j], incoming);
                        }

                    }
                    else
                    {
                        System.out.println("enter the wrong URL ");
                    }
                    break;
                }
            }
            else{
                System.out.println("Wrong method");
            }
            System.out.println("Do you want to enter URL true or false");
            begin = scanner.nextBoolean();
        }
    }
    public static void main(String[] args) {
        start();
    }
}

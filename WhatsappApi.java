import java.util.*;
class Contacts
{
    static HashMap<Integer,Contacts> contacts_array = new HashMap<>();
    static HashMap<Integer,Integer> chats_array = new HashMap<>();
    static HashMap<Integer,LinkedList> mssgs_array = new HashMap<>();
    String name;
    String number;
    static int contact_id = 100;
    public Contacts()
    {
      contact_id++;
    }
    public void setName(String nm)
    {
        this.name = nm;
    }
    public String getName()
    {
        return name;
    }
    public void setNumber(String num)
    {
        this.number = num;
    }
    public String getNumber()
    {
        return number;
    }
    public int getContact_id()
    {
        return contact_id;
    }

    public static void main(String[] args) {

    }
}
class Chats{
    static int chat_id = 0;
    public Chats()
    {
        chat_id++;
    }
    public int getChat_id()
    {
        return chat_id;
    }
    public int getContact_id(Contacts c)
    {
        return c.getContact_id();
    }
}
class Messages{
    static int mssg_id = 0;
    static String message;
    static LinkedList<String> mssgs_all =new LinkedList<>();
    ;
    public Messages()
    {
        mssg_id++;

    }
    public int getMssg_id()
    {
        return mssg_id;
    }
    public int getChat_id(Chats ch1)
    {

        return ch1.getChat_id();
    }
    public void setMessage(String mssg)
    {
        this.message = mssg;
    }
    public String getMessage()
    {
        return message;
    }
    public int getContact_id(Contacts c)
    {
        return c.getContact_id();
    }
}
public class WhatsappApi extends Contacts{
    public static void showContacts()
    {
        Set list_of_contact = contacts_array.keySet();
        Iterator iterator = list_of_contact.iterator();
        while (iterator.hasNext()) {
            int num = (int)iterator.next();
            Contacts c = contacts_array.get(num);
            System.out.println(c.getName());
        }
    }
    public static void showChats()
    {
        Set list_of_contact = chats_array.keySet();
        Iterator iterator = list_of_contact.iterator();
        while (iterator.hasNext()) {
            int num = (int)iterator.next();
            int cid = chats_array.get(num);
            Contacts c = contacts_array.get(cid);
            System.out.println(c.getName());

        }
    }
    public static LinkedList showMessages(int number)
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
        Contacts contacts = new Contacts();
        contacts.setNumber(num);
        contacts.setName(name);
        contacts_array.put(contacts.getContact_id(),contacts);
        System.out.println("create successfully");


    }
    public static void createChats(int num)
    {
        Chats chats = new Chats();
        chats_array.put(chats.getChat_id(),num);
        System.out.println("chat create successfully");
        Messages messages = new Messages();
        LinkedList linkedList = new LinkedList();
        mssgs_array.put(chats.getChat_id(),linkedList);

    }

    @SuppressWarnings("unchecked")
    public static void sendMessages(int num)
    {
        LinkedList incoming = new LinkedList<>();
        try {
            incoming = showMessages(num);
        }
        catch (Exception e)
        {

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the mssg do you want to sent");
        Messages messages = new Messages();
        messages.setMessage(scanner.nextLine());
        incoming.add(messages.getMessage());
        mssgs_array.put(num, incoming);
        System.out.println("mssg sended");
    }
    public static void editContacts(int num)
    {
        Scanner scanner = new Scanner(System.in);
        showContacts();
        System.out.println("Enter the name to change");
        String name = scanner.nextLine();
        System.out.println("Enter the mobile number to change else enter the same");
        String number = scanner.next();
        Contacts contacts = contacts_array.get(num);
        contacts.setNumber(number);
        contacts.setName(name);
        System.out.println(contacts.getContact_id());
        contacts_array.put(contacts.getContact_id(),contacts);
        System.out.println("edited successfully");
    }
    public static void blockContact(int num)
    {
        contacts_array.remove(num);
        System.out.println("deleted successfully");
    }
    @SuppressWarnings("unchecked")
    public static void clearChat(int num)
    {
        LinkedList incoming = new LinkedList<>();
        mssgs_array.remove(num);
        mssgs_array.put(num, incoming);
        System.out.println("chat cleared successfully");
    }
    public static void checkingURLs()
    {
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
                }
                else if (split_url[i].equals("chats") && i == len - 1) {
                    //show list of chats
                    showChats();
                }
                else if (split_url[i].equals("chats") && mssgs_array.containsKey(Integer.parseInt(split_url[j])) && j == len - 1) {
                    showMessages(Integer.parseInt(split_url[j]));
                } else if (split_url[i].equals("contacts") && contacts_array.containsKey(Integer.parseInt(split_url[j]))) {
                    j++;
                    if (j == len - 1 && split_url[j].equals("about")) {
                        j--;
                        System.out.println("Number :  "+Integer.parseInt(split_url[j]));
                        System.out.println("Name :  "+contacts_array.get(Integer.parseInt(split_url[j])));
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
                }
                else if(split_url[i].equals("chats") && contacts_array.containsKey(Integer.parseInt(split_url[j])) && j == len - 1)
                {
                    createChats(Integer.parseInt(split_url[j]));
                }
                else if (split_url[i].equals("chats") && mssgs_array.containsKey(Integer.parseInt(split_url[j])) && j == len - 1) {
                    sendMessages(Integer.parseInt(split_url[j]));
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
                if (split_url[i].equals("contacts") && contacts_array.containsKey(Integer.parseInt(split_url[j])) && j == len - 1) {
                    editContacts(Integer.parseInt(split_url[j]));
                }
                else
                {
                    System.out.println("enter the wrong URL ");
                }
                break;
            }
        }else if (method.equals("DELETE")) {
            for (int i = 1; i < len; i++) {
                int j = i;
                j++;
                if (split_url[i].equals("contacts") && contacts_array.containsKey(Integer.parseInt(split_url[j])) && j == len - 1) {
                    blockContact(Integer.parseInt(split_url[j]));
                } else if (split_url[i].equals("chats") && mssgs_array.containsKey(Integer.parseInt(split_url[j]))){
                    j++;
                    if (j == len - 1 && split_url[j].equals("clear")) {
                        j--;
                        clearChat(Integer.parseInt(split_url[j]));
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
    }
    public static void main(String[] args) {
        Contacts c1 = new Contacts();
        c1.setNumber("9962072701");
        c1.setName("Sathyaraj");
        contacts_array.put(c1.getContact_id(),c1);
        Chats ch1 = new Chats();
        chats_array.put(ch1.getChat_id(),ch1.getContact_id(c1));
        Messages mssggg = new Messages();
        mssggg.setMessage("hii sathyaraj");
        LinkedList<String> mssg_all = new LinkedList<>();
        mssg_all.add(mssggg.getMessage());
        mssgs_array.put(ch1.getChat_id(),mssg_all);

        boolean begin = true;
        while(begin!=false) {
            checkingURLs();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to enter URL true or false");
            begin = scanner.nextBoolean();
        }
    }
}

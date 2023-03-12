import java.util.Scanner;
public class Main {
    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    public static class KWSingleLinkedList<E> {
        //Reference to list head
        private Node<E> head = null;
        private int size = 0;

        public void printContactList(KWSingleLinkedList<Contact> node) {
            Node<Contact> nodeRef;
            nodeRef = node.head;
            if(nodeRef == null){
                System.out.println("No data");
            } else {
                while (nodeRef != null) {
                    System.out.println("---------------------------");
                    System.out.println(nodeRef.data.name);
                    System.out.println(nodeRef.data.phone_number);
                    System.out.println(nodeRef.data.email);
                    nodeRef = nodeRef.next;
                }
            }
        }

        public void searchContactByName(KWSingleLinkedList<Contact> node, String searchedName) {
            Node<Contact> nodeRef;
            nodeRef = node.head;

            while(nodeRef != null) {
                if(nodeRef.data.name.equals(searchedName)) {
                    System.out.println("---------------------------");
                    System.out.println(nodeRef.data.name);
                    System.out.println(nodeRef.data.phone_number);
                    System.out.println(nodeRef.data.email);
                    break;
                }
                nodeRef = nodeRef.next;
            }
        }

        public void searchContactByEmail(KWSingleLinkedList<Contact> node, String searchedEmail) {
            Node<Contact> nodeRef;
            nodeRef = node.head;

            while(nodeRef != null) {
                if(nodeRef.data.email.equals(searchedEmail)) {
                    System.out.println("---------------------------");
                    System.out.println(nodeRef.data.name);
                    System.out.println(nodeRef.data.phone_number);
                    System.out.println(nodeRef.data.email);
                    break;
                }
                nodeRef = nodeRef.next;
            }
        }

        public void deleteContactByName (KWSingleLinkedList<Contact> node, String deletedName){
            Node<Contact> nodeRef;
            nodeRef = node.head;

            while (nodeRef != null){
                if(nodeRef == node.head && nodeRef.next == null){ // if noderef is in the head and head.next is null then head will be deleted
                    if(node.head.data.name.equals(deletedName)){
                        node.head = null;
                        break;
                    }
                } else {
                    if(nodeRef.next.data.name.equals(deletedName)){
                        nodeRef.next = nodeRef.next.next;
                        break;
                    }
                    nodeRef = nodeRef.next;
                }
            }
        }

        public void addFirst(E item) {
            head = new Node<>(item, head);
            size++;
        }

    }

    private static class Contact{
        private String name;
        private String phone_number;
        private String email;

        private Contact(String Name, String Phone_number, String Email){
            name = Name;
            phone_number = Phone_number;
            email = Email;
        }

    }

    public static void main(String[] args) {

        char choice = ' ' ;
        Scanner sc = new Scanner (System.in);

        // initialize linked list
        KWSingleLinkedList<Contact> contacts = new KWSingleLinkedList<>();

        while (choice != 'Q'){
            System.out.println("********************");
            System.out.println("(A)dd");
            System.out.println("(D)elete");
            System.out.println("(E)mail Search");
            System.out.println("(P)rint List");
            System.out.println("(S)earch");
            System.out.println("(Q)uit");
            System.out.println("********************");
            System.out.print("Please enter a command: ");
            choice = sc.next().charAt(0);

            switch(choice){
                case 'A':
                    String name;
                    String phone_number;
                    String email;
                    sc.nextLine();

                    // input name
                    System.out.print("Input name: ");
                    name = sc.nextLine();

                    // input phone number
                    System.out.print("Input phone number: ");
                    phone_number = sc.nextLine();

                    // input email
                    System.out.print("Input email: ");
                    email = sc.nextLine();

                    // initialize new Contact obj with those 3 new items
                    Contact newContact = new Contact(name,phone_number,email);

                    // add the contact to the single linked list
                    contacts.addFirst(newContact);

                    break;

                case 'P':
                    contacts.printContactList(contacts);

                    break;

                case 'S':
                    sc.nextLine();
                    String searchedName = "";
                    System.out.print("Input name to search: ");
                    searchedName = sc.nextLine();

                    contacts.searchContactByName(contacts, searchedName);

                    break;

                case 'E':
                    sc.nextLine();
                    String searchedEmail = "";
                    System.out.print("Input email to search: ");
                    searchedEmail = sc.nextLine();

                    contacts.searchContactByEmail(contacts, searchedEmail);

                    break;

                case 'D':
                    sc.nextLine();
                    String deletedName = "";
                    System.out.print("Input name to delete: ");
                    deletedName = sc.nextLine();

                    contacts.deleteContactByName(contacts, deletedName);

                    break;
                default: break;

            }
        }

    }
}
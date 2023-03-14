public class Phonebook {
    
    private Node head;
    private int size;
    
    private class Node {
        private String name;
        private String phoneNumber;
        private Node next;
        
        public Node(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.next = null;
        }
    }
    
    public Phonebook() {
        this.head = null;
        this.size = 0;
    }
    
    public void addContact(String name, String phoneNumber) {
        Node newNode = new Node(name, phoneNumber);
        
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        
        size++;
    }
    
    public void removeContact(String name) {
        if (head == null) {
            return;
        }
        
        if (head.name.equals(name)) {
            head = head.next;
            size--;
            return;
        }
        
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.name.equals(name)) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public String findPhoneNumber(String name) {
        Node curr = head;
        while (curr != null) {
            if (curr.name.equals(name)) {
                return curr.phoneNumber;
            }
            curr = curr.next;
        }
        return null;
    }
    
    public void printPhonebook() {
        Node curr = head;
        while (curr != null) {
            System.out.println("Name: " + curr.name + ", Phone Number: " + curr.phoneNumber);
            curr = curr.next;
        }
    }
    
    public int getSize() {
        return size;
    }
    
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact("Afarrel", "081212690000");
        phonebook.addContact("Ben", "081212690001");
        phonebook.addContact("Charlie", "081212690002");
        phonebook.printPhonebook();
        System.out.println("Afarrel's phone number: " + phonebook.findPhoneNumber("Afarrel"));
        phonebook.removeContact("Bob");
        phonebook.printPhonebook();
        System.out.println("Phonebook size: " + phonebook.getSize());
    }
}

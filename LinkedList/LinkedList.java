public class LinkedList {
    Node head;

    public void deleteAt(int pos) {
        if (pos == 0) {
            head = head.next;
        } else {
            Node n = head;
            Node n1 = null;
            for (int i = 0; i < pos-1; i++) {
                n= n.next;
            }
            
           // n1 = n.next;
            n.next = n.next.next;
        }

    }

    public void insertAtStart(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        newNode.next = head;
        head = newNode;
    }

    public void insertAt(int pos, int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (pos == 0) {
            insertAtStart(data);
        } else {
            Node n = head;
            for (int i = 0; i < pos - 1; i++) {
                n = n.next;
            }
            newNode.next = n.next;
            n.next = newNode;
        }
    }

    public void insert(int data) {

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = newNode;
        }
    }

    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data);
            node = node.next;
        }
        System.out.print(node.data);
    }

}

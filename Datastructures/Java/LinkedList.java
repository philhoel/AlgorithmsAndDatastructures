public class LinkedList {

    // ----------------------- Node class --------------------- //
    class Node {

        int data;
        Node next;

        public Node(int x) {

            data = x;
            next = null;
        }

        public Node(int x, Node n) {
            data = x;
            next = n;
        }
    }

    // ------------------------- LinkedList class -------------------- //
    private Node head;
    private int length;

    public LinkedList() {

        head = null;
        length = 0;

    }

    public void append(int x) {
        if (head == null) {
            head = new Node(x);
            length++;
            return;
        }

        Node current;
        current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(x);
        length++;
    }

    private void stackFront(int x) {
        Node current = new Node(x, head);
        length++;
    }

    public void insert(int x, int pos) {

        if ((pos < 0) || (pos > length)) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            stackFront(x);
        } else {
            
            Node current;
            current = head;
            for (int i = 0; i < pos-1; i++) {
                current = current.next;
            }

            Node temp = current.next;
            Node newNode = new Node(x, temp);
            current.next = newNode;
            length++;
        }
    }

    public void remove(int pos) {

        if ((pos < 0) || (pos > length)) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            Node current = head;
            head = head.next;
            current = null;
            length--;
        } else {
            Node current = head;
            for (int i = 0; i < pos-1; i++) {
                current = current.next;
            }

            Node temp = current.next;
            current.next = temp.next;
            temp = null;

            length--;

        }
    }

    public int getLength() {
        return length;
    }

    public int getElement(int pos) {
        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void print() {

        Node current;
        current = head;

        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("]");
    }

}
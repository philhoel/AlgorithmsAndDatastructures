import java.lang.Math;

public class Teque {

    class Node {

        int data;
        Node next;
        Node prev;

        public Node(int x) {
            data = x;
            next = null;
            prev = null;
        }

        public Node(int x, Node n, Node p) {
            data = x;
            next = n;
            prev = p;
        }
    }

    Node head;
    Node tail;
    Node middle;
    int size;

    public Teque() {
        head = null;
        tail = null;
        middle = null;
        size = 0;
    }

    public void pushBack(int x) {
        if (head == null) {
            head = new Node(x);
            tail = head;
            return;
        }

        Node current = new Node(x, null, tail);
        tail = current;
        size++;
    }

    public void pushFront(int x) {
        if (head == null) {
            head = new Node(x);
            tail = head;
            return;
        }

        Node current = new Node(x, head, null);
        head = current;
        size++;
    }


    public void pushMiddle(int x) {

        if (head == null) {
            head = new Node(x);
            tail = head;
            return;
        }

        Node current = head;
        for (int i = 0; i < Math.floor((size + 1) / 2) - 1; i++) {
            current = current.next;
        }

        Node tmp = new Node(x, current.next, current);
        Node temp = current.next;
        current.next = tmp;
        temp.prev = tmp;

        size++;
    }

    public void get(int index) {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        if (index <= Math.floor((size + 1)/2)) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            System.out.println(current.data);
            return;
        }

        if (index > Math.floor((size + 1)/2)) {
            Node current = tail;
            for (int i = size; i > index; i--) {
                current = current.next;
            }

            System.out.println(current.data);
            return;
        }
    }
    

    public void printQueue() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("[ ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println("]");
    }
}
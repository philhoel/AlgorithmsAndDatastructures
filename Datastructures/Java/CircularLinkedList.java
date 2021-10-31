class CircularLinkedList {

    // ----------------------------- Class Node -------------------------------- 
    private class Node {

        int value;
        Node next;
        Node prev;
        

        public Node(int x) {

            value = x;
            next = null;
            prev = null;

        }

        public Node(int x, Node n, Node p) {

            value = x;
            next = n;
            prev = p;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }

    public void append(int x) {

        if (head == null) {
            head = new Node(x);
            tail = head;
            size++;
            return;
        }

        Node current = head;
        for (int i = 0; i < size-1; i++) {
            current = current.next;
        }

        current.next = new Node(x, null, current);
        tail = current.next;
        tail.next = head;
        head.prev = tail;

        size++;
        return;
    }

    public int getElement(int index) {

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public void print() {

        if (head == null) {
            System.out.println("The list is empty!");
        }

        System.out.print("[ ");
        Node current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println("]");

    }
}
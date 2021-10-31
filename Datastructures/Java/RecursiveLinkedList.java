class RecursiveLinkedList {
    
    // ----------------------------- Class Node -------------------------------- 
    class Node {

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

    // ---------------------------------------- Variable Field ------------------------------------- 
    private Node head;
    private Node tail;
    private int size;
    private int count = 0;

    public RecursiveLinkedList() {

        head = null;
        tail = head;
        size = 0;
    }

    public int getLength() {
        return size;
    }

    // -------------- Adding Node ------------- //

    private void append(int x, Node v) {
        if (v.next == null) {
            v.next = new Node(x, null, v);
            size++;
            tail = v.next;
            return;
        }

        append(x, v.next);
    }

    public void append(int x) {
        if (head == null) {
            head = new Node(x);
            size++;
            return;
        }

        Node current = head;
        append(x, current);

    }

    private void insert(int x, int index, Node v) {
        if (count == index-1) {
            Node current = v.next;
            Node tmp = new Node(x, current, v);
            v.next = tmp;
            size++;
            return;
        }

        count++;
        insert(x, index, v.next);

    }

    public void insert(int x, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (head == null) {
            head = new Node(x);
            size++;
            return;
        }
        if (index == 0) {
            Node current = new Node(x, head, null);
            head = current;
            size++;
        }

        if (index == size) {
            append(x);
        }

        Node current = head;
        insert(x, index, current);

        count = 0;
    }

    // ------------------- Removing Node ------------------------- //

    private void remove(int index, Node v) {
        if (count == index) {
            Node current = v.next;
            Node tmp = v.prev;

            current.prev = tmp;
            tmp.next = current;

            size--;
            return;
        }

        count++;
        remove(index, v.next);
    }

    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (index == 0) {
            Node current = head;
            head = current.next;
            head.prev = null;
            size--;
            return;
        }

        Node current = head;
        remove(index, current);
        count = 0;
    }

    // ------------ Printing List ---------------------- //

    private void print(Node v) {
        if (v.next == null) {
            return;
        }

        System.out.print(v.value + " ");
        print(v.next);

    }

    public void print() {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        }

        System.out.print("[ ");

        Node current = head;
        print(current);

        System.out.print(tail.value + " ");
        System.out.println("]");
    }
}
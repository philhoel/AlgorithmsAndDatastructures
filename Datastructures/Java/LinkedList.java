class LinkedList {

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

    private Node head;
    private Node tail;
    private int size;

    // ----------------- Constructors ---------------- //

    public LinkedList() {

        head = null;
        tail = null;
        size = 0;
    }

    // ----------------- Adding Nodes ----------------- //

    public void append(int x) {

        if (head == null) {
            head = new Node(x);
            tail = head;
            size++;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(x, null, current);
        tail = current.next;

        size++;
    }

    public void insert(int x, int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (head == null) {
            head =  new Node(x);
            tail = head;
            size++;
            return;
        }

        
        if (index == 0) {

            Node current = head;
            Node tmp = new Node(x, current, null);
            current.prev = tmp;
            head = tmp;
            size++;
            return;

        } else if (index == size - 1) {

            Node current = tail;
            Node tmp1 = current.prev;
            Node tmp2 = new Node(x, current, tmp1);
            current.prev = tmp2;
            size++;
            return;

        } else {
            
            Node current = head;
            for (int i = 0; i < index; i++) {
                //System.out.println(current.value);
                current = current.next;
            }

            Node tmp1 = current.prev;
            Node tmp2 = new Node(x, current, tmp1);
            current.prev = tmp2;
            tmp1.next = tmp2;
            size++;
            return;
        }
    }

    // ---------------------------- Removing Nodes ----------------------- //

    public void remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (index == 0) {

            Node current = head;
            Node tmp = current.next;
            head = tmp;
            tmp.prev = null;

            size--;
            return;
        }

        if (index == size-1) {

            Node current = tail;
            //System.out.println(tail.value);
            Node tmp = current.prev;
            tmp.next = null;
            tail = tmp;

            size--;
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node tmp1 = current.prev;
        Node tmp2 = current.next;
        tmp1.next = tmp2;
        tmp2.prev = tmp1;

        size--;
        return;

    }

    public int pop(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        int j;

        if (index == 0) {

            Node current = head;
            j = current.value;
            Node tmp = current.next;
            head = tmp;
            tmp.prev = null;

            size--;
            return j;
        }

        if (index == size-1) {

            Node current = tail;
            j = current.value;
            Node tmp = current.prev;
            tmp.next = null;
            tail = tmp;

            size--;
            return j;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        j = current.value;
        Node tmp1 = current.prev;
        Node tmp2 = current.next;
        tmp1.next = tmp2;
        tmp2.prev = tmp1;

        size--;
        return j;

    }

    public int pop() {
        return pop(size-1);
    }

    public void clearList() {

        Node current = head;
        Node tmp;
        while (current != null) {
            tmp = current;
            current = current.next;
            tmp.prev = null;
            tmp.next = null;
        }

        head = null;
        tail = null;

        size = 0;
    }

    // -------------------- Other Methods ----------------- //

    public void swapInsertion(int x, int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (head == null) {
            throw new NullPointerException("The list is empty!");
        }

        Node current = head;

        if (index == 0) {
            current.value = x;
            return;
        }

        if (index == size-1) {
            current = tail;
            current.value = x;
            return;
        }

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.value = x;
        return;
    }

    public void sort() {

        int key;
        int j;

        for (int i = 1; i < size; i++) {

            key = getElement(i);
            j = i - 1;

            while (j >= 0 && getElement(j) > key) {
                swapInsertion(getElement(j), j+1);
                j = j - 1;
            }

            //data[j+1] = key;
            swapInsertion(key, j+1);
        }
    }

    // ---------------------- Output ---------------------- //

    public int getLength() {
        return size;
    }

    public int getElement(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (index == size-1) {
            return tail.value;
        }

        if (index == 0) {
            return head.value;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public void print() {

        if (size == 0) {
            System.out.println("The list is empty!");
        }

        System.out.print("[ ");

        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println("]");
    }
}
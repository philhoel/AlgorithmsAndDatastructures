class IterativeBST {

    class Node {

        int value;
        Node left;
        Node right;

        public Node(int x) {
            value = x;
            left = null;
            right = null;
        }
    
        public Node(int x, Node l, Node r) {
            value = x;
            left = l;
            right = r;
        }
    }


    Node root;
    int count;

    public IterativeBST() {
        root = null;
        count = 0;
    }

    public void addNode(int x) {
        if (root == null) {
            root = new Node(x);
            count++;
            return;
        }

        Node current = root;
        while (current != null) {
            if (x >= current.value) {
                current = current.right;
            }
            if (x < current.value) {
                current = current.left;
            }
        }

        if (x >= current.value) {
            current.right = new Node(x);
        }

        if (x < current.value) {
            current.left = new Node(x);
        }

        count++;
    }

    public void printTree() {

        if (root == null) {
            System.out.println("The tree is empty!");
            return;
        }

        System.out.print("[ ");
        Node current = root;
        while (current != null) {
            current = current.left;
        }

    }
}
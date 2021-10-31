class RecursiveBST {

    // ---------------- Class Node ------------------ //

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

    // ------------------ Variable Field ------------------ //

    Node root;
    int count;

    // ---------- Adding Node --------- //

    private Node addNode(int x, Node v) {
        if (v == null) {
            return new Node(x);
        }

        if (x >= v.value) {
            v.right = addNode(x, v.right);
        } else {
            v.left = addNode(x, v.left);
        }

        return v;

    }

    public void addNode(int x) {
        if (root == null) {
            root = new Node(x);
        }

        addNode(x, root);
    }

    // -------- Searching Tree ------------ //

    public boolean searchTree(int x) {
        
    }

    // ----------- Removing Node ----------- //

    public void remove() {

    }

    // ----------- Printing Tree ---------- //

    private void printTree(Node v) {

        if (v == null) {
            return;
        }

        printTree(v.left);
        printTree(v.right);

        System.out.print(v.value + " ");

    }

    public void printTree() {

        if (root == null) {
            System.out.println("The tree is empty!");
            return;
        }

        System.out.print("[ ");

        printTree(root);

        System.out.println("]");
    }
}
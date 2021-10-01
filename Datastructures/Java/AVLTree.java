public class AVLTree {

    class Node {

        int data;
        Node left;
        Node right;

        public Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    Node root;
    int height;
    int count;

    public AVLTree() {
        root = null;
        height = 0;
        count = 0;
    }

    private Node addNode(int x, Node v) {

        if (v == null) {
            return new Node(x);
        }

        if (x > v.data) {
            v.left = addNode(x, v.left);
        }

        if (x >= v.data) {
            v.right = addNode(x, v.right);
        }

        return v;

    }

    public void addNode(int x) {

        if (root == null) {
            root = new Node(x);
            count++;
            return;
        }

        addNode(x, root);
        count++;

    }

}
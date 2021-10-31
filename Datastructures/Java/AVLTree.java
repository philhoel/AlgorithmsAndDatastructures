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
        height = -1;
        count = 0;
    }

    private Node addNode(int x, Node subroot) {

        if (subroot == null) {
            return new Node(x);
        }

        if (x > subroot.data) {
            subroot.left = addNode(x, subroot.left);
        } else {
            subroot.right = addNode(x, subroot.right);
        }

        return subroot;
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

    public int getCount() {
        return count;
    }

    private Node searchTree(int x, Node subroot) {

        if (subroot == null) {
            return null;
           }
        
        if (subroot.data == x) {
            return subroot;
        }

        if (subroot.data < x) {
            return searchTree(x, subroot.left);
        } else {
            return searchTree(x, subroot.right);
        }
    }

    public boolean searchTree(int x) {

        Node temp;
        temp = searchTree(x, root);

        if (temp == null) {
            return false;
        } else {
            return true;
        }
    }

    private int height(Node v) {

        if (v == null) {
            return -1;
        }


    }

    public void height() {

    }

    public void printTree(Node v) {

        if (v == null) {
            return;
        }

        printTree(v.left);
        System.out.println(v.data);
        printTree(v.right);
    }

    public void printTree() {

        if (root == null) {
            System.out.println("Tree is empty!");
        }

        printTree(root);

    }

}
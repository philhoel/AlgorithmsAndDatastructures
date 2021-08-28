


public class BST {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int x) {

            data = x;
            left = null;
            right = null;
        }

        public Node(int x, Node l, Node r) {
            data = x;
            left = l;
            right = r;
        }
    }

    Node root;
    int count;

    public BST() {

        root = null;
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

        root = addNode(x, root);
        count++;
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

    private void printTree(Node subroot) {
        if (subroot == null) {
            return;
        }

        printTree(subroot.right);
        printTree(subroot.left);

        System.out.print(subroot.data + " ");

        
    }

    public void printTree() {

        if (root == null) {
            return;
        }

        System.out.print("[ ");

        printTree(root);

        System.out.println("]");
    }

}
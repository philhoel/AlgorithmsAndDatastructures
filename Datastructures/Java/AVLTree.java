public class AVLTree {

    // ----------------- Class Node ----------------- //
    private class Node {

        int data;
        int height;
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

    // --------------- Constructors ----------- //

    public AVLTree() {
        root = null;
        height = 0;
        //root.height = 0;
        count = 0;
    }

    // ---------------- Help Methods ------------- //

    private int max(int a, int b) {

        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    
    private Node leftRotate(Node z) {
        
        Node y = z.right;
        Node T1 = y.left;

        y.left = z;
        z.right = T1;

        z.height = 1 + max(getHeightOfNode(z.left.data), getHeightOfNode(z.right.data));
        y.height = 1 + max(getHeightOfNode(y.left.data), getHeightOfNode(y.right.data));

        return y;
    }

    private Node rightRotate(Node z) {

        Node y = z.left;
        Node T2 = y.right;

        y.right = z;
        z.left = T2;

        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    private int balanceFactor(Node v) {
        if (v == null) {
            return 0;
        }

        return height(v.left) - height(v.right);
    }
    
    private Node balance(Node v) {

        if (balanceFactor(v) < -1) {
            if (balanceFactor(v.right) > 0) {
                v.right = rightRotate(v.right);
            }
            return leftRotate(v);
        }

        if (balanceFactor(v) > 1) {
            if (balanceFactor(v.left) < 0) {
                v.left = leftRotate(v.left);
            }
            return rightRotate(v);
        }

        return v;
    }

    // -------------------- Adding Node ------------ //

    private Node addNode(int x, Node v) {

        if (v == null) {

            Node myNode = new Node(x);
            System.out.println(myNode.data);
            
            return myNode;
        }

        if (x > v.data) {
            v.left = addNode(x, v.left);
        } else {
            v.right = addNode(x, v.right);
        }

        v.height = 1 + max(height(v.left), height(v.right));
        return balance(v);
    }

    public void addNode(int x) {

        if (root == null) {
            root = new Node(x);
            root.height = 0;
            count++;
            return;
        }

        addNode(x, root);
        count++;

    }

    // ------------------------ Searching Tree ------------------ //

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

    private Node findMin(Node v) {

        if (v == null) {
            return null;
        }

        findMin(v.left);

        return v;
    }

    public Node findMin() {

        if (root == null) {
            System.out.println("The tree is empty!");
            return null;
        }

        return findMin(root);

    }

    // ------------------- Removing ------------------ //

    /*
    private Node remove(int x, Node v) {

        if (v == null) {
            return null;
        }

        if (v.data > x) {
            v.left = remove(x, v.left);
            return v;
        }

        if (v.data < x) {
            v.right = remove(x, v.right);
            return v;
        }

        if (v.left == null) {
            return v.right;
        }

        if (v.right == null) {
            return v.left;
        }

        Node u = findMin(v.right);
        u.data = v.data;
        v.right = remove(u.data, v.right);
        return v;
    }

    public void remove(int x) {

    }

    */

    // ------------------ Output -------------- //

    public int getCount() {
        return count;
    }

    private Node getNode(int x, Node v) {
        if (v == null) {
            return null;
        }

        if (v.data == x) {
            return v;
        }

        if (v.data < x) {
            return getNode(x, v.left);
        } else {
            return getNode(x, v.right);
        }
    }

    public Node getNode(int x) {

        if (root == null) {
            return null;
        }

        return getNode(x, root);
    }

    public int getHeightOfNode(int x) {
        Node v = getNode(x);
        return v.height;
    }

    private int height(Node v) {

        if (v == null) {
            return -1;
        }

        int h;

        int tmp1 = height(v.left);
        int tmp2 = height(v.right);

        if (tmp1 >= tmp2) {
            h = tmp1;
        } else {
            h = tmp2;
        }

        return h + 1;
    }

    public int height() {

        if (root == null) {
            return -1;
        }

        int h;

        h = height(root);

        return h;

    }

    public void printTree(Node v) {

        if (v == null) {
            return;
        }

        printTree(v.left);
        System.out.print(v.data + " ");
        printTree(v.right);
    }

    public void printTree() {

        if (root == null) {
            System.out.println("Tree is empty!");
        }

        System.out.print("[ ");

        printTree(root);

        System.out.println("]");

    }

}
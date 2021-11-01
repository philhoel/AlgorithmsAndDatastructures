class RecursiveBST {

    // ---------------- Class Node ------------------ //

    private class Node {

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
    String path;

    public RecursiveBST() {
        root = null;
        count = 0;
        path = "";
    }

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
            count++;
            return;
        }

        addNode(x, root);

        count++;
    }

    // -------- Searching Tree ------------ //

    private Node searchTree(int x, Node v) {

        if (v == null) {
            return null;
        }

        if (x == v.value) {
            return v;
        } else if (x > v.value) {
            return searchTree(x, v.right);
        } else {
            return searchTree(x, v.left);
        }
    }

    public boolean searchTree(int x) {

        if (root == null) {
            return false;
        }

        Node v = searchTree(x, root);

        if (v == null) {
            //System.out.println("hei");
            return false;

        } else {
            return true;
        }
    }

    private Node writePathToNode(int x, Node v) {

        if (v == null) {
            return null;
        }

        //System.out.println(path);

        if (x == v.value) {
            return v;
        } else if (x > v.value) {
            path += "R";
            return writePathToNode(x, v.right);
        } else {
            path += "L";
            return writePathToNode(x, v.left);
        }
        
    }

    public String writePathToNode(int x) {
        if (root == null) {
            return "The tree is empty!";
        }

        Node v = writePathToNode(x, root);

        //System.out.println(path);

        if (v == null) {
            return "No Node " + x + " in Tree";
        } else {
            String path1 = path;
            path = "";
            return path1;
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
    

    /*
    private Node findMin(Node v) {
        Node min = v;
        while (min.left != null) {
            min = min.left;
        }

        return min;
    }
    */

    // ----------- Removing Node ----------- //

    private Node remove(int x, Node v) {

        if (v == null) {
            return null;
        }

        if (v.value > x) {
            v.left = remove(x, v.left);
            return v;
        }

        if (v.value < x) {
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
        u.value = v.value;
        v.right = remove(u.value, v.right);
        return v;
    }

    public void remove(int x) {

        if (root == null) {
            return;
        }

        remove(x, root);
    }

    // ----------- Output ---------- //

    public int getCount() {
        return count;
    }

    private int height(int h, Node v) {

        if (v == null) {
            return -1;
        }

        int tmp1;
        int tmp2;

        tmp1 = height(h, v.left);
        tmp2 = height(h, v.right);

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

        int h = 0;

        h = height(h, root);

        return h;
    }

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
import java.util.ArrayList;

public class FileSystemTree {

    private class Node {

        int numb;
        String name;
        ArrayList<Node> children;

        public Node(String name) {
            this.name = name;
            children = new ArrayList<Node>();
        }
    }

    Node root;
    int count;

    public FileSystemTree() {

        root = null;
        count = 0;
    }
}
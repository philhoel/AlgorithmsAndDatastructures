import java.util.*;


public class Tree {

    class Node {

        int data;
        List<Integer> children;

        public Node(int x) {
            data = x;
            children = new List<Integer>();
        }

        public addChildNode(Node v) {
            if ( !(children.isEmpty()) ){
                children.add(v);
            }
        }
    }

    int amountOfNodes;
    Node root;

    public Tree() {
        amountOfNodes = 0;
        root = null;
    }

    public void addNode(int x) {
        
    }


}
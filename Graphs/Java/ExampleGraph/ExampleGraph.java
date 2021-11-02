import java.util.ArrayList;

public class ExampleGraph {

    private class Node {

        ArrayList<Node> adjecentNodes;
        int id;

        public Node(int id) {

            adjecentNodes = new ArrayList<Node>();
            this.id = id;
        }
        
    }

    int count = 0;
    ArrayList<Node> graph;

    public ExampleGraph() {
        graph = new ArrayList<Node>();
    }

    public void addNode() {
        
    }

}
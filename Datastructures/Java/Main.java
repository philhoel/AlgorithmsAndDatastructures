
public class Main {

    public static void main(String arg[]) {

        BST myTree = new BST();
        myTree.addNode(10);
        myTree.addNode(7);
        myTree.addNode(4);
        myTree.addNode(5);
        myTree.addNode(1);
        myTree.addNode(6);
        myTree.addNode(20);
        myTree.addNode(30);
        myTree.addNode(15);
        myTree.addNode(11);

        myTree.printTree();

        System.out.println(myTree.searchTree(20));

    }
}
import java.util.*;
import java.util.Random;


public class Main {

    public static void main(String arg[]) {

        HeapArray myHeap = new HeapArray();

        Random rand = new Random();

        

        for (int i = 0; i < 10; i++) {
            int myRand = rand.nextInt(10);
            myHeap.printHeap();
            myHeap.insert(myRand);
        }

        /*
        myHeap.insert(0);
        myHeap.insert(1);
        myHeap.insert(7);
        myHeap.insert(2);
        myHeap.insert(4);
        myHeap.insert(11);
        myHeap.insert(10);
        myHeap.insert(5);
        myHeap.insert(10);
        myHeap.insert(6);
        myHeap.insert(9);
        myHeap.insert(29);
        myHeap.insert(14);
        myHeap.insert(28);
        myHeap.insert(21);
        myHeap.insert(19);
        myHeap.insert(19);
        myHeap.insert(15);
        myHeap.insert(22);
        myHeap.insert(23);
        myHeap.insert(3);

        myHeap.printHeap();

        myHeap.removeMin();

        myHeap.printHeap();

        */


        /*

        AVLTree myTree = new AVLTree();

        Random rand = new Random();

        

        for (int i = 0; i < 10; i++) {
            int myRand = rand.nextInt(10);
            System.out.println(myRand);
            myTree.addNode(myRand);
        }

        

        myTree.addNode(10);
        myTree.addNode(12);
        myTree.addNode(9);
        myTree.addNode(5);
        //myTree.addNode(7);
        myTree.addNode(11);
        myTree.addNode(15);
        myTree.addNode(14);

        System.out.println("Number of Nodes: " + myTree.getCount());

        myTree.printTree();

        System.out.println(myTree.searchTree(7));

        //myTree.remove(7);

        //myTree.printTree();

        System.out.println("Height of tree: " + myTree.height());

        System.out.println(myTree.getHeightOfNode(12));

        //System.out.println(myTree.writePathToNode(14));

        */
    }
}
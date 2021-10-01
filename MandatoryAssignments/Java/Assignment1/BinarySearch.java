import java.util.*;
import java.lang.Math;

public class BinarySearch {

    public static void main(String[] args) {

        LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
            myArrayList.add(i);
        }

        boolean val1 = binarySearch(myArrayList, 5);
        boolean val2  = binarySearch(myLinkedList, 4);

        System.out.println(val1);
        System.out.println(val2);
        
    }

    public static boolean binarySearch(LinkedList<Integer> lst, int x) {

        int low = 0;
        int high = lst.size() - 1;

        int i;

        while (low < high) {
            i = (int)(Math.floor((high + low)/2));
            if (lst.get(i) == x) {
                return true;
            }

            if (lst.get(i) < x) {
                low = i + 1;
            }

            if (lst.get(i) > x) {
                high = i - 1;
            }
        }

        return false;

    }

    public static boolean binarySearch(ArrayList<Integer> lst, int x) {

        int low = 0;
        int high = lst.size() - 1;

        int i;

        while (low < high) {
            i = (int)(Math.floor((high + low)/2));
            if (lst.get(i) == x) {
                return true;
            }

            if (lst.get(i) < x) {
                low = i + 1;
            }

            if (lst.get(i) > x) {
                high = i - 1;
            }
        }

        return false;

    }
}
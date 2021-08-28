import java.util.*;
import java.lang.Math;

public class SortingAlgorithms {

    int[] myArray;
    //int[] A;
    //int size;

    public SortingAlgorithms(int[] arr) {

        myArray = arr;
        //A = new int[myArray.length];
    }

    public void printArray() {

        System.out.print("[ ");

        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }

        System.out.println("]");
    }

    private void swap(int i, int j) {
        int tmp;
        tmp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = tmp;
    }

    public void bubbleSort() {

        boolean swapped = false;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length - 1; j++) {
                if (myArray[j] > myArray[j+1]) {
                    swap(i,j);
                    swapped = true;
                }
            }
            // does not work ?
            if (!swapped) {
                break;
            }
        }
    }

    public void naiveBubbleSort() {
        boolean swapped = false;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length - 1; j++) {
                if (myArray[j] > myArray[i]) {
                    swap(i,j);
                    swapped = true;
                }
            }
        }
    }

    public void selectionSort() {
        int min;

        for (int i = 0; i < myArray.length; i++) {
            min = i;

            for (int j = i+1; j < myArray.length; j++) {
                if (myArray[min] > myArray[j]) {
                    min = j;
                }
            }

            if (i != min) {
                swap(min, i);
            }
        }
    }

    public void insertionSort() {
        int j;
        for (int i = 0; i < myArray.length; i++) {
            j = i;
            while ((j > 0) && (myArray[j] < myArray[j-1])) {
                swap(j-1, j);
                j--;
            }
        }
    }

    private int choosePivot(int high, int low) {
        int piv = myArray[Math.round(high/2)];
        return piv;
    }

    private int partition(int low, int high) {

        // Needs to be changed
        int p = choosePivot(high, low);
        swap(high, p);
        int pivot = myArray[high];
        int left = low;
        int right = high - 1;

        while (left <= right) {
            while ((left <= right) && (myArray[left] <= pivot)) {
                left++;
            }

            while ((right >= left) && (myArray[right] <= pivot)) {
                right--;
            }

            if (left < right) {
                swap(left, right);
            }
        }

        swap(left, high);

        return left;
    }

    public void quickSort(int low, int high) {
        int p;
        if (low >= high) {
            return;
        }
        p = partition(low, high);
        quickSort(low, p - 1);
        quickSort(p+1, high);
    }
}
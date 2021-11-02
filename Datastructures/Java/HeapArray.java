import java.util.ArrayList;
import java.math.*;

public class HeapArray {

    int[] data;
    int size;
    int capacity;

    public HeapArray() {
        capacity = 16;
        size = 0;
        data = new int[capacity];
    }

    private void resize() {
        capacity *= 2;
        int[] tmp = new int[capacity];

        for (int i = 0; i < size; i++) {
            tmp[i] = data[i];
        }

        data = tmp;
    }

    public void insert(int x) {

        if (size >= capacity) {
            resize();
        }

        data[size] = x;
        int i = size;;

        
        int tmp;
        while ((0 < i) && (data[i] < data[(int)Math.floor((i-1)/2)])) {
            tmp = data[i];
            data[i] = data[(int)Math.floor((i-1)/2)];
            data[(int)Math.floor((i-1)/2)] = tmp;

            i = (int)Math.floor((i-1)/2);
        }

        size++;

    }

    public void removeMin() {
        int i, j, x, tmp;
        x = data[0];
        data[0] = data[size-1];
        i = 0;

        while ((2*i + 2) < size-1) {
            if (data[2*i+1] <= data[2*i+2]) {
                j = 2*i + 1;
            } else {
                j = 2*i + 2;
            }

            if (data[j] <= data[i]) {
                tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;

                i = j;
                continue;
            }

            break;
        }

        if ((2*i + 1 < size-1) && (data[2*i+1] <= data[i])) {
            tmp = data[i];
            data[i] = data[2*i + 1];
            data[2*i+1] = tmp;
        }
    }

    public void printHeap() {

        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }
    
}
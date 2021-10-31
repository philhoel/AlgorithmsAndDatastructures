import java.util.List;

class ArrayList {

    private int[] data;
    private int capacity;
    private int size;

    // ------------ Constructors --------------- //

    public ArrayList() {
        capacity = 2;
        data = new int[capacity];
        size = 0;
    }

    public ArrayList(int[] lst) {
        capacity = 2;
        data = new int[capacity];
        size = 0;

        for (int i = 0; i < lst.length; i++) {
            append(lst[i]);
        }
    }

    // --------------- Resizing ---------------- //


    
    private void resize() {
        capacity *= 2;
        int[] tmp = new int[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = data[i];
        }

        data = tmp;
    }

    private void shrink() {
        capacity /= 2;
        int[] tmp = new int[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = data[i];
        }

        data = tmp;
    }

    // ---------------- Adding Element ---------------- //

    public void append(int x) {
        if (size == capacity) {
            resize();
        }

        data[size] = x;
        size++; 
    }

    /*
    @param x 
    @return 
    */
    public void insert(int x, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (size == capacity) {
            resize();
        }

        if (index == size) {
            append(x);
            return;
        }

        int[] tmp = new int[capacity];

        if (index == 0) {

            tmp[0] = x;
            for (int i = 0; i < size; i++) {
                tmp[i+1] = data[i];
            }

        } else {

            for (int i = 0; i < index; i++) {
                tmp[i] = data[i];
            }

            tmp[index] = x;

            for (int i = index; i < size; i++) {
                tmp[i+1] = data[i];
            }
        }

        data = tmp;
        size++;
        return;

    }

    // ------------------- Removing Element ----------------------- //

    public void remove(int index) {

        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        int[] tmp = new int[capacity];

        if (index == size-1) {

            for (int i = 0; i < size-1; i++) {
                tmp[i] = data[i];
            }

        } else if (index == 0) {

            for (int i = 0; i < size-1; i++) {
                tmp[i] = data[i+1];
            }

        } else {

            for (int i = 0; i < index; i++) {
                tmp[i] = data[i];
            }

            for (int i = index; i < size-1; i++) {
                tmp[i] = data[i+1];
            }
        }

        data = tmp;
        size--;
        return;
    }

    public void clearList() {
        data = new int[capacity];
        size = 0;
    }

    public int pop(int index) {

        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        int[] tmp = new int[capacity];

        if (index == size-1) {

            for (int i = 0; i < size-1; i++) {
                tmp[i] = data[i];
            }

        } else if (index == 0) {

            for (int i = 0; i < size-1; i++) {
                tmp[i] = data[i+1];
            }

        } else {

            for (int i = 0; i < index; i++) {
                tmp[i] = data[i];
            }

            for (int i = index; i < size-1; i++) {
                tmp[i] = data[i+1];
            }
        }

        int j = data[index];
        data = tmp;
        size++;
        return j;

    }

    public int pop() {
        return pop(size-1);
    }

    // ---------------------- Output -------------------- //

    public void sort() {

        int key;
        int j;

        for (int i = 0; i < size; i++) {

            key = data[i];
            j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j+1] = data[j];
                j = j - 1;

            }

            data[j+1] = key;
        }

    }

    public void reverse() {

        int[] tmp = new int[capacity];

        int j = size-1;
        for (int i = 0; i < size; i++) {
            tmp[i] = data[j];
            j--;
        }

        data = tmp;

    }

    public int getElement(int index) {

        if (index < 0 || index >=size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        
        return data[index];
    }

    public int getLength() {
        return size;
    }

    public ArrayList copy() {
        ArrayList tmp = new ArrayList(data);
        
        return tmp;
    }

    public void print() {
        if (size == 0) {
            System.out.println("The list is empty!");
        }

        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("]");
    }
}
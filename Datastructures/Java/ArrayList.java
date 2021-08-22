
public class ArrayList {
    
    int[] data;
    int capacity = 1000000;
    int size;

    public ArrayList() {

        data = new int[capacity];
        size = 0;
    }

    public void append(int x) {

        data[size] = x;
        size++;
    }

    public void insert(int x, int pos) {

        if ((pos < 0) || (pos > size)) {
            throw new IndexOutOfBoundsException();
        } else {

            if (pos == size) {
                this.append(x);
            } else {
                int[] temp = new int[capacity];

                for (int i = 0; i < pos; i++) {
                    temp[i] = data[i];
                }
                temp[pos] = x;

                for (int i = pos; i < size+1; i++) {
                    temp[i+1] = data[i];
                }

                data = temp;
                size++;
            }
        }
    }

    public void remove(int pos) {

        if ((pos < 0) || (pos > size)) {
            throw new IndexOutOfBoundsException();
        } else {

            int[] temp = new int[capacity];
            
            for (int i = 0; i < pos; i++) {
                temp[i] = data[i];
            }

            for (int i = pos+1; i < size; i++) {
                temp[i-1] = data[i];
            }

            data = temp;
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public void print() {

        System.out.print("[ ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println("]");
    }
}

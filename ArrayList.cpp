#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;

class ArrayList {

    private:
    // ------------------------------------------------- Private ------------------------------------------------
        int capacity = 2;
        int* arr;


        void resize() {

            capacity = pow(capacity, 2);
        }


    public:
    // ---------------------------------------------------- Public ----------------------------------------------

        int size;

        // Constructor for ArrayList
        ArrayList() {

            arr = new int[capacity];
            size = 0;
        }

        // Destructor
        ~ArrayList() {

            delete[] arr;
        }

        /*
        Operator overloader
        Overloads the [] operator

        @params - index of value to be returned
        @return - value at given index
        */
        int& operator[](int index) {
            if ((index >= 0) && (index < size)) {
                return arr[index];
            }
        }

        // Gets the private capacity
        int get_capacity() {
            return capacity;
        }

        // Gets size
        int get_size() {
            return size;
        }

        /*
        Append member function
        Appends a value to the end of the list

        @params - Value to be appended
        */
        void append(int x) {
            if (size >= capacity) {
                resize();
            }

            arr[size] = x;
            size += 1;
        }

        /*
        Insert member function
        Inserts a given value at given index

        @params - Value, index to place value
        */
        void insert(int x, int index) {
            if (size >= capacity) {
                resize();
            }

            if ((index > 0) && (index < size)) {
                int* tmp;
                tmp = new int[size+1];
                for (int i = 0; i < index; i++) {
                    tmp[i] = arr[i];
                }

                tmp[index] = x;

                for (int i = index; i < size; i++) {
                    tmp[i+1] = arr[i];
                }

                for (int i = 0; i <= size; i++) {
                    arr[i] = tmp[i];
                }

                delete[] tmp;

                size += 1;

            }
        }

        void remove(int index) {
            int* tmp;
            tmp = int[size-1];

            for (int i = 0; i < index; i++) {
                tmp[i] = arr[i];
            }

            for (int i = index; i < size; i++) {
                tmp[i] = arr[i+1];
            }

            for (int i = 0; i < size-1; i++) {
                arr[i] = tmp[i];
            }

            delete[] tmp;
            length -= 1;
        }

        // ------------------------------------------- Sorting Algorithms -----------------------------------------------

        void bubble_sort() {

        }

        void Print() {

            cout << "[ ";
            for (int i = 0; i < size; i++) {
                cout << arr[i] << " ";
            }

            cout << "]" << endl;
        }

};

int main() {

    ArrayList new_arr;
    new_arr.append(1);
    new_arr.append(2);
    new_arr.append(3);
    new_arr.insert(3, 2);

    new_arr.Print();

    cout << new_arr[2] << endl;

    return 0;
}
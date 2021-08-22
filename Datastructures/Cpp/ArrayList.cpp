#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>
#include <stdexcept>


using namespace std;

class ArrayList {

    private:

        int* data;
        int capacity;
        int size;

        void capacityIncrease() {
            if (size == capacity) {
                capacity *= 2;
                int* tmp;
                tmp = new int[capacity];
                for (int i = 0; i < size; i++) {
                    tmp[i] = data[i];
                } 

                delete[] data;
                data = tmp;
            }
        }

    public:

        ArrayList() {

            capacity = 2;
            data = new int[capacity];
            size = 0;
        }

        ~ArrayList() {

            delete[] data;

        }

        void append(int x) {
            if (size == capacity) {
                capacityIncrease();
            }

            data[size] = x;
            size++;
        }

        void insert(int x, int pos) {

            if (size == capacity) {
                capacityIncrease();
            }

            if ((pos < 0) || (pos > size)) {
                throw range_error("Index Error");
            } else if (pos == size) {
                data[size] = x;
                size++;
            } else {
                int* tmp;
                tmp = new int[size+1];
                for (int i = 0; i < pos; i++) {
                    tmp[i] = data[i];
                }

                tmp[pos] = x;

                for (int i = pos; i < size; i++) {
                    tmp[i+1] = data[i];
                }

                data = tmp;
                size++;
 
            }
        }

        void remove(int pos) {

            if ((pos < 0) || (pos > size)) {
                throw range_error("Index Error");
            } else {
                int* tmp;
                tmp = new int[size];
                for (int i = 0; i < pos; i++) {
                    tmp[i] = data[i];
                }
                for (int i = pos+1; i < size; i++) {
                    tmp[i-1] = data[i];
                }

                data = tmp;
                size--;
 
            }
        }

        int& operator[] (int pos) {
            if ((pos < 0) || (pos > size)) {
                throw range_error("Index Error");
            } else {
                return data[pos];
            }
        }

        void print() {

            cout << "[ ";
            for (int i = 0; i < size; i++) {
                cout << data[i] << " ";
            }

            cout << "]" << endl;
        }

};

int main() {

    ArrayList myList;
    myList.append(1);
    myList.append(2);
    myList.append(3);
    myList.append(4);

    myList.print();

    myList.insert(9, 2);

    myList.print();

    myList.remove(2);

    myList.print();

    cout << myList[2] << endl;

    return 0;
}
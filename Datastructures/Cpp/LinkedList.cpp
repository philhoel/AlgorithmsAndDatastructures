#include <iostream>
#include <string>
#include <cstdlib>
#include <vector>
#include <stdexcept>

using namespace std;

struct Node {

    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }

    Node(int x, Node* n) {
        data = x;
        next = n;
    }
};

class LinkedList {

    private:

        Node* head;
        int size;

    public:

        LinkedList() {

            head = nullptr;
            size = 0;
        }

        ~LinkedList() {

        }

        void append(int x) {

            if (size == 0) {
                head = new Node(x);
                size++;
                return;
            }

            Node* current;
            current = head;
            while (current->next != nullptr) {
                current = current->next;
            }

            current->next = new Node(x);
            size++;
        }

        void insert(int x, int pos) {

            if (size == 0) {
                head = new Node(x);
                size++;
                return;
            }

            if ((pos < 0) || (pos > size)) {
                throw range_error("Index Error");
            } else if (pos == 0) {
                Node* current = new Node(x, head);
                head = current;
                size++;
            } else {
                Node* current;
                current = head;
                for (int i = 0; i < pos-1; i++) {
                    current = current->next;
                }

                Node* temp = current->next;
                Node* newNode = new Node(x, temp);
                current->next = newNode;
                size++;
            }
        }

        void remove(int pos) {
            if ((pos <= 0) || (pos > size)) {
                throw range_error("Index Error");
            } else {
                Node* current;
                current = head;
                for (int i = 0; i < pos-1; i++) {
                    current = current->next;
                }

                Node* temp = current->next;
                current->next = temp->next;
                delete temp;

                size--;
            }
        }

        int& operator[] (int pos) {
            if ((pos < 0) || (pos > size)) {
                throw range_error("Index Error");
            } else {
                Node* current;
                current = head;
                for (int i = 0; i < pos; i++) {
                    current = current->next;
                }

                return current->data;
            }
        }

        void print() {

            cout << "[ ";

            Node* current;
            current = head;
            while (current != nullptr) {
                cout << current->data << " ";
                current = current->next;
            }

            cout << "]" << endl;
        }
};

int main() {

    LinkedList myList;

    myList.append(1);
    myList.append(2);
    myList.append(3);
    myList.append(4);
    myList.append(5);

    myList.print();

    cout << myList[2] << endl;

    myList.insert(9, 2);

    myList.print();

    myList.remove(2);

    myList.print();

    return 0;
}
#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;

struct Node {

    int value;
    Node* next;
    Node* prev;

    Node(int n){
        value = n;
        next = nullptr;
        prev = nullptr;
    }

    Node(int n, Node* N, Node* P){
        value = n;
        next = N;
        prev = P;
    }
};

class LinkedList {

    private:

        int length;
        Node* head;

    public:

        LinkedList() {
            head = nullptr;
            length = 0;
        }

        ~LinkedList() {
            Node* current;
            Node* next_node;

            current = head;

            while (current != nullptr) {
                next_node = current->next;
                delete current;
                current = next_node;
            }

        }

        void append(int x) {

            if (head == nullptr) {
                head = new Node(x, nullptr, nullptr);
                length += 1;

                return;
            }

            Node* current;
            current = head;
            while (current->next != nullptr) {
                current = current->next;
            }

            current->next = new Node(x, nullptr, current);

            length += 1;

        }

        int& get_length() {
            return length;
        }

        void remove(int index) {
            
        }

        void Print() {
            Node* current = head;
            cout << "[ ";
            while (current->next != nullptr) {
                cout << current->value << " ";
                current = current->next;
            }

            cout << current->value << " ";
            cout << "]" << endl;
        }
};

int main() {

    LinkedList new_list;
    new_list.append(1);
    new_list.append(2);
    new_list.append(3);

    new_list.Print();

    return 0;

}
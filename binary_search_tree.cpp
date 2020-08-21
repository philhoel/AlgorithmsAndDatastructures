#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;

struct Node {

    int value;
    Node* right;
    Node* left;

    Node(int x, Node* r, Node* l) {
        value = x;
        right = r;
        left = l;
    }

};


class BST {

    private:
        Node* root;

    public:

        BST() {
            root = nullptr;
        }

        


};
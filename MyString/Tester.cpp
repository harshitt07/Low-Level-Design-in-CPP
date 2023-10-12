#include "iostream"
#include "string"

#include "./../MyString/MyStringLeaf.h"
#include "./../MyString/MyStringInternal.h"

using namespace std;

char get(MyString* root, int K) {
    if(root->getLeftChild() == NULL && root->getRightChild() == NULL) {
        return root->getString()[K - 1];
    }
    if(K > root->getLeftChild()->getLength()) {
        return get(root->getRightChild(), K - root->getLeftChild()->getLength());
    }
    return get(root->getLeftChild(), K);
}

string toString(MyString* root) {
    if(root->getLeftChild() == NULL && root->getRightChild() == NULL) {
        return root->getString();
    } else {
        return toString(root->getLeftChild()) + toString(root->getRightChild());
    }
}

void append(MyString* root, MyString* parent, string S) {
    if(root->getLeftChild() == NULL && root->getRightChild() == NULL) {
        MyStringLeaf* left = new MyStringLeaf(root->getString());
        MyStringLeaf* right = new MyStringLeaf(S);
        MyStringInternal* internal = new MyStringInternal(left, right);
        parent->setRightChild(internal);
        return ;
    }
    append(root->getRightChild(), root, S);
}

int main() {

    MyStringLeaf* leaf1 = new MyStringLeaf("ABCDE");
    MyStringLeaf* leaf2 = new MyStringLeaf("FGHIJKLMNO");
    MyStringLeaf* leaf3 = new MyStringLeaf("PQRSTUVWXYZ");
    MyStringInternal* internal1 = new MyStringInternal(leaf2, leaf3);
    MyStringInternal* root = new MyStringInternal(leaf1, internal1);

    // Question 2 => Print the whole string
    string S = toString(root);
    cout << S << endl;

    // Question 3 => Print the character at given index K
    int K = 12;
    cout << get(root, K) << endl;

    // Question 4 => Implement the append method
    append(root, NULL, " C++ is the best!");

    cout << toString(root) << endl;

    return 0;
}


/**
 * Given a large character strings are *sometimes* stored in a special data structure called MyString.
 * It is a binary tree, where each node is either a leaf or an internal node; e.g
 * A simple MyString can be just a single leaf root: Leaf<len=5>: ABCDE
 * A larger MyString tree may contain internal nodes as well, e.g.:
  root: Internal<len=26>
   ->left : Leaf<len=5> :ABCDE
   ->right:
        ->left : Leaf‹len=10>:FGHIJKLMNO
        ->right: Leaf‹len=11>:PQRSTUVWXYZ
 * 1. Write data structure defining a MyString.
 * 2. Implement a ToString() method, returning the entire MyString as a string.
 * 3. Implement get (k) method, returning k-th character of the MyString.
 * 4. Implement Append() method, adding a string to the end of the MyString.
 * 
*/
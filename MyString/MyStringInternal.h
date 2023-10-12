#include "string"

#include "./MyString.h"
using namespace std;

#ifndef MY_STRING_INTERNAL_H
#define MY_STRING_INTERNAL_H

class MyStringInternal : public MyString {

    MyString* left;
    MyString* right;

    public:
    MyStringInternal(MyString* _left, MyString* _right) : MyString(_left->getLength() + _right->getLength()) {
        left = _left;
        right = _right;
    }

    string getString() {
        return "";
    }

    MyString* getLeftChild() {
        return left;
    }

    MyString* getRightChild() {
        return right;
    }

    void setRightChild(MyString* _right) {
        right = _right;
    }

};

#endif

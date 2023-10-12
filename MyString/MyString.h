#include "string"
using namespace std;

#ifndef MY_STRING_H
#define MY_STRING_H

class MyString {

    int length;

    public:
    MyString(int _length) {
        length = _length;
    }

    void setLength(int _length) {
        length = _length;
    }

    int getLength() {
        return length;
    }

    virtual string getString() = 0;

    virtual MyString* getLeftChild() {
        return NULL;
    }

    virtual MyString* getRightChild() {
        return NULL;
    };

    virtual void setRightChild(MyString* _rightChild) { }
};

#endif
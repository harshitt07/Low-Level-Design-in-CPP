#include "string"

#include "./MyString.h"
using namespace std;

#ifndef MY_STRING_LEAF_H
#define MY_STRING_LEAF_H

class MyStringLeaf : public MyString {

    string S;

    public:
    MyStringLeaf(string _S) : MyString(_S.length()) {
        S = _S;
    }

    string getString() {
        return S;
    }

};

#endif

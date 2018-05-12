/*

https://www.interviewbit.com/problems/trailing-zeros-in-factorial/

*/


#include <iostream>
#include <vector>
#include <algorithm>
#include <list>
#include <queue>
using namespace std;

int get_trailing_zeros(int n) {
    int zeros = 0;
    while(n>0) {
        zeros += n/5;
        n = n/5;
    }
    return zeros;
}

int main() {
    int n;
    cin >> n;
    cout << get_trailing_zeros(n);
    return 0;
}

/*

https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/

*/


#include <iostream>
#include <vector>
#include <algorithm>
#include <list>
#include <queue>
using namespace std;

void print_vector(vector<int> v) {
    for (int i = 0; i < v.size(); ++i) {
        cout<<v[i]<<" ";
    }
    cout<<"\n";
}

vector<int> generate_kth_row(int k) {
    vector<int> ans;
    int elem = 1;
    int numerator = k;
    int denominator = 1;

    for(int i=0; i<=k; i++) {
        ans.push_back(elem);
        elem = (elem * numerator)/denominator;
        numerator--;
        denominator++;
    }
    return ans;
}

int main() {
    int k;
    cin>>k;
    vector<int> v = generate_kth_row(k);

    print_vector(v);

    return 0;
}

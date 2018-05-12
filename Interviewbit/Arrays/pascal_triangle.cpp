/*

https://www.interviewbit.com/problems/pascal-triangle/

*/

#include <iostream>
#include <vector>
using namespace std;

void print_vector(vector<int> v) {
    int v_size = v.size();
    for (int i = 0; i < v_size; ++i) {
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
        elem = (elem * numerator) / denominator;
        numerator--;
        denominator++;
    }

    return ans;
}

vector <vector<int> > pascal_triangle(int n) {
    vector <vector<int> > res;
    for(int i = 0; i < n; i++) {
        res.push_back(generate_kth_row(i));
    }
    return res;
}

int main() {
    int n;
    cin >> n;
    vector <vector<int> > v = pascal_triangle(n);
    int v_size = v.size();
    for(int i = 0; i < v_size; i++) {
        print_vector(v[i]);
    }
    return 0;
}

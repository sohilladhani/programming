
/*
https://www.interviewbit.com/problems/add-one-to-number/
*/

#include <iostream>
#include <vector>
#include <chrono>
using namespace std;

void print_vector(vector<int> v) {
    for (int i = 0; i < v.size(); ++i) {
        cout<<v[i]<<" ";
    }
    cout<<"\n";
}

vector<int> add_one_to_number(vector<int> &A) {
    while(A[0] == 0 && A.size() > 1) {
        A.erase(A.begin());
    }
    int i = A.size() - 1;
    if(i>=0) {
        while(A[i] == 9 && i >= 0) {
            A[i] = 0;
            --i;
        }
    }

    if(i==-1) {
        A.insert(A.begin(), 0);
        i = 0;
    }
    A[i]++;
    return A;
}

int main() {
    int n = 0;
    vector<int> v;
    cin>>n;
    int input = -1;
    for (int i = 0; i < n; ++i) {
        cin >> input;
        v.push_back(input);
    }
    auto start_time = chrono::steady_clock::now();
    print_vector(add_one_to_number(v));
    auto end_time = chrono::steady_clock::now();
    cout<<"Finished in " << chrono::duration<double, milli>(end_time-start_time).count() << "ms" << endl;
    return 0;
}

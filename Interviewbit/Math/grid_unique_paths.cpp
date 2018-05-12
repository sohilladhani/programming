/*

https://www.interviewbit.com/problems/grid-unique-paths/

*/

#include <iostream>
using namespace std;

int get_unique_grid_paths(int a, int b) {
    int m = a + b - 2;
    int n = a - 1;
    long long ans = 1;
    if(n>m/2) n = m-n;

    for(int i=1; i<=n; i++) {
        ans = ans*m/i;
        m--;
    }
    return ans;
}


int main() {
    int a;
    int b;
    cin>>a;
    cin>>b;
    cout<<get_unique_grid_paths(a, b);
    return 0;
}

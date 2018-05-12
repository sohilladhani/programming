/*

    https://www.interviewbit.com/problems/palindrome-integer/

    */

    #include <iostream>

    using namespace std;

    int is_palindrome_integer(int n) {
        int tmp = n;
        int new_n = 0;
        while(tmp>0) {
            new_n*=10;
            new_n+=tmp%10;
            tmp/=10;
        }
        if(n == new_n) return 1;
        else return 0;
    }

    int main() {
        int n;
        cin>>n;
        cout<<is_palindrome_integer(n);
        return 0;
    }

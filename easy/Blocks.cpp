#include <bits/stdc++.h>
using namespace std;

const long long MOD = 1000000007LL;

long long modPow(long long base, long long exp) {
    long long result = 1;
    base %= MOD;
    while (exp > 0) {
        if (exp % 2 == 1) {
            result = (result * base) % MOD;
        }
        base = (base * base) % MOD;
        exp /= 2;
    }
    return result;
}

int main() {
    int N;
    cin >> N;
    vector<long long> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    vector<long long> B(N);
    for (int i = 0; i < N; i++) {
        cin >> B[i];
    }
    
    sort(A.begin(), A.end(), greater<long long>());
    sort(B.begin(), B.end());
    
    long long totalBits = 0;
    for (int i = 0; i < N; i++) {
        totalBits += A[i] + B[i];
    }
    
    long long result = 0;
    long long pow = 1;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < A[i]; j++) {
            result = (result + pow) % MOD;
            pow = (pow * 2) % MOD;
        }
        for (int j = 0; j < B[i]; j++) {
            pow = (pow * 2) % MOD;
        }
    }
    
    cout << result % MOD << endl;
    return 0;
}

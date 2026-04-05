#include <bits/stdc++.h>
using namespace std;

const long long MOD = 1000000007LL;

long long modPow2(long long exp) {
    long long result = 1;
    long long base = 2;
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
    for (int i = 0; i < N; i++) cin >> A[i];
    vector<long long> B(N);
    for (int i = 0; i < N; i++) cin >> B[i];
    
    long long result = 0;
    
    for (int i = 0; i < N; i++) {
        long long coins = A[i] % MOD;
        long long pow2 = modPow2(B[i]);
        coins = (coins * pow2) % MOD;
        result = (result + coins) % MOD;
    }
    
    cout << result << endl;
    return 0;
}

#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<long long> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    
    vector<long long> dp(N + 1, 0);
    
    for (int i = N - 1; i >= 0; i--) {
        int nextIdx = i + (int)A[i] + 1;
        long long take = A[i];
        if (nextIdx <= N) {
            take += dp[nextIdx];
        }
        long long skip = dp[i + 1];
        dp[i] = max(take, skip);
    }
    
    cout << dp[0] << endl;
    return 0;
}

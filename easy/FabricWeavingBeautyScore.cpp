#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M, H;
    cin >> N;
    cin >> M;
    cin >> H;
    vector<int> A(N);
    for (int i = 0; i < N; i++) cin >> A[i];
    vector<int> B(M);
    for (int i = 0; i < M; i++) cin >> B[i];
    
    vector<vector<int>> dp(N + 1, vector<int>(M + 1, 0));
    
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            
            int bonus = 0;
            if (A[i - 1] == B[j - 1]) {
                bonus = H;
            }
            
            dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + bonus);
        }
    }
    
    cout << dp[N][M] << endl;
    return 0;
}

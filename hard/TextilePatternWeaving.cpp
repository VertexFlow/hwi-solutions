#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M, H;
    if(!(cin >> N)) return 0;
    cin >> M >> H;
    
    vector<int> A(N), B(M);
    for (int i = 0; i < N; i++) cin >> A[i];
    for (int i = 0; i < M; i++) cin >> B[i];
    
    vector<vector<map<int, ll>>> dp(N + 1, vector<map<int, ll>>(M + 1));
    dp[0][0][0] = 0;
    
    for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= M; j++) {
            if (i > 0) {
                int newColor = A[i - 1];
                for (auto& entry : dp[i - 1][j]) {
                    int prevColor = entry.first;
                    ll prevScore = entry.second;
                    ll newScore = prevScore + (prevColor == newColor ? H : 0);
                    auto it = dp[i][j].find(newColor);
                    if (it == dp[i][j].end() || newScore > it->second) {
                        dp[i][j][newColor] = newScore;
                    }
                }
            }
            
            if (j > 0) {
                int newColor = B[j - 1];
                for (auto& entry : dp[i][j - 1]) {
                    int prevColor = entry.first;
                    ll prevScore = entry.second;
                    ll newScore = prevScore + (prevColor == newColor ? H : 0);
                    auto it = dp[i][j].find(newColor);
                    if (it == dp[i][j].end() || newScore > it->second) {
                        dp[i][j][newColor] = newScore;
                    }
                }
            }
        }
    }
    
    ll ans = 0;
    for (auto& entry : dp[N][M]) {
        ans = max(ans, entry.second);
    }
    cout << ans << endl;
    
    return 0;
}

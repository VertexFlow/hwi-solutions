#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M, B;
    if(!(cin >> N)) return 0;
    cin >> M >> B;
    vector<vector<int>> Color(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> Color[i][j];
        }
    }
    vector<vector<int>> V(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> V[i][j];
        }
    }
    
    vector<vector<map<int, ll>>> dp(N, vector<map<int, ll>>(M));
    
    int firstColor = Color[0][0];
    dp[0][0][firstColor] = V[0][0];
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (i == 0 && j == 0) continue;
            
            if (i > 0) {
                for (auto& entry : dp[i-1][j]) {
                    int prevColor = entry.first;
                    ll prevScore = entry.second;
                    int currColor = Color[i][j];
                    ll newScore = prevScore + V[i][j] + (prevColor == currColor ? B : 0);
                    auto it = dp[i][j].find(currColor);
                    if (it == dp[i][j].end() || newScore > it->second) {
                        dp[i][j][currColor] = newScore;
                    }
                }
            }
            
            if (j > 0) {
                for (auto& entry : dp[i][j-1]) {
                    int prevColor = entry.first;
                    ll prevScore = entry.second;
                    int currColor = Color[i][j];
                    ll newScore = prevScore + V[i][j] + (prevColor == currColor ? B : 0);
                    auto it = dp[i][j].find(currColor);
                    if (it == dp[i][j].end() || newScore > it->second) {
                        dp[i][j][currColor] = newScore;
                    }
                }
            }
        }
    }
    
    ll ans = 0;
    for (auto& entry : dp[N-1][M-1]) {
        ans = max(ans, entry.second);
    }
    cout << ans << endl;
    
    return 0;
}

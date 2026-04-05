#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M;
    if(!(cin >> N)) return 0;
    cin >> M;
    vector<vector<int>> grid(N, vector<int>(M));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> grid[i][j];
        }
    }
    
    vector<vector<map<int, ll>>> dp(N, vector<map<int, ll>>(M));
    
    int v = grid[0][0];
    dp[0][0][v] = (ll)v * v;
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (i == 0 && j == 0) continue;
            if (i > 0) {
                for (auto& entry : dp[i-1][j]) {
                    int minPrev = entry.first;
                    ll energyPrev = entry.second;
                    int vCurr = grid[i][j];
                    int minNew = min(minPrev, vCurr);
                    ll energyNew = energyPrev + (ll)vCurr * minNew;
                    auto it = dp[i][j].find(minNew);
                    if (it == dp[i][j].end() || energyNew > it->second) {
                        dp[i][j][minNew] = energyNew;
                    }
                }
            }
            if (j > 0) {
                for (auto& entry : dp[i][j-1]) {
                    int minPrev = entry.first;
                    ll energyPrev = entry.second;
                    int vCurr = grid[i][j];
                    int minNew = min(minPrev, vCurr);
                    ll energyNew = energyPrev + (ll)vCurr * minNew;
                    auto it = dp[i][j].find(minNew);
                    if (it == dp[i][j].end() || energyNew > it->second) {
                        dp[i][j][minNew] = energyNew;
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

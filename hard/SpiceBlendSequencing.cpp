#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M, K, H;
    if(!(cin >> N)) return 0;
    cin >> M >> K >> H;
    
    vector<int> flavorA(N), intensityA(N);
    for (int i = 0; i < N; i++) {
        cin >> flavorA[i] >> intensityA[i];
    }
    
    vector<int> flavorB(M), intensityB(M);
    for (int i = 0; i < M; i++) {
        cin >> flavorB[i] >> intensityB[i];
    }
    
    const int MAX_F = 100;
    const ll NEG = LLONG_MIN / 4;
    
    vector<vector<vector<vector<ll>>>> dp(2, vector<vector<vector<ll>>>(M + 1, vector<vector<ll>>(K + 1, vector<ll>(MAX_F + 1, NEG))));
    dp[0][0][0][0] = 0;
    
    for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= M; j++) {
            for (int k = 0; k <= K; k++) {
                ll bestPrev = NEG;
                for (int f = 0; f <= MAX_F; f++) {
                    bestPrev = max(bestPrev, dp[i % 2][j][k][f]);
                }
                
                if (i < N && k < K) {
                    int fNew = flavorA[i];
                    ll val = bestPrev + intensityA[i] + H;
                    dp[(i + 1) % 2][j][k + 1][fNew] = max(dp[(i + 1) % 2][j][k + 1][fNew], val);
                }
                
                if (j < M && k < K) {
                    int fNew = flavorB[j];
                    ll val = bestPrev + intensityB[j] + H;
                    dp[i % 2][j + 1][k + 1][fNew] = max(dp[i % 2][j + 1][k + 1][fNew], val);
                }
            }
        }
        
        if (i < N) {
            for (int j = 0; j <= M; j++) {
                for (int k = 0; k <= K; k++) {
                    fill(dp[(i + 1) % 2][j][k].begin(), dp[(i + 1) % 2][j][k].end(), NEG);
                }
            }
        }
    }
    
    ll ans = 0;
    for (int f = 0; f <= MAX_F; f++) {
        ans = max(ans, dp[N % 2][M][K][f]);
    }
    cout << ans << endl;
    
    return 0;
}

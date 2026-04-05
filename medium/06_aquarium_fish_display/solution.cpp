#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m, f;
    if(!(cin >> n)) return 0;
    cin >> m >> f;
    vector<vector<long long>> s(f + 1, vector<long long>(f + 1));
    for(int i = 1; i <= f; i++) {
        for(int j = 1; j <= f; j++) {
            cin >> s[i][j];
        }
    }
    vector<int> a(n), b(m);
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < m; i++) cin >> b[i];
    const long long NEG = LLONG_MIN / 4;
    vector<vector<vector<long long>>> dp(n + 1, vector<vector<long long>>(m + 1, vector<long long>(2, NEG)));
    if(n > 0 && m > 0) {
        dp[1][1][0] = s[a[0]][b[0]];
        dp[1][1][1] = s[a[0]][b[0]];
    }
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= m; j++) {
            if(i == 1 && j == 1) continue;
            if(i > 1) {
                dp[i][j][0] = max(dp[i][j][0], dp[i-1][j][0] + s[a[i-1]][a[i-2]]);
                if(j > 0) {
                    dp[i][j][0] = max(dp[i][j][0], dp[i-1][j][1] + s[a[i-1]][b[j-1]]);
                }
            }
            if(j > 1) {
                dp[i][j][1] = max(dp[i][j][1], dp[i][j-1][1] + s[b[j-1]][b[j-2]]);
                if(i > 0) {
                    dp[i][j][1] = max(dp[i][j][1], dp[i][j-1][0] + s[b[j-1]][a[i-1]]);
                }
            }
        }
    }
    cout << max(dp[n][m][0], dp[n][m][1]) << "\n";
    return 0;
}

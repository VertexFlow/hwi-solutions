#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    if(!(cin >> n)) return 0;
    cin >> m;
    int costA, costB;
    cin >> costA >> costB;
    vector<vector<int>> v(n, vector<int>(m));
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cin >> v[i][j];
        }
    }
    long long totalCost = 0;
    for(int i = 0; i < n; i++) {
        vector<long long> dp(m + 1, LLONG_MAX / 4);
        dp[0] = 0;
        for(int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] + costA - v[i][j - 1];
            if(j >= 2) {
                dp[j] = min(dp[j], dp[j - 2] + costB);
            }
        }
        totalCost += dp[m];
    }
    cout << totalCost << "\n";
    return 0;
}

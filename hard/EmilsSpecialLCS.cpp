#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    string A, B;
    if(!(getline(cin, A))) return 0;
    getline(cin, B);
    
    int n = A.length();
    int m = B.length();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
            if (A[i - 1] == B[j - 1]) {
                int weight = (A[i - 1] == 'e') ? 2 : 1;
                dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + weight);
            }
        }
    }
    
    cout << dp[n][m] << endl;
    
    return 0;
}

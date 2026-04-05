#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin >> n)) return 0;
    int k;
    cin >> k;
    vector<long long> a(n);
    for(int i = 0; i < n; i++) cin >> a[i];
    const long long NEG = LLONG_MIN / 4;
    vector<long long> dp(k, NEG);
    dp[0] = 0;
    for(int i = 0; i < n; i++) {
        int rem = a[i] % k;
        vector<long long> newDp = dp;
        for(int r = 0; r < k; r++) {
            if(dp[r] != NEG && r != rem) {
                newDp[rem] = max(newDp[rem], dp[r] + a[i]);
            }
        }
        dp = newDp;
    }
    long long ans = 0;
    for(int r = 0; r < k; r++) {
        ans = max(ans, dp[r]);
    }
    cout << ans << "\n";
    return 0;
}

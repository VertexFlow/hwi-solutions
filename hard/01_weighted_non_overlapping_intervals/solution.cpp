#include <bits/stdc++.h>
using namespace std;

struct Interval {
    int l, r, w;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    if(!(cin >> N)) return 0;
    cin >> K;
    vector<Interval> intervals(N);
    for (int i = 0; i < N; i++) {
        cin >> intervals[i].l >> intervals[i].r >> intervals[i].w;
    }
    
    sort(intervals.begin(), intervals.end(), [](const Interval& a, const Interval& b) {
        return a.r < b.r;
    });
    
    vector<int> right(N);
    for (int i = 0; i < N; i++) {
        right[i] = intervals[i].r;
    }
    
    const long long NEG = LLONG_MIN;
    vector<vector<long long>> dp(N + 1, vector<long long>(K + 1, NEG));
    dp[0][0] = 0;
    
    for (int i = 1; i <= N; i++) {
        for (int k = 0; k <= K; k++) {
            dp[i][k] = dp[i - 1][k];
        }
        
        int lo = 0, hi = N - 1, idx = -1;
        int target = intervals[i - 1].l - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (right[mid] <= target) {
                idx = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        for (int k = 1; k <= K; k++) {
            if (idx >= 0 && dp[idx + 1][k - 1] != NEG) {
                long long val = dp[idx + 1][k - 1] + intervals[i - 1].w;
                dp[i][k] = max(dp[i][k], val);
            }
        }
    }
    
    long long ans = dp[N][K];
    cout << (ans == NEG ? -1 : ans) << endl;
    
    return 0;
}

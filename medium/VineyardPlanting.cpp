#include <bits/stdc++.h>
using namespace std;

struct State {
    long long mn, mx, score;
    State(long long s=0, long long m1=0, long long m2=0) { score=s; mn=m1; mx=m2; }
};

void addState(vector<State>& list, const State& s) {
    for (size_t i = 0; i < list.size(); i++) {
        const State& e = list[i];
        if (e.mn <= s.mn && e.mx >= s.mx && e.score >= s.score) return;
        if (s.mn <= e.mn && s.mx >= e.mx && s.score >= e.score) {
            list.erase(list.begin() + i);
            i--;
        }
    }
    list.push_back(s);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    if(!(cin >> n)) return 0;
    cin >> m;
    vector<long long> a(n), b(m);
    for(int i = 0; i < n; i++) cin >> a[i];
    for(int i = 0; i < m; i++) cin >> b[i];
    vector<vector<vector<State>>> dp(n+1, vector<vector<State>>(m+1));
    dp[0][0].push_back(State(0, LLONG_MAX, LLONG_MIN));
    for(int i = 0; i <= n; i++) {
        for(int j = 0; j <= m; j++) {
            for(const State& cur : dp[i][j]) {
                if(i < n) {
                    long long x = a[i];
                    long long add, nm, nM;
                    if(cur.mx == LLONG_MIN) {
                        add = 0; nm = x; nM = x;
                    } else {
                        add = max(cur.mx - x, x - cur.mn);
                        add = max(add, 0LL);
                        nm = min(cur.mn, x);
                        nM = max(cur.mx, x);
                    }
                    addState(dp[i+1][j], State(cur.score + add, nm, nM));
                }
                if(j < m) {
                    long long x = b[j];
                    long long add, nm, nM;
                    if(cur.mx == LLONG_MIN) {
                        add = 0; nm = x; nM = x;
                    } else {
                        add = max(cur.mx - x, x - cur.mn);
                        add = max(add, 0LL);
                        nm = min(cur.mn, x);
                        nM = max(cur.mx, x);
                    }
                    addState(dp[i][j+1], State(cur.score + add, nm, nM));
                }
            }
        }
    }
    long long ans = 0;
    for(const State& s : dp[n][m]) {
        ans = max(ans, s.score);
    }
    cout << ans << "\n";
    return 0;
}

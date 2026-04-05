#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int N;
vector<vector<int>> adj;
vector<int> W;

ll kolakoskiBonus(int c) {
    if (c <= 0) return 0;
    vector<int> seq;
    seq.push_back(1);
    int i = 1, j = 0;
    while ((int)seq.size() < c + 5) {
        int val = seq[j++];
        for (int k = 0; k < val && (int)seq.size() < c + 5; k++) {
            seq.push_back((j % 2 == 0) ? 1 : 2);
        }
    }
    if (seq[c - 1] == 1) {
        return 30LL * ((c % 10) + 1);
    }
    return 0;
}

bool isOreNumber(int w) {
    if (w <= 0) return false;
    int ore[] = {1, 6, 28, 140, 270, 496, 672, 1086, 2202, 3784, 6128, 8128, 10656, 14400, 18630, 27216, 56160, 64496, 71316, 100128, 144240, 184752, 214272, 231840, 303744, 315036, 384384, 413952, 536400, 551376, 579600, 635046, 715428, 783072, 876624, 1027680, 1155648, 1244160, 1384176, 1552320};
    for (int o : ore) {
        if (o == w) return true;
        if (o > w) break;
    }
    return false;
}

vector<vector<ll>> dp;

ll dfs(int v, int parent, bool take) {
    ll res = 0;
    if (take) {
        res = W[v];
        for (int nb : adj[v]) {
            if (nb != parent) {
                res += dfs(nb, v, false);
            }
        }
    } else {
        for (int nb : adj[v]) {
            if (nb != parent) {
                ll incl = dfs(nb, v, true);
                ll excl = dfs(nb, v, false);
                res += max(incl, excl);
            }
        }
    }
    return res;
}

void findBest(int v, int parent, bool take, set<int>& current) {
    if (take) {
        current.insert(v);
        for (int nb : adj[v]) {
            if (nb != parent) {
                findBest(nb, v, false, current);
            }
        }
    } else {
        for (int nb : adj[v]) {
            if (nb != parent) {
                if (dp[nb][1] >= dp[nb][0]) {
                    current.insert(nb);
                    findBest(nb, v, true, current);
                } else {
                    findBest(nb, v, false, current);
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    if(!(cin >> N)) return 0;
    W.resize(N);
    for (int i = 0; i < N; i++) cin >> W[i];
    vector<int> T(N);
    for (int i = 0; i < N; i++) cin >> T[i];
    
    int M;
    cin >> M;
    adj.assign(N, {});
    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    int K;
    cin >> K;
    
    dp.assign(N, vector<ll>(2, 0));
    for (int i = 0; i < N; i++) {
        dp[i][0] = dfs(i, -1, false);
        dp[i][1] = W[i] + dfs(i, -1, true) - dfs(i, -1, false);
    }
    
    set<int> bestSet;
    findBest(0, -1, false, bestSet);
    
    ll baseScore = 0;
    for (int v : bestSet) {
        baseScore += W[v];
    }
    int count = bestSet.size();
    
    int oreCount = 0;
    for (int v : bestSet) {
        if (isOreNumber(W[v])) oreCount++;
    }
    
    ll bonus = kolakoskiBonus(count);
    int bits = __builtin_popcountll(baseScore);
    ll penalty = (bits % 2 == 1) ? 25 : 0;
    
    ll finalScore = baseScore + bonus - penalty;
    if (oreCount > K) {
        finalScore = (ll)(finalScore * 0.9);
    }
    
    cout << finalScore << endl;
    
    return 0;
}

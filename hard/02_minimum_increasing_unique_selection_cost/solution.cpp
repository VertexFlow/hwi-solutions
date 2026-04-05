#include <bits/stdc++.h>
using namespace std;

struct BIT {
    int n;
    vector<long long> tree;
    BIT(int n = 0) { init(n); }
    void init(int n_) {
        n = n_;
        tree.assign(n + 2, LLONG_MAX);
    }
    void update(int idx, long long val) {
        while (idx <= n) {
            if (val < tree[idx]) tree[idx] = val;
            idx += idx & -idx;
        }
    }
    long long query(int idx) {
        long long res = LLONG_MAX;
        while (idx > 0) {
            if (tree[idx] < res) res = tree[idx];
            idx -= idx & -idx;
        }
        return res;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, K;
    if(!(cin >> N)) return 0;
    cin >> K;
    vector<int> A(N);
    for (int i = 0; i < N; i++) cin >> A[i];
    
    vector<int> sorted = A;
    sort(sorted.begin(), sorted.end());
    sorted.erase(unique(sorted.begin(), sorted.end()), sorted.end());
    
    int maxVal = sorted.size();
    for (int i = 0; i < N; i++) {
        A[i] = lower_bound(sorted.begin(), sorted.end(), A[i]) - sorted.begin() + 1;
    }
    
    vector<BIT> bits(K + 1);
    for (int k = 0; k <= K; k++) {
        bits[k].init(maxVal + 2);
    }
    
    bits[0].update(1, 0);
    
    for (int i = 0; i < N; i++) {
        for (int k = 1; k <= K; k++) {
            long long prev = bits[k - 1].query(A[i] - 1);
            if (prev != LLONG_MAX) {
                long long cost = prev + (long long)(i + 1 - k) * (i + 1 - k);
                bits[k].update(A[i], cost);
            }
        }
    }
    
    long long ans = bits[K].query(maxVal + 1);
    cout << (ans == LLONG_MAX ? -1 : ans) << endl;
    
    return 0;
}

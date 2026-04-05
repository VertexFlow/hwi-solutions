#include <bits/stdc++.h>
using namespace std;

const int MAXM = 10000;
const int MAXVAL = 1000000;
const int MAXSTEP = 5000;

vector<int> primes;
vector<bool> fortunate;
vector<bool> isPrime;

void sieve(int n) {
    isPrime.assign(n + 1, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) primes.push_back(i);
    }
}

void computeFortunate() {
    sieve(MAXVAL + MAXM + 5);
    fortunate.assign(MAXM + 1, false);
    long long primorial = 1;
    for (size_t i = 0; i < primes.size(); i++) {
        if (i > 0) primorial *= primes[i - 1];
        for (int m = 2; m <= MAXM; m++) {
            if (!fortunate[m]) {
                long long val = primorial + m;
                if (val <= MAXVAL + MAXM && isPrime[(int)val]) {
                    fortunate[m] = true;
                }
            }
        }
    }
}

int recamanDistance(int M) {
    if (M <= 1) return 0;
    vector<bool> seen(MAXVAL + 1, false);
    int cur = M;
    int steps = 0;
    for (int i = 1; i <= MAXSTEP; i++) {
        int next = cur - i;
        if (next <= 0 || seen[next]) {
            next = cur + i;
        }
        if (next > MAXVAL || seen[next]) {
            break;
        }
        seen[cur] = true;
        cur = next;
        steps++;
    }
    return steps;
}

struct SegTree {
    int n;
    vector<int> tree;
    SegTree(const vector<int>& arr) {
        n = arr.size();
        tree.assign(4 * n, 0);
        build(1, 0, n - 1, arr);
    }
    void build(int node, int l, int r, const vector<int>& arr) {
        if (l == r) {
            tree[node] = arr[l];
        } else {
            int mid = (l + r) / 2;
            build(node * 2, l, mid, arr);
            build(node * 2 + 1, mid + 1, r, arr);
            tree[node] = max(tree[node * 2], tree[node * 2 + 1]);
        }
    }
    void update(int idx, int val) {
        update(1, 0, n - 1, idx, val);
    }
    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
        } else {
            int mid = (l + r) / 2;
            if (idx <= mid) {
                update(node * 2, l, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, r, idx, val);
            }
            tree[node] = max(tree[node * 2], tree[node * 2 + 1]);
        }
    }
    int query(int ql, int qr) {
        return query(1, 0, n - 1, ql, qr);
    }
    int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return INT_MIN;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l + r) / 2;
        return max(query(node * 2, l, mid, ql, qr), query(node * 2 + 1, mid + 1, r, ql, qr));
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    computeFortunate();
    int n;
    if(!(cin >> n)) return 0;
    vector<int> a(n);
    for (int i = 0; i < n; i++) cin >> a[i];
    SegTree seg(a);
    int q;
    cin >> q;
    long long totalSum = 0;
    for (int i = 0; i < q; i++) {
        int type;
        cin >> type;
        if (type == 0) {
            int idx, val;
            cin >> idx >> val;
            seg.update(idx, val);
        } else {
            int l, r;
            cin >> l >> r;
            int mx = seg.query(l, r);
            int dist = recamanDistance(mx);
            if (fortunate[mx]) {
                dist *= 17;
            }
            totalSum += dist;
        }
    }
    cout << totalSum << "\n";
    return 0;
}

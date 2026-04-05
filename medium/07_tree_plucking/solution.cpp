#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long val;
    int deg;
    vector<int> adj;
    Node() { val = 0; deg = 0; }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin >> n)) return 0;
    vector<Node> nodes(n);
    for(int i = 0; i < n; i++) cin >> nodes[i].val;
    for(int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        u--; v--;
        nodes[u].adj.push_back(v);
        nodes[v].adj.push_back(u);
        nodes[u].deg++;
        nodes[v].deg++;
    }
    priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<pair<long long, int>>> pq;
    vector<bool> removed(n, false);
    for(int i = 0; i < n; i++) {
        if(nodes[i].deg <= 1) {
            pq.push({nodes[i].val, i});
        }
    }
    long long totalCost = 0;
    int removedCount = 0;
    while(removedCount < n) {
        auto [val, u] = pq.top();
        pq.pop();
        if(removed[u]) continue;
        totalCost += nodes[u].val;
        removed[u] = true;
        removedCount++;
        for(int w : nodes[u].adj) {
            if(!removed[w]) {
                nodes[w].val += nodes[u].val;
                nodes[w].deg--;
                if(nodes[w].deg == 1) {
                    pq.push({nodes[w].val, w});
                }
            }
        }
    }
    cout << totalCost << "\n";
    return 0;
}

#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    if(!(cin >> n)) return 0;
    vector<long long> a(n);
    for(int i = 0; i < n; i++) cin >> a[i];
    unordered_set<long long> seen;
    for(int i = 0; i < n; i++) {
        if(seen.count(a[i])) {
            cout << -1 << "\n";
            return 0;
        }
        seen.insert(a[i]);
    }
    vector<pair<long long, int>> pairs(n);
    for(int i = 0; i < n; i++) {
        pairs[i] = {a[i], i};
    }
    sort(pairs.begin(), pairs.end());
    vector<int> pos(n);
    for(int i = 0; i < n; i++) {
        pos[pairs[i].second] = i;
    }
    vector<bool> visited(n, false);
    long long cost = 0;
    for(int i = 0; i < n; i++) {
        if(visited[i] || pos[i] == i) {
            visited[i] = true;
            continue;
        }
        int j = i;
        long long cycleSum = 0;
        long long cycleMin = LLONG_MAX;
        int cycleSize = 0;
        while(!visited[j]) {
            visited[j] = true;
            cycleSum += a[j];
            cycleMin = min(cycleMin, a[j]);
            cycleSize++;
            j = pos[j];
        }
        if(cycleSize > 1) {
            long long withoutShortcut = (cycleSize - 1) * cycleSum;
            long long withShortcut = cycleSum + cycleMin + (long long)(cycleSize + 1) * cycleMin;
            cost += min(withoutShortcut, withShortcut);
        }
    }
    cout << cost << "\n";
    return 0;
}

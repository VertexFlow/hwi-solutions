#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, D, K, P;
    if(!(cin >> N)) return 0;
    cin >> D >> K >> P;
    vector<pair<int,int>> films;
    for (int i = 0; i < N; i++) {
        int g, a;
        cin >> g >> a;
        films.push_back({g, a});
    }
    
    sort(films.begin(), films.end(), [](const pair<int,int>& a, const pair<int,int>& b) {
        return a.second > b.second;
    });
    
    long long totalAppeal = 0;
    int lastGenre = -1;
    int penalties = 0;
    
    for (int i = 0; i < D; i++) {
        int bestIdx = -1;
        for (int j = 0; j < (int)films.size(); j++) {
            if (films[j].first != lastGenre) {
                bestIdx = j;
                break;
            }
        }
        
        if (bestIdx == -1) bestIdx = 0;
        
        totalAppeal += films[bestIdx].second;
        if (lastGenre != -1 && films[bestIdx].first == lastGenre) {
            penalties++;
        }
        lastGenre = films[bestIdx].first;
        films.erase(films.begin() + bestIdx);
    }
    
    long long result = totalAppeal - (long long)penalties * P;
    cout << result << endl;
    
    return 0;
}

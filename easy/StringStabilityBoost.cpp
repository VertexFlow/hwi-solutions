#include <bits/stdc++.h>
using namespace std;

int main() {
    string S;
    cin >> S;
    int n = S.length();
    
    unordered_set<string> originalPairs;
    for (int i = 0; i < n - 1; i++) {
        string p = S.substr(i, 2);
        originalPairs.insert(p);
    }
    int originalScore = originalPairs.size();
    
    int maxScore = originalScore;
    
    for (int i = 0; i < n - 1; i++) {
        swap(S[i], S[i + 1]);
        unordered_set<string> pairs;
        for (int j = 0; j < n - 1; j++) {
            string p = S.substr(j, 2);
            pairs.insert(p);
        }
        maxScore = max(maxScore, (int)pairs.size());
        swap(S[i], S[i + 1]);
    }
    
    cout << maxScore << endl;
    return 0;
}

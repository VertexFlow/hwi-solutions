#include <bits/stdc++.h>
using namespace std;

int main() {
    vector<int> firstLine;
    string line;
    getline(cin, line);
    stringstream ss(line);
    int val;
    while (ss >> val) firstLine.push_back(val);
    
    int N = firstLine[0];
    vector<int> A;
    for (size_t i = 1; i < firstLine.size() && A.size() < (size_t)N; i++) {
        A.push_back(firstLine[i]);
    }
    while ((int)A.size() < N) {
        getline(cin, line);
        stringstream ss2(line);
        while (ss2 >> val && (int)A.size() < N) {
            A.push_back(val);
        }
    }
    
    int removed = 0;
    bool changed = true;
    
    while (changed) {
        changed = false;
        vector<int> toRemove;
        
        for (int i = 1; i < (int)A.size() - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                toRemove.push_back(i);
            }
        }
        
        if (!toRemove.empty()) {
            changed = true;
            removed += (int)toRemove.size();
            vector<int> newA;
            int skipIdx = 0;
            for (int i = 0; i < (int)A.size(); i++) {
                if (skipIdx < (int)toRemove.size() && i == toRemove[skipIdx]) {
                    skipIdx++;
                    continue;
                }
                newA.push_back(A[i]);
            }
            A = newA;
        }
    }
    
    cout << removed << endl;
    return 0;
}

#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;
    vector<long long> E(N);
    for (int i = 0; i < N; i++) {
        cin >> E[i];
    }
    
    int result = 1;
    vector<long long> prefix(N);
    prefix[0] = E[0];
    
    for (int k = 1; k <= N; k++) {
        if (k == 1) {
            result = 1;
            continue;
        }
        
        vector<long long> copy = prefix;
        copy.resize(k);
        bool possible = true;
        
        for (int i = 0; i < k - 1; i++) {
            if (copy[i] > copy[i + 1]) {
                long long diff = copy[i] - copy[i + 1];
                copy[i] -= diff;
                copy[i + 1] += diff;
            }
        }
        
        for (int i = 0; i < k - 1; i++) {
            if (copy[i] > copy[i + 1]) {
                possible = false;
                break;
            }
        }
        
        if (possible) {
            result = k;
            if (k < N) {
                prefix[k] = E[k];
            }
        } else {
            break;
        }
    }
    
    cout << result << endl;
    return 0;
}

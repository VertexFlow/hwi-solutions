#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M, K;
    cin >> N;
    cin >> M;
    cin >> K;
    vector<int> P(N);
    for (int i = 0; i < N; i++) cin >> P[i];
    vector<int> R(M);
    for (int i = 0; i < M; i++) cin >> R[i];
    
    sort(P.begin(), P.end());
    sort(R.begin(), R.end(), greater<int>());
    
    int count = 0;
    vector<int> amplified(M, 0);
    int ampUsed = 0;
    
    for (int i = 0; i < N; i++) {
        int need = P[i];
        bool matched = false;
        
        for (int j = 0; j < M && !matched; j++) {
            if (amplified[j] == 0 && ampUsed < K) {
                if (R[j] * 2 >= need) {
                    amplified[j] = 1;
                    ampUsed++;
                    count++;
                    matched = true;
                }
            }
        }
        
        if (!matched) {
            for (int j = 0; j < M && !matched; j++) {
                if (amplified[j] == 0 && R[j] >= need) {
                    amplified[j] = 2;
                    count++;
                    matched = true;
                }
            }
        }
    }
    
    cout << count << endl;
    return 0;
}

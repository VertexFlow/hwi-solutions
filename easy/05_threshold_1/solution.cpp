#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, X, K;
    cin >> N;
    cin >> X;
    cin >> K;
    vector<long long> A(N);
    for (int i = 0; i < N; i++) {
        cin >> A[i];
    }
    
    int currentK = K;
    int maxIndex = 0;
    
    for (int i = 0; i < N - 1; i++) {
        long long threshold = A[i] + X;
        if (A[i + 1] <= threshold) {
            continue;
        } else {
            if (currentK > 0) {
                currentK--;
            } else {
                maxIndex = i;
                break;
            }
        }
        maxIndex = i + 1;
    }
    
    if (maxIndex < N - 1) {
        maxIndex = N - 1;
    }
    
    cout << maxIndex << endl;
    return 0;
}

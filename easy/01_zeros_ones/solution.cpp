#include <bits/stdc++.h>
using namespace std;

int findMaxSubarray(int N, vector<int>& A) {
    int left = 0;
    int right = 0;
    int transitions = 0;
    int valueBeforeTransition = -1;
    int maxLen = 0;
    
    while (right < N) {
        if (right == left) {
            right++;
            if (right < N) {
                transitions = 0;
                valueBeforeTransition = A[left];
            }
            continue;
        }
        
        if (transitions == 0) {
            if (A[right] != A[right - 1]) {
                transitions = 1;
                valueBeforeTransition = A[right - 1];
            }
        } else if (transitions == 1) {
            if (A[right] != valueBeforeTransition && A[right] != A[right - 1]) {
                maxLen = max(maxLen, right - left);
                left++;
                right = left;
                transitions = 0;
                valueBeforeTransition = -1;
                continue;
            }
        }
        right++;
    }
    
    maxLen = max(maxLen, right - left);
    return maxLen;
}

int main() {
    int N, M;
    cin >> N;
    cin >> M;
    vector<int> flips(M);
    for (int i = 0; i < M; i++) {
        cin >> flips[i];
        flips[i]--;
    }
    
    vector<int> A(N, 0);
    long long result = 1;
    const int mod = 1000000007;
    
    for (int idx = 0; idx < M; idx++) {
        int pos = flips[idx];
        A[pos] = 1 - A[pos];
        int cost = findMaxSubarray(N, A);
        result = (result * cost) % mod;
    }
    
    cout << result << endl;
    return 0;
}

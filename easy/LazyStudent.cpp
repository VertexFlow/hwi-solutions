#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, c;
    long long m;
    cin >> n;
    cin >> m;
    cin >> c;
    vector<long long> x(n);
    for (int i = 0; i < n; i++) cin >> x[i];
    
    sort(x.begin(), x.end(), greater<long long>());
    
    int count = 0;
    double totalScore = 0;
    
    for (int i = 0; i < n; i++) {
        totalScore += x[i];
        if (totalScore >= m) {
            count = i + 1;
            break;
        }
    }
    
    if (count == 0) {
        for (int i = 0; i < n; i++) {
            totalScore = 0;
            int thinkCount = 0;
            for (int j = 0; j <= i; j++) {
                totalScore += x[j];
                thinkCount++;
                if (totalScore >= m) break;
            }
            for (int j = i + 1; j < n; j++) {
                totalScore += (double)x[j] / c;
            }
            if (totalScore >= m) {
                count = thinkCount;
                break;
            }
        }
    }
    
    cout << count << endl;
    return 0;
}

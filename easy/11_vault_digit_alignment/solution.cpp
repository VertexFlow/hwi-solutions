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
    vector<int> Arr;
    for (size_t i = 1; i < firstLine.size() && (int)Arr.size() < N; i++) {
        Arr.push_back(firstLine[i]);
    }
    while ((int)Arr.size() < N) {
        getline(cin, line);
        stringstream ss2(line);
        while (ss2 >> val && (int)Arr.size() < N) {
            Arr.push_back(val);
        }
    }
    
    long long totalCost = 0;
    int target = Arr[0];
    
    for (int i = 1; i < N; i++) {
        if (Arr[i] < target) {
            totalCost += (target - Arr[i]);
            Arr[i] = target;
        } else {
            target = Arr[i];
        }
    }
    
    cout << totalCost << endl;
    return 0;
}

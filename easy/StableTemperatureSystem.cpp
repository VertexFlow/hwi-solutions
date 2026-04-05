#include <bits/stdc++.h>
using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<long long> T(N);
    for (int i = 0; i < N; i++)
    {
        cin >> T[i];
    }

    long long totalOps = 0;
    vector<long long> effective = T;

    for (int i = 1; i < N; i++)
    {
        if (effective[i] > effective[i - 1] + 1)
        {
            totalOps += effective[i] - (effective[i - 1] + 1);
            effective[i] = effective[i - 1] + 1;
        }
    }

    cout << totalOps << endl;
    return 0;
}

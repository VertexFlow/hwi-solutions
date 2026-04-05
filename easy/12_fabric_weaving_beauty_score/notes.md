## Fabric Weaving Beauty Score

### Problem Summary
Interleave two sequences while maintaining order. Maximize harmony bonus for same-color consecutive threads.

### Intuition
DP where dp[i][j] represents max beauty when i elements from A and j from B are placed. Check if next element matches the last placed.

### Approach
1. Create dp table of size (N+1) x (M+1).
2. For each cell dp[i][j]:
   - Take max of dp[i-1][j] and dp[i][j-1]
   - Check if A[i-1] matches last placed (from A or B or first)
   - Add harmony bonus H if consecutive colors match
3. Return dp[N][M].

### Time Complexity
O(N * M) - fill entire DP table.

### Space Complexity
O(N * M) for dp table.

## Coins

### Problem Summary
For each index, maximize coins with operations: add 1 coin, or multiply coins by 2. Find total.

### Intuition
Greedy: do all additions first, then all multiplications. Formula: (0 + A[i]) * 2^B[i].

### Approach
1. For each index i:
   - coins = A[i] * 2^B[i] mod MOD
2. Sum all coins and return modulo.

### Time Complexity
O(N log B[i]) using fast exponentiation.

### Space Complexity
O(1) additional space.

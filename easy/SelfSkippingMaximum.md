## Self-Skipping Maximum

### Problem Summary
Select elements from array such that if you pick index i, you skip the next A[i] elements. Maximize the total sum.

### Intuition
This is a classic dynamic programming problem. For each position, we decide whether to take the element or skip it. If we take it, we must jump past the skipped elements.

### Approach
1. Process from right to left.
2. For each index i:
   - Option 1: Take A[i] and jump to i + A[i] + 1
   - Option 2: Skip and move to i + 1
3. dp[i] = max(take option, skip option)
4. Answer is dp[0].

### Time Complexity
O(N) - each index processed once.

### Space Complexity
O(N) for dp array.

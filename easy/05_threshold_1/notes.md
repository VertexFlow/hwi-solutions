## Threshold 1

### Problem Summary
Traverse an array starting from index 0. Each step may require a power-up if the next element exceeds current + X. Find max reachable index.

### Intuition
Simply iterate through the array. If next element exceeds current + X, we need a power-up. Track remaining power-ups and stop when we need one but have none.

### Approach
1. Start at index 0 with K power-ups.
2. For each i from 0 to N-2:
   - If A[i+1] <= A[i] + X, move freely.
   - Else if K > 0, use one power-up and move.
   - Else stop at index i.
3. Return the maximum index reached.

### Time Complexity
O(N) - single pass through the array.

### Space Complexity
O(N) to store the array.

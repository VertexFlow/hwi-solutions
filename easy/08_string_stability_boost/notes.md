## String Stability Boost

### Problem Summary
Find maximum distinct adjacent pairs after exactly one adjacent swap.

### Intuition
Count distinct pairs in the original string, then try swapping each adjacent pair and count distinct pairs again. Take the maximum.

### Approach
1. Count distinct pairs in original string.
2. For each position i from 0 to n-2:
   - Swap characters at i and i+1.
   - Count distinct pairs in swapped string.
   - Swap back to original.
3. Return maximum score.

### Time Complexity
O(N^2) due to pair counting for each swap position.

### Space Complexity
O(N) for storing pairs in set.

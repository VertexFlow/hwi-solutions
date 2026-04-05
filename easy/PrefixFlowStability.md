## Prefix Flow Stability

### Problem Summary
Find the largest prefix that can be made non-decreasing by transferring units from left to right.

### Intuition
We can only move units from left to right. To check if a prefix can be made non-decreasing, we simulate transfers from left to right - whenever a[i] > a[i+1], transfer the difference.

### Approach
1. Check each prefix length k from 1 to N.
2. For each prefix, simulate left-to-right transfers.
3. If any element still violates non-decreasing order, that prefix length is invalid.
4. Return the largest valid prefix length.

### Time Complexity
O(N^2) in worst case.

### Space Complexity
O(N) for the prefix array.

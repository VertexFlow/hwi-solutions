## Stable Temperature System

### Problem Summary
Make array stable where adjacent elements differ by at most 1. You can only decrease elements. Find minimum operations.

### Intuition
We propagate constraints from left to right. If an element exceeds the previous element + 1, we must reduce it. The total reduction needed is the answer.

### Approach
1. Copy array to effective array.
2. Iterate from left to right.
3. If T[i] > T[i-1] + 1, reduce T[i] to T[i-1] + 1.
4. Accumulate the total reduction.
5. Return total operations.

### Time Complexity
O(N) - single pass.

### Space Complexity
O(N) for the effective array.

## ZerosOnes

### Problem Summary
Flip bits in an array and find the product of maximum subarray lengths (with at most one transition) after each flip.

### Intuition
After each flip, we need to find the longest contiguous subarray that is either all same values or has exactly one change from 0s to 1s or 1s to 0s. We slide a window and count transitions.

### Approach
1. Start with array A of all zeros.
2. For each flip operation, toggle the bit at position B[i].
3. Use two pointers (sliding window) to find longest subarray:
   - Track if we've seen 0, 1, or 2 transitions
   - If we see a third transition, move left pointer
4. Multiply each cost and take modulo.

### Time Complexity
O(N * M) - sliding window for each operation.

### Space Complexity
O(N) for the array.

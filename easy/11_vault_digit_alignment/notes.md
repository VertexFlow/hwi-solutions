## Vault Digit Alignment

### Problem Summary
Make digits non-decreasing using forward-only rotation. Find minimum total rotations.

### Intuition
Track the target (maximum needed so far). If current digit is less, rotate it up to target and add cost.

### Approach
1. Start with target = first digit.
2. For each subsequent digit:
   - If digit >= target, update target.
   - If digit < target, add (target - digit) to cost and set digit to target.
3. Return total cost.

### Time Complexity
O(N) - single pass.

### Space Complexity
O(N) for storing the array.

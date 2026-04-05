# Easy Questions

### Questions - [View PDF](./assets/questions.pdf)

### 1. Zeros Ones - [Solution](./01_zeros_ones)

Flip bits in an array and compute product of max subarray lengths (with at most one transition) after each flip.

**Problem:** Given array A (initially zeros) of length N and M indices B. Flip A[B[i]] after each operation. After each flip, find max length of contiguous subarray with at most one 0→1 or 1→0 transition. Return product of all costs modulo 10^9+7.

---

### 2. Self Skipping Maximum - [Solution](./02_self_skipping_maximum)

Select subsequence from array where picking index i forces skipping next A[i] elements.

**Problem:** Given array A of N positive integers. If you pick index i, skip next A[i] elements. Maximize sum of selected elements.

---

### 3. Prefix Flow Stability - [Solution](./03_prefix_flow_stability)

Transfer units forward in array to make longest prefix non-decreasing.

**Problem:** Given array E of size N. Transfer 1 unit from E[i] to E[i+1] any number of times (forward only). Find max K such that first K elements can be made non-decreasing.

---

### 4. Peak Elimination - [Solution](./04_peak_elimination)

Remove peak elements iteratively from sequence.

**Problem:** Given sequence of N integers. A peak (i > 1, A[i] > A[i-1] and A[i] > A[i+1]) can be removed. Find max number of elements removable.

---

### 5. Threshold 1 - [Solution](./05_threshold_1)

Traverse array using power-ups when height difference exceeds threshold.

**Problem:** Given array A, start at index 0. Move right: if A[i+1] <= A[i] + X, move free; else use one power-up. Start with K power-ups. Find max reachable index.

---

### 6. Stable Temperature System - [Solution](./06_stable_temperature_system)

Decrease temperatures to ensure adjacent differences ≤ 1.

**Problem:** Given array T of N temperatures. Decrease any element (cost = 1 per unit) so |T[i] - T[i-1]| ≤ 1 for all i. Find minimum operations.

---

### 7. Blocks - [Solution](./07_blocks)

Arrange alternating 1-blocks and 0-blocks to maximize binary value.

**Problem:** Given arrays A (1-block sizes) and B (0-block sizes). Arrange into alternating binary string to maximize decimal value. Return modulo 10^9+7.

---

### 8. String Stability Boost - [Solution](./08_string_stability_boost)

Perform one adjacent swap to maximize distinct adjacent pairs.

**Problem:** Given string S. Stability score = number of distinct adjacent pairs. Perform exactly one adjacent swap. Find maximum stability achievable.

---

### 9. Tool Rental Maximization - [Solution](./09_tool_rental_maximization)

Match customers to tools with K amplifiers available.

**Problem:** N customers need tools with power >= P[i]. M tools with rating R[j]. Use K amplifiers to double up to K tools. Maximize customers served.

---

### 10. Coins - [Solution](./10_coins)

Maximize coins using add and multiply operations.

**Problem:** For each i, start with 0 coins. Perform: add 1 coin (A[i] times), multiply by 2 (B[i] times). Find sum of max coins for all i mod 10^9+7.

---

### 11. Vault Digit Alignment - [Solution](./11_vault_digit_alignment)

Rotate digits forward to make sequence non-decreasing.

**Problem:** N digits (0-9) can only rotate forward (0→1→...→9→0). Make sequence non-decreasing with minimum rotations.

---

### 12. Fabric Weaving Beauty Score - [Solution](./12_fabric_weaving_beauty_score)

Interleave two threads spools to maximize harmony bonuses.

**Problem:** Two spools A (N threads) and B (M threads). Weave maintaining order. Same-color adjacent pairs earn bonus H. Maximize total beauty.

---

### 13. Lazy Student - [Solution](./13_lazy_student)

Minimize questions to think through for expected passing score.

**Problem:** n questions worth x[i] marks. Guess: expected x[i]/c. Think: earn full x[i]. With c choices, find min questions to think to achieve expected score >= m.

---

## Summary

| #   | Name                      | Approach                  |
| --- | ------------------------- | ------------------------- |
| 1   | Zeros Ones                | Sliding Window            |
| 2   | Self Skipping Maximum     | DP (right-to-left)        |
| 3   | Prefix Flow Stability     | Prefix Simulation         |
| 4   | Peak Elimination          | Iterative Removal         |
| 5   | Threshold 1               | Greedy Traversal          |
| 6   | Stable Temperature System | Left-to-right Propagation |
| 7   | Blocks                    | Sort + Build              |
| 8   | String Stability Boost    | Try All Swaps             |
| 9   | Tool Rental               | Sort + Greedy Match       |
| 10  | Coins                     | Greedy + Fast Power       |
| 11  | Vault Digit Alignment     | Prefix Target             |
| 12  | Fabric Weaving            | 2D DP                     |
| 13  | Lazy Student              | Sort + Greedy             |

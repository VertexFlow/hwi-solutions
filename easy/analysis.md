## Analysis of Easy DSA Questions

### Types of Problems in the PDF

The PDF contains 13 problems covering various categories:

1. **Array Manipulation** - Q1 (ZerosOnes), Q6 (Stable Temperature System)
2. **Dynamic Programming** - Q2 (Self-Skipping Maximum), Q12 (Fabric Weaving Beauty Score)
3. **Greedy Algorithms** - Q7 (Blocks), Q9 (Tool Rental), Q10 (Coins), Q13 (Lazy Student)
4. **String Processing** - Q8 (String Stability Boost)
5. **Sequential Processing** - Q5 (Threshold 1), Q11 (Vault Digit Alignment)
6. **Simulation/Iteration** - Q3 (Prefix Flow Stability), Q4 (Peak Elimination)

### Patterns Observed

1. **Sliding Window/Two Pointers** - Used in Q1 for finding subarrays
2. **Dynamic Programming** - Q2 uses DP from right to left, Q12 uses 2D DP
3. **Greedy with Sorting** - Q7, Q9, Q10, Q13 all benefit from sorting first
4. **Prefix Propagation** - Q3, Q6, Q11 all involve propagating constraints forward
5. **Iterative Removal** - Q4 repeatedly removes peaks until none remain

### Difficulty Level

All questions are **Easy** level:
- Most have simple O(N) or O(N log N) solutions
- Q12 (DP) is slightly more complex but still manageable
- No advanced data structures required beyond arrays

### Key Concepts Required

1. **Arrays and Strings** - Basic operations and traversal
2. **Sorting** - Essential for greedy problems
3. **Dynamic Programming** - Basic 1D and 2D DP
4. **Two Pointers/Sliding Window** - For subarray problems
5. **Greedy Choice** - When to take local optimal solution
6. **Hash Sets** - For counting distinct elements
7. **Math/Modular Arithmetic** - For large number operations

### What a Beginner Should Study

Before attempting similar questions:

1. **Arrays** - Traversal, modification, prefix/suffix sums
2. **Sorting** - Arrays.sort(), custom comparators
3. **HashMap/HashSet** - For O(1) lookups and counting
4. **Basic DP** - fibonacci-style, decision DP
5. **Two-pointer technique** - For subarray problems
6. **Modular arithmetic** - For large number results
7. **String manipulation** - substrings, character access

### Problem Summary Table

| Q# | Name | Approach | Time |
|----|------|----------|------|
| 1 | ZerosOnes | Sliding Window | O(N*M) |
| 2 | Self-Skipping Maximum | DP (right-to-left) | O(N) |
| 3 | Prefix Flow Stability | Prefix Simulation | O(N^2) |
| 4 | Peak Elimination | Iterative Removal | O(N^2) |
| 5 | Threshold 1 | Greedy Traversal | O(N) |
| 6 | Stable Temperature System | Left-to-right Propagation | O(N) |
| 7 | Blocks | Sort + Build | O(N log N) |
| 8 | String Stability Boost | Try All Swaps | O(N^2) |
| 9 | Tool Rental | Sort + Greedy Match | O(N log N) |
| 10 | Coins | Greedy + Fast Power | O(N log B) |
| 11 | Vault Digit Alignment | Prefix Target | O(N) |
| 12 | Fabric Weaving | 2D DP | O(N*M) |
| 13 | Lazy Student | Sort + Greedy | O(N^2) |

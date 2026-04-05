## Tool Rental Maximization

### Problem Summary
Match customers with tools. Can amplify K tools to double their power. Maximize matches.

### Intuition
Sort customers by requirement and tools by power. Try to match each customer, using amplifiers on tools that need them to meet the requirement.

### Approach
1. Sort customers ascending by requirement.
2. Sort tools descending by power.
3. For each customer:
   - Try to use an amplifier on a tool to meet requirement.
   - If not possible, try matching without amplification.
4. Count maximum matches.

### Time Complexity
O(N log N + M log M) for sorting.

### Space Complexity
O(N + M) for storing arrays.

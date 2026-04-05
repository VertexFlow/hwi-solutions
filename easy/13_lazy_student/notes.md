## Lazy Student

### Problem Summary
Minimize questions to think while achieving expected score >= m. Guess gives x/c in expectation.

### Intuition
Sort questions by value descending. Greedily think through highest-value questions first to maximize expected score with minimum "think" operations.

### Approach
1. Sort questions by value in descending order.
2. Try thinking through questions one by one (greedy).
3. For each subset of "thought" questions, calculate expected score.
4. Return minimum count that achieves expected >= m.

### Time Complexity
O(N^2) in worst case.

### Space Complexity
O(N) for storing questions.

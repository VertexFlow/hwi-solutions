# Vineyard Planting

## Problem Summary
Interleave two arrays A and B preserving order to maximize total score, where each new element's contribution is max(|x - max|, |x - min|).

## Intuition
Use DP to track all possible states (range min/max) after placing some elements. The score is the extension of the current range.

## Approach
1. DP state dp[i][j] = list of possible (score, min, max) after i from A and j from B.
2. For each state, try taking next from A or B.
3. Prune dominated states (same or worse range with better/worse score).
4. Final answer is max score at dp[n][m].

## Time Complexity
O(N * M * S) where S is average number of states per cell (kept small by pruning).

## Space Complexity
O(N * M * S)

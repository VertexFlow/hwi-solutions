# Textile Pattern Weaving

## Problem Summary
Interleave two sequences of threads to maximize harmony bonus for same-color consecutive pairs.

## Intuition
DP over two sequences. Track best beauty score for each state based on last color placed.

## Approach
1. dp[i][j] = map of (last_color -> max_beauty) using i from A, j from B
2. Transition by taking next from A or B
3. Add H bonus when new color matches previous
4. Answer is max beauty at dp[N][M]

## Time Complexity
O(N*M*C) where C is number of colors

## Space Complexity
O(N*M*C) in worst case

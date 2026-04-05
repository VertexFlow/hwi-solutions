# Aquarium Fish Display

## Problem Summary
Merge two sequences of fish into one row preserving order, maximizing sum of compatibility scores for adjacent pairs.

## Intuition
Use DP where we track the last placed fish to compute pair scores. Similar to merging two arrays.

## Approach
1. dp[i][j][0] = max score ending with A[i-1]
2. dp[i][j][1] = max score ending with B[j-1]
3. Transitions consider the previous fish and add S[prev][current]
4. Answer is max of dp[n][m][0] and dp[n][m][1]

## Time Complexity
O(N * M)

## Space Complexity
O(N * M)

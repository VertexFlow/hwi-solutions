# Minimum Increasing Unique Selection Cost

## Problem Summary
Select K elements from array that are strictly increasing in both index and value, with minimum cost.

## Intuition
Use DP where dp[i][k] = min cost for increasing subsequence of length k ending at position i. Cost formula: sum of (index - position)^2.

## Approach
1. Coordinate compress values
2. Use BIT (Fenwick Tree) for each k to track minimum dp value for values <= current
3. For each element, extend subsequences from k-1 to k using BIT queries
4. Update BIT[k] with new dp values
5. Answer is min dp for length K

## Time Complexity
O(N * K * logV) where V is number of unique values

## Space Complexity
O(K * V) for BITs

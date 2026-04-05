# Maximum Modulo Sum

## Problem Summary
Select a subsequence from an array to maximize sum where no two consecutive elements have the same remainder when divided by K.

## Intuition
We want to pick elements strategically so that consecutive elements in our selection have different remainders. This is a classic DP problem where we track the best sum ending with each possible remainder.

## Approach
1. Use dynamic programming where dp[r] stores the maximum sum of a valid subsequence ending with remainder r.
2. For each element, try to extend subsequences that ended with a different remainder.
3. Initialize dp[0] = 0 (empty subsequence).
4. Update dp for each element considering all possible extensions.
5. Answer is the maximum value across all remainders.

## Time Complexity
O(N * K) where N is array size and K is the divisor.

## Space Complexity
O(K) for the DP array.

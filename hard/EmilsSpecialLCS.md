# Emil's Special LCS

## Problem Summary
Find common subsequence maximizing length * count_of_'e'.

## Intuition
Modified LCS where 'e' characters have weight 2 (contributes to both length and count_e) and other characters have weight 1.

## Approach
1. dp[i][j] = max weighted score for A[0..i) and B[0..j)
2. Standard LCS recurrence with weighted matching
3. Weight = 2 if char is 'e', else 1
4. Answer is dp[n][m]

## Time Complexity
O(|A| * |B|)

## Space Complexity
O(min(|A|, |B|)) with space optimization

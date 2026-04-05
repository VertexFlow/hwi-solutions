# Weighted Non-Overlapping Intervals

## Problem Summary
Select exactly K intervals that do not overlap to maximize total weight.

## Intuition
Sort intervals by their right endpoint. For each interval, decide whether to include it or skip it. Use DP to track the maximum weight for selecting k intervals up to each point.

## Approach
1. Sort intervals by right endpoint
2. Create dp[i][k] = max weight using k intervals from first i intervals
3. For each interval, find the last non-overlapping interval using binary search
4. Either skip the interval or take it (if it doesn't overlap)
5. Answer is dp[N][K]

## Time Complexity
O(N*K*logN) - N intervals, K selections, binary search for each

## Space Complexity
O(N*K) for DP table

# Terrain Color Trail

## Problem Summary
Find max score path on grid where score = sum of scenic values + bonus for same-color transitions.

## Intuition
DP similar to Q3. Track best score for each possible last color at each cell.

## Approach
1. dp[i][j] = map of (last_color -> max_score)
2. Transition from top and left cells
3. Add V[i][j] + (B if same color as previous)
4. Merge states keeping best score per color
5. Answer is max score at destination

## Time Complexity
O(N*M*K) in worst case

## Space Complexity
O(N*M*K) in worst case

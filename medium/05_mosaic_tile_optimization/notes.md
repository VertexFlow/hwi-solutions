# Mosaic Tile Optimization

## Problem Summary
Tile an NxM grid with 1x1 tiles (cost costA, bonus V[i][j]) or 1x2 horizontal tiles (cost costB, no bonus). Minimize net cost.

## Intuition
Since tiles are horizontal only, each row can be solved independently. This becomes a simple DP for tiling a 1xM row.

## Approach
1. For each row, use DP where dp[j] = min cost for first j columns.
2. Transition: dp[j] = min(dp[j-1] + costA - V[i][j-1], dp[j-2] + costB).
3. Sum dp[M] for all rows.

## Time Complexity
O(N * M)

## Space Complexity
O(M) per row

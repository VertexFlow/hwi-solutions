# The Crystal Path

## Problem Summary
Find max energy path from top-left to bottom-right where contribution at each cell is value * min_so_far.

## Intuition
DP where we track the best energy for each possible minimum value. When moving to a new cell, the minimum updates and affects the contribution.

## Approach
1. dp[i][j] = map of (min_value -> max_energy) for paths reaching (i,j)
2. For each cell, merge states from top and left neighbors
3. New min = min(prev_min, current_value)
4. New energy = prev_energy + current_value * new_min
5. Answer is max energy at destination cell

## Time Complexity
O(N*M*V) where V is number of unique values per cell

## Space Complexity
O(N*M*V) in worst case

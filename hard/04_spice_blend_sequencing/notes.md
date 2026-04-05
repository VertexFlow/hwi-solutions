# Spice Blend Sequencing

## Problem Summary
Select K items from two ordered sequences to maximize sum of intensities plus harmony bonus for consecutive same-flavor pairs.

## Intuition
DP over two sequences. Track state by how many items taken from each sequence and the last flavor to compute harmony bonus.

## Approach
1. dp[i][j][k][f] = max score using i from A, j from B, k total items, last flavor f
2. Iterate through all positions in the 2D grid formed by A and B
3. At each state, compute best previous score and extend with next item from A or B
4. Add harmony bonus H when flavor matches previous
5. Answer is max score at dp[N][M][K][f]

## Time Complexity
O(N*M*K*F) where F is max flavor value (100)

## Space Complexity
O(K*F) using rolling arrays

# Film Festival Programming

## Problem Summary
Select D films and arrange them to maximize sum of appeals minus repetition penalties for consecutive same-genre films.

## Intuition
Greedy approach: pick highest-appeal film that differs from previous genre. Fall back to any film if no different genre available.

## Approach
1. Sort all films by appeal descending
2. Iterate D times, selecting the highest-appeal film whose genre differs from last selected
3. If no such film exists, take the highest-appeal film anyway (incurs penalty)
4. Subtract penalties: number of same-genre consecutive pairs * P

## Time Complexity
O(N*D) or O(N*logN) with optimization

## Space Complexity
O(N)

# Dual Timeline

## Problem Summary
Assign tasks to two parallel teams to minimize total penalty where penalty = completion_time * penalty_weight.

## Intuition
We process tasks in order and assign each to the team with the smaller current accumulated time. This minimizes when each task completes.

## Approach
1. Track total time for each team.
2. For each task, assign to the team with less accumulated time.
3. Calculate penalty as team_time * task_penalty.

## Time Complexity
O(N)

## Space Complexity
O(1)

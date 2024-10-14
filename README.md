# 10x10 Board Movement Solver - IASI Project

This repository contains the implementation of a project for the **Intelligence Artificial and Intelligent Systems (IASI)** course. The objective is to solve a problem where a piece shaped like an "L" moves across a 10x10 board to reach a specified target position using heuristic-based search algorithms.

## Project Overview

The goal of the project is to design and implement a system that moves a piece (in the shape of an "L") across a 10x10 board, avoiding walls, and reaches a target position. The input is a board where each cell is marked as one of the following:
- `0` - Empty cell
- `1` - Wall
- `2` - Piece (starting position)
- `3` - Target position

The piece can rotate and move (up, down, left, right) while avoiding obstacles and walls. The solution is represented as a sequence of moves that will take the piece from its initial position to the target, considering rotation and translation actions.

## Algorithms

Two search algorithms were implemented to find solutions for this problem:

1. **Best-First Search (BFS)**:
   - This is a heuristic-driven search algorithm that selects the most promising node according to a heuristic function, aiming to minimize the number of moves to reach the target.
   
2. **Hill-Climbing Search**:
   - This algorithm follows a local search approach, continually moving towards the neighbor with the steepest ascent based on the heuristic, hoping to find the target quickly.

Both algorithms aim to minimize the number of moves and find a solution in a short amount of time.

## Input Format

The input file is a simple text file with 10 rows, where each row contains numbers separated by commas, representing the 10x10 board. The values in the file follow the encoding:
- `0` - Empty cell
- `1` - Wall
- `2` - Piece
- `3` - Target position

Example input (`board.txt`):

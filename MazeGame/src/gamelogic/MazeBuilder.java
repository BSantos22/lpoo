package gamelogic;

import java.util.*;


public class MazeBuilder implements IMazeBuilder{
	char[][] maze;
	int exit_x;
	int exit_y;
	
	public char[][] buildMaze(int size) throws IllegalArgumentException{
		Random rnd = new Random();
		maze = new char[size][size];
		
		// fill maze
		for (char[] row : maze) {
			for (char dot : row) {
				dot = 'X';
			}
		}
		
		// choose exit		
		do {
			int exit_border = rnd.nextInt(4);
			switch (exit_border) {
			case 0: // left
				exit_x = 0;
				exit_y = rnd.nextInt(size);
				break;
			case 1: // right
				exit_x = size - 1;
				exit_y = rnd.nextInt(size);
				break;
			case 2: // top
				exit_y = 0;
				exit_x = rnd.nextInt(size);
				break;
			case 3: // bottom
				exit_y = size - 1;
				exit_x = rnd.nextInt(size);
				break;
			}
		} while ((exit_x == 0 || exit_x == size) && (exit_y == 0 || exit_y == size));
		
		maze[exit_y][exit_x] = 'S';
		
		// Create path
		Stack<Point> path = new Stack<Point>();
		
		// Starting point
		Point start = new Point();
		
		if (exit_x == 0) {
			start.x = 1;
			start.y = exit_y;
		}
		else if (exit_x == size - 1) {
			start.x = size - 2;
			start.y = exit_y;
		}
		else if (exit_y == 0) {
			start.x = exit_x;
			start.y = 1;
		}
		else if (exit_y == size - 1) {
			start.x = exit_x;
			start.y = size - 2;
		}
		
		path.push(start);
	
		
		// Next point
		while (!path.empty()) {
			int choose = rnd.nextInt(4);
			Point next = path.peek();
			
			
			
			
			
		}
		
		
		return maze;
	}
	
	public Point chooseNextPoint(char[][] maze, Point point) /*throws DeadEnd*/ {
		Random rnd = new Random();
		Point next_point = point;
		Vector<Point> options = new Vector<Point>(4);
		
		
		
		
		
		return next_point;
	}
	
	
}

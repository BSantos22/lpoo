package gametest;

import org.junit.Test;
import gamelogic.*;

public class TestMazeBuilder {

	@Test
	public void printMaze() {
		char[][] maze = MazeBuilder.buildMaze(30);
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				System.out.print(maze[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
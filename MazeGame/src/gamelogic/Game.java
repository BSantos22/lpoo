package gamelogic;

import java.util.ArrayList;

import gamelogic.Dragon;
import gamelogic.Hero;
import gamelogic.Maze;

public class Game {
	public Maze maze;
	public Hero hero;
	public String game_mode;
	public ArrayList<Dragon> dragons = new ArrayList<Dragon>();

	public Game() {
		maze = new Maze();
		hero = new Hero();
	}
	
	public Game (char[][] board) {
		maze = new Maze(board);
		hero = new Hero(board);
		
		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board.length; a++) {
				if (board[a][i] == 'D') {
					dragons.add(new Dragon(i,a));
				}
			}
		}
	}
	
	
	
	public Game(int maze_size, int number_dragons) {		
		maze = new Maze(maze_size);
		hero = new Hero(maze);

		for (int i = 0; i < number_dragons; i++) {
			dragons.add(new Dragon(maze));
		}
	} 

	public String return_board() {
		return maze.return_board();
	}

	public int play(String game_mode, String key) {
		if (game_mode.equals("0")) {
			for (int i = 0; i < dragons.size(); i++) {
				dragons.get(i).move(maze);
			}
		}

		if (game_mode.equals("1")) {
			for (int i = 0; i < dragons.size(); i++) {
				if (dragons.get(i).is_sleeping == 'D') {
					if (dragons.get(i).mode(maze) == 0)
						dragons.get(i).move(maze);

					else if (dragons.get(i).mode(maze) == 1)
						dragons.get(i).fallAsleep(maze);

				} else if (dragons.get(i).is_sleeping == 'd')
					if (dragons.get(i).mode(maze) == 0 || dragons.get(i).mode(maze) == 1)
						dragons.get(i).wakeUp(maze);	
			}
		}
		// gameMode == "2" -> stand still


		if (!hero.move(key, maze)) {
			return 0;
		}
		
		if (hero.x == maze.exit.x && hero.y == maze.exit.y) {
			return 1;
		}

		hero.pickUpSword(maze.sword, maze);		

		for (Dragon d : dragons) {

			switch (hero.fightDragon(d)) {
			case 1:
				return 2; // LOSE
			case 2:
				d.dies(maze); // WIN
				dragons.remove(d);
				if (dragons.isEmpty())
					maze.board[maze.exit.y][maze.exit.x] = ' ';
				
				return 3;
			}
		}

		return 0;
	}
}
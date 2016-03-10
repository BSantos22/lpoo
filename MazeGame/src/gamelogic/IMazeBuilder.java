package gamelogic;

public interface IMazeBuilder {
	public char[][] buildMaze(int size) throws IllegalArgumentException;
}

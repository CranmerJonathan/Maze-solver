// Assignment: Assignment11
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class solves the maze and also reads the maze from the user.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {
	//declaring variables
	Stack<Node> stack = new Stack<Node>();
	char[][] maze;
	int eggFound = 0;
	int mHeight;
	int mWidth;
	Node node;

	// ************************************************************************************
	// ************** Utility method to read maze from user input *************************
	// ************************************************************************************
	
	//Maze solver
	public void depthFirstSearch() {
		int i = 0;
		int j = 0;
		stack.add(node = new Node(0,0));
		do {
			if (i < mHeight - 1) {
				if (maze[i + 1][j] != '#' && maze[i + 1][j] != 'x') {
					stack.add(node = new Node(i+1,j));
				}
			}
			if (i > 0) {
				if (maze[i - 1][j] != '#' && maze[i - 1][j] != 'x') {
					stack.add(node = new Node(i-1,j));
				}
			}
			if (j < mWidth - 1) {
				if (maze[i][j + 1] != '#' && maze[i][j + 1] != 'x') {
					stack.add(node = new Node(i,j+1));
				}
			}
			if (j > 0) {
				if(maze[i][j - 1] != '#' && maze[i][j - 1] != 'x') {
					stack.add(node = new Node(i,j-1));
				}
			}
			maze[i][j] = 'x';
			i = stack.peek().getY();
			j = stack.pop().getX();
			if (maze[i][j] == 'E') {
				eggFound++;
			}
		} while (stack != null && !stack.isEmpty());
	}
	
	//Egg getter
	public int getEggFound() {
		return eggFound;
	}
	
	//Method to print maze
	public void printMaze() {
		for (int i = 0; i < mHeight; i++) {
			for (int j = 0; j < mWidth; j++) {
				System.out.print(maze[i][j]);
				}
			System.out.println("");
		}
		System.out.println("");
	}
	
	//Navabi wrote
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];

			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

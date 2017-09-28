import java.util.*;
import java.io.*;

public class mazePath {
	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(new File("maze.txt"));
		String[][] mazeMap = new String[8][10];
		boolean[][] mazeboolean = new boolean[8][10];
		String[] array = new String[8];
		int goalR = 0, goalC = 0;

		for (int i = 0; i < array.length; i++) { // converting the maze to a 2-D
													// string array
			array[i] = s.nextLine();
			System.out.println(array[i]);
			for (int j = 0; j < mazeMap[i].length; j++) {
				mazeMap[i][j] = Character.toString(array[i].charAt(j));
			}
		}

		for (int i = 0; i < mazeMap.length; i++) { // find the position of "$"
			for (int j = 0; j < mazeMap[i].length; j++) {
				if (mazeMap[i][j].equals("$")) {
					goalR = i;
					goalC = j;
					break;
				}
			}
		}

		for (int i = 0; i < mazeboolean.length; i++) { // making a 2-D boolean
														// array according to
														// the mazeMap array
			for (int j = 0; j < mazeboolean[i].length; j++) {
				if (mazeMap[i][j].equals("x")) {
					mazeboolean[i][j] = false;
				} else {
					mazeboolean[i][j] = true;
				}
			}

		}

		findPath(goalR, goalC, mazeboolean);
	}

	public static int[] findPath(int pathR, int pathC, boolean[][] mazeboolean) {
		int[] position = new int[2];
		position[0] = pathR;
		position[1] = pathC;

		if (pathR == 1 && pathC == 2) {
			mazeboolean[pathR + 1][pathC] = false;
		}

		if (mazeboolean[pathR - 1][pathC]) {
			mazeboolean[pathR][pathC] = false;
			System.out.println("(" + position[0] + ", " + position[1] + ")");
			pathR = pathR - 1;
			return findPath(pathR, pathC, mazeboolean);
		}

		if (mazeboolean[pathR + 1][pathC]) {
			mazeboolean[pathR][pathC] = false;
			System.out.println("(" + position[0] + ", " + position[1] + ")");
			pathR = pathR + 1;
			return findPath(pathR, pathC, mazeboolean);
		}

		if (mazeboolean[pathR][pathC - 1]) {
			mazeboolean[pathR][pathC] = false;
			System.out.println("(" + position[0] + ", " + position[1] + ")");
			pathC = pathC - 1;
			return findPath(pathR, pathC, mazeboolean);
		}

		if (mazeboolean[pathR][pathC + 1]) {
			mazeboolean[pathR][pathC] = false;
			System.out.println("(" + position[0] + ", " + position[1] + ")");
			pathC = pathC + 1;
			return findPath(pathR, pathC, mazeboolean);
		}

		System.out.println("(" + position[0] + ", " + position[1] + ")");
		return position;
	}

}

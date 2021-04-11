package helix;

import java.util.ArrayList;
import java.util.List;

public class MatrixHelixMorph {

	private static final String LEFT = "left";
	private static final String DOWN = "down";
	private static final String TOP = "top";
	private static final String RIGHT = "right";

	/**
	 * @param inMatrix
	 * @return a matrix that is morphed into a helix version of inMatrix
	 */
	public static int[][] helix(int[][] inMatrix) {
		if (inMatrix.length == 0) {
			return inMatrix;
		}
		int rows = inMatrix.length;
		int cols = inMatrix[0].length;
		String direction = RIGHT; //default
		boolean[][] visited = new boolean[rows][cols];
		List<Integer> collected = new ArrayList<>();
		for (int[] matrix : inMatrix) {
			for (int j = 0; j < cols; j++) {
				collected.add(matrix[j]);
			}
		}

		int i = 0, j = 0;
		while (collected.size() != 0) {
			if (direction.equals(RIGHT)) {
				if (i < rows && j < cols && !visited[i][j]) {
					inMatrix[i][j] = collected.get(0);
					collected.remove(0);
					visited[i][j] = true;
					j++;
				} else {
					direction = DOWN;
					j--;
					i++;
				}
				continue;
			}
			if (direction.equals(DOWN)) {
				if (i < rows && j < cols && !visited[i][j]) {
					inMatrix[i][j] = collected.get(0);
					visited[i][j] = true;
					collected.remove(0);
					i++;
				} else {
					direction = LEFT;
					j--;
					i--;
				}
				continue;
			}

			if (direction.equals(LEFT)) {
				if (i >= 0 && j >= 0 && !visited[i][j]) {
					inMatrix[i][j] = collected.get(0);
					visited[i][j] = true;
					collected.remove(0);
					j--;
				} else {
					direction = TOP;
					j++;
					i--;
				}
				continue;
			}

			if (i >= 0 && j >= 0 && !visited[i][j]) {
				inMatrix[i][j] = collected.get(0);
				visited[i][j] = true;
				collected.remove(0);
				i--;
			} else {
				direction = RIGHT;
				j++;
				i++;
			}
		}
		return inMatrix;
	}
}
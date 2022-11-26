package Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathBetweenCellsBFS {
	private static class Station {
		int x;
		int y;
		int dist; // distance
		Station prev; // parent cell in the path

		Station(int x, int y, int dist, Station prev) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.prev = prev;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	// BFS, Time O(n^2), Space O(n^2)
	public static int shortestPath(int[][] matrix) {

		// initialize the cells
		int row = matrix.length;
		int col = matrix[0].length;
		Station[][] hall = new Station[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] != 1) {
					// System.out.print(matrix[i][j]);
					hall[i][j] = new Station(i, j, Integer.MAX_VALUE, null);
				}

			}
			// System.out.println();
		}
		// System.out.println();
		// System.out.println();
		// for(int i = 0; i < hall.length; i++){
		// for(int j = 0; j<hall[i].length; j++){
		// if(hall[i][j] == null){
		// System.out.print(" null ");
		// } else {
		// System.out.print(hall[i][j].toString() + " ");
		// }
		// }
		// System.out.println();
		// }

		// breadth first search
		LinkedList<Station> queue = new LinkedList<>();
		Station src = hall[0][0];
		// System.out.println("null? " + src);
		// src = (0,0)
		src.dist = 1;
		queue.add(src);

		Station dest = null;
		Station path;

		while ((path = queue.poll()) != null) {
			// find destination
			// if at the end
			if (path.x == matrix.length - 1 && path.y == matrix[0].length - 1) {
				dest = path;
				break;
			}
			// moving up
			visit(hall, queue, path.x - 1, path.y, path);
			// moving down
			visit(hall, queue, path.x + 1, path.y, path);
			// moving left
			visit(hall, queue, path.x, path.y - 1, path);
			// moving right
			visit(hall, queue, path.x, path.y + 1, path);
		}

		// compose the path if path exists
		
			LinkedList<Station> pathList = new LinkedList<>();
			path = dest;
			do {
				pathList.addFirst(path);
			} while ((path = path.prev) != null);
			// System.out.println(pathList.size());
			return pathList.size();
		
	}

	private static void visit(Station[][] cells, LinkedList<Station> queue, int x, int y, Station parent) {
		// out of boundary
		if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
			return;
		}
		// update distance, and previous node
		int dist = parent.dist + 1;
		Station p = cells[x][y];
		if (dist < p.dist) {
			p.dist = dist;
			p.prev = parent;
			queue.add(p);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{ 1, 0, 0, 1 },
				{ 1, 1, 1, 0 },
				{ 0, 0, 1, 1 },
				{ 0, 0, 0, 9 }, };

		// case1, there is no path
		int[] start = { 0, 0 };
		int[] end = { 3, 3 };
		// System.out.println("case 1 shortest path: " + shortestPath(matrix, start,
		// end));
		int[][] matrix2 = {
				{ 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1 } };
		int[][] matrix3 = {
				{ 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0 } };

		// case 2, there is path
		int[] start1 = { 0, 0 };
		int[] end1 = { 5, 5 };
		// shortestPath(matrix3, start1, end1);
		// System.out.println(newMap(matrix3));
		// newMap(matrix2);
		int[][] matrix4 = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0 },
				{ 0, 1, 0 ,0, 0 },
				{ 0, 0, 0, 1, 0 },
				{ 1, 0, 0, 1, 0 }
		};
		System.out.println(newMap(matrix4));
	}

	public static ArrayList generateStation(int[][] matrix) {
		ArrayList<int[][]> matrixList = new ArrayList<>();
		// matrixList.add(matrix);
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == 1) {
					int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
					copy[row][col] = 0;
					matrixList.add(copy);
				}
			}
		}
		return matrixList;
	}

	public static int newMap(int[][] matrix) {
		ArrayList<int[][]> matrixList = new ArrayList<>();
		ArrayList<Integer> pathDistanceList = new ArrayList<>();

		matrixList = generateStation(matrix);

		for (int i = 0; i < matrixList.size() - 1; i++) {
			pathDistanceList.add(shortestPath(matrixList.get(i)));
		}

		int min = pathDistanceList.get(0);
		for (int i = 0; i < pathDistanceList.size(); i++) {
			if (pathDistanceList.get(i) < min) {
				min = pathDistanceList.get(i);
			}
		}
		return min;

	}
}
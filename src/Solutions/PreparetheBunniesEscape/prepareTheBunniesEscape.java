package Solutions.PreparetheBunniesEscape;

import java.util.LinkedList;


public class prepareTheBunniesEscape {

    static class Station implements Comparable<Station> {
        int x, y, dist;
        boolean passWall;

        public Station(int x, int y, int moves, boolean wentThroughWall) {
            this.x = x;
            this.y = y;
            this.dist = moves;
            this.passWall = wentThroughWall;
        }

        public int compareTo(Station other) {
            return dist - other.dist;
        }
    }

    public static int solution(int[][] map) {
        int ans = Integer.MAX_VALUE;
        int passWall = 0;
        int directionX[] = { 0, 0, -1, 1 };
        int directionY[] = { -1, 1, 0, 0 };
        LinkedList<Station> queue = new LinkedList<Station>();
        boolean visited[][][] = new boolean[map.length][map[0].length][2];

        queue.add(new Station(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Station path = queue.poll();
            // reached escape pod
            if (path.x == map.length - 1 && path.y == map[0].length - 1) {
                ans = Math.min(ans, path.dist);
            }

            if (visited[path.x][path.y][(path.passWall ? 0 : 1)]) {
                continue;
            }

            visited[path.x][path.y][(path.passWall ? 0 : 1)] = true;
            
            for (int i = 0; i < directionX.length; i++) {
                int x = path.x + directionX[i];
                int y = path.y + directionY[i];
                if (x < 0 || x >= map.length || y < 0 || y >= map[0].length
                        || (map[x][y] == 1 && path.passWall))
                    continue;

                if (map[x][y] == 1)
                    queue.add(new Station(x, y, path.dist + 1, true));
                else
                    queue.add(new Station(x, y, path.dist + 1, path.passWall));

            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix3 = {
                { 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0 } };
        int[][] test = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } };
        System.out.println(prepareTheBunniesEscape.solution(matrix3));

    }

}
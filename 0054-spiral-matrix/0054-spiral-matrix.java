class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        int x = 0, y = 0;
        while (true) {
            if (answer.size() == n * m) break;
            if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
                x -= dx[idx];
                y -= dy[idx];
                idx = (idx + 1) % 4;
            }
            if (!visited[x][y]) {
                answer.add(matrix[x][y]);
                visited[x][y] = true;
            }
            x += dx[idx];
            y += dy[idx];
        }
        return answer;
    }
}
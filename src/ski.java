import java.util.Scanner;

public class ski {
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        int[][] map = new int[row][column];
        int[][] drop = new int[row][column];
        int[][] path = new int[row][column];
        int max = 1;
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
            	map[i][j] = in.nextInt();
            	drop[i][j] = 0;
            	path[i][j] = 0;
            }
        }
        
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
            	max = Math.max(max, computePath(map, path, drop, i, j));
            }
        }
        System.out.println(max);
        System.out.print("\n");
/*        for(int[] i:path) {
        	for(int j: i)
        		System.out.print(j+" ");
    		System.out.print("\n");
<<<<<<< Upstream, based on 32
        }/*///


        
	}
	
	
	static int computePath(int[][] map, int[][] path, int[][]drop, int row ,int column) {
		if (path[row][column] != 0)
			return path[row][column];
		
		int max = 1;
		
		for (int[] dir : dirs) {
			int x = column + dir[0], y = row + dir[1];
			if (x < 0 || x >= map[0].length || y < 0 || y >= map.length || map[y][x] >= map[row][column])
				continue;
			int len = 1 + computePath(map, path, drop, y, x);
			max = Math.max(max, len);
		}
		path[row][column] = max;
		return path[row][column];
	}

}

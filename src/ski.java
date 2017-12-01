import java.util.Scanner;

public class ski {
	//used to search all 4 directions on a giving point
	public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int column = scan.nextInt();
        int[][] map = new int[row][column];
        int[][] drop = new int[row][column];
        int[][] path = new int[row][column];
        int maxPath = 1;
        int maxDrop = 0;
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
            	map[i][j] = scan.nextInt();
            	drop[i][j] = -1;
            	path[i][j] = 0;
            }
        }
        scan.close();
        
        //compute maxpath and maxdrop for all points
        for (int i = 0; i<row; i++) {
            for (int j = 0; j<column; j++) {
            	int tmp = computePath(map, path, drop, i, j);
            	//only update maxDrop if maxpath is updated
            	if (maxPath == tmp)
            		maxDrop = Math.max(drop[i][j],maxDrop);
            	else if (maxPath == tmp)
            		maxDrop = drop[i][j];
            	maxPath = Math.max(maxPath, tmp);
        
            }
         }
        
        System.out.println(maxPath);
        System.out.println(maxDrop);
        System.out.print("\n");
      
        /*for(int[] i:drop) {
        	for(int j: i)
        		System.out.print(j+" ");
    		System.out.print("\n");
        }
       for(int[] i:path) {
       	for(int j: i)
       		System.out.print(j+" ");
   		System.out.print("\n");
       }*///
        


	}
	
	
	static int computePath(int[][] map, int[][] path, int[][]drop, int row ,int column) {
		
		if (path[row][column] != 0) 
			return path[row][column];

		int maxPath = 1;
		int maxDrop = (drop[row][column]==-1)? 0:drop[row][column];
		
		for (int[] dir : dirs) {
			int x = column + dir[0], y = row + dir[1];
			if (x < 0 || x >= map[0].length || y < 0 || y >= map.length || map[y][x] >= map[row][column])
				continue;
			int len = 1 + computePath(map, path, drop, y, x);

			if (maxPath <= len) {
				maxDrop = Math.max(map[row][column]-map[y][x]+drop[y][x], maxDrop);
			}
			maxPath = Math.max(maxPath, len);
			
		}
		path[row][column] = maxPath;
		drop[row][column] = maxDrop;
		return path[row][column];
	}

}

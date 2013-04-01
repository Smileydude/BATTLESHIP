/**
 * 0 = water
 * 1 = ship
 * 2 = miss
 * 3 = hit
 * @author Tom
 *
 */
public class grid {
	public int[][]	grid;
	
	public grid(int size){
		grid = new int[size][size];
		
	}
	
	public void shoot(int x,int y){
		if (grid[x][y]==1){
			grid[x][y]=3;
		}
		else{
			grid[x][y]= 2;
		}
	}
	
	public void place(int x, int y){
		grid[x][y]= 1;
	}
		
}


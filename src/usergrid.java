/**
 * 0 = water
 * 1 = ship
 * 2 = miss
 * 3 = hit
 * @author Tom
 *
 */

public class usergrid {
	public int[][]	grid;
	public boolean turn;
	public boolean place;
	public int		count;
	
	public usergrid(int size){
		grid = new int[size][size];
		turn = true;
		place = true;
		count = 0;
		
	}
	
	public void input(int x, int y){
		if (turn==true && place==false){
			
		if (grid[x][y]==0){
			grid[x][y]=2;
			
			
			
		}
		if (grid[x][y]==1){
			grid[x][y]=3;
			
		}}
		if (turn==true && place == true ){
			if (grid[x][y]==0){
				grid[x][y]=1;
				count=count+1;
				if (count==14){
					place=false;
				}
				
			}
		}
		else{
			
		}
	}

	public int[][] getGrid(){
		return grid;
	}
	public boolean placeComplete(){
		return place;
	}
	
	
	


}


		




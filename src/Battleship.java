
import java.util.Random;

public class Battleship {
	
	
	//holds the grid for users
	String [][] User1=new String[5][5];
	int shipNum=0; //holds the number of ships currently placed
	int[] ships={1,2,3,4,5};//holds the different ship lengths
	boolean hit=false;//holds if AI got a hit.
	boolean hit2=false;//holds if AI got a second hit in a row
	int attempt=0; //holds the attempts made for a second hit (AI)
	int [] hitLocation=new int [2];//holds the initial hit location for AI
	int []hitDirection=new int [2];//holds the direction the AI should go
	Random generator=new Random();
	
	//places the ship piece into the players grid.
	//int x and y represent the position chosen for the ship, 
	//starting on one of the ship's end
	
	public void addShip(int x, int y, int shipType, boolean vertical)
	{	//if the ship is to be horizontal it tests if this a valid position.
		if(vertical==false)
		{
			//tests if the ship is in bounds of bounds
			if (x-ships[shipType]<0)
			{
				//places the ship into the grid
				for(int counter=0;counter<ships[shipType];counter++)
				{
				User1[x-counter][y]="ship";
				}
			}
			else
			{
				System.out.println("error, invalid selection");
			}
		}
		else// if the ship is vertical it does the same thing but for the y-coordinate
		{
			//tests if the ship is in bounds of bounds
			if (y-ships[shipType]<0)
			{
				//places the ship into the grid
				for(int counter=0;counter<ships[shipType];counter++)
				{
				User1[x][y-counter]="ship";
				}
			}
			else
			{
				System.out.println("error, invalid selection");
			}
		}
		
	}

	/**
	 * @param args
	 */
	//shoots at the target location
	public boolean shoot(int x, int y)
	{
		boolean hit=false;
		//sees if a ship is hit
		if(User1[x][y].equals("ship"))
		{
			User1[x][y]="hit";
			hit=true;
			
			if(checkSunk(x,y))
			{
				System.out.println("sunk");
				
				/*prlly put something like
				 * if (all sunk)
				 * player loses
				*/
			}
		}
		else
		{
			User1[x][y]="miss";
		}
		
		return hit;
	}
	
	//idk how to do this yet
	public boolean checkSunk(int x, int y)
	{
		boolean sunk=false;
		

		return sunk;
	}
	
	public void computerAI()
	{
		int x=0;
		int y=0;
		
		if(hit=false)
		{
		
		x=generator.nextInt(5);
		y=generator.nextInt(5);
		
		hit=shoot(x,y);
		
			if (hit)
			{
			hitLocation[0]=x;
			hitLocation[1]=y;
			}
		}
		else
		{
			if (checkSunk(hitLocation[0],hitLocation[1]))
			{
				hit=false;
				hit2=false;
			}
			else if(hit2=false)
			{
				
			if(attempt==0)
			{
			hit2=shoot(hitLocation[0]+1,hitLocation[1]);
			hitDirection[0]=1;
			hitDirection[1]=0;
			}
			else if(attempt==1)
			{
			hit2=shoot(hitLocation[0],hitLocation[1]+1);
			hitDirection[0]=1;
			hitDirection[1]=0;
			}

			else if(attempt==2)
			{
			hit2=shoot(hitLocation[0]-1,hitLocation[1]);
			hitDirection[0]=-1;
			hitDirection[1]=0;
			}

			else if(attempt==3)
			{
			hit2=shoot(hitLocation[0],hitLocation[1]-1);
			hitDirection[0]=0;
			hitDirection[1]=-1;
			}
			else
			{
			attempt=0;
			}
			
			}
			else if(hit2=true)
			{
				
				shoot(hitDirection[0],hitDirection[1]);
				hitDirection[0]=hitDirection[0]+hitDirection[0]%2;
				hitDirection[1]=hitDirection[1]+hitDirection[1]%2;
				
			}
		}
		
		
		
	}
}


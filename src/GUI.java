	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.*;


//state=true hit
//state=false miss

	class GUI extends JFrame implements ActionListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private     JSplitPane  splitPaneV;
		private     JSplitPane  splitPaneH;
		private     JPanel      Computer;
		private     JPanel      User;
		private     JPanel      Info;
		private 	int 		size = 11;
		private		JButton[][]		computerbuttons;
		private		JButton[][] 	userbuttons;
		private		String[]		letters = {"A","B","C","D","E","F","G","H","I","J"};
		private		ImageIcon		water = new ImageIcon("water1.jpg");
		private		ImageIcon		hit = new ImageIcon("hit.jpg");
		private		ImageIcon		miss = new ImageIcon("miss.jpg");
		private		ImageIcon		blank = new ImageIcon("blank.jpg");
		private		ImageIcon		ship = new ImageIcon("boat.jpg");	
		private		usergrid	ugrid= new usergrid(size);
		private		computergrid	cgrid = new computergrid(size);
		private 	JTextField		text= new JTextField("Place ships on top left grid");


		
		

		public GUI(){
		    setTitle( "BattleShip" );
		    setBackground( Color.gray );

		    JPanel leftPanel = new JPanel();
		    leftPanel.setLayout( new BorderLayout() );
		    getContentPane().add( leftPanel );

		    // Create the panels
		    createComputer();
		    createUser();
		    createInfo();

		    // Create a splitter pane
		    splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		    leftPanel.add( splitPaneH, BorderLayout.CENTER );
		    
		    splitPaneH.setRightComponent( User );
		    
		    splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
		    
		    splitPaneV.setLeftComponent( Computer );
		    splitPaneV.setRightComponent( Info);
		    
		    splitPaneH.setLeftComponent(splitPaneV);
		}

		public void createComputer(){
		    Computer = new JPanel();
		    Computer.setLayout( new GridLayout(size,size) );

		    computerbuttons= new JButton[size][size];
		    
		    //The top left square
		    computerbuttons[0][0] = new JButton(blank);
		    Computer.add(computerbuttons[0][0]);
		    
		    //The first row
		    for (int j=1; j<size; j++){
		    	int i=0;
		    	String str = "" + j;
		    	computerbuttons[i][j] = new JButton(str);
		    	Computer.add(computerbuttons[i][j]);
		    }

		    //The entire playing area
		    for (int i=1; i<size; i++){
		    	for (int j=0; j<size; j++){
		    		
		    		if (j==0){ //The left titles
		    			String title = letters[i-1];
		    			computerbuttons[i][j] = new JButton(title);
			    		Computer.add(computerbuttons[i][j]);
		    		}
		    		else{
		    		computerbuttons[i][j] = new JButton(water);
		    		
		    		Computer.add(computerbuttons[i][j]);
		    		
		    		computerbuttons[i][j].addActionListener(this);
		    	}}
		    }
		    

		}

		public void createUser(){
		    User = new JPanel();
		    User.setLayout( new GridLayout(size,size) );
		    //User.setPreferredSize(new Dimension(500,500));
		    //User.setMinimumSize(new Dimension(700,700));
		    //User.setSize(800, 800);
		    
		    userbuttons= new JButton[size][size];
		    
		    //The top left square
		    userbuttons[0][0] = new JButton(blank);
		    User.add(userbuttons[0][0]);
		    
		    //The first row
		    for (int j=1; j<size; j++){
		    	int i=0;
		    	String str = "" + j;
		    	userbuttons[i][j] = new JButton(str);
		    	User.add(userbuttons[i][j]);
		    }

		    //The entire playing area
		    for (int i=1; i<size; i++){
		    	for (int j=0; j<size; j++){
		    		
		    		if (j==0){ //The left titles
		    			String title = letters[i-1];
		    			userbuttons[i][j] = new JButton(title);
			    		User.add(userbuttons[i][j]);
		    		}
		    		else{
		    		userbuttons[i][j] = new JButton(water);
		    		userbuttons[i][j].addActionListener(this);
		    		User.add(userbuttons[i][j]);
		    	}}
		    }
		}

		public void createInfo(){
		    Info = new JPanel();
		    Info.setLayout( new BorderLayout() );
		    
		    
		    Info.add( new JLabel( "Directions" ), BorderLayout.NORTH );
		    Info.add( text, BorderLayout.CENTER );
		}
		
		/**
		 * Updates a JButton with a new image for either hit(true) or miss(false)
		 * @param y (coordinate A,B,C to 1,2,3 etc...)
		 * @param x	(coordinate 1,2,3 etc...)
		 * @param state (hit=true, miss=false)
		 */
		public void update(){
			int[][] usergrid = ugrid.getGrid();
			int[][] computergrid = cgrid.getGrid();
			for (int i = 0; i<size-1;i++){
				for (int j = 0; j<size-1;j++){
					if (usergrid[i][j]==0){
						userbuttons[i+1][j+1].setIcon(water);
					}
					if (usergrid[i][j]==1){
						userbuttons[i+1][j+1].setIcon(water);
					}
					if (usergrid[i][j]==2){
						userbuttons[i+1][j+1].setIcon(miss);
					}
					if (usergrid[i][j]==3){
						userbuttons[i+1][j+1].setIcon(hit);
					}
					if (computergrid[i][j]==0){
						computerbuttons[i+1][j+1].setIcon(water);
					}
					if (computergrid[i][j]==1){
						computerbuttons[i+1][j+1].setIcon(ship);
					}
					if (computergrid[i][j]==2){
						computerbuttons[i+1][j+1].setIcon(miss);
					}
					if (computergrid[i][j]==3){
						computerbuttons[i+1][j+1].setIcon(hit);
					}
				}
			}
			
			
			
				
			}			
		
		
		public void place(int x, int y){
			computerbuttons[x][y].setIcon(ship);
		}

		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 1; i<size; i++){
				for (int j = 1; j<size; j++){
					if (e.getSource()==computerbuttons[i][j]){
						cgrid.input(i-1, j-1);	
						this.update();
						break;
					}
					if (e.getSource()==userbuttons[i][j]){
						ugrid.input(i-1, j-1);
						this.update();
						break;
					}
					}
				}
		}
		
		
		
	
	}
		
		
				
			
	        
			
		

		
		

	
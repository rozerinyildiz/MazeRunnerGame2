package MazeGamee2;

public class Maze2 {
	private char[][] mazeTable;
    private int row;
    private int column;
    private int sizeofrow;
    private int sizeofcolumn;
    private int tempRow;
    private int tempCol;
    
    public Maze2() {
        row = 0; 
        column = 5;  
        sizeofrow = 10;
        sizeofcolumn = 12;
        mazeTable = new char[sizeofrow][sizeofcolumn];  
        fillMap(mazeTable);
      
    }
    
    private void fillMap(char[][] map) {
        for(int row2=0;row2<sizeofrow;row2++){
    		 for(int col2=0;col2<sizeofcolumn;col2++) {
    			 map[row2][col2] = '*';
    		 }
    	 }
    	 mazeTable[0][5] = 'S'; // start
    	 mazeTable[row+1][column] = ' ';
    	 mazeTable[row+2][column] = ' ';
    	 mazeTable[row+2][column+1] = ' ';
    	 mazeTable[row+2][column+2] = ' ';
    	 mazeTable[row+2][column+3] = ' ';
    	 mazeTable[row+3][column+3] = ' ';
    	 mazeTable[row+4][column+3] = ' ';
    	 mazeTable[row+5][column+3] = ' ';
    	 mazeTable[row+6][column+3] = ' ';
    	 mazeTable[row+6][column+4] = ' ';
    	 mazeTable[row+6][column+5] = ' ';
    	 mazeTable[row+7][column+5] = ' ';
    	 mazeTable[row+8][column+5] = ' ';
    	 mazeTable[row+9][column+5] = 'F'; // finish
    	 
    	 }
    
    public void printMap() {
        printMap(mazeTable);
    }

    private void printMap(char[][] map) {
        for (int i = 0; i < sizeofrow; i++) {
            for (int j = 0; j < sizeofcolumn; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
   private boolean canMove(int rowMove, int colMove) {
	   int newrow = row + rowMove;
	   int newcolumn = column + colMove;
        if (newcolumn > sizeofcolumn || newcolumn < 0 ||
            newrow > sizeofrow || newrow < 0) {
            return false;
        }else if (mazeTable[newrow][newcolumn] == 'F') { // chNGED
        	tempRow = newrow;
        	tempCol = newcolumn;
        	return areYouWin();
        }else if(mazeTable[newrow][newcolumn] == ' ') {
        	return true;
        }else {
        	return false;
        }
    }
    
    public boolean areYouWin() {
        if (tempRow == 9 && tempCol == 10) {
            return true;
        }else {
            return false;
        }
    }
    
    public boolean canIMoveRight() {
        return canMove(0,1);
    }

    public boolean canIMoveLeft() {
        return canMove(0,-1);
    }

    public boolean canIMoveUp() {
        return canMove(-1,0);
    }

    public boolean canIMoveDown() {
        return canMove(1,0);
    }
    
    private void move(int rowMove, int colMove) {
        
    	if(canMove(rowMove, colMove)) {
            
        	mazeTable[row][column] = ' ';
            row += rowMove;
            column += colMove;
            mazeTable[row][column] = 'S';
         } if(mazeTable[row][column] == '*') { 
            throw new IllegalArgumentException("ERROR: You cannot move that way");
        }
       
    }
    
    public void moveRight() {
        move(0, 1);
    }

    public void moveLeft() {
        move(0, -1);
    }

    public void moveUp() {
        move(-1, 0);
    }

    public void moveDown() {
        move(1, 0);
    }
}

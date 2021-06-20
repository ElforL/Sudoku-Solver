import java.awt.Color;

public class Sudoku {
	public static int[][] board = new int[9][9];
	static GUI2 frame ;

	public static void main(String[] args) {
		frame = new GUI2();

	}


	// checks if the values entered by user is makes a valid board
	// e.g no duplicates in a row, column, or subgroup
	static boolean isBoardValid() {
		//array to mark visited numbers
		boolean[] valid = new boolean[board[0].length];

		//check rows
		for(int i=0; i < board.length;i++) {
			//reset the array
			for (int j = 0; j < valid.length; j++) 
				valid[j] = false;

			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0)
					continue;
				else if(valid[board[i][j]-1]) {
					return false;
				}else if(!valid[board[i][j]-1]){
					valid[board[i][j]-1] = true;
				}
			}
		}

		//check columns
		for(int i=0; i < board.length;i++) {
			//reset the array
			for (int j = 0; j < valid.length; j++)
				valid[j] = false;

			for(int j = 0; j < board[i].length; j++) {
				if(board[j][i] == 0)
					continue;
				else if(valid[board[j][i]-1]) {
					return false;
				}else if(!valid[board[j][i]-1]){
					valid[board[j][i]-1] = true;
				}
			}
		}

		//check Subgroups
		for (int row = 0; row < board.length; row += 3) {
			for (int clm = 0; clm < board[row].length; clm += 3) {
				//reset the array
				for (int j = 0; j < valid.length; j++)
					valid[j] = false;

				for(int i = 0; i < 9; i++){
					if(board[i/3 + row][i%3 + clm] == 0) {
						continue;
					}else if(valid[board[i/3 + row][i%3 + clm]-1]) {
						return false;
					}else if(!valid[board[i/3 + row][i%3 + clm]-1]) {
						valid[board[i/3 + row][i%3 + clm]-1] = true;
					}
				}
			}
		}

		return true;
	}

	//reads the board from the JTable
	static void readBoard() throws InvalidException{
		for(int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if(frame.table[i][j].getText().equals(""))
					board[i][j] = 0;

				//invalid input
				else if(Integer.parseInt(frame.table[i][j].getText()) >= 10 || Integer.parseInt(frame.table[i][j].getText()) <= 0) {
					frame.invalidExceptionLabel.setText("invalid input in row:"+(i+1)+" column:"+(j+1));
					throw new InvalidException("ERR1| invalid input in row:"+(i+1)+" column:"+(j+1)); //ERROR 001

				}else {
					board[i][j] = Integer.parseInt(frame.table[i][j].getText());
					frame.table[i][j].setForeground(Color.red);
				}
			}
		}

		if(!isBoardValid()) {
			frame.invalidExceptionLabel.setText("invalid board duplicates in a row, column, or a subgroup");
			throw new InvalidException("ERR2| invalid board: duplicates in a row, column, or a subgroup"); //ERROR 002
		}
	}


	static void solve() {
		emptyBoard();
		try {
			readBoard();
			solveBoard();
			frame.loadNums(board);
			System.out.println("Solved");
		}catch(InvalidException ex) {
			System.out.println(ex.getMessage());
		}


	}

	//sets board to all 0s
	static void emptyBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 0;
			}
		}
	}
	

	//recursive solve method
	static boolean solveBoard() {
		int row,clm;
		int[] found = findEmpty();
		

		// base case
		// if no empty slot is found then the board is solved
		if(found[0] == -1)
			return true;
		else {
			row = found[0];
			clm = found[1];
		}

		for(int i = 1; i <= 9; i++) {
			if(checkNum(i,row,clm)) {
				board[row][clm] = i;

				if(solveBoard())
					return true;

				board[row][clm] = 0;
			}
		}
		return false;
	}

	//find an empty slot and return the row and column
	static int[] findEmpty() {
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(board[i][j] == 0)
					return new int[] {i, j};
			}
		}
		return new int[] {-1,-1};
	}

	//checks if a number is valid in a certain row and column
	static boolean checkNum(int n, int row, int clm) {

		//row
		for(int i = 0; i < board[row].length; i++) {
			if(board[row][i] == n && i != clm) {
				return false;
			}
		}

		//column
		for(int i = 0; i < board.length; i++) {
			if(board[i][clm] == n && i != row) {
				return false;
			}
		}

		//subgroup
		int first_row = ((row / 3)) * 3;
		int first_clm = ((clm / 3)) * 3;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if((first_row+i) == row && (first_clm+j) == clm){
					continue;
				}else if(board[first_row+i][first_clm+j] == n){
					return false;
				}
			}
		}

		return true;
	}

	@SuppressWarnings("serial")
	public static class InvalidException extends Exception
	{
		public InvalidException(String message)
		{
			super(message);
		}
	}

}

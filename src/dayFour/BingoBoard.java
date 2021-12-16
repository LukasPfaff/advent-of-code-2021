package dayFour;

import java.util.ArrayList;

public class BingoBoard {
	BingoField[][] board = new BingoField[5][5];

	public BingoBoard(ArrayList<Integer> list) {
		int k = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = new BingoField(list.get(k));
				k++;
			}
		}
	}
	
	public BingoBoard (BingoBoard b){
		this.board = b.board.clone();
	}

	public void contains(int i) {
		Boolean contains = false;
		for (BingoField[] fields : this.board) {
			for (BingoField field : fields) {
				if (field.getNumber() == i) {
					field.mark();
					contains = true;
					break;
				}
			}
			if (contains){
				break;
			}
		}
	}

	public Boolean hasWon() {
		Boolean won = false;
		Boolean[] horizontal = new Boolean[5];
		Boolean[] vertikal = new Boolean[5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				horizontal[j] = board[i][j].getMarked();
				vertikal[j] = board[j][i].getMarked();
			}
			for (Boolean b : horizontal) {
				if (!b) {
					won = false;
					break;
				} else {
					won = true;
				}
			}
			if (!won) {
				for (Boolean b : vertikal) {
					if (!b) {
						won = false;
						break;
					} else {
						won = true;
					}
				}
			}
			if(won){
				break;
			}
		}
		return won;
	}
	
	public int sumOfUnmarked(){
		int result = 0;
		for (BingoField[] fields : this.board) {
			for (BingoField field : fields) {
				if(!field.getMarked()){
					result += field.getNumber();
				}
			}
		}
		return result;
	}
}

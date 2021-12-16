package dayFour;

public class BingoField {
	private int number;
	private Boolean marked;
	
	public BingoField(int i){
		this.number = i;
		this.marked = false;
	}
	
	/**
	 * mark this field
	 */
	public void mark(){
		this.marked = true;
	}
	
	/**
	 * get the number in the field
	 * @return
	 */
	public int getNumber(){
		return this.number;
	}
	
	/**
	 * get the marked status of the field
	 * @return
	 */
	public Boolean getMarked(){
		return this.marked;
	}
}

package algorithms.maxsubarray;


public class ValueHolder {
	private int low;
	private int high;
	private int sum;
	
	ValueHolder(int low, int high, int sum) {
		this.low = low;
		this.high = high;
		this.sum = sum;
	}
	
	public int getLow() /*to the windows... to the wall*/ {
		return this.low;
	}
	
	public int getHigh() /*on no arguments supplied*/ {
		return this.high;
	}
	
	public int getSum /*haha, I swear I'll stop here*/ () {
		return this.sum;
	}
}
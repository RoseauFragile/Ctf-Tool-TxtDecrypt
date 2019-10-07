package model.tools;

public class CharOccurence implements Comparable<CharOccurence>{
	private char ch;
	private int count;
	private char decoded;
	public CharOccurence(char ch, int count) {
		this.setCh(ch);
		this.setCount(count);
	}
	@Override
	public String toString() {
		return new String("Number of occurence of " + this.getCh() + " is :" +this.getCount());
	}
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int compareTo(CharOccurence ch) {
        int compareSize = ch.getCount();
        return Integer.compare(compareSize,this.getCount());
	}
	public char getDecoded() {
		return decoded;
	}
	public void setDecoded(char decoded) {
		this.decoded = decoded;
	}
}

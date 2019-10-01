package model.crack;

public abstract class Crack {
	private int KEY_SIZE = 12;
	private byte [] input;
	private String cypherText;
	private String Key;
    
	public Crack(String cyphertext) {
		this.setCypherText(cyphertext);
	}

	public byte[] getInput() {
		return input;
	}

	public void setInput(byte[] input) {
		this.input = input;
	}

	public String getCypherText() {
		return cypherText;
	}

	public void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public int getKEY_SIZE() {
		return KEY_SIZE;
	}

	public void setKEY_SIZE(int kEY_SIZE) {
		KEY_SIZE = kEY_SIZE;
	}
} 
 
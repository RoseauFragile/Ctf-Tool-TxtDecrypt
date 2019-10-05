package model.tools;

import java.util.ArrayList;

public class Block {
	private ArrayList<Integer> list;
	public int lenght;
	private ArrayList<Score> listScore;
	private char bestScoreChar;
	private byte[] entirebytes;
	
	public Block(byte[] bytes, int lenght) {
		this.setEntirebytes(bytes);
		this.lenght = lenght;
		this.setList(bytes);
		this.listScore = new ArrayList<Score>();
	}
	
	public Block(ArrayList<Integer> index, int size) {
		this.lenght = size;
		this.setList(index);
		this.listScore = new ArrayList<Score>();
	}

	private void setList(byte[] bytes) {
		this.list = new ArrayList<Integer>();
		for(int i = 0; i < this.lenght; i++) {
			this.list.add((int) bytes[i]);
		}
	}
	
	public void showList() {
		System.out.println();
		for (int i = 0;i<this.list.size();i++){
			System.out.print(this.list.get(i).toString());
		}
		System.out.println();
	}
	
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}
	
	public ArrayList<Integer> getList() {
		return this.list;
	}

	public void addScore(Score score) {
		this.listScore.add(score);
	}
	
	public char getBestScoreKeyChar() {
		ArrayList<Double> keyScores= new ArrayList<Double>();
		ArrayList<String> keys = new ArrayList<String>();
		int index = 0;
		
		for(Score score : this.listScore) {
			keyScores.add(score.getScore());
			String s = String.valueOf(score.getLetter());
			keys.add(s);
		}
		
		double max = keyScores.get(0);

		for (int i = 0; i < keyScores.size(); i++) 
		{
			if (max < keyScores.get(i)) 
			{
				max = keyScores.get(i);
				index = i;
			}
		}
		this.bestScoreChar = (keys.get(index)).charAt(0);
		return this.bestScoreChar;
	}

	public byte[] getEntirebytes() {
		return entirebytes;
	}

	public void setEntirebytes(byte[] entirebytes) {
		this.entirebytes = entirebytes;
	}
}
package model.crack;

public class Score {
	private char letter;
	private double score;
	
	public Score(char letter,double score) {
		this.setLetter(letter);
		this.setScore(score);
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}

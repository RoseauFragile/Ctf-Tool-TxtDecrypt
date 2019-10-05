package model.tools;

public class KeySizeHammingDistance implements Comparable<KeySizeHammingDistance> {
	private int keySize;
	private float score;
	
	public KeySizeHammingDistance(int keySize, float score) {
		this.setKeySize(keySize);
		this.setScore(score);
	}
	
	public int getKeySize() {
		return keySize;
	}
	private void setKeySize(int keySize) {
		this.keySize = keySize;
	}
	public float getScore() {
		return score;
	}
	private void setScore(float score) {
		this.score = score;
	}

	public int compareTo(KeySizeHammingDistance key) {
        float compareSize = key.getScore();
        return Float.compare(this.getScore(),compareSize);
	}
	
    @Override
    public String toString() {
        return "[ KeySize=" + this.getKeySize() + ", Score=" + this.getScore()+"]";
    }
	
}

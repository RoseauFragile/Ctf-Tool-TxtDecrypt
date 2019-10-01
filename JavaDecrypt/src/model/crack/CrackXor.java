package model.crack;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import model.CLctrlCrypt;

public class CrackXor extends Crack {

    ArrayList<Block> textBlocks;
    ArrayList<Block> transposedBlocks;
	
	public CrackXor(String cyphertext) throws UnsupportedEncodingException {
		super(cyphertext);
		this.crackXor();
	}
	
	private void crackXor() {
		try {
			this.refactoreCypherText();
		} catch (UnsupportedEncodingException e) {
			System.out.println("Erreur dans le formatage du fichier chiffre");
			e.printStackTrace();
		}
		this.scoreEachBlock();
		this.recomposeKey();
	}
	
	private void refactoreCypherText() throws UnsupportedEncodingException {
        this.setInput(this.getCypherText().getBytes("UTF-8"));
        this.textBlocks = ToolsRefacto.parseCypherTextToBlock(this.getCypherText());
        this.transposedBlocks = ToolsRefacto.transposeAllBlocksByIndex(this.textBlocks);
	}
	
	private double scoreDecryptedBytes(String decryption) {
		return this.freqScoreString(decryption);
	}
	
	private double freqScoreString(String lettres) {
		double score = 0;
		String letters = lettres.toLowerCase();
		for(int i =0; i < letters.length();i ++) {
			score = score + ToolsCrack.getScoreLetter(letters.charAt(i));
		}
		return score;
	}
	
	private void scoreEachBlock() {
		final byte[] output = new byte[12];
		final byte[] output1 = new byte[12];
		for(Block block : this.transposedBlocks) {
			for(int key = 0; key < 256; key++) {
				output1[0] = (byte) key;
				double scored = 0;
				for (int byteIndex = 0; byteIndex < block.getList().size(); byteIndex++) {
					output[0] = block.getList().get(byteIndex).byteValue();
					String xored = CLctrlCrypt.encode_using_xor(output,output1);
					scored = scored + this.scoreDecryptedBytes(xored);
				}
				block.addScore(new Score((char) key, scored));
			}
		}
	}
	
	private void recomposeKey() {
		System.out.print("Recomposition de la cle : ");
		String key = "";
		for(Block block : this.transposedBlocks) {
			key = key + block.getBestScoreKeyChar();
		}
		key = key.toLowerCase();
		System.out.println(key);
		System.out.println("FIN DE LA CLE");
		this.setKey(key);
	}

}

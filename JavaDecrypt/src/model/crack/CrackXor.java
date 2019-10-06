package model.crack;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

import model.Model;
import model.tools.Block;
import model.tools.KeySizeHammingDistance;
import model.tools.Score;
import model.tools.ToolsCrack;
import model.tools.ToolsRefacto;

public class CrackXor extends Crack {

    ArrayList<Block> textBlocks;
    ArrayList<Block> transposedBlocks;
    private static int KEYSIZE_MIN = 2;
    private static int KEYSIZE_MAX = 40 ;
    private int keySizeGuessed;
    private int[] fiveFirstIntKeys;

	public CrackXor(String cyphertext, int language, Model model) throws UnsupportedEncodingException {
		super(cyphertext, language, model);
		this.crackXor();
	}
	
	private void crackXor() {
		this.setFiveFirstIntKeys(this.guessTheKeySize());
		this.setFiveFirstkeys();
		
		for(int i = 0 ; i< 5;i++) {
			this.keySizeGuessed = this.getFiveFirstIntKeys()[i];
			try {
				this.refactoreCypherText();
			} catch (UnsupportedEncodingException e) {
				System.out.println("Erreur dans le formatage du fichier chiffre");
				e.printStackTrace();
			}
			this.scoreEachBlock();
			this.recomposeKey();
			this.getFiveFirstkeys()[i]= this.getKey();
		}
		
		System.out.println("Most probable keys : ");
		for(int i = 0; i<this.getFiveFirstkeys().length;i++) {
			System.out.println(this.getFiveFirstkeys()[i]);
		}
		
		this.keySizeGuessed = this.guessTheKeySize()[0];
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
        this.textBlocks = ToolsRefacto.parseCypherTextToBlock(this.getCypherText(), this.keySizeGuessed);
        this.transposedBlocks = ToolsRefacto.transposeAllBlocksByIndex(this.textBlocks, this.keySizeGuessed);
	}
	
	private double scoreDecryptedBytes(String decryption) {
		return this.freqScoreString(decryption);
	}
	
	private double freqScoreString(String lettres) {
		double score = 0;
		String letters = lettres.toLowerCase();
		for(int i =0; i < letters.length();i ++) {
			if(this.getLanguage() == 1) {
				score = score + ToolsCrack.getScoreLetterEnglish(letters.charAt(i));
			}else {
				score = score + ToolsCrack.getScoreLetterFrench(letters.charAt(i));
			}
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
					String xored = this.encode_using_xor(output,output1);
					scored = scored + this.scoreDecryptedBytes(xored);
				}
				block.addScore(new Score((char) key, scored));
			}
		}
	}
	
	private void recomposeKey() {
		String key = "";
		for(Block block : this.transposedBlocks) {
			key = key + block.getBestScoreKeyChar();
		}
		key = key.toLowerCase();
		this.setKey(key);
	}
	
	public String encode_using_xor(final byte[] input, final byte[] secret) {
        final byte[] output = new byte[input.length];
        if (secret.length == 0) {
            throw new IllegalArgumentException("empty security key");
        }
        int spos = 0;
        for (int pos = 0; pos < input.length; ++pos) {
            output[pos] = (byte) (input[pos] ^ secret[spos]);
            ++spos;
            if (spos >= secret.length) {
                spos = 0;
            }
        }
        return new String(output);
    }
	
	public String decode_operation(String s,final byte[] key){
		int spos = 0;
		try{
			byte [] output=s.getBytes();
        for (int pos = 0; pos < output.length; ++pos) {
            output[pos] = (byte) (output[pos] ^ key[spos]);
            ++spos;
            if (spos >= key.length) {
                spos = 0;
            }
        }
        return new String(output, "UTF-8");
        }catch(Exception e){	
        }
		return null;
	}
	
	private int[] guessTheKeySize() {
		int[] keysGuessing = new int[5];
		ArrayList<KeySizeHammingDistance> keys = new ArrayList<KeySizeHammingDistance>();
		for(int i = KEYSIZE_MIN; i <= KEYSIZE_MAX; i++) {
			ArrayList<Block> blocks = ToolsRefacto.parseCypherTextToBlock(this.getCypherText(), i);
			int blocksSize = blocks.size() -1;			
			float list[] = new float[blocksSize];
			for(int j = 0; j < blocksSize -1 ;j++){
				Block block1 = blocks.get(j);
				Block block2 = blocks.get(j+1);
				int hammingDistance = ToolsCrack.hammingDist(block1.getEntirebytes(), block2.getEntirebytes());
				float distance = (float) hammingDistance/ (float) i;
				list[j] = distance;
			}
			float sumList =0;
			for(int k = 0; k < list.length; k++) {
				sumList = sumList + list[k];
			}
			float distanceAverage = sumList / blocksSize;			
			keys.add(new KeySizeHammingDistance(i, distanceAverage));			
		}
	   Collections.sort(keys);
	   for(int i = 0; i < 5; i++){
		   keysGuessing[i] = keys.get(i).getKeySize();
	   }
		return keysGuessing;
	}

	public int[] getFiveFirstIntKeys() {
		return fiveFirstIntKeys;
	}

	public void setFiveFirstIntKeys(int[] fiveFirstIntKeys) {
		this.fiveFirstIntKeys = fiveFirstIntKeys;
	}
}


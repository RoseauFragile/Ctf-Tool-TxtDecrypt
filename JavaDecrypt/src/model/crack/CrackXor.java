package model.crack;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class CrackXor extends Crack {

    ArrayList<Block> textBlocks;
    ArrayList<Block> transposedBlocks;
    private static int KEYSIZE_MIN = 2;
    private static int KEYSIZE_MAX = 42;
   // private static int KEYSIZE = 12;
    private int keyGuessed;

	public CrackXor(String cyphertext) throws UnsupportedEncodingException {
		super(cyphertext);
		this.crackXor();
	}
	
	private void crackXor() {
		this.keyGuessed = this.guessTheKey();
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
        this.textBlocks = ToolsRefacto.parseCypherTextToBlock(this.getCypherText(), this.keyGuessed);
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
	
	private int guessTheKey() {
		List<Integer> keys = new ArrayList<Integer>(); 
		for(int i = KEYSIZE_MIN; i <= KEYSIZE_MAX; i++) {
			ArrayList<Block> blocks = ToolsRefacto.parseCypherTextToBlock(this.getCypherText(), i);
			Block block1 = blocks.get(0);
			Block block2 = blocks.get(1);
			block1.showList();
			block2.showList();
			System.out.println("Taille de list block1 : " + block1.getList().size());
			System.out.println("Taille de list block2 : " + block2.getList().size());
			System.out.println("Nombre de blocs : " + blocks.size() + " hamming : "+this.hammingDist(block1.getEntirebytes(), block2.getEntirebytes()));
			keys.add(i);
		}
		return 12;
	}
	
	private int hammingDist(byte[] bs, byte[] bs2) 
	{ 
	    int hammingDist = 0;

        for (int pos = 0; pos < bs.length; ++pos) {
        	hammingDist = hammingDist + this.d(bs[pos],bs2[pos]);
        }
	    return hammingDist;
	}
	
    public int d(byte x, byte y) {
        return d((int)x, (int)y);
    }
	
    public int d(int x, int y) {
        int dist = 0;
        int val = x ^ y;
        while (val != 0) {
            ++dist;
            val &= val - 1;
        }
        return dist;
    }
}


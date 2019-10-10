package model.crack;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

import model.Model;
import model.tools.CharOccurence;
import model.tools.ToolsRefacto;

public class CrackCaesar extends Crack {
	public CrackCaesar(String cyphertext, int language, Model model) throws UnsupportedEncodingException {
		super(cyphertext, language, model);
		this.crackCaesar();
	}

	private void crackCaesar() {
		this.setCypherText(this.getCypherText().replaceAll("\\s",""));
		ArrayList<CharOccurence> list =ToolsRefacto.getOccuringChar(this.getCypherText());
		Collections.sort(list);
		this.setClearText(this.decrypt(this.getCypherText(), list));
	}
	
	private String decrypt(String cypherText, ArrayList<CharOccurence> list) {
		String toDecode = cypherText;
		int position = 0;
		int decal = 0;
		String input = ("" + list.get(0).getCh()).toLowerCase();	
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int ePos = alphabet.indexOf("e")+1;
		for(int i=0; i < input.length(); i++){
		    position = alphabet.indexOf(input.charAt(i))+1;
		}
		decal = position - ePos;
		for(CharOccurence ch : list) {
			String input2 =(""+ ch.getCh()).toLowerCase();
			int position2 = 0;
			for(int i=0; i < input.length(); i++){
			    position2 = alphabet.indexOf(input2.charAt(i))+1;
			}
			if((position2 - (decal +1)) < 0) {
				int test = 26 + (position2 - (decal +1));
				ch.setDecoded(alphabet.charAt(test));
			}else {
				ch.setDecoded(alphabet.charAt(position2 - (decal +1)));
			}
			toDecode = toDecode.replace(ch.getCh(), ch.getDecoded());
		}
	return toDecode;
	}
}
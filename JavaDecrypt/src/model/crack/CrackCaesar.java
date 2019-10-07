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
		String test = "Pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.";
		ArrayList<CharOccurence> list =ToolsRefacto.getOccuringChar(test);
		Collections.sort(list);
		System.out.println(list);
		System.out.println("decoded : " +this.replaceChar(test, list));
	}
	
	//TODO replace
	private String replaceChar(String cypherText, ArrayList<CharOccurence> list) {
			String toDecode = cypherText;
			for(int i =0; i <list.size(); i++) {
				if(i == 0) {
					list.get(i).setDecoded(' ');
				}else if(i == 1){
					list.get(i).setDecoded('e');
				}else if(i == 2){
					list.get(i).setDecoded('a');
				}
			}
			for(CharOccurence ch : list) {
				System.out.println("Replace : " + ch.getCh() + " with : " + ch.getDecoded());
				toDecode.replace(ch.getCh(), ch.getDecoded());
			}
		return toDecode;
	}
}

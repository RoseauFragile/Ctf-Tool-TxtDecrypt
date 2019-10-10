package model.crack;

import java.util.Base64;
import model.Model;

public abstract class Crack {
	private int KEY_SIZE = 12;
	private String cypherText;
	private String Key;
	private int language;
	private Model model;
	private String[] fiveFirstkeys;
	private String clearText;
    
	public Crack(String cyphertext, int language, Model model) {
		this.setLanguage(language);
		this.setModel(model);
		if(this.getModel().isBase64()) {
			byte [] barr = Base64.getDecoder().decode(cyphertext); 
			String string = new String(barr);
			this.setCypherText(string);
		}else {
			this.setCypherText(cyphertext);
		}
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

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String[] getFiveFirstkeys() {
		return fiveFirstkeys;
	}

	public void setFiveFirstkeys() {
		this.fiveFirstkeys = new String[5];
	}

	public String getClearText() {
		return clearText;
	}

	public void setClearText(String clearText) {
		this.clearText = clearText;
	}
} 
 
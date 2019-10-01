package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.crack.CrackXor;

public class Model {
	private String path;
 	private String keyLength;
 	private CrackXor crackXor;
 	private String cypherText;
 	private String clearText;
 	private String key;
 
 	public Model(String path, String keyLength) {
 		this.path = path;
 		this.keyLength = keyLength;
 	}
 	
	public void setCrack() throws IOException {
		String fileName = this.getPath();
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
		this.setCypherText(content);
		this.setCrackXor(new CrackXor(this.getCypherText()));
		if(this.key!= null) {
			this.setClearText(this.getCrackXor().decode_operation(content, this.key.getBytes()));
		}else {
			this.setClearText(this.getCrackXor().decode_operation(content, this.crackXor.getKey().getBytes()));	
		}
	}
 
 	public String getPath() {
 		return path;
 	}
 
 	public void setPath(String path) {
 		this.path = path;
 	}
 
 	public String getKeyLength() {
 		return keyLength;
 	}
 
 	public void setKeyLength(String keyLength) {
 		this.keyLength = keyLength;
 	}

	public CrackXor getCrackXor() {
		return crackXor;
	}

	public String getCypherText() {
		return cypherText;
	}

	public void setCypherText(String cypherText) {
		this.cypherText = cypherText;
	}

	public String getClearText() {
		return clearText;
	}

	public void setClearText(String clearText) {
		this.clearText = clearText;
	}

	public void saveKey() {
		key = this.crackXor.getKey();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setCrackXor(CrackXor crackXor) {
		this.crackXor = crackXor;
	}
}
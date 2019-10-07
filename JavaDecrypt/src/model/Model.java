package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JOptionPane;

import model.crack.CrackCaesar;
import model.crack.CrackXor;
import model.tools.ToolsRefacto;

public class Model {
	private String path;
 	private CrackXor crackXor;
 	private CrackCaesar crackCaesar;
 	private String cypherText;
 	private String clearText;
 	private String key;
	private int language;
	private boolean isBase64;
	
 	public Model(){

 	}
 	
 	private void initCrack(String path) throws IOException {
		this.setPath(path);
		this.setCypherText();
		this.setBase64(ToolsRefacto.isBase64(this.getCypherText()));
 	}
 	
	public void setCrackCaesar(String path) throws IOException{
		this.initCrack(path);
		this.setCrackCaesar(new CrackCaesar(this.getCypherText(),this.getLanguage(),this));
	}

	public void setCrackXor(String path) throws IOException{
		this.initCrack(path);
		this.setCrackXor(new CrackXor(this.getCypherText(),this.getLanguage(),this));
		if(this.key!= null) {
			this.setClearText(this.getCrackXor().decode_operation(this.getCypherText(), this.key.getBytes()));
		}else {
			this.setClearText(this.getCrackXor().decode_operation(this.getCypherText(), this.crackXor.getKey().getBytes()));	
		}
	}
	
	private void setCypherText() throws IOException {
        String content ="";
        try {
    		String fileName = this.getPath();
    		List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    		StringBuilder sb = new StringBuilder();
    		for (int i =0; i < lines.size(); i++) {
    			sb.append(lines.get(i)); 
    			}
    		String fromFile = sb.toString();
    		content = fromFile;
        }
        catch(Exception e) {
            try{
            	content = new String(Files.readAllBytes(Paths.get(this.getPath())), StandardCharsets.UTF_8);
            }catch(Exception f) {
				JOptionPane.showMessageDialog(null,"Choose a valid file", "File not found", JOptionPane.ERROR_MESSAGE);
            }
        }
		this.setCypherText(content);
	}
 
 	public String getPath() {
 		return path;
 	}
 
 	public void setPath(String path) {
 		this.path = path;
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

	public void setLanguage(int language) {
		this.language = language;
	}
	
	public int getLanguage() {
		return this.language;
	}

	public boolean isBase64() {
		return isBase64;
	}

	public void setBase64(boolean isBase64) {
		this.isBase64 = isBase64;
	}

	public CrackCaesar getCrackCaesar() {
		return crackCaesar;
	}

	public void setCrackCaesar(CrackCaesar crackCaesar) {
		this.crackCaesar = crackCaesar;
	}
}
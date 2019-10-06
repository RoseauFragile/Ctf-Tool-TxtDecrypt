package model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.crack.CrackXor;
import model.tools.ToolsRefacto;

public class Model {
	private String path;
 	private CrackXor crackXor;
 	private String cypherText;
 	private String clearText;
 	private String key;
	private int language;
	private boolean isBase64;
	
 	public Model(){

 	}

	public void setCrack(String path) throws IOException{
		this.setPath(path);
		this.setCypherText();
		this.setBase64(ToolsRefacto.isBase64(this.getCypherText()));
		this.setCrackXor(new CrackXor(this.getCypherText(),this.getLanguage(),this));
		if(this.key!= null) {
			this.setClearText(this.getCrackXor().decode_operation(this.getCypherText(), this.key.getBytes()));
		}else {
			this.setClearText(this.getCrackXor().decode_operation(this.getCypherText(), this.crackXor.getKey().getBytes()));	
		}
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
	
	private void setCypherText() throws IOException {
        String content;
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
            content = new String(Files.readAllBytes(Paths.get(this.getPath())), StandardCharsets.UTF_8);
        }
		this.setCypherText(content);
	}
}
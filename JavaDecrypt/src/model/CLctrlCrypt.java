package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CLctrlCrypt {
	public CLctrlCrypt() {
	      
	}
	
	public static void ecrireUnFichier(String path, String texte) {
		File file = new File(path);
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(texte);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Erreur lors de l'écriture du fichier");
			e.printStackTrace();
		}
	}
	
	public String lireFichierSimple(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return sb.toString();
	}
	
	public static String encode_using_xor(final byte[] input, final byte[] secret) {
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
}

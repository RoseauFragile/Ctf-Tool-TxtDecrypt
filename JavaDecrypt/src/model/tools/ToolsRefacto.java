package model.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ToolsRefacto {
	
	public static String convertStringToBinary(String s) {
	      byte[] bytes = s.getBytes();
	      StringBuilder binary = new StringBuilder();
	      for (byte b : bytes)
	      {
	         int val = b;
	         for (int i = 0; i < 8; i++)
	         {
	            binary.append((val & 128) == 0 ? 0 : 1);
	            val <<= 1;
	         }
	      }
	      System.out.println("'" + s + "' to binary: " + binary);
	      return binary.toString();
	}
		
	public static ArrayList<Block> transposeAllBlocksByIndex(ArrayList<Block> blocks, int keySizeGuessed){
		ArrayList<Block> blockss = new ArrayList<Block>();
		ArrayList<ArrayList<Integer>> indexs = new ArrayList<ArrayList<Integer>>(); 
		for(int i =0; i < keySizeGuessed;i++) {
			indexs.add(new ArrayList<Integer>());
		}
		
		for(Block block : blocks) {
			ArrayList<Integer> list = block.getList();
			for(int i =0; i < list.size(); i++) {
					indexs.get(i).add(list.get(i));
				}
			}
		
		for(ArrayList<Integer> integ : indexs) {
			blockss.add(new Block(integ,integ.size()));
		}
		return blockss;
	}
	
	public static ArrayList<Block> parseCypherTextToBlock(String cyphertext,int keySize) {
		byte[] bytesOfText;
		byte[] bytesOfCurrentBlock = new byte[keySize];
		
		ArrayList<Block> blocks = new ArrayList<Block>();
		bytesOfText = cyphertext.getBytes();
		int count = 0;
		
		for(int i = 0; i < bytesOfText.length; i++) {
			bytesOfCurrentBlock[count] = bytesOfText[i];
			count = count +1;
			if(count == keySize) {
				blocks.add(new Block(bytesOfCurrentBlock, count));
				count = 0;
				bytesOfCurrentBlock = new byte[keySize];
			}
		}
		blocks.add(new Block(bytesOfCurrentBlock, count));
		return blocks;
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
}

package model.crack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ToolsRefacto {
	final static int KEY_SIZE = 12;
	
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
		
	public static ArrayList<Block> transposeAllBlocksByIndex(ArrayList<Block> blocks){
		ArrayList<Block> blockss = new ArrayList<Block>();
		ArrayList<Integer> index0 = new ArrayList<Integer>();
		ArrayList<Integer> index1 = new ArrayList<Integer>();
		ArrayList<Integer> index2 = new ArrayList<Integer>();
		ArrayList<Integer> index3 = new ArrayList<Integer>();
		ArrayList<Integer> index4 = new ArrayList<Integer>();
		ArrayList<Integer> index5 = new ArrayList<Integer>();
		ArrayList<Integer> index6 = new ArrayList<Integer>();
		ArrayList<Integer> index7 = new ArrayList<Integer>();
		ArrayList<Integer> index8 = new ArrayList<Integer>();
		ArrayList<Integer> index9 = new ArrayList<Integer>();
		ArrayList<Integer> index10 = new ArrayList<Integer>();
		ArrayList<Integer> index11 = new ArrayList<Integer>();
								
		for(Block block : blocks) {
			ArrayList<Integer> list = block.getList();
			for(int i =0; i < list.size(); i++) {
				switch(i) {
				 case 0:
					 index0.add(list.get(i));
					 break;
				 case 1:
					 index1.add(list.get(i));
					 break;
				 case 2:
					 index2.add(list.get(i));
					 break;
				 case 3:
					 index3.add(list.get(i));
					 break;
				 case 4:
					 index4.add(list.get(i));
					 break;
				 case 5:
					 index5.add(list.get(i));
					 break;
				 case 6:
					 index6.add(list.get(i));
					 break;
				 case 7:
					 index7.add(list.get(i));
					 break;
				 case 8:
					 index8.add(list.get(i));
					 break;
				 case 9:
					 index9.add(list.get(i));
					 break;
				 case 10:
					 index10.add(list.get(i));
					 break;
				 case 11:
					 index11.add(list.get(i));
					 break;
				 default:
					 System.out.println("Erreur au moment de transpose");
				}
			}
		}
		blockss.add(new Block(index0,index0.size()));
		blockss.add(new Block(index1,index1.size()));
		blockss.add(new Block(index2,index2.size()));
		blockss.add(new Block(index3,index3.size()));
		blockss.add(new Block(index4,index4.size()));
		blockss.add(new Block(index5,index5.size()));
		blockss.add(new Block(index6,index6.size()));
		blockss.add(new Block(index7,index7.size()));
		blockss.add(new Block(index8,index8.size()));
		blockss.add(new Block(index9,index9.size()));
		blockss.add(new Block(index10,index10.size()));
		blockss.add(new Block(index11,index11.size()));
		return blockss;
	}
	
	public static ArrayList<Block> parseCypherTextToBlock(String cyphertext) {
		byte[] bytesOfText;
		byte[] bytesOfCurrentBlock = new byte[KEY_SIZE];
		
		ArrayList<Block> blocks = new ArrayList<Block>();
		bytesOfText = cyphertext.getBytes();
		int count = 0;
		
		for(int i = 0; i < bytesOfText.length; i++) {
			bytesOfCurrentBlock[count] = bytesOfText[i];
			count = count +1;
			if(count == 12) {
				blocks.add(new Block(bytesOfCurrentBlock, count));
				count = 0;
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

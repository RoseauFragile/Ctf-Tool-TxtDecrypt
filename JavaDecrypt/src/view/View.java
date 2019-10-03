package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class View{

	 private JFrame frame;
	 private JLabel pathLabel;
	 private JLabel keyLabel;
	 private JTextField path;
	 private JTextField key;
	 private JButton decryptButton;
	 private JButton printDecrypted;
	 private JButton saveKey;
	 private JButton saveDecrypted;
	 private static int WIDTH = 1000;
	 private static int HEIGHT = 150;
	 private static String TITLE = "CRACK XOR VIGENERE";
	 private JFileChooser chooser; 
	 
	 public View() {
		 this.initView(WIDTH, HEIGHT, TITLE);
	 }
	 
	 private void initView(int width, int height,String title) {
		  frame = new JFrame(title);
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(width, height);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
		  
		  pathLabel = new JLabel("Path :");
		  keyLabel = new JLabel("Key(optionnal) :");
		  path = new JTextField();
		  key = new JTextField();
		  decryptButton = new JButton("Decrypt");
		  printDecrypted = new JButton("Show cypherDecrypted");
		  saveKey = new JButton("Save Key");
		  saveDecrypted = new JButton("Save Decrypted");
		  
		  GroupLayout layout = new GroupLayout(frame.getContentPane());
		  layout.setAutoCreateGaps(true);
		  layout.setAutoCreateContainerGaps(true);
		  layout.setHorizontalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pathLabel).addComponent(keyLabel))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(path).addComponent(key))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(decryptButton).addComponent(saveKey))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(printDecrypted).addComponent(saveDecrypted)));
		  layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pathLabel).addComponent(path).addComponent(decryptButton).addComponent(printDecrypted))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(keyLabel).addComponent(key).addComponent(saveKey))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(saveDecrypted)));
		  layout.linkSize(SwingConstants.HORIZONTAL, decryptButton);
		  layout.linkSize(SwingConstants.HORIZONTAL, printDecrypted);
		  frame.getContentPane().setLayout(layout);
	 }
	 
	 public JFrame getFrame() {
	  return frame;
	 }
	 
	 public void setFrame(JFrame frame) {
	  this.frame = frame;
	 }
	 
	 public JLabel getPathLabel() {
	  return pathLabel;
	 }
	 
	 public void setPathLabel(JLabel pathLabel) {
	  this.pathLabel = pathLabel;
	 }
	 
	 public JLabel getKeyLabel() {
	  return keyLabel;
	 }
	 
	 public void setKeyLabel(JLabel keyLengthLabel) {
	  this.keyLabel = keyLengthLabel;
	 }
	 
	 public JTextField getPath() {
	  return path;
	 }
	 
	 public void setPath(JTextField path) {
	  this.path = path;
	 }
	 
	 public JTextField getKey() {
	  return key;
	 }
	 
	 public void setKey(JTextField keyLenght) {
	  this.key = keyLenght;
	 }
	 
	 public JButton getDecryptButton() {
	  return decryptButton;
	 }
	 
	 public void setDecryptButton(JButton firstnameSaveButton) {
	  this.decryptButton = firstnameSaveButton;
	 }
	 
	 public JButton getPrintDecrypted() {
	  return printDecrypted;
	 }
	 
	 public void setPrintDecrypted(JButton hello) {
	  this.printDecrypted = hello;
	 }

	public JButton getSaveKey() {
		return saveKey;
	}

	public void setSaveKey(JButton saveKey) {
		this.saveKey = saveKey;
	}

	public JButton getSaveDecrypted() {
		return saveDecrypted;
	}

	public void setSaveDecrypted(JButton saveDecrypted) {
		this.saveDecrypted = saveDecrypted;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setChooser() {
		this.chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new File("/")); 
		chooser.changeToParentDirectory(); 
		chooser.showOpenDialog(null);
	}
}
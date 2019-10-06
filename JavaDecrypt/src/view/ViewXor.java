package view;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ViewXor{

	 private JFrame frame;
	 private JLabel pathLabel;
	 private JTextField path;
	 private JButton decryptButton;
	 private JButton printDecrypted;
	 private JButton chooseFile;
	 private JButton saveDecrypted;
	 private JRadioButton french;
	 private JRadioButton english;
	 private static int WIDTH = 1000;
	 private static int HEIGHT = 700;
	 private static String TITLE = "CRACK XOR VIGENERE";
	 private JFileChooser chooser;
	 private JProgressBar progressBar; 
	 
	 public ViewXor() {
		 this.initView(WIDTH, HEIGHT, TITLE);
	 }
	 
	 private void initView(int width, int height,String title) {
	      
		  pathLabel = new JLabel("Path :");
		  path = new JTextField();
		  decryptButton = new JButton("Decrypt");
		  printDecrypted = new JButton("Show cypherDecrypted");
		  chooseFile = new JButton("Choose File");
		  saveDecrypted = new JButton("Save Decrypted");
		  progressBar = new JProgressBar(0, 100);
		  progressBar.setValue(0);
		  progressBar.setStringPainted(true);
		  this.setFrench(new JRadioButton("French"));
		  this.setEnglish(new JRadioButton("English"));
		  
		  ButtonGroup group = new ButtonGroup();
		  group.add(english);
		  group.add(french);
		  english.setSelected(true);
		  
		  BackgroundPanel back = new BackgroundPanel("tsoi.jpg");
	      
		  frame = new JFrame(title);
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(width, height);
		  frame.setLocationRelativeTo(null);
		  frame.setVisible(true);
		  frame.setContentPane(back);
		  
		  
		  GroupLayout layout = new GroupLayout(frame.getContentPane());
		  layout.setAutoCreateGaps(true);
		  layout.setAutoCreateContainerGaps(true);
		  layout.setHorizontalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pathLabel).addComponent(chooseFile).addComponent(decryptButton).addComponent(english).addComponent(french))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(path).addComponent(progressBar))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(printDecrypted).addComponent(saveDecrypted)));
		  layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(pathLabel).addComponent(path).addComponent(printDecrypted))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(chooseFile).addComponent(progressBar).addComponent(saveDecrypted))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(decryptButton))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(english))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(french)));		  
		  back.setLayout(layout);
		  progressBar.setIndeterminate(true);
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
	 
	 public JTextField getPath() {
	  return path;
	 }
	 
	 public void setPath(JTextField path) {
	  this.path = path;
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

	public JButton getChooseFile() {
		return chooseFile;
	}

	public void setChooseFile(JButton chooseFile) {
		this.chooseFile = chooseFile;
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
	
	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public String setChooser() {
		this.chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new File("/")); 
		chooser.changeToParentDirectory(); 
		chooser.showOpenDialog(null);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = chooser.getSelectedFile();
		String fullPath = file.getAbsolutePath();
		return fullPath;
	}
	
	public String setChooserSave() {
		this.chooser = new JFileChooser(); 
		chooser.setCurrentDirectory(new File("/")); 
		chooser.changeToParentDirectory(); 
		JButton save = new JButton("Save to file");
		chooser.showSaveDialog(save);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = chooser.getSelectedFile();
		String fullPath = file.getAbsolutePath()+".txt";
		return fullPath;
	}

	public JRadioButton getFrench() {
		return french;
	}

	public void setFrench(JRadioButton french) {
		this.french = french;
	}

	public JRadioButton getEnglish() {
		return english;
	}

	public void setEnglish(JRadioButton english) {
		this.english = english;
	}
}
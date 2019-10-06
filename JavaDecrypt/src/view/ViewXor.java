package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ViewXor extends JFrame{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	 private JLabel layout;
	 
	 public ViewXor() {
		 super(TITLE);
		 this.setSize(WIDTH, HEIGHT);
		 this.setLocationRelativeTo(null);
		 this.setResizable(true);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
		 this.setLayout(new BorderLayout());
		 this.layout = new JLabel(new ImageIcon("Tsoi.jpg"));
		 this.add(this.layout);
		 this.layout.setLayout(new FlowLayout());
		 this.initView();
	 }
	 
	 private void initView() {
	     
		  JPanel test = new JPanel();
		  test.setBorder(BorderFactory.createTitledBorder("Choose option"));
		  progressBar = new JProgressBar(0, 100);
		  progressBar.setValue(0);
		  progressBar.setStringPainted(true);
		  progressBar.setIndeterminate(true);
		  printDecrypted = new JButton("Show cypherDecrypted");
		  saveDecrypted = new JButton("Save Decrypted");
		  test.add(progressBar);
		  test.add(printDecrypted);
		  test.add(saveDecrypted);
		  
		  JPanel topPan = new JPanel();
		  topPan.setBorder(BorderFactory.createTitledBorder("Choose file"));
		  pathLabel = new JLabel("Path :");
		  path = new JTextField();
		  chooseFile = new JButton("Choose File");
		  decryptButton = new JButton("Decrypt");
		  topPan.add(pathLabel);
		  topPan.add(path);
		  topPan.add(chooseFile);
		  topPan.add(decryptButton);
		  
		  JPanel languagePan = new JPanel();
		  languagePan.setBorder(BorderFactory.createTitledBorder("Choose a language"));
		  ButtonGroup group = new ButtonGroup();
		  this.setFrench(new JRadioButton("French"));
		  this.setEnglish(new JRadioButton("English"));
		  group.add(english);
		  group.add(french);
		  english.setSelected(true);
		  languagePan.add(english);
		  languagePan.add(french);
		  
		  JPanel control = new JPanel();
		  control.add(new JButton("Back"));
		  
		  this.layout.add(topPan, BorderLayout.NORTH);
		  this.layout.add(languagePan, BorderLayout.WEST);
		  this.layout.add(test, BorderLayout.CENTER);
		  this.layout.add(control, BorderLayout.SOUTH);
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

	public void setPossiblesKeys(String[] fiveFirstkeys) {
		// TODO Auto-generated method stub
		
	}
}
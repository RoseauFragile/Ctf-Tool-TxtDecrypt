package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public abstract class ViewFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private static int WIDTH = 1000;
	 private static int HEIGHT = 700;
	 private JLabel layout;
	 private JMenuBar menuBar;
     private JMenu fileMenu;
     private JMenuItem exitMenu;
     private JMenuItem openFileMenu;
     private JMenuItem back;
     private JMenuItem xorButton;
     private JMenuItem cesarButton;
     private Color opacity;
	 private JButton decryptButton;
	 private JButton printDecrypted;
	 private JButton chooseFile;
	 private JButton saveDecrypted;
	 private JLabel pathLabel;
	 private JTextField path;
	 private JFileChooser chooser;
	 private JRadioButton french;
	 private JRadioButton english;
	 private String pathToBackground;
	 private static String TITLE = "POC JAVA CRYPTO";
	
	 public ViewFrame() {
		super(TITLE); 
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initMenu();
	 }
	 
	 private void initMenu() {
	      this.menuBar = new JMenuBar();
	      this.setFileMenu(new JMenu("File"));
	      this.setExitMenu(new JMenuItem("Exit"));
	      this.setOpenFileMenu(new JMenuItem("Open"));
	      this.setBack(new JMenuItem("Back"));
	      this.setXorButton(new JMenuItem("XOR"));
	      this.setCesarButton(new JMenuItem("Cesar"));
	      this.fileMenu.add(openFileMenu);
	      this.fileMenu.add(exitMenu);
	      this.fileMenu.add(xorButton);
	      this.fileMenu.add(cesarButton);
	      this.menuBar.add(fileMenu);
	      this.menuBar.add(back);
		  this.setJMenuBar(this.menuBar);
	 	}
	 
	 public void initView(String pathToBackground, Color opacity) {
		if(this.getPrincipalLayout() != null) {
			this.getPrincipalLayout().removeAll();
			this.getContentPane().removeAll();
		}
		this.opacity = opacity;
		this.pathToBackground = pathToBackground;
		this.layout = new JLabel(new ImageIcon(this.pathToBackground));
		this.add(this.layout);
		this.layout.setLayout(new GridBagLayout());
		 
		  JPanel option = new JPanel();
		  option.setBorder(BorderFactory.createTitledBorder("Choose option"));
		  printDecrypted = new JButton("Show cypherDecrypted");
		  saveDecrypted = new JButton("Save Decrypted");
		  option.add(printDecrypted);
		  option.add(saveDecrypted);
		  option.setBackground(this.opacity);
		  
		  JPanel topPan = new JPanel();
		  topPan.setBorder(BorderFactory.createTitledBorder("Choose file"));
		  pathLabel = new JLabel("Path :");
		  path = new JTextField();
		  path.setPreferredSize(new Dimension(200,24));
		  chooseFile = new JButton("Choose File");
		  decryptButton = new JButton("Decrypt");
		  topPan.add(pathLabel);
		  topPan.add(path);
		  topPan.add(chooseFile);
		  topPan.add(decryptButton);
		  topPan.setBackground(this.opacity);
		  
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
		  languagePan.setBackground(this.opacity);
		  
		  GridBagConstraints c = new GridBagConstraints();
		  
		  c.fill = GridBagConstraints.NONE;
		  c.gridx = 0;
		  c.gridy = 0;
		  c.weightx = 0.5;
		  c.anchor = GridBagConstraints.FIRST_LINE_START;
		  this.getPrincipalLayout().add(topPan, c);
		  
		  c.fill = GridBagConstraints.NONE;
		  c.ipady = 0; 
		  c.insets = new Insets(10,0,0,0);
		  c.gridx = 0;
		  c.gridy = 1;
		  c.weightx = 0.5;
		  this.getPrincipalLayout().add(languagePan, c);	  
		  
		  c.fill = GridBagConstraints.NONE;
		  c.ipady = 0;
		  c.weighty = 0.5;   
		  c.anchor = GridBagConstraints.PAGE_END; 
		  c.insets = new Insets(10,0,0,0);  
		  c.gridx = 2;       
		  c.gridy = 2;       
		  this.getPrincipalLayout().add(option, c);
		  
	 }
	 
		public JMenu getFileMenu() {
			return fileMenu;
		}

		public void setFileMenu(JMenu fileMenu) {
			this.fileMenu = fileMenu;
		}

		public JMenuItem getExitMenu() {
			return exitMenu;
		}

		public void setExitMenu(JMenuItem exitMenu) {
			this.exitMenu = exitMenu;
		}

		public JMenuItem getOpenFileMenu() {
			return openFileMenu;
		}

		public void setOpenFileMenu(JMenuItem openFileMenu) {
			this.openFileMenu = openFileMenu;
		}

		public JMenuItem getBack() {
			return back;
		}

		public void setBack(JMenuItem back) {
			this.back = back;
		}

		public void setLayout(JLabel layout) {
			this.layout = layout;
		}
		
		public JLabel getPrincipalLayout() {
			return layout;
		}

		public JMenuBar getPrincipalMenuBar() {
			return menuBar;
		}

		public void setMenuBar(JMenuBar menuBar) {
			this.menuBar = menuBar;
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

			public JMenuItem getXorButton() {
				return xorButton;
			}

			public void setXorButton(JMenuItem xorButton) {
				this.xorButton = xorButton;
			}

			public JMenuItem getCesarButton() {
				return cesarButton;
			}

			public void setCesarButton(JMenuItem cesarButton) {
				this.cesarButton = cesarButton;
			}

			public String getPathToBackground() {
				return pathToBackground;
			}

			public void setPathToBackground(String pathToBackground) {
				this.pathToBackground = pathToBackground;
			}				
}
package view;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	private static String TITLE = "Menu";
	 private static int WIDTH = 500;
	 private static int HEIGHT = 100;
	 private JButton xorButton;
	 private JButton cesarButton;
	 private JLabel choiceLabel;

	 public MenuView() {
		 super(TITLE);
		 this.getContentPane().setLayout(new BorderLayout());
		 this.getContentPane().setLayout(new BorderLayout());
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(WIDTH, HEIGHT);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
		 this.initView();
	 }
	 
	 private void initView() {
	
		  
		  this.setChoiceLabel(new JLabel("Choose a crack :"));
		  xorButton = new JButton("XOR");
		  cesarButton = new JButton("CESAR");
		  
		  GroupLayout layout = new GroupLayout(this.getContentPane());
		  layout.setAutoCreateGaps(true);
		  layout.setAutoCreateContainerGaps(true);
		  layout.setHorizontalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(choiceLabel))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(xorButton))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(cesarButton)));

		  layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(choiceLabel).addComponent(xorButton).addComponent(cesarButton)));
		  this.getContentPane().setLayout(layout);
	 }
	
	public JButton getXorButton() {
		return xorButton;
	}

	public void setXorButton(JButton xorButton) {
		this.xorButton = xorButton;
	}

	public JButton getCesarButton() {
		return cesarButton;
	}

	public void setCesarButton(JButton cesarButton) {
		this.cesarButton = cesarButton;
	}

	public JLabel getChoiceLabel() {
		return choiceLabel;
	}

	public void setChoiceLabel(JLabel choiceLabel) {
		this.choiceLabel = choiceLabel;
	}
}
package view;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuView{

	 private static String TITLE = "Menu";
	 private static int WIDTH = 500;
	 private static int HEIGHT = 100;
	 private JFrame frame;
	 private JButton xorButton;
	 private JLabel choiceLabel;

	 public MenuView() {
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
		  
		  this.setChoiceLabel(new JLabel("Choose a crack :"));
		  xorButton = new JButton("XOR");
		  
		  GroupLayout layout = new GroupLayout(frame.getContentPane());
		  layout.setAutoCreateGaps(true);
		  layout.setAutoCreateContainerGaps(true);
		  layout.setHorizontalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(choiceLabel))
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(xorButton)));
		  layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(choiceLabel).addComponent(xorButton)));
		  frame.getContentPane().setLayout(layout);
	 }
	 
	 public JFrame getFrame() {
	  return frame;
	 }
	 
	 public void setFrame(JFrame frame) {
	  this.frame = frame;
	 }
	
	public JButton getXorButton() {
		return xorButton;
	}

	public void setXorButton(JButton xorButton) {
		this.xorButton = xorButton;
	}

	public JLabel getChoiceLabel() {
		return choiceLabel;
	}

	public void setChoiceLabel(JLabel choiceLabel) {
		this.choiceLabel = choiceLabel;
	}
}
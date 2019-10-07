package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewMain extends ViewFrame{
	private static final long serialVersionUID = 1L;
	 private static String IMAGE = "manifesto.jpg";
     private ViewXor viewXor;
     private ViewCesar viewCesar;
         
	public ViewMain() {
		super();
		this.initMenuView();
		this.setVisible(true);
	}

	public void initMenuView() {
		if(this.getPrincipalLayout() != null) {
			this.getPrincipalLayout().removeAll();
			this.getContentPane().removeAll();
		}
		this.setSize(1000, 1000);
		this.setPathToBackground(IMAGE);
		JLabel label = new JLabel(new ImageIcon(this.getPathToBackground()));
		label.setBackground(Color.black);
		label.setOpaque(true);
		this.setLayout( label);
		this.add(this.getPrincipalLayout());
	}

	public ViewXor getViewXor() {
		return viewXor;
	}

	public void setViewXor(ViewXor viewXor) {
		this.viewXor = viewXor;
	}

	public ViewCesar getViewCesar() {
		return viewCesar;
	}

	public void setViewCesar(ViewCesar viewCesar) {
		this.viewCesar = viewCesar;
	}
}
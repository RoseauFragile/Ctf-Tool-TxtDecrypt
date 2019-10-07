package view;

import java.awt.Color;

public class ViewXor{
	 private static final long serialVersionUID = 1L;
	 private static String IMAGE = "tsoi.jpg";
     private static Color OPACITY = new Color(0.0f,0.0f,0.0f,0.2f);
     private ViewFrame viewFrame;
     
	public ViewXor(ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.getViewFrame().initView(IMAGE, OPACITY);
		this.getViewFrame().setTitle("XOR CRACK");
		this.getViewFrame().setVisible(true);
	}
	public ViewFrame getViewFrame() {
		return viewFrame;
	}
	public void setViewFrame(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	public void setView() {
		this.getViewFrame().initView(IMAGE, OPACITY);
	}
}
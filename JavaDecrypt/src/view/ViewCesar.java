package view;

import java.awt.Color;


public class ViewCesar extends ViewFrame{

	 private static final long serialVersionUID = 1L;
	 private static String IMAGE = "roman.jpg";
     private static Color OPACITY = new Color(0.0f,0.0f,0.0f,0.2f);
     private ViewFrame viewFrame;
     
 	public ViewCesar(ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		this.getViewFrame().initView(IMAGE, OPACITY);
		this.getViewFrame().setTitle("CESAR CRACK");
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
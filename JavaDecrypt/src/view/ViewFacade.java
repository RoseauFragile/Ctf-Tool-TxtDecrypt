package view;

public class ViewFacade {
	private ViewXor xorView;
	private ViewMain menuView;
	private ViewCesar cesarView;
	
	public ViewFacade() {
		this.setMenuView();
	}

	public ViewMain getMenuView() {
		return menuView;
	}

	public void setMenuView() {
		this.menuView = new ViewMain();
	}

	public ViewXor getXorView() {
		return xorView;
	}
	
	public void setXorView() {
		this.menuView.setViewXor(new ViewXor(this.menuView));
	}

	public ViewCesar getCesarView() {
		return cesarView;
	}

	public void setCesarView() {
		this.menuView.setViewCesar(new ViewCesar(this.menuView));
	}
}
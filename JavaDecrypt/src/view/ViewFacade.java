package view;

public class ViewFacade {
	private ViewXor xorView;
	private MenuView menuView;
	private ViewCesar cesarView;
	
	public ViewFacade() {
		this.setMenuView();
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView() {
		this.menuView = new MenuView();
	}

	public ViewXor getXorView() {
		return xorView;
	}

	public void setXorView() {
		this.xorView = new ViewXor();
		this.getMenuView().dispose();
	}

	public ViewCesar getCesarView() {
		return cesarView;
	}

	public void setCesarView() {
		this.cesarView = new ViewCesar();
		this.getMenuView().dispose();
	}
}
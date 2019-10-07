package view;

public class ViewFacade {
	private ViewXor xorView;
	private MenuView menuView;
	
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
	
	
}

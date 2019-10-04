package view;

public class ViewFacade {
	private ViewXor xorView;
	private MenuView menuView;
	
	public ViewFacade() {
		this.setMenuView(new MenuView());
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

	public ViewXor getXorView() {
		return xorView;
	}

	public void setXorView() {
		this.xorView = new ViewXor();
		this.getMenuView().getFrame().setVisible(false);
	}
	
	
}

package view;

public class ViewFacade {
	private View xorView;
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

	public View getXorView() {
		return xorView;
	}

	public void setXorView() {
		this.xorView = new View();
		this.getMenuView().getFrame().setVisible(false);
	}
	
	
}

package controller;

import view.MenuView;

public class ControllerMenu {

	private MenuView menuView;
	private ControllerFacade controllerFacade;
	
	public ControllerMenu(MenuView menuView, ControllerFacade controllerFacade) {
		this.setMenuView(menuView);
		this.setControllerFacade(controllerFacade);
	}

	public void initController() {
		this.getMenuView().getXorButton().addActionListener(e -> showXorMenu());
	}

	private void showXorMenu() {
	this.getControllerFacade().setXorMenu();
	}
	

	public MenuView getMenuView() {
		return menuView;
	}

	private void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

	public ControllerFacade getControllerFacade() {
		return controllerFacade;
	}

	public void setControllerFacade(ControllerFacade controllerFacade) {
		this.controllerFacade = controllerFacade;
	}
}

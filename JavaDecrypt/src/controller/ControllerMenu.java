package controller;

import view.ViewFrame;

public class ControllerMenu {

	private ViewFrame menuView;
	private ControllerFacade controllerFacade;
	
	public ControllerMenu(ViewFrame viewFrame, ControllerFacade controllerFacade) {
		this.setMenuView(viewFrame);
		this.setControllerFacade(controllerFacade);
	}

	public void initController() {
		this.getMenuView().getXorButton().addActionListener(e -> showXorMenu());
		this.getMenuView().getCesarButton().addActionListener(e -> showCesarMenu());
		this.getMenuView().getExitMenu().addActionListener(e -> exit());
		this.getMenuView().getBack().addActionListener(e -> backToMenu());
	}

	private void exit() {
		System.exit(0);
	}
	
	private void backToMenu() {
	    this.getControllerFacade().getViewFacade().getMenuView().initMenuView();
	}

	private void showCesarMenu() {
		this.getControllerFacade().setCesarMenu();
	}

	private void showXorMenu() {
	this.getControllerFacade().setXorMenu();
	}
	

	public ViewFrame getMenuView() {
		return menuView;
	}

	private void setMenuView(ViewFrame viewFrame) {
		this.menuView = viewFrame;
	}

	public ControllerFacade getControllerFacade() {
		return controllerFacade;
	}

	public void setControllerFacade(ControllerFacade controllerFacade) {
		this.controllerFacade = controllerFacade;
	}
}

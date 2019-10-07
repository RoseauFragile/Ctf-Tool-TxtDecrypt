package controller;

import model.Model;
import model.ModelFacade;
import view.ViewFacade;

public class ControllerFacade {
	private ControllerXor controllerXor;
	private ControllerMenu controllerMenu;
	private ModelFacade modelFacade;
	private ViewFacade viewFacade;
	private ControllerCesar controllerCesar;
	
	public ControllerFacade(ViewFacade viewFacade, ModelFacade modelFacade) {
		this.setModelFacade(modelFacade);
		this.setViewFacade(viewFacade);
		this.initMenuView();
	}
	
	public void initMenuView() {
		this.setControllerMenu(new ControllerMenu(this.getViewFacade().getMenuView(),this));
		this.getControllerMenu().initController();
	}
	
	public void setXorMenu() {
		this.modelFacade.setModel(new Model());
		this.getViewFacade().setXorView();
		this.setControllerXor(new ControllerXor(this,this.getModelFacade().getModel(), this.getViewFacade().getMenuView()));
		this.getControllerXor().initController();
	}
	
	public void setCesarMenu() {
		this.modelFacade.setModel(new Model());
		this.getViewFacade().setCesarView();
		this.setControllerCesar(new ControllerCesar(this,this.getModelFacade().getModel(), this.getViewFacade().getMenuView()));
		this.getControllerCesar().initController();
	}
	
	public ControllerXor getControllerXor() {
		return controllerXor;
	}
	public void setControllerXor(ControllerXor controllerXor) {
		this.controllerXor = controllerXor;
	}
	public ControllerMenu getControllerMenu() {
		return controllerMenu;
	}
	public void setControllerMenu(ControllerMenu controllerMenu) {
		this.controllerMenu = controllerMenu;
	}
	public ViewFacade getViewFacade() {
		return viewFacade;
	}
	public void setViewFacade(ViewFacade viewFacade) {
		this.viewFacade = viewFacade;
	}
	public ModelFacade getModelFacade() {
		return modelFacade;
	}
	public void setModelFacade(ModelFacade modelFacade) {
		this.modelFacade = modelFacade;
	}

	public ControllerCesar getControllerCesar() {
		return controllerCesar;
	}

	public void setControllerCesar(ControllerCesar controllerCesar) {
		this.controllerCesar = controllerCesar;
	}
}

package controller;

import model.Model;
import model.ModelFacade;
import view.ViewFacade;

public class ControllerFacade {
	private ControllerXor controllerXor;
	private ControllerMenu controllerMenu;
	private ModelFacade modelFacade;
	private ViewFacade viewFacade;
	
	public ControllerFacade(ViewFacade viewFacade, ModelFacade modelFacade) {
		this.setModelFacade(modelFacade);
		this.setViewFacade(viewFacade);
		this.initMenuView();
	}
	
	private void initMenuView() {
		this.setControllerMenu(new ControllerMenu(this.getViewFacade().getMenuView(),this));
		this.getControllerMenu().initController();
	}
	
	public void setXorMenu() {
		this.modelFacade.setModel(new Model());
		this.getViewFacade().setXorView();
		this.setControllerXor(new ControllerXor(this,this.getModelFacade().getModel(), this.getViewFacade().getXorView()));
		this.getControllerXor().initController();
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
}

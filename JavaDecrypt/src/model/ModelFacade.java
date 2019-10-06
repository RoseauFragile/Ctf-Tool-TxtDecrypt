package model;

public class ModelFacade {
	private Model model;

	public ModelFacade() {
	
	}
	
	public ModelFacade(Model model) {
		this.setModel(model);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}

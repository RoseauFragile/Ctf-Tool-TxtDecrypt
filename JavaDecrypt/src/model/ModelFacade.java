package model;

public class ModelFacade {
	private Model model;

	public ModelFacade(String path, String keyLength) {
		this.setModel(new Model(path, keyLength));
	}
	
	public ModelFacade() {
		// TODO Auto-generated constructor stub
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
}

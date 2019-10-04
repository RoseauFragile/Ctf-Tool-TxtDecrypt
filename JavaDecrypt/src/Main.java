import java.io.FileNotFoundException;

import controller.ControllerFacade;
import java.io.IOException;
import model.ModelFacade;
import view.ViewFacade;





public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ViewFacade viewFacade = new ViewFacade();
		ModelFacade modelFacade = new ModelFacade();
		@SuppressWarnings("unused")
		ControllerFacade controllerFacade = new ControllerFacade(viewFacade, modelFacade);
	}
}

import java.io.FileNotFoundException;

import controller.ControllerFacade;
import java.io.IOException;
import model.ModelFacade;
import view.ViewFacade;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		/*Model m = new Model("C:\\Users\\Benjamin\\Desktop\\Souille\\FichierADecrypter\\fichier003crypt.txt","");
		View v = new View(1000,150,"CRACK XOR VIGENERE");
		ControllerFrame c = new ControllerFrame(m, v);
		c.initController();*/
		ViewFacade viewFacade = new ViewFacade();
		ModelFacade modelFacade = new ModelFacade();
		ControllerFacade controllerFacade = new ControllerFacade(viewFacade, modelFacade);
		
	}
}

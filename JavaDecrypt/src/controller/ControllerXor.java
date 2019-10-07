package controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Model;
import model.tools.ToolsRefacto;
import view.ProgressFrame;
import view.ViewFrame;

public class ControllerXor {
	private Model model;
	private ViewFrame view;
	private ControllerFacade controllerFacade;
	
	public ControllerXor(ControllerFacade controllerFacade, Model m, ViewFrame v) {
		this.setControllerFacade(controllerFacade);
		model = m;
		view = v;
	}
	
	public void initController() {
		view.getDecryptButton().addActionListener(e -> {
			try {
				decryptCypher();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		view.getPrintDecrypted().addActionListener(e -> printDecrypted());
		view.getSaveDecrypted().addActionListener(e -> saveDecrypted());
		view.getChooseFile().addActionListener(e -> chooseFile());
		view.getExitMenu().addActionListener(e -> exit());
	}

	private void exit() {
		System.exit(0);
	}

	private void chooseFile() {
		try {
		String fullPath = this.view.setChooser();
		this.view.getPath().setText(fullPath);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Please enter a valid file name", "File not found", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void saveDecrypted() {
		  try{
			  String fullPath = this.view.setChooserSave();
			  ToolsRefacto.ecrireUnFichier(fullPath,model.getClearText());
		  }catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Please enter a valid file name", "File not found", JOptionPane.ERROR_MESSAGE);
		  }
	}

	private void decryptCypher() throws IOException {
		@SuppressWarnings("unused")
		ProgressFrame progress = new ProgressFrame(this);
		if(view.getEnglish().isSelected()) {
			model.setLanguage(1);
		}else {
			model.setLanguage(2);
		}
		model.setCrackXor(view.getPath().getText());
	}
	
	public void showKeys() {
		JOptionPane.showMessageDialog(null, model.getCrackXor().getFiveFirstkeys(), "Probable keys", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void printDecrypted() {
		JTextArea msg = new JTextArea("The key is : " + model.getCrackXor().getKey() +"\n"+ model.getClearText());
		msg.setLineWrap(true);
		msg.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(msg);
		scrollPane.setSize(500, 500);
		msg.setSize(500, 500);
		JOptionPane.showMessageDialog(null, scrollPane);
	}

	public void showFrame() {
		this.view.setVisible(true);
	}

	public ControllerFacade getControllerFacade() {
		return controllerFacade;
	}

	public void setControllerFacade(ControllerFacade controllerFacade) {
		this.controllerFacade = controllerFacade;
	}
}
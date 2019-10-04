package controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Model;
import model.crack.ToolsRefacto;
import view.ViewXor;

public class ControllerFrame {
	private Model model;
	private ViewXor view;
	public ControllerFrame(Model m, ViewXor v) {
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
	}
	
	private void chooseFile() {
		String fullPath = this.view.setChooser();
		this.view.getPath().setText(fullPath);
	}

	private void saveDecrypted() {
		  String fullPath = this.view.setChooserSave();
		  ToolsRefacto.ecrireUnFichier(fullPath,model.getClearText());
	}

	private void decryptCypher() throws IOException {
		model.setPath(view.getPath().getText());
		model.setCrack();
		view.getProgressBar().setValue(100);
		view.getProgressBar().setIndeterminate(false);
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
		this.view.getFrame().setVisible(true);
	}
}
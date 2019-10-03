package controller;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.Model;
import model.crack.ToolsRefacto;
import view.View;

public class ControllerFrame {
	private Model model;
	private View view;
	public ControllerFrame(Model m, View v) {
		model = m;
		view = v;
		initView();
	}
	
	public void initView() {
		view.getPath().setText(model.getPath());
		view.getKey().setText(model.getKeyLength());
	}
	
	public void initController() {
		System.out.println("TEST");
		view.getDecryptButton().addActionListener(e -> {
			try {
				decryptCypher();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getPrintDecrypted().addActionListener(e -> printDecrypted());
		view.getSaveKey().addActionListener(e -> saveKey());
		view.getSaveDecrypted().addActionListener(e -> saveDecrypted());
	}
	
	private void saveDecrypted() {
		  ToolsRefacto.ecrireUnFichier(model.getPath()+"decrypted.txt",model.getClearText());
		  JOptionPane.showMessageDialog(null, "The decrypted txt has been saved in the same folder than the encryptedFile : " + model.getPath()+"decrypted.txt");
	}

	private void saveKey() {
		model.saveKey();
		view.getKey().setText(model.getKey());
	}

	private void decryptCypher() throws IOException {
		System.out.println("TEST");
		model.setPath(view.getPath().getText());
		model.setCrack();
		view.getKey().setText(model.getCrackXor().getKey());
	}
	
	private void printDecrypted() {
		JTextArea msg = new JTextArea("The key is : " + model.getCrackXor().getKey() +"   "+ model.getClearText());
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
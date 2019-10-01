package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.CLctrlCrypt;
import model.Model;
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
		view.getExitButton().addActionListener(e -> exit());
		view.getSaveDecrypted().addActionListener(e -> saveDecrypted());
		view.getSaveEncrypted().addActionListener(e -> saveEncrypted());
	}
	
	@SuppressWarnings("static-access")
	private void saveEncrypted() {
		model.setPath(view.getPath().getText());
		if(view.getKey().getText() != "") {
			String s = view.getKey().getText();
			CLctrlCrypt test = new CLctrlCrypt();
			String content;
			try {
				content = new String(Files.readAllBytes(Paths.get(model.getPath())));
				String testS = test.encode_using_xor(content.getBytes(),s.getBytes());
				System.out.println(testS);
				String path = model.getPath()+"Encrypted.txt";
				System.out.println(path);
				test.ecrireUnFichier(path, testS);
				JOptionPane.showMessageDialog(null, "Your txt has been encrypted and saved in the same folder than the clearFile : " + model.getPath()+"Encrypted.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "You must enter a valid key to crypt (length = 12, a-z).");
		}
	}

	private void saveDecrypted() {
		  CLctrlCrypt.ecrireUnFichier(model.getPath()+"decrypted.txt",model.getClearText());
		  JOptionPane.showMessageDialog(null, "The decrypted txt has been saved in the same folder than the encryptedFile : " + model.getPath()+"decrypted.txt");
	}

	private void saveKey() {
		model.saveKey();
		view.getKey().setText(model.getKey());
	}

	private void decryptCypher() throws IOException {
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
	
	private void exit() {
		System.exit(0);
	}
}
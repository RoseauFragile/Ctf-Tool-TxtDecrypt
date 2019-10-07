package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import controller.ControllerCesar;
import controller.ControllerXor;

public class ProgressFrame extends JFrame{

  private static final long serialVersionUID = 1L;
  private Thread t;
  private JProgressBar bar;
  private JButton launch ;
  private JButton exit ;
  private ControllerXor controllerXor;
  private ControllerCesar controllerCesar;
   
  public ProgressFrame(ControllerXor controllerXor){
	this.setControllerXor(controllerXor);
    this.setSize(500, 150);
    this.setTitle("Cracking");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);      
      
    bar  = new JProgressBar();
    bar.setMaximum(500);
    bar.setMinimum(0);
    bar.setStringPainted(true);
      
    this.getContentPane().add(bar, BorderLayout.CENTER);
      
    launch = new JButton("Launch");
    launch.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
    	Traitement traitement = new Traitement();
        t = new Thread(traitement);
        t.start();  
        
      }
    });
    exit = new JButton("Exit");
    exit.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent event){
    	  exit();
      }
    }); 
    this.getContentPane().add(launch, BorderLayout.PAGE_START);
    this.getContentPane().add(exit, BorderLayout.PAGE_END);
    this.setVisible(true);      
  }
  
  public ProgressFrame(ControllerCesar controllerCesar) {
		this.setControllerCesar(controllerCesar);
	    this.setSize(500, 150);
	    this.setTitle("Cracking");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);      
	      
	    bar  = new JProgressBar();
	    bar.setMaximum(500);
	    bar.setMinimum(0);
	    bar.setStringPainted(true);
	      
	    this.getContentPane().add(bar, BorderLayout.CENTER);
	      
	    launch = new JButton("Launch");
	    launch.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){
	    	Traitement traitement = new Traitement();
	        t = new Thread(traitement);
	        t.start();  
	        
	      }
	    });
	    exit = new JButton("Exit");
	    exit.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent event){
	    	  exit();
	      }
	    }); 
	    this.getContentPane().add(launch, BorderLayout.PAGE_START);
	    this.getContentPane().add(exit, BorderLayout.PAGE_END);
	    this.setVisible(true);  
}

public void exit() {
	  this.dispose();
	  if(this.bar.getValue() == 500) {
		  this.controllerXor.showKeys();
	  }
  }

public ControllerXor getControllerXor() {
	return controllerXor;
}

public void setControllerXor(ControllerXor controllerXor) {
	this.controllerXor = controllerXor;
}

public ControllerCesar getControllerCesar() {
	return controllerCesar;
}

public void setControllerCesar(ControllerCesar controllerCesar) {
	this.controllerCesar = controllerCesar;
}

class Traitement implements Runnable{   
	
		@SuppressWarnings("static-access")
		public void run(){
	      launch.setEnabled(false);
	      exit.setEnabled(false);
	      for(int val = 0; val <= 500; val++){
	        bar.setValue(val);
	        try {
	          t.sleep(10);
	        } catch (InterruptedException e) {
	        e.printStackTrace();
	        }
	      }
	      launch.setEnabled(true);
	      exit.setEnabled(true);
	    }   
	  }
}
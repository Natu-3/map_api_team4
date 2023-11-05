package t4_webproject;
import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.awt.*;

public class mainFrame extends JFrame{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */


	public mainFrame() {
		setTitle("Main Page");
		setSize(2000,1000);
		setLocation(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		mainFrame myFrame = new mainFrame();
		Container cont = myFrame.getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(new JButton("White"), BorderLayout.CENTER);
		
		
		myFrame.setVisible(true);
	}
}

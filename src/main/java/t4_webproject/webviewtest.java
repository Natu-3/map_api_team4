import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class webviewtest extends JFrame {

	private static final long serialVersionUID = -3791304857591006215L;
	private static final String True = null;

	public webviewtest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2000,1000);
		JFXPanel fxPanel = new JFXPanel();
		add(fxPanel);
		
		Platform.runLater(new Runnable() {

			public void run() {

				initAndLoadWebView(fxPanel);

			}

		});
		
		setVisible(true);
	}
	
	private static void initAndLoadWebView(final JFXPanel fxPanel) {
		Group group = new Group();
		Scene scene = new Scene(group);
		fxPanel.setScene(scene);

		WebView webView = new WebView();

		group.getChildren().add(webView);
		webView.setMinSize(500, 500);
		webView.setMaxSize(500, 500);

		WebEngine webEngine = webView.getEngine();

		webEngine.load("http://localhost:8080/t4_webproject/NewFile.jsp");

	}
	
	
	public static void main(String[] args){
		webviewtest a = new webviewtest();
		a.isVisible();
}
}
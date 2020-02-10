package application;



import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Event_Controller {
	@FXML
	private TextField Username;
	@FXML
	private TextField Password;
	@FXML
	private Button Login;
	@FXML
	private Label Statuslbl;
	@FXML
	private ImageView UWELogo;
	
	
	// [[Login controller]]
	
	public void LoginEvent(ActionEvent event) {
		if(Username.getText().equals("admin") && Password.getText().equals("admin")) {
			System.out.println("Login Success");
			// [[ Hide login window when login success]]
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			try {
				Pane root = loader.load(getClass().getResource("GeneralView.fxml").openStream());
				Scene scene = new Scene(root);
				primaryStage.setTitle("UWE Accomodation System");
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("Login Failed");
			Statuslbl.setText("Wrong username or password");
		}
	}
	public void LogoutEvent(ActionEvent event) {
		((Node)event.getSource()).getScene().getWindow().hide();
	}
	
}
